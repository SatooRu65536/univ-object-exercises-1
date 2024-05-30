package jp.ac.ait.k23075;

import java.util.Random;

public class Weapon extends Equipment {
    private int atk;

    public Weapon(String name, int atk) {
        super(name);
        this.atk = atk;
    }

    public Weapon() {
        super("武器");
        this.atk = 0;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public static Weapon getWeapon() {
        final String[] WEAPON_NAMES = { "我が子", "雪", "硬い氷", "アザラシの牙" };
        final int index = new Random().nextInt(WEAPON_NAMES.length);
        String weaponName = WEAPON_NAMES[index];

        Weapon weapon = new Weapon(weaponName, (index - 1) * 2);
        return weapon;
    }
}
