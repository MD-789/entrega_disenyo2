package com.taller.patrones.infrastructure.strategies;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;

/**
 * Bien
 */
public interface DamageStrategy {
    int calculateDamage(Character attacker, Character defender, Attack attack);
}
