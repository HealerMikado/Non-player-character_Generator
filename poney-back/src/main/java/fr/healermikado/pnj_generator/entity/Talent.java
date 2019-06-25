package fr.healermikado.pnj_generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Talent
 */
@Entity
@Table(name="talents")
@Getter
@Setter
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talent")
    private Long idTalent;
   
    @Column
    private String nom;
    
}