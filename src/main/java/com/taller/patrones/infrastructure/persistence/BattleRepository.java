package com.taller.patrones.infrastructure.persistence;

import com.taller.patrones.domain.Battle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Almacena las batallas activas en memoria.
 * <p>
 * Nota: BattleService hace new BattleRepository() cada vez. Si otro servicio
 * también creara su propio BattleRepository, ¿compartirían las batallas?
 */
public class BattleRepository {
    private static  BattleRepository instance;
    private static final Map<String, Battle> battles = new ConcurrentHashMap<>();

    private BattleRepository() {

    } //Te ha faltado el constructor privado, si no lo poner privado explícitamente, se siguen pudiendo crear objetos
    // sin usar tu método getInstance(), así que seguirá pudiendo haber más de una instancia. Cuando quieres hacer
    //  algo, no confías en que el usuario lo hará bien, por eso tienes que limitarlo y validarlo todo.

    public void save(String id, Battle battle) {
        battles.put(id, battle);
    }

    public Battle findById(String id) {
        return battles.get(id);
    }

    public void remove(String id) {
        battles.remove(id);
    }

    public static BattleRepository getInstance(){
        if (instance == null ){
            instance = new BattleRepository();
        }
        return instance;
    } // Bien
}
