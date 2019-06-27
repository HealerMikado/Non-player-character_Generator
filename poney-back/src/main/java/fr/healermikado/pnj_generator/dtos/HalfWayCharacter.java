package fr.healermikado.pnj_generator.dtos;

import fr.healermikado.pnj_generator.entity.Race;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * the input from the ui 
 */
@Getter
@Setter
@AllArgsConstructor
public class HalfWayCharacter {
	private String name;
	private Race race;
	private int level;
	private String src;

}
