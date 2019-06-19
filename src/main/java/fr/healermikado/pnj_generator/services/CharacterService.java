package fr.healermikado.pnj_generator.services;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.daos.IRaceDao;
import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.dtos.LevelDto;
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
    public CharacterDto generateCharacter() {
        List<Race> races = iRaceDao.findAll();
        Collections.shuffle(races);

        races.forEach(r -> r.setGenericTalents(talentService.findAllGenericTalent()));

        int characterLevel = ThreadLocalRandom.current().nextInt(0, 11);

        Race race = races.get(0);

        CharacterDto outputCharacter = new CharacterDto(tokenService.generateRandomName(race.getPossibleToken()), race,
                characterLevel);
        outputCharacter.setTalents(talentService.generateTalentsMap(race.generateAllTalents(), characterLevel));
        setStatisticLevel(outputCharacter);
        return outputCharacter;
    }

    public void setStatisticLevel(CharacterDto theCharacterToCreate) {
        int bodyLevel = 0;
        int mindLevel = 0;
        int charmLevel = 1;

        // At level one a character can upgrade body or mind
        if (Math.random() < 0.5) {
            bodyLevel++;
        } else {
            mindLevel++;
        }
        // For each level upgrade a stat
        for (int i = 0; i < theCharacterToCreate.getLevel(); i++) {
            boolean updated = false;
            do {
                int random = ThreadLocalRandom.current().nextInt(3);
                switch (random) {
                case 0:
                if (talentService.getLevelService().isUpgradable(bodyLevel)){
                    bodyLevel++;
                    updated=true;
                }
                    break;
                case 1:
                if (talentService.getLevelService().isUpgradable(mindLevel)){
                    mindLevel++;
                    updated=true;
                }
                    break;
                case 2:
                if (talentService.getLevelService().isUpgradable(charmLevel)){
                    charmLevel++;
                    updated=true;
                }
                    break;
                default:
                    break;
                }
                
            } while (!updated);
        }

        System.out.println(bodyLevel);
        System.out.println(mindLevel);
        System.out.println(charmLevel);
        theCharacterToCreate.setBodyLevel(new LevelDto(talentService.getLevelService().getLevels().get(bodyLevel)));
        theCharacterToCreate.setMindLevel(new LevelDto(talentService.getLevelService().getLevels().get(mindLevel)));
        theCharacterToCreate.setCharmLevel(new LevelDto(talentService.getLevelService().getLevels().get(charmLevel)));

    }

}