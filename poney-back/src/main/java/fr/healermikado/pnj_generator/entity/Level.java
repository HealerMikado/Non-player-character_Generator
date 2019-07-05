package fr.healermikado.pnj_generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Level
 */
@Entity
@Table(name = "level")
public class Level {

    @Id
    @Column(name = "lvl")
    private Long lvl;

    @Column(name="lvl_value")
    private String diceValue;

    /**
     * Full arg constructor
     * @param lvl
     * @param diceValue
     */
    public Level(Long lvl, String diceValue) {
        this.lvl = lvl;
        this.diceValue = diceValue;
    }

    public Level(){
        
    }
 
	public Long getLvl() {
        return lvl;
    }

    public void setLvl(Long lvl) {
        this.lvl = lvl;
    }

    public String getDiceValue() {
        return diceValue;
    }

    public void setDiceValue(String diceValue) {
        this.diceValue = diceValue;
    }
    
}