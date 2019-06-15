package fr.healermikado.pnj_generator.entity;

import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * Race
 */
@Entity
@Table(name = "races")
@Getter
@Setter
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_race")
    private Long idRace;

    @Column
    private String nom;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "link_race_talent", joinColumns = { @JoinColumn(name = "id_race") }, inverseJoinColumns = {
            @JoinColumn(name = "id_talent") })
    private Set<Talent> specificTalents;

    @Transient
    private Set<Talent> genericTalents;


    public List<Talent> getAllTalents(){
        List<Talent> allTalents = new ArrayList<>() ;
        allTalents.addAll(specificTalents);
        allTalents.addAll(genericTalents);
        return allTalents;
    }
}