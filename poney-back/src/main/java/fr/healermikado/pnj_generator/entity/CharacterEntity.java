package fr.healermikado.pnj_generator.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * AlreadyMadeEntity
 * 
 * This class is the entity representing an already made character, like the maines six,
 * Spyke etc.
 */
@Entity
@Table(name = "already_made")
public class CharacterEntity {

    private static final String ID_QUIRK = "id_quirk";
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    

    @Column
    private int level;

    @Column(columnDefinition = "VARCHAR(500)")
    private String src;

    @ManyToOne()
    @JoinColumn(name = "id_race", referencedColumnName = "id_race")
    private Race race;

    @Column(nullable = true)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "quirks_link_already_made", joinColumns = {
            @JoinColumn(name = "id_pony") }, inverseJoinColumns = { @JoinColumn(name = ID_QUIRK) })
    private Set<QuirkEntity> quirks;
    
    @ManyToOne()
    @JoinColumn(name="lvl_body", referencedColumnName = "lvl")    
    private Level bodyLevel;
    @ManyToOne()
    @JoinColumn(name="lvl_mind", referencedColumnName = "lvl")    
    private Level mindLevel;
    @ManyToOne()
    @JoinColumn(name="lvl_charm", referencedColumnName = "lvl")    
    private Level charmLevel;

    public static String getIdQuirk() {
        return ID_QUIRK;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Set<QuirkEntity> getQuirks() {
        return quirks;
    }

    public void setQuirks(Set<QuirkEntity> quirks) {
        this.quirks = quirks;
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

    
    
}