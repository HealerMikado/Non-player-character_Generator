package fr.healermikado.pnj_generator.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.daos.ITalentDao;
import fr.healermikado.pnj_generator.entity.Level;
import fr.healermikado.pnj_generator.entity.Talent;

/**
 * TalentService
 */
@Service
public class TalentService {
    @Autowired
    private LevelService levelService;

    @Autowired
    private ITalentDao iTalentDao;

    public Set<Talent> findAllGenericTalent() {
        return iTalentDao.findAllGenericTalent();
    }

    public Map<String, Level> generateTalentsMap(List<Talent> allTalents, int level) {
        // generate the raw list of the talent
        List<String> listTalents = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            listTalents.add(allTalents.get(ThreadLocalRandom.current().nextInt(allTalents.size())).getNom());
        }

        // The map with raw level
        Map<String, Integer> talentsRawLvl = new HashMap<>();
        for (String nomTalent : listTalents) {
            if (talentsRawLvl.containsKey(nomTalent)) {
                // some more code to check if the level of the current talent if not max.
                // If not level up the talent, else choose another. Loop until a level up occur
                Integer currentTalentLevel;
                Boolean lvlUp = false;
                do {
                    currentTalentLevel = talentsRawLvl.get(nomTalent);
                    if (levelService.isUpgradable(currentTalentLevel)) {
                        lvlUp = true;
                    } else {
                        // Choose another talent
                        nomTalent = allTalents.get(ThreadLocalRandom.current().nextInt(allTalents.size()))
                                .getNom();
                    }

                } while (!lvlUp);
                talentsRawLvl.put(nomTalent, currentTalentLevel + 1);

            } else {
                talentsRawLvl.put(nomTalent, 0);
            }
        }
        Map<String, Level> talentsOut = talentsRawLvl.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), //
                        e -> levelService.getLevels().get(e.getValue())));

        return talentsOut;

    }

    public LevelService getLevelService() {
        return levelService;
    }

    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

    public ITalentDao getiTalentDao() {
        return iTalentDao;
    }

    public void setiTalentDao(ITalentDao iTalentDao) {
        this.iTalentDao = iTalentDao;
    }

    
}