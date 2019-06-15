package fr.healermikado.businessObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import fr.healermikado.pnj_generator.entity.Race;
import fr.healermikado.pnj_generator.entity.Talent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Character
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Character {

    @NonNull
    private String name;
    @NonNull
    private String race;
    @NonNull
    private int level;

    private Map<String,Integer> talents;

    public void generateTalentsMap(List<Talent> allTalents){
        // generate the raw list of the talent
        List<String> listTalents = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            listTalents.add(allTalents.get(ThreadLocalRandom.current().nextInt(0, allTalents.size())).getNom());
        }

        Map<String,Integer> talents = new HashMap<>();
        for (String nomTalent : listTalents) {
            if(talents.containsKey(nomTalent)){
                Integer currentTalentLevel = talents.get(nomTalent);
                talents.put(nomTalent, currentTalentLevel+1);
            } else {
                talents.put(nomTalent, 1);
            }
        }
        this.talents = talents;

    } 


    
}