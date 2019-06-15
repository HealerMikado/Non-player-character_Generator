package fr.healermikado.pnj_generator.services;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.businessObjects.Character;
import fr.healermikado.pnj_generator.daos.IRaceDao;
import fr.healermikado.pnj_generator.daos.ITalentDao;
import fr.healermikado.pnj_generator.entity.Race;
import fr.healermikado.pnj_generator.entity.Talent;

/**
 * CharacterService
 */
@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private IRaceDao iRaceDao;

    @Autowired
    private ITalentDao iTalentDao;

    @Override
    public Character generateCharacter() {
        List<Race> races = iRaceDao.findAll();
        Collections.shuffle(races);

        Set<Talent> genericTalents = iTalentDao.findAllGenericTalent();
        races.forEach(r -> r.setGenericTalents(genericTalents));

        int characterLevel = ThreadLocalRandom.current().nextInt(0, 11);

        Race race = races.get(0);

        Character outputCharacter = new Character("toto", race.getNom(),characterLevel);
        outputCharacter.generateTalentsMap(race.getAllTalents());

        return outputCharacter;
    }

}