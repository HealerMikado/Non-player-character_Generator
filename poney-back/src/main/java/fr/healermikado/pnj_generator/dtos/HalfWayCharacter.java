package fr.healermikado.pnj_generator.dtos;

import fr.healermikado.pnj_generator.entity.Race;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HalfWayCharacter {
	private String name;
	private Race race;
	private int level;
	private String src;

}
