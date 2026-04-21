package core;

/**
 * Requirement: OOD Principles (Abstract Class)
 * This is the root of the hierarchy. It cannot be instantiated.
 */
public abstract class GameEntity {
    protected String name;
    protected int x, y;

    public GameEntity(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    // Abstract method: Every entity must define how it displays itself.
    public abstract void displayInfo();

    // Getters and Setters (Encapsulation)
    public String getName() { return name; }
    public int getX() { return x; }
    public int getY() { return y; }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
} 