package fr.healermikado.pnj_generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Talent
 */
@Entity
@Table(name="talents")

public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talent")
    private Long idTalent;
   
    @Column
    private String nom;

    public Long getIdTalent() {
        return idTalent;
    }

    public void setIdTalent(Long idTalent) {
        this.idTalent = idTalent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
}