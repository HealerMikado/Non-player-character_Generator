package fr.healermikado.pnj_generator.services;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.daos.ITokenDao;
import fr.healermikado.pnj_generator.entity.Token;

/**
 * TokenService
 * 
 * Get all the name token and generate a random name
 */
@Service
public class TokenService {

    @Autowired
    private ITokenDao iTokenDao;
    
    public String generateRandomName(){

        List<Token> tokens = iTokenDao.findAll();

        String firstName = getRandomToken(tokens);

        String lastName = getRandomToken(tokens);

        return firstName + " " + lastName;
    }

    private String getRandomToken(List<Token> tokens) {
        return  tokens.get(ThreadLocalRandom.current().nextInt(tokens.size())).getToken();
    }
}