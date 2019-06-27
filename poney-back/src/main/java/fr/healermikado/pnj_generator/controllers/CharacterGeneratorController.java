package fr.healermikado.pnj_generator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import fr.healermikado.pnj_generator.services.ICharacterService;

/**
 * CharacterGeneratorController
 */
@RestController
@RequestMapping(value = "/generate", produces = "application/json;charset=UTF-8")
@CrossOrigin(origins = "http://localhost:3000")
public class CharacterGeneratorController {
	private Logger logger = LoggerFactory.getLogger(CharacterGeneratorController.class);

	@Autowired
	public ICharacterService characterService;

	@GetMapping(value = "")
	@ResponseBody
	public CharacterDto generateCharacter() {
		logger.info("A new pony will be generate from scratch");
		return characterService.generateCharacter();
	}

	@PostMapping(value = "/creation")
	public ResponseEntity<HttpStatus> createCharacter(@RequestBody CharacterDto character) {
		logger.info("A new pony will be create with info");
		characterService.generateCharacterFromDto(character);

		return ResponseEntity.ok(HttpStatus.OK);
	}


    
//    @PostMapping(value="creation")
//    public ResponseEntity<HttpStatus> createCharacter(@RequestBody HalfWayCharacter character) {
//    	characerService.generateCharacter(character);
//    	return ResponseEntity.ok(HttpStatus.OK);
//    }
    
}