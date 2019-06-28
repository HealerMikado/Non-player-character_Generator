package fr.healermikado.pnj_generator.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Race
 */
@Entity
@Table(name = "races")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_race")
    private Long idRace;

    @Column
    private String name;
        
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "id_race")
    private List<RaceImage> images;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "link_race_talent", joinColumns = { @JoinColumn(name = "id_race") }, inverseJoinColumns = {
            @JoinColumn(name = "id_talent") })
    private Set<Talent> specificTalents;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "link_token_race", joinColumns = { @JoinColumn(name = "id_race") }, inverseJoinColumns = {
            @JoinColumn(name = "id_token") })
    private Set<Token> possibleToken;

    @Transient
    private Set<Talent> genericTalents;


    public List<Talent> generateAllTalents(){
        List<Talent> allTalents = new ArrayList<>() ;
        allTalents.addAll(specificTalents);
        allTalents.addAll(genericTalents);
        return allTalents;
    }
}