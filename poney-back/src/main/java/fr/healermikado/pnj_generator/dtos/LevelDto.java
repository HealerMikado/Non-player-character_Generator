package fr.healermikado.pnj_generator.dtos;

import fr.healermikado.pnj_generator.entity.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Level
 * 
 * Level of a talent
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelDto {

    private String diceValue;    

    public LevelDto (Level level){
        this.diceValue = level.getDiceValue();
    }

}