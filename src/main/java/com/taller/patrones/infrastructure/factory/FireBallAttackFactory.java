package com.taller.patrones.infrastructure.factory;

import com.taller.patrones.domain.Attack;

public class FireBallAttackFactory implements AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Fireball", 80, Attack.AttackType.SPECIAL);
    }
}
