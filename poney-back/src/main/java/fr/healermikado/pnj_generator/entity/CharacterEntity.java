package fr.healermikado.pnj_generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterEntity {

    @Id
    @Column
    private Long id;
    @Column
    private String name;

    @Column
    private String src;
    
    @ManyToOne()
    @JoinColumn(name="id_race", referencedColumnName = "id_race") 
    private Race race;
    
    @ManyToOne()
    @JoinColumn(name="lvl_body", referencedColumnName = "lvl")    
    private Level bodyLevel;
    @ManyToOne()
    @JoinColumn(name="lvl_mind", referencedColumnName = "lvl")    
    private Level mindLevel;
    @ManyToOne()
    @JoinColumn(name="lvl_charm", referencedColumnName = "lvl")    
    private Level charmLevel;
    
}