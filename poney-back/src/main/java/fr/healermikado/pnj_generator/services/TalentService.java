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
import fr.healermikado.pnj_generator.dtos.LevelDto;
import fr.healermikado.pnj_generator.entity.Talent;
import lombok.Getter;
import lombok.Setter;

/**
 * TalentService
 */
@Service
@Getter
@Setter
public class TalentService {
    @Autowired
    private LevelService levelService;

    @Autowired
    private ITalentDao iTalentDao;

    public Set<Talent> findAllGenericTalent() {
        return iTalentDao.findAllGenericTalent();
    }

    public Map<String, LevelDto> generateTalentsMap(List<Talent> allTalents, int level) {
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
        Map<String, LevelDto> talentsOut = talentsRawLvl.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), //
                        e -> new LevelDto(levelService.getLevels().get(e.getValue()))));

        return talentsOut;

    }
}