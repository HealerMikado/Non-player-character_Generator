package fr.healermikado.pnj_generator.services;

import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.dtos.HalfWayCharacter;
import fr.healermikado.pnj_generator.entity.CharacterEntity;

/**
 * ICharacterService
 */
public interface ICharacterService {

    public CharacterDto generateCharacter();
//    public CharacterEntity generateCharacter(HalfWayCharacter hc);
}