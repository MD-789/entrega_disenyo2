package com.taller.patrones.infrastructure.strategies;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;

public class CriticalDamageStrategy implements DamageStrategy{
    @Override
    public int calculateDamage(Character attacker, Character defender, Attack attack) {
        // 20% de probabilidad
        if (Math.random() > 0.2) {
            return 0; // el ataque falla
        }

        int raw = (int) (((double) (attacker.getAttack() * attack.getBasePower()) / 100) * 1.5);
        return Math.max(1, raw - defender.getDefense());
    }
}
