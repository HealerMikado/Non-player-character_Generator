package fr.healermikado.pnj_generator.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.services.CharacterService;

/**
 * CharacterGeneratorController
 */
@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
@CrossOrigin(origins = "*")
public class CharacterGeneratorController {
	private Logger logger = LoggerFactory.getLogger(CharacterGeneratorController.class);

	@Autowired
	public CharacterService characterService;

	@GetMapping(value = "/generate")
	@ResponseBody
	public CharacterDto generateCharacter() {
		logger.info("A new pony will be generate from scratch");
		return characterService.generateCharacter();
	}

	@PostMapping(value = "/creation")
	public ResponseEntity<HttpStatus> createCharacter(@RequestBody CharacterDto character) {
		logger.info("A new pony will be create with info");
		logger.info(character.toString());
		characterService.generateCharacterFromDto(character);

		return ResponseEntity.ok(HttpStatus.OK);
	}


	@GetMapping(value = "/character/{id}")
    @ResponseBody
    public CharacterDto findAlreadyMadeCharacterById(@PathVariable("id") Long id) {
        return characterService.getCharacterById(id);
    }

    @GetMapping(value = "/characters")
    @ResponseBody
    public List<CharacterDto> findAllAlreadyMadeCharacter() {
        return characterService.getAllCharacter();
    }
    

    
    
}