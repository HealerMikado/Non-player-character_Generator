package fr.healermikado.pnj_generator.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.healermikado.pnj_generator.entity.QuirkEntity;

/**
 * IQuirkEntity
 */
@Repository
public interface IQuirkDao extends CrudRepository<QuirkEntity, Long> {

    public List<QuirkEntity> findAll();

    public Optional<QuirkEntity> findById(Long id);
    
}