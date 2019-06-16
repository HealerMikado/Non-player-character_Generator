package fr.healermikado.pnj_generator.services;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.businessObjects.Character;
import fr.healermikado.pnj_generator.daos.IRaceDao;
import fr.healermikado.pnj_generator.entity.Race;

/**
 * CharacterService
 */
@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private IRaceDao iRaceDao;

    @Autowired
    private TalentService talentService;

    @Autowired
    private TokenService tokenService;

    @Override
    public Character generateCharacter() {
        List<Race> races = iRaceDao.findAll();
        Collections.shuffle(races);

        races.forEach(r -> r.setGenericTalents(talentService.findAllGenericTalent()));

        int characterLevel = ThreadLocalRandom.current().nextInt(0, 11);

        Race race = races.get(0);

        Character outputCharacter = new Character(tokenService.generateRandomName(), race,characterLevel);
        outputCharacter.setTalents(talentService.generateTalentsMap(race.getAllTalents(), characterLevel));

        return outputCharacter;
    }

}