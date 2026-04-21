package Item;

import Item.Consumable.Consumable;
import Item.Weapon.Weapon;
import core.LivingEntity;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();
    private Weapon equippedWeapon;
    private int maxCapacity;

    public Inventory(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    // This is the method your Warrior was looking for!
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void equipWeapon(Weapon weapon) {
        if (items.contains(weapon)) {
            this.equippedWeapon = weapon;
            System.out.println("Equipped: " + weapon.getName());
        }
    }

    public Item getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public boolean addItem(Item item) {
        items.add(item);
        return true;
    }

    public void showItems() {
        System.out.println("\n--- BACKPACK ---");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName());
        }
    }
    
    public void useConsumable(Consumable c, LivingEntity target) {
        c.use(target);
        items.remove(c);
    }
}