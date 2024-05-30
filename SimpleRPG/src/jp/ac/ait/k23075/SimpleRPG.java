package jp.ac.ait.k23075;

import java.util.Random;
import java.util.Scanner;

import jp.ac.ait.k23075.jobs.EmperorPenguin;
import jp.ac.ait.k23075.jobs.GentooPenguin;
import jp.ac.ait.k23075.jobs.KingPenguin;

public class SimpleRPG {

    // このクラスでは、画面からの入力をいろいろなメソッドで行うため、
    // フィールド化しておく
    final static Scanner scanner = new Scanner(System.in);

    Hero hero;
    Enemy enemy;

    /**
     * 勇者を生成して返すメソッド
     * 
     * @return
     */
    Hero createHero() {
        // 勇者の名前を入力させます
        System.out.println("名前を入力してください");
        System.out.print("> ");
        String name = scanner.nextLine() + "ペンギン";

        // パラメータをランダム生成
        int hp = new Random().nextInt(41) + 80;
        int atk = new Random().nextInt(8) + 8;
        int def = new Random().nextInt(8) + 8;
        int agi = new Random().nextInt(8) + 8;

        // ペンギンの種類をランダムに決定
        Hero[] heros = {
                new EmperorPenguin(name, hp, atk, def, agi),
                new GentooPenguin(name, hp, atk, def, agi),
                new EmperorPenguin(name, hp, atk, def, agi),
                new KingPenguin(name, hp, atk, def, agi),
        };

        // ペンギンの種類をランダムに決定
        int jobIndex = name.length() % heros.length;

        return heros[jobIndex];
    }

    Enemy createEnemy() {

        final String[] ENEMY_NAMES = { "シャチ", "ヒョウアザラシ", "トウゾクカモメ", "ニンゲン", "キビシイサムサ" };

        // 上記配列から、ランダムに1つだけの名前を抽出して敵の名前とする。
        String name = ENEMY_NAMES[new Random().nextInt(ENEMY_NAMES.length)];

        Enemy enemy = new Enemy( // パラメータ ランダム範囲
                name,
                new Random().nextInt(151) + 50, // HP 50 〜 200
                new Random().nextInt(11) + 10, // ATK 10 〜 20
                new Random().nextInt(11) + 5, // DEF 5 〜 15
                new Random().nextInt(11) + 10); // AGI 10 〜 20

        return enemy;

    }

    private boolean heroActionAttack() {
        // 攻撃だった場合
        AttackResult ret = hero.attack(enemy);
        System.out.println(enemy.getName() + "に" + ret.damage + "のダメージ");
        if (ret.state == AttackResult.BATTLE_END) {
            // 戦闘終了
            System.out.println(enemy.getName() + "を倒して食物連鎖の頂点に君臨した！");
            System.out.println();
            System.out.println(">> ゲームクリア <<");
            return false; // 続行不能
        }

        System.out.println();
        showStatus();

        // 戻り値は、行動により戦闘続行可否をbooleanで返します
        return true;
    }

    private boolean heroActionSpecialAttack(IHeroJob job) {
        // 攻撃だった場合
        AttackResult ret = job.specialAttack(enemy);
        System.out.println(enemy.getName() + "に" + ret.damage + "のダメージ");
        if (ret.state == AttackResult.BATTLE_END) {
            // 戦闘終了
            System.out.println(enemy.getName() + "を倒して食物連鎖の頂点に君臨した！");
            System.out.println();
            System.out.println(">> ゲームクリア <<");
            return false; // 続行不能
        }

        System.out.println();
        showStatus();

        // 戻り値は、行動により戦闘続行可否をbooleanで返します
        return true;
    }

    private boolean heroActionEscape() {
        // 逃亡だった場合
        System.out.println(hero.getName() + "は、群れの元に帰りたい！");
        System.out.println(hero.getName() + "は、逃げ出した！");
        System.out.println();
        System.out.println(">> ゲームオーバー <<");
        return false; // 続行不能
    }

    /**
     * 勇者の行動
     * 
     * @return falseの場合続行不能
     */
    boolean heroAction() {
        IHeroJob job = (IHeroJob) hero;

        System.out.println("\n--- " + hero.getName() + "のターン ---");

        // 勇者の1回分の行動決定と行動を行わせるメソッド

        // 画面より、攻撃か逃亡かを選択させ、その行動結果を画面に表示します
        System.out.println(hero.getName() + "の行動を決めてください");
        System.out.println("  1: 通常攻撃");
        System.out.println("  2: " + job.getSpecialAttackName());
        System.out.println("  3: 逃亡");
        System.out.print("> ");

        String input = scanner.nextLine();
        System.out.print("\n");

        if (input.equals("1")) {
            return heroActionAttack();
        } else if (input.equals("2")) {
            return heroActionSpecialAttack(job);
        } else {
            return heroActionEscape();
        }
    }

    boolean enemyAction() {
        System.out.println("\n--- " + enemy.getName() + "のターン ---");

        // 敵の1回分の攻撃行動を行わせるメソッド（敵は攻撃の行動のみ行います）
        // 攻撃だった場合
        AttackResult ret = enemy.attack(hero);
        System.out.println(hero.getName() + "に" + ret.damage + "のダメージ");
        if (ret.state == AttackResult.BATTLE_END) {
            // 戦闘終了
            System.out.println(hero.getName() + "は無残にも喰われてしまった。");
            System.out.println();
            System.out.println(">> ゲームオーバー <<");

            return false; // 続行不能
        }
        // 戻り値は、行動により戦闘続行可否をbooleanで返します

        System.out.println();
        showStatus();

        return true;
    }

    /**
     * 勇者と敵の残りHPを表示するメソッド
     */
    void showStatus() {
        System.out.println("| HP " + hero.getHp() + " : " + hero.getName());
        System.out.println("| HP " + enemy.getHp() + " : " + enemy.getName());
    }

    void battleLoop() {
        // 戦闘処理の無限ループを用意します
        while (true) {
            // 無限ループ内では、勇者と敵の素早さを比較し行動順序を入れ替え、それぞれの行動を行います
            // 行動により戦闘続行不可能になった場合は、その場で無限ループを抜け、メソッドを終了します
            if (hero.getAgi() >= enemy.getAgi()) {
                // 勇者のほうが早い
                if (!heroAction())
                    return;
                if (!enemyAction())
                    return;
            } else {
                if (!enemyAction())
                    return;
                if (!heroAction())
                    return;
            }
        }
    }

    public static void main(String[] args) {
        SimpleRPG app = new SimpleRPG();

        app.hero = app.createHero();

        System.out.println(app.hero.toString());

        app.enemy = app.createEnemy();
        System.out.println(app.enemy.toString());

        app.hero.setWeapon(Weapon.getWeapon());

        System.out.println("");
        System.out.println(app.hero.getName() + "は、" + app.enemy.getName() + "と遭遇した！");
        System.out.println(app.hero.getName() + "は、と群れの元に帰りたい！");
        System.out.println(app.hero.getName() + "は、" + app.hero.getWeapon().getName() + "を取り出した!");
        System.out.println(app.hero.getName() + "は、攻撃力が " + app.hero.getWeapon().getAtk() + " 上昇した！");
        System.out.println("");

        app.battleLoop();
    }
}
