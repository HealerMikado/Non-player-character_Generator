package fr.healermikado.pnj_generator.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.healermikado.pnj_generator.daos.ILevelDao;
import fr.healermikado.pnj_generator.entity.Level;
import lombok.Getter;

/**
 * LevelService
 */
@Service
@Getter
public class LevelService {

    @Autowired
    private ILevelDao iLevelDao;

    private List<Level> levels;

    @PostConstruct
    public void initialize() {
        this.levels = this.iLevelDao.findAllByOrderByLvlAsc();
    }

    public boolean isUpgradable(Integer levelToTest) {
        return (levelToTest < levels.size() - 1);
    }

}