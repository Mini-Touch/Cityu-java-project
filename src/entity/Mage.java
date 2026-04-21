package entity;

import core.LivingEntity;
import Item.Inventory;
import Item.Weapon.Weapon;
import Item.Weapon.CrystalStaff;
import Item.Weapon.ApprenticeWand;

public class Mage extends LivingEntity {
    private int mana;
    private final int MAX_MANA;
    private Inventory backpack;
    private final int MANA_COST = 25;

    public Mage(String name, int x, int y, int health, int level, int intelligence) {
        super(name, x, y, health, level, intelligence); 
        this.MAX_MANA = 100;
        this.mana = MAX_MANA;
        this.backpack = new Inventory(10);
    }

    public Inventory getBackpack() { return backpack; }
    public int getMana() { return mana; }

    @Override
    public void displayInfo() {
        System.out.println("[Mage] " + name + " | MP: " + mana + "/" + MAX_MANA);
    }

    @Override
    public void attack(LivingEntity target) {
        if (mana >= MANA_COST) {
            int damage = this.getStrength() * 2; // Intelligence based damage
            
            Weapon equipped = backpack.getEquippedWeapon();
            if (equipped instanceof CrystalStaff) {
                damage += ((CrystalStaff) equipped).getMagicBoost();
            }

            mana -= MANA_COST;
            System.out.println(name + " casts Fireball for " + damage + " damage!");
            target.takeDamage(damage);
        } else {
            System.out.println(name + " lacks mana! Weak strike for 5 damage.");
            target.takeDamage(5);
        }
    }

    public void rest() {
        int recovery = 30;
        Weapon equipped = backpack.getEquippedWeapon();
        if (equipped instanceof ApprenticeWand) {
            recovery += ((ApprenticeWand) equipped).getManaRegenBonus();
        }
        this.mana = Math.min(mana + recovery, MAX_MANA);
        System.out.println(name + " meditates, restoring mana to " + mana);
    }
}