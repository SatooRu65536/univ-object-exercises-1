package jp.ac.ait.k23075.jobs;

import java.util.Random;

import jp.ac.ait.k23075.AttackResult;
import jp.ac.ait.k23075.CharacterBase;
import jp.ac.ait.k23075.Hero;
import jp.ac.ait.k23075.IHeroJob;

public class EmperorPenguin extends Hero implements IHeroJob {

    public EmperorPenguin(String name, int hp, int atk, int def, int agi) {
        super(name, hp, atk, def, agi);
    }

    @Override
    public String getJobName() {
        return "エンペラー";
    }

    @Override
    public String getSpecialAttackName() {
        return "皇帝の権威";
    }

    /**
     * 10%の確率で敵を屈服させるが、失敗すると攻撃できない
     * 
     * @param target 行動対象(基本的に敵が渡されます)
     * @return 行動結果
     */
    @Override
    public AttackResult specialAttack(CharacterBase target) {
        // ランダムな数値の生成に使用する乱数生成器を初期化
        Random r = new Random();

        AttackResult ret = new AttackResult();

        int damage = target.getHp();

        if (r.nextDouble() < 0.03) {
            // 3%の確率で成功
            System.out.println(target.getName() + " は皇帝の権威に屈した！");
        } else {
            System.out.println(target.getName() + " は皇帝の権威に屈しなかった！");
            damage = 0;
        }

        // 引数の攻撃対象がダメージを受ける
        boolean isBattleEnd = target.receiveDamage(damage);

        // 攻撃を行ったことによる行動結果を生成して返す
        ret.damage = damage;
        if (isBattleEnd) {
            // 戦闘終了の条件を満たす場合、勇者の勝利となる
            ret.state = AttackResult.BATTLE_END;
        }
        return ret;
    }

    @Override
    public String toString() {
        // デバッグ用に職業メッセージを追加しておきます。
        return super.toString() + ", " + this.getJobName() + "(" + this.getSpecialAttackName() + ")";
    }
}
