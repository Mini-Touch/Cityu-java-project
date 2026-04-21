package Item.Consumable;

import core.LivingEntity;

public class StrengthPotion extends Consumable {
    private int strengthBoost;

    public StrengthPotion(String name, int weight, int strengthBoost) {
        super("StrengthPotion", 1, "A bitter red liquid that provided" + strengthBoost + "strength");
        this.strengthBoost = strengthBoost;
    }

    @Override
    public void use(LivingEntity target) {
        if (target != null) {
            target.addStrength(strengthBoost);
            System.out.println(target.getName() + " gained strength!");
        }
    }
}