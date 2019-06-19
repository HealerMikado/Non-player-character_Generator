package fr.healermikado.pnj_generator.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.services.AlreadyMadeCharacterService;

/**
 * AlreadyMadeCharacterController Get the already made character
 */
@RestController
public class AlreadyMadeCharacterController {

    @Autowired
    AlreadyMadeCharacterService alreadyMadeCharacterService;

    @GetMapping(value = "character/{id}")
    @ResponseBody
    public CharacterDto findAlreadyMadeCharacterById(@PathVariable("id") Long id) {
        return alreadyMadeCharacterService.getCharacterById(id);
    }
}