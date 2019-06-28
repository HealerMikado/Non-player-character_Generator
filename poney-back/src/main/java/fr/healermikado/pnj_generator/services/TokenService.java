package fr.healermikado.pnj_generator.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.entity.Token;

/**
 * TokenService
 * 
 * Get all the name token and generate a random name
 */
@Service
public class TokenService {
    
    public String generateRandomName(Set<Token> tokens){


        String firstName = getRandomToken(tokens);

        String lastName = getRandomToken(tokens);

        return firstName + " " + lastName;
    }

    private String getRandomToken(Set<Token> tokens) {
    	List<Token> tokenList = new ArrayList<>();
    	tokenList.addAll(tokens);
    	Collections.shuffle(tokenList);
        return  tokenList.get(0).getToken();
    }
}