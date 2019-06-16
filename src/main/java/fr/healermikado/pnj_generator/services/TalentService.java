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

    public  Map<String, String> generateTalentsMap(List<Talent> allTalents, int level) {
        // generate the raw list of the talent
        List<String> listTalents = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            listTalents.add(allTalents.get(ThreadLocalRandom.current().nextInt(allTalents.size())).getNom());
        }

        Map<String, Integer> talentsIntLvl = new HashMap<>();
        for (String nomTalent : listTalents) {
            if (talentsIntLvl.containsKey(nomTalent)) {
                // some more code to check if the level of the current talent if not max.
                // If not level up the talent, else choose another. Loop until a level up occur
                Integer currentTalentLevel;
                Boolean lvlUp = false;
                do {
                    currentTalentLevel = talentsIntLvl.get(nomTalent);
                    if (levelService.isUpgradable(currentTalentLevel)) {
                        lvlUp = true;
                    } else {
                        // Choose another talent
                        String newTalent = allTalents.get(ThreadLocalRandom.current().nextInt(allTalents.size()))
                                .getNom();
                    }

                } while (!lvlUp);
                talentsIntLvl.put(nomTalent, currentTalentLevel + 1);

            } else {
                talentsIntLvl.put(nomTalent, 0);
            }
        }
        Map<String, String> talentsOut = talentsIntLvl.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> levelService.getLevels().get(e.getValue()).getDiceValue()));


        return talentsOut;

    }
}