package Item;
public class Armor extends Item {
    private int defense;

    public Armor(String name, int weight, String description, int defense) {
        super(name, weight, description);
        this.defense = defense;
    }

    public int getDefense() { return defense; }
}
