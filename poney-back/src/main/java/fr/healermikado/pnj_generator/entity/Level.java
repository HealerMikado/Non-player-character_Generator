package fr.healermikado.pnj_generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Level
 */
@Entity
@Table(name = "level")
@Getter
@Setter
public class Level {

    @Id
    @Column(name = "lvl")
    private Long lvl;

    @Column(name="lvl_value")
    private String diceValue;    
}