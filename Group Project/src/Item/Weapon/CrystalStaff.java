package Item.Weapon;

public class CrystalStaff extends Weapon {
    private int magicBoost;

    public CrystalStaff() {
        // Name, Weight, Physical Damage
        super("Crystal Staff", 6, 5, "A staff tipped with a pulsing blue gem. Enhances magical focus."); 
        this.magicBoost = 20; // High magic bonus
    }

    public int getMagicBoost() {
        return magicBoost;
    }
}