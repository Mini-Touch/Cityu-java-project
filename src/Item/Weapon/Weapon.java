package Item.Weapon;

import Item.Item;

public class Weapon extends Item {
    private int damage;

    public Weapon(String name, int weight, int damage, String description) {
        super(name, weight, description);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
