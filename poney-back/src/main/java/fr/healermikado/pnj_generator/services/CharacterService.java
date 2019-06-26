package fr.healermikado.pnj_generator.services;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.daos.ICharacterDao;
import fr.healermikado.pnj_generator.daos.IRaceDao;
import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.dtos.HalfWayCharacter;
import fr.healermikado.pnj_generator.dtos.LevelDto;
import fr.healermikado.pnj_generator.entity.CharacterEntity;
import fr.healermikado.pnj_generator.entity.Race;

/**
 * CharacterService
 */
@Service
public class CharacterService implements ICharacterService {
	@Autowired
	private ICharacterDao iCharacterDao;
    @Autowired
    private IRaceDao iRaceDao;

    @Autowired
    private TalentService talentService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private QuirkService quirkService;

    @Override
    public CharacterDto generateCharacter() {
        List<Race> races = iRaceDao.findAll();
        Collections.shuffle(races);

        races.forEach(r -> r.setGenericTalents(talentService.findAllGenericTalent()));

        int characterLevel = ThreadLocalRandom.current().nextInt(0, 11);

        Race race = races.get(0);

        CharacterDto outputCharacter = new CharacterDto(tokenService.generateRandomName(race.getPossibleToken()), race,
                characterLevel);
        // the the talent
        outputCharacter.setTalents(talentService.generateTalentsMap(race.generateAllTalents(), characterLevel));
        //set the quirks. TODO change that
        outputCharacter.setQuirks(
                quirkService.getSomeQuirkEntities(1).stream().map(q -> q.getValue()).collect(Collectors.toSet()));
        setStatisticLevel(outputCharacter);

        return outputCharacter;
    }
    
//    @Override
//    public CharacterEntity generateCharacter(HalfWayCharacter hc) {
//        hc.getRace().setGenericTalents(talentService.findAllGenericTalent());
//
//        int characterLevel =hc.getLevel();
//
//        Race race = hc.getRace();
//
//         outputCharacter = new CharacterDto(hc.getName(), race,
//                characterLevel);
//        // the the talent
//        outputCharacter.setTalents(talentService.generateTalentsMap(race.generateAllTalents(), characterLevel));
//        //set the quirks. TODO change that
//        outputCharacter.setQuirks(
//                quirkService.getSomeQuirkEntities(1).stream().map(q -> q.getValue()).collect(Collectors.toSet()));
//        setStatisticLevel(outputCharacter);
//        
//        iCharacterDao.save(outputCharacter);
//        return outputCharacter;
//    }
    
    
    
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
                    if (talentService.getLevelService().isUpgradable(bodyLevel)) {
                        bodyLevel++;
                        updated = true;
                    }
                    break;
                case 1:
                    if (talentService.getLevelService().isUpgradable(mindLevel)) {
                        mindLevel++;
                        updated = true;
                    }
                    break;
                case 2:
                    if (talentService.getLevelService().isUpgradable(charmLevel)) {
                        charmLevel++;
                        updated = true;
                    }
                    break;
                default:
                    break;
                }

            } while (!updated);
        }

        theCharacterToCreate.setBodyLevel(new LevelDto(talentService.getLevelService().getLevels().get(bodyLevel)));
        theCharacterToCreate.setMindLevel(new LevelDto(talentService.getLevelService().getLevels().get(mindLevel)));
        theCharacterToCreate.setCharmLevel(new LevelDto(talentService.getLevelService().getLevels().get(charmLevel)));

    }

}