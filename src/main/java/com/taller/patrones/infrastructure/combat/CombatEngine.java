package com.taller.patrones.infrastructure.combat;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;
import com.taller.patrones.infrastructure.factory.*;
import com.taller.patrones.infrastructure.strategies.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Motor de combate. Calcula daño y crea ataques.
 * <p>
 * Nota: Esta clase crece cada vez que añadimos un ataque nuevo o un tipo de daño distinto.
 */
public class CombatEngine {
    private final Map<String, AttackFactory> factories = new HashMap<>();//mapa para evitar el switch
    private final Map<Attack.AttackType, DamageStrategy>strategies = new HashMap<>();


    public CombatEngine() {
        factories.put("TACKLE", new TackleAttackFactory());
        factories.put("SLASH", new SlashAttackFactory());
        factories.put("FIREBALL", new FireBallAttackFactory());
        factories.put("ICE_BEAM", new IceBeamAttackFactory());
        factories.put("POISON_STING", new PoisonStingAttackFactory());
        factories.put("THUNDER", new ThunderAttackFactory());
        factories.put("METEORO", new MeteoroAttackFactory());
        strategies.put(Attack.AttackType.NORMAL, new NormalDamageStrategy());
        strategies.put(Attack.AttackType.SPECIAL, new SpecialDamageStrategy());
        strategies.put(Attack.AttackType.STATUS, new StatusDamageStrategy());
        strategies.put(Attack.AttackType.CRITICAL, new CriticalDamageStrategy());

    };
    /**
     * Crea un ataque a partir de su nombre.
     * Cada ataque nuevo requiere modificar este método.
     */
    public Attack createAttack(String name) {
        String n = name != null ? name.toUpperCase() : "";
        AttackFactory factory = factories.get(n);
        if(factory!= null){
            return  factory.createAttack();
        }
        factory = new GolpeAttackFactory();//Caso por defecto
        return factory.createAttack();
    }

    /**
     * Calcula el daño según el tipo de ataque.
     * Cada fórmula nueva (ej. crítico, veneno con tiempo) requiere modificar este switch.
     */
    public int calculateDamage(Character attacker, Character defender, Attack attack) {
        DamageStrategy strategy = strategies.get(attack.getType());

        if (strategy != null) {
            return strategy.calculateDamage(attacker, defender, attack);
        }else{
            return 0;
        }


    }
}
