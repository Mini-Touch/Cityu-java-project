package mechanics;

import core.LivingEntity;

public class CombatManager {

    /**
     * Core combat logic (your main responsibility)
     * Calculates damage + 25% critical hit chance + death check
     */
    public static void applyDamageWithCritical(LivingEntity attacker, LivingEntity target, int baseDamage) {
        if (!target.isAlive()) {
            throw new DeadEntityException("Cannot attack a dead entity: " + target.getName());
        }

        boolean isCritical = Math.random() < 0.25; // 25% critical hit
        int finalDamage = isCritical ? (int)(baseDamage * 1.8) : baseDamage;

        if (isCritical) {
            System.out.println("*** CRITICAL HIT! ***");
        }

        System.out.println(attacker.getName() + " deals " + finalDamage + " damage to " + target.getName() + "!");
        target.takeDamage(finalDamage);

        if (!target.isAlive()) {
            System.out.println(target.getName() + " has been defeated!");
        }
    }
}