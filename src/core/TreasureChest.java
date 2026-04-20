package core;

import mechanics.DeadEntityException;

public class TreasureChest implements Damageable, Interactable {
    private int durability = 50;
    private boolean isOpened = false;

    @Override
    public void takeDamage(int amount) {
        durability -= amount;
        if (durability <= 0) {
            System.out.println("💥 The treasure chest shatters open!");
            isOpened = true;
        }
    }

    @Override
    public int getCurrentHealth() {
        return durability;
    }

    @Override
    public boolean isDead() {
        return durability <= 0;
    }

    @Override
    public void interact(LivingEntity entity) {
        if (isOpened || isDead()) {
            System.out.println("The chest is already empty.");
        } else {
            System.out.println("You open the chest and find healing items inside!");
            isOpened = true;
            entity.heal(30);   // Uses LivingEntity.heal() – no cast needed
        }
    }

    @Override
    public String getDescription() {
        return isOpened ? "An opened empty chest." : "A sturdy locked treasure chest.";
    }
}