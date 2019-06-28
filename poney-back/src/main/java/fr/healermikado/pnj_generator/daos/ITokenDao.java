 package fr.healermikado.pnj_generator.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.healermikado.pnj_generator.entity.Token;

/**
 * ITokenDao
 */
@Repository
public interface ITokenDao extends CrudRepository<Token, Long> {

    public List<Token> findAll();
}