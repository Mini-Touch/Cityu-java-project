package Item.Consumable;

import core.LivingEntity; 

public class MaxHealthElixir extends Consumable {
    public MaxHealthElixir() {
        super("Max Health Elixir", 1,"A Legendary Elixr provided regeneration of full HP");
    }

    @Override
    public void use(LivingEntity target) {
        // Use existing methods to change state
        target.heal(100); 
        System.out.println(target.getName() + " drank a legendary elixir!");
    }
}