package fr.healermikado.pnj_generator.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.daos.IAlreadyMadeEntityDao;
import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.entity.CharacterEntity;

/**
 * AlreadyMadeCharacterService
 */
@Service
public class AlreadyMadeCharacterService {

    @Autowired
    private IAlreadyMadeEntityDao iAlreadyMadeEntityDao;

    public CharacterDto getCharacterById(Long id) {
        Optional<CharacterEntity> optCharEntity = iAlreadyMadeEntityDao.findById(id);
        CharacterDto outputedCharacterDto = null;

        if (optCharEntity.isPresent()) { 
            outputedCharacterDto = new CharacterDto(iAlreadyMadeEntityDao.findById(id).get());
        }

        return outputedCharacterDto;
    }
}