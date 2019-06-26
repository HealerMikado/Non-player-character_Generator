package fr.healermikado.pnj_generator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.entity.CharacterEntity;
import fr.healermikado.pnj_generator.services.ICharacterService;

/**
 * CharacterGeneratorController
 */
@RestController
@RequestMapping(value="/generate", produces = "application/json;charset=UTF-8")
@CrossOrigin(origins = "http://localhost:3000")
public class CharacterGeneratorController {
    @Autowired
    public ICharacterService characterService;

    @GetMapping(value = "")
    @ResponseBody
    public CharacterDto generateCharacter() {
        return characterService.generateCharacter();
    }
    
   @PostMapping(value="/creation")
   public ResponseEntity<HttpStatus> createCharacter(@RequestBody CharacterDto character) {

    
		characterService.generateCharacterFromDto(character);

   	return ResponseEntity.ok(HttpStatus.OK);
   }
    
}