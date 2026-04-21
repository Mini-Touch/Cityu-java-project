package Item.Consumable;

import core.LivingEntity;

public class MysterySoup extends Consumable {
    public MysterySoup() {
        super("Mystery Soup", 2,"Look strange, maybe it taste good?");
    }

    @Override
    public void use(LivingEntity target) {
        // Random effect between -10 and 10
        int effect = (int)(Math.random() * 21) - 10; 

        if (effect > 0) {
            target.heal(effect); // Use the public heal method
            System.out.println(target.getName() + " found the soup delicious! +" + effect + " HP");
        } else if (effect < 0) {
            // Use Math.abs to turn -5 into 5 for the damage method
            target.takeDamage(Math.abs(effect)); 
            System.out.println(target.getName() + " hated the soup... " + effect + " HP");
        } else {
            System.out.println(target.getName() + " thought the soup was flavorless. No effect.");
        }
    }
}