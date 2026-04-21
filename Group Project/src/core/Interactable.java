package core;

public interface Interactable {
    void showActions();
    void handleInput(int choice, LivingEntity target);
}