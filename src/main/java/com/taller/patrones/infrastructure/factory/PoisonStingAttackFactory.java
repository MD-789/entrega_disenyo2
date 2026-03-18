package com.taller.patrones.infrastructure.factory;

import com.taller.patrones.domain.Attack;

public class PoisonStingAttackFactory implements AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Poison Sting", 20, Attack.AttackType.STATUS);
    }
}
