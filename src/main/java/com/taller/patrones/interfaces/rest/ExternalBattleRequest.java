package com.taller.patrones.interfaces.rest;

/**
 * Buen nombre de clase, se entiende lo que es
 *
 * También buena idea hacer que venga ya mapeado desde fuera gracias a este dto. De momento se adapta a nuestro caso,
 * pero piensa en cómo evolucionaría si aparece un nuevo formato de entrada con otros nombres de campos. ¿Cómo lo
 * adaptarías? (por ir un poco mas allá, esto está muy bien)
 */
public class ExternalBattleRequest {

    public String fighter1_name;
    public Integer fighter1_hp;
    public Integer fighter1_atk;

    public String fighter2_name;
    public Integer fighter2_hp;
    public Integer fighter2_atk;
}