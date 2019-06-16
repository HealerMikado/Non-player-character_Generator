package fr.healermikado.pnj_generator.businessObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import fr.healermikado.pnj_generator.entity.Race;
import fr.healermikado.pnj_generator.entity.Talent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Character
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Character {

    private String name;
    private String race;
    private int level;

    private Map<String,String> talents;

    public Character (String name, Race race,int level){
        this.name = name;
        this.race = race.getNom();
        this.level = level;
    }
    
}