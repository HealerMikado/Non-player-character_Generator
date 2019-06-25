package fr.healermikado.pnj_generator.dtos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import fr.healermikado.pnj_generator.entity.CharacterEntity;
import fr.healermikado.pnj_generator.entity.Race;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Character
 * 
 */
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
    private Map<String, LevelDto> talents;

    // The body level
    private LevelDto bodyLevel;

    // The mind level
    private LevelDto mindLevel;

    // The charm level
    private LevelDto charmLevel;
    
    // The rouce image
    private String src;

    //The default list
    private Set<String> quirks;

    public CharacterDto(String name, Race race, int level) {
        this.name = name;
        this.race = race.getNom();
        this.level = level;
    }

    public CharacterDto(CharacterEntity alreadyMadeEntity) {

        
        this.name = alreadyMadeEntity.getName();
        this.race = alreadyMadeEntity.getRace().getNom();
        this.src = alreadyMadeEntity.getSrc();
        this.quirks = alreadyMadeEntity.getQuirks().stream().map(q-> q.getValue()).collect(Collectors.toSet());

        // Automatic map between entity et dto
        ModelMapper modelMapper = new ModelMapper();
        this.bodyLevel = modelMapper.map(alreadyMadeEntity.getBodyLevel(), LevelDto.class);
        this.mindLevel = modelMapper.map(alreadyMadeEntity.getMindLevel(), LevelDto.class);
        this.charmLevel = modelMapper.map(alreadyMadeEntity.getCharmLevel(), LevelDto.class);
        
    }

}