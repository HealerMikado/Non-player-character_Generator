package fr.healermikado.pnj_generator.entity;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.dtos.LevelDto;
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

    private static final String ID_QUIRK = "id_quirk";
    @Id
    @Column
    private Long id;
    @Column
    private String name;

    @Column
    private String src;

    @ManyToOne()
    @JoinColumn(name = "id_race", referencedColumnName = "id_race")
    private Race race;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "quirks_link_already_made", joinColumns = {
            @JoinColumn(name = "id_pony") }, inverseJoinColumns = { @JoinColumn(name = ID_QUIRK) })
    private Set<QuirkEntity> quirks;
    
    @ManyToOne()
    @JoinColumn(name="lvl_body", referencedColumnName = "lvl")    
    private Level bodyLevel;
    @ManyToOne()
    @JoinColumn(name="lvl_mind", referencedColumnName = "lvl")    
    private Level mindLevel;
    @ManyToOne()
    @JoinColumn(name="lvl_charm", referencedColumnName = "lvl")    
    private Level charmLevel;
    
//    public CharacterEntity(CharacterDto characterDto) {
//
//        ModelMapper modelMapper = new ModelMapper();
//         this.name=characterDto.getName();
//         this.race.setNom(characterDto.getRace());
//         this.src=characterDto.getSrc();
//        modelMapper.map(characterDto,CharacterEntity.class);
//        this.quirks = characterDto.getQuirks().stream().map(q-> q.getValue()).collect(Collectors.toSet());
//
//        // Automatic map between entity et dto
//        this.bodyLevel = modelMapper.map(alreadyMadeEntity.getBodyLevel(), LevelDto.class);
//        this.mindLevel = modelMapper.map(alreadyMadeEntity.getMindLevel(), LevelDto.class);
//        this.charmLevel = modelMapper.map(alreadyMadeEntity.getCharmLevel(), LevelDto.class);
//        
//    }
}