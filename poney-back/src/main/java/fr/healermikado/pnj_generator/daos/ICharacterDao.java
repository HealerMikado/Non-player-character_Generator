package fr.healermikado.pnj_generator.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.healermikado.pnj_generator.entity.CharacterEntity;

/**
 * IAlreadyMadeEntityDao
 */
@Repository
public interface ICharacterDao extends CrudRepository<CharacterEntity, Long> {

    public Optional<CharacterEntity> findById(Long id);
    
    public List<CharacterEntity> findAll();
    
}