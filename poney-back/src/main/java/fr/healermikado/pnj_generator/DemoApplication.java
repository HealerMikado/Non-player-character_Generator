package fr.healermikado.pnj_generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.healermikado.pnj_generator.daos.IAlreadyMadeEntityDao;
import fr.healermikado.pnj_generator.entity.CharacterEntity;
import fr.healermikado.pnj_generator.entity.Race;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	static private 	IAlreadyMadeEntityDao alreadyMadeEntityDao;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	    @Override
	    public void run(String... args) {
	        // Create a couple of Book and BookCategory
	    	alreadyMadeEntityDao.save(new CharacterEntity(7L, "toto", "photo", new Race(4L, "Dragon"), ));
	    }
	}

}
