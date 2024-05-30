package jp.ac.ait.k23075.jobs;

import java.util.Random;

import jp.ac.ait.k23075.AttackResult;
import jp.ac.ait.k23075.CharacterBase;
import jp.ac.ait.k23075.Hero;
import jp.ac.ait.k23075.IHeroJob;

public class KingPenguin extends Hero implements IHeroJob {
    private int lastHp = this.getHp();

    public KingPenguin(String name, int hp, int atk, int def, int agi) {
        super(name, hp, atk, def, agi);
    }

    private int getLastHp() {
        return lastHp;
    }

    private void setLastHp(int lastHp) {
        this.lastHp = lastHp;
    }

    @Override
    public String getJobName() {
        return "キング";
    }

    @Override
    public String getSpecialAttackName() {
        return "王の意地";
    }

    /**
     * 50%の確率で受けたダメージの2倍のダメージを返す
     * 
     * @param target 行動対象(基本的に敵が渡されます)
     * @return 行動結果
     */
    @Override
    public AttackResult specialAttack(CharacterBase target) {
        Random r = new Random();

        AttackResult ret = new AttackResult();

        int damage = (this.getLastHp() - this.getHp()) * 2;

        if (r.nextDouble() < 0.5) {
            System.out.println(this.getName() + " の意地により2倍のダメージを与えた！");
        } else {
            System.out.println(this.getName() + " はメンタルブレイクした！");
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

        // ダメージを受けた後のHPを記録しておく
        this.setLastHp(this.getHp());

        return ret;
    }

    @Override
    public String toString() {
        // デバッグ用に職業メッセージを追加しておきます。
        return super.toString() + ", " + this.getJobName() + "(" + this.getSpecialAttackName() + ")";
    }
}
