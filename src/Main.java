import entity.*;
import core.LivingEntity;
import mechanics.GameUI;
import Item.*;
import Item.Consumable.*;
import Item.Weapon.*;
import mechanics.CombatManager;
import mechanics.DeadEntityException;
import mechanics.OutOfManaException;
import core.Damageable;
import core.TreasureChest;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameUI ui = new GameUI();
        LivingEntity hero = null;

        // --- 1. CHARACTER SELECTION ---
        System.out.println("=== RPG CHARACTER SELECTION ===");
        System.out.println("1. Warrior (Strength & Stamina)\n2. Mage (Intelligence & Mana)");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if (choice == 1) {
            hero = new Warrior(name, 0, 0, 100, 1, 15);
        } else {
            hero = new Mage(name, 0, 0, 80, 1, 10);
        }

        // Give starter items
        Inventory heroInv;
        if (hero instanceof Warrior) {
            heroInv = ((Warrior) hero).getBackpack();
        } else {
            heroInv = ((Mage) hero).getBackpack();
        }
        heroInv.addItem(new HealthPotion("Health Potion", 1, 30));
        heroInv.addItem(new StrengthPotion("Strength Potion", 1, 5));
        if (hero instanceof Warrior) {
            heroInv.addItem(new HeavyWarhammer());
        } else {
            heroInv.addItem(new CrystalStaff());
        }

        // --- 2. MULTI-ENEMY LIST ---
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Goblin", 0, 0, 40, 1, 10));
        enemies.add(new Enemy("Slime", 0, 0, 30, 1, 5));

        // --- 3. MAIN BATTLE LOOP ---
        while (hero.isAlive() && !enemies.isEmpty()) {
            Enemy target = enemies.get(0);
            boolean turnEnded = false;

            while (!turnEnded && target.isAlive() && hero.isAlive()) {
                ui.displayBattleStatus(hero, target);
                int action = sc.nextInt();

                switch (action) {
                    case 1: // Attack
                        try {
                            hero.attack(target);
                        } catch (DeadEntityException | OutOfManaException e) {
                            System.out.println("Combat error: " + e.getMessage());
                        }
                        turnEnded = true;
                        break;

                    case 2: // Backpack
                        handleBackpack(hero, sc);
                        break;

                    case 3: // Rest / Meditate
                        if (hero instanceof Warrior) {
                            ((Warrior) hero).rest();
                        } else {
                            ((Mage) hero).rest();
                        }
                        turnEnded = true;
                        break;

                    default:
                        System.out.println("Invalid choice! You tripped and wasted your turn.");
                        turnEnded = true;
                }
            }

            // Cleanup dead enemies
            if (!target.isAlive()) {
                System.out.println("Victory over " + target.getName() + "!");
                Item drop = target.dropLoot();
                if (drop != null) {
                    Inventory inv;
                    if (hero instanceof Warrior) {
                        inv = ((Warrior) hero).getBackpack();
                    } else {
                        inv = ((Mage) hero).getBackpack();
                    }
                    inv.addItem(drop);
                }
                enemies.remove(0);
            }

            // Enemy Turn
            if (!enemies.isEmpty() && hero.isAlive() && turnEnded) {
                System.out.println("\n--- Enemy Turn ---");
                Enemy currentEnemy = enemies.get(0);
                try {
                    currentEnemy.attack(hero);
                } catch (DeadEntityException | OutOfManaException e) {
                    System.out.println("Enemy combat error: " + e.getMessage());
                }
            }
        }

        // --- 4. POST-BATTLE TREASURE ENCOUNTER ---
        if (hero.isAlive()) {
            System.out.println("\nYou have cleared the area!");

            System.out.println("\nYou discover a sturdy Treasure Chest nearby...");
            TreasureChest treasureChest = new TreasureChest();

            Damageable chestAsDamageable = treasureChest;
            System.out.println("Chest durability: " + chestAsDamageable.getCurrentHealth() +
                               " | Dead: " + chestAsDamageable.isDead());

            treasureChest.interact(hero);
        }

        // Clean win/lose message (no emoji)
        if (hero.isAlive()) {
            System.out.println("\nYOU WIN THE GAME!");
        } else {
            System.out.println("\nGAME OVER");
        }

        sc.close();
    }

    private static void handleBackpack(LivingEntity hero, Scanner sc) {
        Inventory inv;
        if (hero instanceof Warrior) {
            inv = ((Warrior) hero).getBackpack();
        } else if (hero instanceof Mage) {
            inv = ((Mage) hero).getBackpack();
        } else {
            return;
        }

        inv.showItems();
        System.out.print("Enter item # to use (0 to exit): ");
        if (sc.hasNextInt()) {
            int itemIdx = sc.nextInt();
            if (itemIdx > 0) {
                Item item = inv.getItem(itemIdx - 1);
                if (item != null) {
                    if (item instanceof Consumable) {
                        inv.useConsumable((Consumable) item, hero);
                    } else if (item instanceof Weapon) {
                        inv.equipWeapon((Weapon) item);
                    }
                }
            }
        } else {
            sc.next(); // Clear invalid input
        }
    }
}