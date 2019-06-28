package fr.healermikado.pnj_generator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.healermikado.pnj_generator.dtos.CharacterDto;

import fr.healermikado.pnj_generator.services.AlreadyMadeCharacterService;

/**
 * AlreadyMadeCharacterController Get the already made character
 */
@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
@CrossOrigin(origins = "*")
public class AlreadyMadeCharacterController {

    @Autowired
    AlreadyMadeCharacterService alreadyMadeCharacterService;

    @GetMapping(value = "character/{id}")
    @ResponseBody
    public CharacterDto findAlreadyMadeCharacterById(@PathVariable("id") Long id) {
        return alreadyMadeCharacterService.getCharacterById(id);
    }

    @GetMapping(value = "characters")
    @ResponseBody
    public List<CharacterDto> findAllAlreadyMadeCharacter() {
        return alreadyMadeCharacterService.getAllCharacter();
    }
    

}