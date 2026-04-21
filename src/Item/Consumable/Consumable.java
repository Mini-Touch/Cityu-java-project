package Item.Consumable; // 1. Package at the top

import Item.Item;        // 2. Import the parent
import core.LivingEntity;   // 3. Import the Player

public abstract class Consumable extends Item {
    public Consumable(String name, int weight, String description) {
        super(name, weight, description);
    }

    // Now accepts any LivingEntity (Warrior/Mage) instead of just Player
    public abstract void use(LivingEntity target);
}

