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


/**
 * Race
 */
@Entity
@Table(name = "races")
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

        public Long getIdRace() {
                return idRace;
        }

        public void setIdRace(Long idRace) {
                this.idRace = idRace;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public List<RaceImage> getImages() {
                return images;
        }

        public void setImages(List<RaceImage> images) {
                this.images = images;
        }

        public Set<Talent> getSpecificTalents() {
                return specificTalents;
        }

        public void setSpecificTalents(Set<Talent> specificTalents) {
                this.specificTalents = specificTalents;
        }

        public Set<Token> getPossibleToken() {
                return possibleToken;
        }

        public void setPossibleToken(Set<Token> possibleToken) {
                this.possibleToken = possibleToken;
        }

        public Set<Talent> getGenericTalents() {
                return genericTalents;
        }

        public void setGenericTalents(Set<Talent> genericTalents) {
                this.genericTalents = genericTalents;
        }

}