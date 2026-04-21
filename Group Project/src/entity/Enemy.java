package entity;

import core.LivingEntity;
import Item.Item;
import Item.Consumable.HealthPotion;
import Item.Weapon.GlassDagger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends LivingEntity {
    private List<Item> lootTable;

    public Enemy(String name, int x, int y, int health, int level, int strength) {
        super(name, x, y, health, level, strength);
        this.lootTable = new ArrayList<>();
        initializeLoot();
    }

    private void initializeLoot() {
        // Balance: Common drops (Potions) and rare drops (Weapons)
        lootTable.add(new HealthPotion("Rusty Potion", 1, 10));
        lootTable.add(new HealthPotion("Standard Potion", 1, 25));
        lootTable.add(new GlassDagger()); // Rare drop
    }

    @Override
    public void displayInfo() {
        System.out.println("[Enemy] " + name + " | HP: " + health + " | Level: " + level);
    }

    @Override
    public void attack(LivingEntity target) {
        int damage = strength + (level * 1);
        System.out.println(name + " lunges at " + target.getName() + "!");
        target.takeDamage(damage);
    }

    // The Drop System
    public Item dropLoot() {
        if (!this.isAlive()) {
            Random rand = new Random();
            // 70% chance to drop something, 30% chance to drop nothing
            if (rand.nextDouble() < 0.70) {
                Item dropped = lootTable.get(rand.nextInt(lootTable.size()));
                System.out.println(" " + name + " dropped: " + dropped.getName());
                return dropped;
            }
        }
        return null;
    }
}