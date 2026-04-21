package Item.Weapon;

public class ApprenticeWand extends Weapon {
    private int manaRegenBonus;

    public ApprenticeWand() {
        super("Apprentice Wand", 2, 2,"Wand for Apprentice Mage, Having high recover for mana");
        this.manaRegenBonus = 5; // Helps Mage recover mana faster
    }

    public int getManaRegenBonus() {
        return manaRegenBonus;
    }
}