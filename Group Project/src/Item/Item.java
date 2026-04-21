package Item;

public abstract class Item {
    private String name;
    private int weight;
    protected String description; 

    public Item(String name, int weight, String description) {
        this.name = name;
        this.weight = weight;
        this.description = description;
    }

    public String getName() { return name; }
    public int getWeight() { return weight; }
    public String getDescription() { return description; }
    
}

