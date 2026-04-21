package mechanics;

import entity.Warrior;
import entity.Enemy;
import java.util.Scanner;

public class StageManager {
    private Scanner input = new Scanner(System.in);

    public void startStage(Warrior player, Enemy enemy) {
        System.out.println(" STAGE START: " + player.getName() + " vs " + enemy.getName());

        while (player.isAlive() && enemy.isAlive()) {
            // 1. Show the "Buttons"
            showMenu(player);
            
            // 2. Get Selection
            int choice = input.nextInt();
            handleAction(choice, player, enemy);

            // 3. Enemy Turn
            if (enemy.isAlive()) {
                System.out.println("\n--- Enemy's Turn ---");
                enemy.attack(player);
            }
            
            System.out.println("\n================================");
        }
    }

    private void showMenu(Warrior p) {
        System.out.println("\n[ " + p.getName() + " HP: " + p.getHealth() + " ]");
        System.out.println("Choose your action:");
        System.out.println("1.  Attack");
        System.out.println("2.  Open Inventory");
        System.out.println("3.  Rest (Restore Stamina)");
        System.out.print("Select (1-3): ");
    }

    private void handleAction(int choice, Warrior p, Enemy e) {
        switch (choice) {
            case 1:
                p.attack(e);
                break;
            case 2:
                p.getBackpack().showItems();
                // You could add logic here to select an item index!
                break;
            case 3:
                p.rest();
                break;
            default:
                System.out.println("Invalid choice! You tripped and wasted your turn.");
        }
    }
}