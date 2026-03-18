package com.taller.patrones.infrastructure.factory;

import com.taller.patrones.domain.Attack;

public class IceBeamAttackFactory implements AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Ice Beam", 70, Attack.AttackType.SPECIAL);
    }
}
