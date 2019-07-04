package fr.healermikado.pnj_generator.entity;

import java.util.Objects;

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
    


    public Talent() {
    }

    public Talent(Long idTalent, String nom) {
        this.idTalent = idTalent;
        this.nom = nom;
    }

    public Long getIdTalent() {
        return this.idTalent;
    }

    public void setIdTalent(Long idTalent) {
        this.idTalent = idTalent;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Talent idTalent(Long idTalent) {
        this.idTalent = idTalent;
        return this;
    }

    public Talent nom(String nom) {
        this.nom = nom;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Talent)) {
            return false;
        }
        Talent talent = (Talent) o;
        return Objects.equals(idTalent, talent.idTalent) && Objects.equals(nom, talent.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTalent, nom);
    }

    @Override
    public String toString() {
        return "{" +
            " idTalent='" + getIdTalent() + "'" +
            ", nom='" + getNom() + "'" +
            "}";
    }

}