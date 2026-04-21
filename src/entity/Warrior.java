package entity;

import core.LivingEntity;
import Item.Inventory;

public class Warrior extends LivingEntity {
    private int stamina;
    private Inventory backpack;

    public Warrior(String name, int x, int y, int health, int level, int strength) {
        // Pass core data up to LivingEntity
        super(name, x, y, health, level, strength); // Pass strength to super        
        this.stamina = 100; // Warriors start with full stamina
        this.backpack = new Inventory(15);
    }

    public Inventory getBackpack() { return backpack; }

    @Override
    public void displayInfo() {
        System.out.println(" [Warrior] Name: " + name + " | Level: " + level + " | HP: " + health + "/" + maxHealth);
    }

    @Override
    public void attack(LivingEntity target) {
        // 1. Get Base Strength from LivingEntity (The one potions update)
        int totalDamage = this.getStrength(); 

        // 2. Add Weapon Damage if something is equipped
        if (backpack.getEquippedWeapon() != null) {
            totalDamage += backpack.getEquippedWeapon().getDamage();
        }

        // 3. Apply level bonus
        totalDamage += (this.level * 2);

        if (stamina >= 10) {
            stamina -= 10;
            System.out.println(name + " performs a Heavy Strike for " + totalDamage + " damage!");
            target.takeDamage(totalDamage);
        } else {
            System.out.println(name + " is exhausted, dealing " + (totalDamage / 2) + " damage.");
            target.takeDamage(totalDamage / 2);
        }
    }

    // Unique Warrior behavior
    public void rest() {
        this.stamina = 100;
        System.out.println(name + " takes a breather and restores stamina.");
    }

    public int getStamina() {
        return stamina;
    }
}