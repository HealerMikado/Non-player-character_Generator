package fr.healermikado.pnj_generator.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.healermikado.pnj_generator.entity.Level;

/**
 * ILevelDao
 */
@Repository
public interface ILevelDao extends CrudRepository<Level, Long> {

    public List<Level> findAllByOrderByLvlAsc();
    
}