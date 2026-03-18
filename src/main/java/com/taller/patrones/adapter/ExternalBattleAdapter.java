package com.taller.patrones.adapter;

import com.taller.patrones.interfaces.rest.ExternalBattleRequest;
import org.springframework.stereotype.Component;
import com.taller.patrones.domain.Character;

@Component
public class ExternalBattleAdapter {

    public Character toPlayer(ExternalBattleRequest req) {
        return new Character.Builder()
                .name(req.fighter1_name != null ? req.fighter1_name : "Héroe")
                .maxHp(req.fighter1_hp != null ? req.fighter1_hp : 150)
                .attack(req.fighter1_atk != null ? req.fighter1_atk : 25)
                .defense(10)
                .speed(5)
                .build();
    }

    public Character toEnemy(ExternalBattleRequest req) {
        return new Character.Builder()
                .name(req.fighter2_name != null ? req.fighter2_name : "Dragón")
                .maxHp(req.fighter2_hp != null ? req.fighter2_hp : 120)
                .attack(req.fighter2_atk != null ? req.fighter2_atk : 30)
                .defense(8)
                .speed(4)
                .build();
    }
}
