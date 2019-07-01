package fr.healermikado.pnj_generator.dtos;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import fr.healermikado.pnj_generator.entity.CharacterEntity;
import fr.healermikado.pnj_generator.entity.Level;
import fr.healermikado.pnj_generator.entity.Race;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Character
 * 
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CharacterDto {

    // The name of the pony
    private String name;

    // The string representation of the race of the pony 
    private String race;

    // The level of the pony
    private int level;

    // The talents of the pony and theirs level
    private Map<String, Level> talents;

    // The body level
    private Level bodyLevel;

    // The mind level
    private Level mindLevel;

    // The charm level
    private Level charmLevel;
    
    // The rouce image
    private String src;

    //The default list
    private Set<String> quirks;

    public CharacterDto(String name, Race race, int level) {
        this.name = name;
        this.race = race.getName();
        this.level = level;
    }

    public CharacterDto(String name, String race, int level, String src) {
        this.name = name;
        this.race = race;
        this.level = level;
        this.src = src;
    }


    public CharacterDto(CharacterEntity alreadyMadeEntity) {

        this.name = alreadyMadeEntity.getName();
        this.level = alreadyMadeEntity.getLevel();
        this.race = alreadyMadeEntity.getRace().getName();
        this.src = alreadyMadeEntity.getSrc();
        this.quirks = alreadyMadeEntity.getQuirks().stream().map(q-> q.getValue()).collect(Collectors.toSet());
        this.bodyLevel = alreadyMadeEntity.getBodyLevel();
        this.mindLevel = alreadyMadeEntity.getMindLevel();
        this.charmLevel = alreadyMadeEntity.getCharmLevel();
        
    }
    
}