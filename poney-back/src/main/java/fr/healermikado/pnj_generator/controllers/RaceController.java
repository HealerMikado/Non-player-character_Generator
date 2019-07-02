package fr.healermikado.pnj_generator.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.healermikado.pnj_generator.entity.Race;
import fr.healermikado.pnj_generator.services.RaceService;

/**
 * RaceController
 */
@RestController
@CrossOrigin(origins = "*")
public class RaceController {

    @Autowired
    public RaceService raceService;

    @GetMapping(value = "/races")
    @ResponseBody
    public List<Race> getAllRace() {
        return raceService.getAllRaces();
    }

    @GetMapping(value = "/race/{id}")
    @ResponseBody
    public Optional<Race> getRaceById(@PathVariable("id") Long id) {
        return raceService.getRaceById(id);
    }
}