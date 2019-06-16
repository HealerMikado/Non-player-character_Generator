package fr.healermikado.pnj_generator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.healermikado.pnj_generator.businessObjects.Character;
import fr.healermikado.pnj_generator.services.ICharacterService;

/**
 * CharacterGeneratorController
 */
@RestController
public class CharacterGeneratorController {

    @Autowired
    public ICharacterService characerService;

    @GetMapping(value = "/")
    @ResponseBody
    public Character generateCharacter() {
        return characerService.generateCharacter();
    }

}