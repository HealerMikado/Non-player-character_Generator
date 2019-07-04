package fr.healermikado.pnj_generator.entity;

import java.util.Objects;

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

    public Level() {
    }

    public Level(Long lvl, String diceValue) {
        this.lvl = lvl;
        this.diceValue = diceValue;
    }

    public Long getLvl() {
        return this.lvl;
    }

    public void setLvl(Long lvl) {
        this.lvl = lvl;
    }

    public String getDiceValue() {
        return this.diceValue;
    }

    public void setDiceValue(String diceValue) {
        this.diceValue = diceValue;
    }

    public Level lvl(Long lvl) {
        this.lvl = lvl;
        return this;
    }

    public Level diceValue(String diceValue) {
        this.diceValue = diceValue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Level)) {
            return false;
        }
        Level level = (Level) o;
        return Objects.equals(lvl, level.lvl) && Objects.equals(diceValue, level.diceValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lvl, diceValue);
    }

    @Override
    public String toString() {
        return "{" +
            " lvl='" + getLvl() + "'" +
            ", diceValue='" + getDiceValue() + "'" +
            "}";
    }



}