package com.taller.patrones.infrastructure.factory;

import com.taller.patrones.domain.Attack;

public class MeteoroAttackFactory implements AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Meteoro", 120, Attack.AttackType.SPECIAL);
    }
}
