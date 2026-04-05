package com.taller.patrones.domain;



/**
 * Representa un personaje en combate.
 */
public class Character {

    private final String name;
    private int currentHp;
    private final int maxHp;
    private final int attack;
    private final int defense;
    private final int speed;
    private final String equipamiento; //Intenta evitar el spanglish.
    // Yo intento programar siempre en inglés por costumbre. Elijas lo que elijas, quédate con uno.
    private boolean bufado;
    private ClaseType clase;


    private Character(Builder builder) {
        this.name = builder.name;
        this.maxHp = builder.maxHp;
        this.currentHp = builder.currentHp != null ? builder.currentHp : builder.maxHp;
        this.attack = builder.attack;
        this.defense = builder.defense;
        this.speed = builder.speed;
        this.equipamiento = builder.equipamiento;
        this.bufado = builder.bufado;
        this.clase = builder.clase;

    } //Entiendo tu idea pero es raro, lo suyo es tener un estático que devuelva un builder,
    // y que ese builder haga un .build devolviendo un Character con los valores que se le hayan
    // asignado:
    //https://github.com/AnaGciaSchz/dragon-quest-patrones/blob/solucion-ana/src/main/java/com/taller/patrones/domain/model/Character.java

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private String name;
        private Integer currentHp; // opcional. Bien visto.
        private int maxHp;
        private int attack;
        private int defense;
        private int speed;
        private String equipamiento;
        private boolean bufado;
        private ClaseType clase;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder maxHp(int maxHp) {
            this.maxHp = maxHp;
            return this;
        }

        public Builder currentHp(int currentHp) {
            this.currentHp = currentHp;
            return this;
        }

        public Builder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder defense(int defense) {
            this.defense = defense;
            return this;
        }

        public Builder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public Builder equipamiento(String equipamiento){
            this.equipamiento = equipamiento;
            return this;
        }

        public Builder bufado(boolean bufado){
            this.bufado = bufado;
            return this;
        }

        public Builder clase(ClaseType clase){
            this.clase = clase;
            return this;
        }

        public Character build() {

            // Validaciones mínimas. Me gustan, aunque habría que añadir alguna más, como que la currentHP no puede ser mayor
            // que la maxHP. Pero bueno, esta práctica es para lo que es así que se entiende la idea y está bien hecho
            if (name == null || name.isBlank()) {
                throw new IllegalStateException("Name is required");
            }
            if (maxHp <= 0) {
                throw new IllegalStateException("maxHp must be > 0");
            }

            return new Character(this);
        }
    }

    public String getName() { return name; }
    public int getCurrentHp() { return currentHp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public String getEquipamiento() {return equipamiento;}
    public boolean isBufado() {return bufado;}
    public ClaseType getClase() {return clase;}

    public void takeDamage(int damage) {
        this.currentHp = Math.max(0, currentHp - damage);
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public double getHpPercentage() {
        return maxHp > 0 ? (double) currentHp / maxHp * 100 : 0;
    }

    public enum ClaseType {
        GUERRERO,MAGO
    }
}
