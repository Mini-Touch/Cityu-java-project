package Item.Consumable;

import core.LivingEntity;  // <--- Add this line!

public class HealthPotion extends Consumable {
    private int healAmount;

    public HealthPotion(String name, int weight, int healAmount) {
        super("HealthPotion", 1, "A shimmering red liquid that restores " + healAmount + " HP.");        
        this.healAmount = healAmount;
    }

    @Override
    public void use(LivingEntity target) {
        target.heal(healAmount);
        System.out.println(target.getName() + " used a potion!");    
    }
}
