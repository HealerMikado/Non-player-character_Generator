package fr.healermikado.pnj_generator.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.daos.IQuirkDao;
import fr.healermikado.pnj_generator.entity.QuirkEntity;

/**
 * DefaultService
 */
@Service
public class QuirkService {

    @Autowired
    private IQuirkDao iQuirkDao;



    private List<QuirkEntity> getAllQuirksFromDb() {
       return iQuirkDao.findAll();
    }

    public List<QuirkEntity> getSomeQuirkEntities(int numberOfQuirksToReturn){
        List<QuirkEntity> quirksToReturn = new ArrayList<>();
        List<QuirkEntity> workingQuirks = getAllQuirksFromDb();       
        for (int i = 0; i < numberOfQuirksToReturn; i++) {
            //generate a random number
        	
            int randomNumber = ThreadLocalRandom.current().nextInt(workingQuirks.size());
            quirksToReturn.add(workingQuirks.get(randomNumber));
            workingQuirks.remove(randomNumber);
        }
        return quirksToReturn;
    }

    public IQuirkDao getiQuirkDao() {
        return iQuirkDao;
    }

    public void setiQuirkDao(IQuirkDao iQuirkDao) {
        this.iQuirkDao = iQuirkDao;
    }

    

}