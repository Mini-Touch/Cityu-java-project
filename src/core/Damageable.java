package core;

public interface Damageable {
    void takeDamage(int amount);
    int getCurrentHealth();
    boolean isDead();
}