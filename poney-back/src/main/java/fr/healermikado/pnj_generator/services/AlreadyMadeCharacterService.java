package fr.healermikado.pnj_generator.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.daos.ICharacterDao;
import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.entity.CharacterEntity;

/**
 * AlreadyMadeCharacterService
 */
@Service
public class AlreadyMadeCharacterService {

    @Autowired
    private ICharacterDao iAlreadyMadeEntityDao;

    public CharacterDto getCharacterById(Long id) {
        Optional<CharacterEntity> optCharEntity = iAlreadyMadeEntityDao.findById(id);
        CharacterDto outputedCharacterDto = null;

        if (optCharEntity.isPresent()) { 
            outputedCharacterDto = new CharacterDto(iAlreadyMadeEntityDao.findById(id).get());
        }

        return outputedCharacterDto;
    }

	public List<CharacterDto> getAllCharacter() {
		return iAlreadyMadeEntityDao.findAll().stream().map(p-> new CharacterDto(p)).collect(Collectors.toList());
	}
}