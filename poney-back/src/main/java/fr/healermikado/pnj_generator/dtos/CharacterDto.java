package fr.healermikado.pnj_generator.dtos;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import fr.healermikado.pnj_generator.entity.CharacterEntity;
import fr.healermikado.pnj_generator.entity.Level;
import fr.healermikado.pnj_generator.entity.Race;

/**
 * Character
 * 
 */
public class CharacterDto {

    // The name of the pony
    private String name;

    // The string representation of the race of the pony
    private String race;

    // The level of the pony
    private int level;

    // The talents of the pony and theirs level
    private Map<String, Level> talents;

    // The body level
    private Level bodyLevel;

    // The mind level
    private Level mindLevel;

    // The charm level
    private Level charmLevel;

    // The rouce image
    private String src;

    // The default list
    private Set<String> quirks;

    /**
     * Full arg constructor
     * @param name
     * @param race
     * @param level
     * @param talents
     * @param bodyLevel
     * @param mindLevel
     * @param charmLevel
     * @param src
     * @param quirks
     */
    public CharacterDto(String name, String race, int level, Map<String, Level> talents, Level bodyLevel,
            Level mindLevel, Level charmLevel, String src, Set<String> quirks) {
        this.name = name;
        this.race = race;
        this.level = level;
        this.talents = talents;
        this.bodyLevel = bodyLevel;
        this.mindLevel = mindLevel;
        this.charmLevel = charmLevel;
        this.src = src;
        this.quirks = quirks;
    }

    public CharacterDto(String name, Race race, int level) {
        this.name = name;
        this.race = race.getName();
        this.level = level;
    }

    public CharacterDto(CharacterEntity alreadyMadeEntity) {

        this.name = alreadyMadeEntity.getName();
        this.level = alreadyMadeEntity.getLevel();
        this.race = alreadyMadeEntity.getRace().getName();
        this.src = alreadyMadeEntity.getSrc();
        this.quirks = alreadyMadeEntity.getQuirks().stream().map(q -> q.getValue()).collect(Collectors.toSet());
        this.bodyLevel = alreadyMadeEntity.getBodyLevel();
        this.mindLevel = alreadyMadeEntity.getMindLevel();
        this.charmLevel = alreadyMadeEntity.getCharmLevel();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Map<String, Level> getTalents() {
        return talents;
    }

    public void setTalents(Map<String, Level> talents) {
        this.talents = talents;
    }

    public Level getBodyLevel() {
        return bodyLevel;
    }

    public void setBodyLevel(Level bodyLevel) {
        this.bodyLevel = bodyLevel;
    }

    public Level getMindLevel() {
        return mindLevel;
    }

    public void setMindLevel(Level mindLevel) {
        this.mindLevel = mindLevel;
    }

    public Level getCharmLevel() {
        return charmLevel;
    }

    public void setCharmLevel(Level charmLevel) {
        this.charmLevel = charmLevel;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Set<String> getQuirks() {
        return quirks;
    }

    public void setQuirks(Set<String> quirks) {
        this.quirks = quirks;
    }

    @Override
    public String toString() {
        return "CharacterDto [bodyLevel=" + bodyLevel + ", charmLevel=" + charmLevel + ", level=" + level
                + ", mindLevel=" + mindLevel + ", name=" + name + ", quirks=" + quirks + ", race=" + race + ", src="
                + src + ", talents=" + talents + "]";
    }

}