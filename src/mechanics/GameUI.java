package mechanics;

import core.LivingEntity;
import entity.Warrior;
import entity.Mage;

public class GameUI {

    // Creates the [████------] visual bar
    private String getBar(int current, int max, String symbol) {
        int barWidth = 10; 
        int filledSegments = Math.max(0, (int) ((double) current / max * barWidth));
        
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barWidth; i++) {
            if (i < filledSegments) bar.append(symbol);
            else bar.append("-");
        }
        bar.append("] ");
        bar.append(current).append("/").append(max);
        return bar.toString();
    }

    public void displayBattleStatus(LivingEntity player, LivingEntity enemy) {
        System.out.println("\n" + "=".repeat(40));
        
        // Player Side
        System.out.println(player.getName() + " (LVL " + player.getLevel() + ")");
        System.out.println("HP:   " + getBar(player.getHealth(), 100, "█"));
        
        if (player instanceof Warrior) {
            System.out.println("STM:  " + getBar(((Warrior) player).getStamina(), 100, "█"));
        } else if (player instanceof Mage) {
            System.out.println("MANA: " + getBar(((Mage) player).getMana(), 100, "█"));
        }

        System.out.println("-".repeat(20));
        
        // Enemy Side
        System.out.println(enemy.getName() + " (LVL " + enemy.getLevel() + ")");
        System.out.println("HP:   " + getBar(enemy.getHealth(), 100, "█"));
        System.out.println("=".repeat(40));
        
        // Action Menu (The "Buttons")
        System.out.println("ACTIONS:");
        System.out.println("1. Attack");
        System.out.println("2. Open Backpack");
        System.out.println("3. Rest / Meditate");
        System.out.print("> Selection: ");
    }
}