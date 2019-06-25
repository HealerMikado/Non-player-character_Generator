package fr.healermikado.pnj_generator.daos;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.healermikado.pnj_generator.entity.Talent;

/**
 * ITalentDao
 */
@Repository
public interface ITalentDao extends CrudRepository<Talent, Long> {

    @Query(value ="select t.id_talent, t.nom from talents t LEFT JOIN link_race_talent l ON t.id_talent = l.id_talent WHERE l.id_talent  IS NULL",
    nativeQuery = true)
     public Set<Talent> findAllGenericTalent();



}