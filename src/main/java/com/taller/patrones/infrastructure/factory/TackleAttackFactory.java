package com.taller.patrones.infrastructure.factory;

import com.taller.patrones.domain.Attack;

public class TackleAttackFactory implements AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Tackle", 40, Attack.AttackType.NORMAL);
    }
}
