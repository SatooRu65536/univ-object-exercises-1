package jp.ac.ait.k23075.jobs;

import java.util.Random;

import jp.ac.ait.k23075.AttackResult;
import jp.ac.ait.k23075.CharacterBase;
import jp.ac.ait.k23075.Hero;
import jp.ac.ait.k23075.IHeroJob;

public class GentooPenguin extends Hero implements IHeroJob {

    public GentooPenguin(String name, int hp, int atk, int def, int agi) {
        super(name, hp, atk, def, agi);
    }

    @Override
    public String getJobName() {
        return "ジェンツー";
    }

    @Override
    public String getSpecialAttackName() {
        return "俊足の一撃";
    }

    /**
     * 攻撃力は10%下がるが、攻撃が必ず成功し、30%の確率でクリティカルヒット
     * 
     * @param target 行動対象(基本的に敵が渡されます)
     * @return 行動結果
     */
    @Override
    public AttackResult specialAttack(CharacterBase target) {
        // ランダムな数値の生成に使用する乱数生成器を初期化
        Random r = new Random();

        // 引数の攻撃対象に対して与えることのできるダメージを算出
        // 与えるダメージ = (自身の攻撃力 - 敵の防御力 / 2)(小数点以下切り上げ) に、-3〜+3のランダムな値を加算
        int damage = (int) Math.ceil((double) this.getAtk() - (target.getDef() / 2.0))
                + (r.nextInt(7) - 3); // ← −3〜+3のランダムな値

        // 攻撃力を 90% にする
        damage = (int) (damage * 0.9);

        AttackResult ret = new AttackResult();

        // 攻撃成功時 30% の確率でクリティカル
        if (r.nextDouble() < 0.3) {
            System.out.println("クリティカルヒット！");
            damage *= 2;
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
        String job = "JOB:" + this.getJobName() + "(" + this.getSpecialAttackName() + ")";
        return super.toString() + "\n  " + job;
    }
}
