package com.taller.patrones.infrastructure.factory;

import com.taller.patrones.domain.Attack;

// Bien
public interface AttackFactory {
    Attack createAttack();
}
