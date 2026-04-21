package core;

public abstract class LivingEntity extends GameEntity {
    protected int health;
    protected int maxHealth;
    protected int level;
    protected int strength;
    protected boolean isAlive;

    public LivingEntity(String name, int x, int y, int health, int level, int strength) {
        super(name, x, y); // Calls GameEntity constructor
        this.health = health;
        this.maxHealth = health;
        this.level = level;
        this.strength = strength;
        this.isAlive = true;
    }

    /**
     * Requirement: Polymorphism
     * We don't know HOW a LivingEntity attacks yet (Warrior swings, Mage casts).
     * We force subclasses to implement this.
     */
    public abstract void attack(LivingEntity target);

    public void takeDamage(int amount) {
        if (!isAlive) return;

        this.health -= amount;
        System.out.println(name + " received " + amount + " damage!");

        if (this.health <= 0) {
            this.health = 0;
            this.isAlive = false;
            System.out.println("💀 " + name + " has died!");
        }
    }

    // Common logic for all living things
    public void heal(int amount) {
        this.health += amount;
        
        if (isAlive && this.health > maxHealth) {
            this.health = maxHealth;            
            System.out.println(name + " healed for " + amount + ". Current HP: " + health);
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) { this.strength = strength; }

    public void addStrength(int amount) {
        this.strength += amount;
    }

    public int getLevel() {
        return level;
    }

    // (Optional) Add a setter if you want to level up later
    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isAlive() { return isAlive; }
    public int getHealth() { return health; }
}
