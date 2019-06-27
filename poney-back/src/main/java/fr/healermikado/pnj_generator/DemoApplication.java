package fr.healermikado.pnj_generator;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.healermikado.pnj_generator.daos.ICharacterDao;
import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.entity.CharacterEntity;
import fr.healermikado.pnj_generator.services.CharacterService;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	CharacterService characterService;

	@Autowired
	ICharacterDao iCharacterDao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void test() {

		System.out.println("toto");

		CharacterDto characterDto = new CharacterDto("Derpy", "Pégase", 3, "https://i.kym-cdn.com/entries/icons/original/000/005/316/derpypony.jpg");

		CharacterEntity character = characterService.generateCharacterFromDto(characterDto);

		iCharacterDao.save(character);
	}

}
