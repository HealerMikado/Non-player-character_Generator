package fr.healermikado.pnj_generator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.daos.IRaceDao;
import fr.healermikado.pnj_generator.entity.Race;
import lombok.Getter;
import lombok.Setter;

/**
 * RaceService
 */
@Service
@Getter
@Setter
public class RaceService {

    @Autowired
    private IRaceDao iRaceDao;

    public Optional<Race> getRaceById(Long id){
        return iRaceDao.findById(id);
    }

    public List<Race> getAllRaces(){
        return iRaceDao.findAll();
    }
    
}