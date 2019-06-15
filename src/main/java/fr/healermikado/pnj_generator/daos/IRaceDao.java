package fr.healermikado.pnj_generator.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.healermikado.pnj_generator.entity.Race;

/**
 * IRaceDao
 */
@Repository
public interface IRaceDao extends CrudRepository<Race, Long>{

    public List<Race> findAll();
}