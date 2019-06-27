package fr.healermikado.pnj_generator.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import fr.healermikado.pnj_generator.daos.ICharacterDao;
import fr.healermikado.pnj_generator.daos.IRaceDao;
import fr.healermikado.pnj_generator.dtos.CharacterDto;
import fr.healermikado.pnj_generator.dtos.LevelDto;
import fr.healermikado.pnj_generator.entity.CharacterEntity;
import fr.healermikado.pnj_generator.entity.Level;
import fr.healermikado.pnj_generator.entity.Race;

/**
 * CharacterService
 */
@Service
public class CharacterService implements ICharacterService {
	private Logger logger = LoggerFactory.getLogger(CharacterService.class);
	@Autowired
	private ICharacterDao iCharacterDao;
	@Autowired
	private IRaceDao iRaceDao;

	@Autowired
	private TalentService talentService;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private QuirkService quirkService;

	private static final String DEFAULT_SRC = "https://static1.fjcdn.com/comments/Ghostrollerelite+rolled+a+random+image+posted+in+comment+2724081+at+_b8d37e5c953413851a5e42d88b304a37.png";

	@Override
	public CharacterDto generateCharacter() {
		List<Race> races = iRaceDao.findAll();
		Collections.shuffle(races);

		races.forEach(r -> r.setGenericTalents(talentService.findAllGenericTalent()));

		int characterLevel = ThreadLocalRandom.current().nextInt(0, 11);

		Race race = races.get(0);

		CharacterDto outputCharacter = new CharacterDto(tokenService.generateRandomName(race.getPossibleToken()), race,
				characterLevel);
		// the the talent
		outputCharacter.setTalents(talentService.generateTalentsMap(race.generateAllTalents(), characterLevel));
		// set the quirks. TODO change that
		outputCharacter.setQuirks(
				quirkService.getSomeQuirkEntities(1).stream().map(q -> q.getValue()).collect(Collectors.toSet()));
		setStatisticLevel(outputCharacter);

		return outputCharacter;
	}

	/**
	 * Create a CharacterEntity from a CharacterDto. Call the database to get all
	 * the usefull info. Check the info
	 * 
	 * @param hc
	 * @return
	 */
	@Override
	public CharacterEntity generateCharacterFromDto(CharacterDto characterDto) {
		logger.info("Create empty character");
		CharacterEntity theCharacterToReturn = new CharacterEntity();
		/// For know the race have to exist in the DB :(
		// TODO change that
		theCharacterToReturn.setRace(iRaceDao.findByName(characterDto.getRace()).get());
		logger.debug(String.format("Race of the generate character %s", theCharacterToReturn.getRace()) );
		//Generate name if name is empty
		theCharacterToReturn.setName(StringUtils.isEmpty(characterDto.getName())
				? tokenService.generateRandomName(theCharacterToReturn.getRace().getPossibleToken())
				: characterDto.getName());
		logger.debug(String.format("Name of the generate character %s", theCharacterToReturn.getName()) );
		
		theCharacterToReturn.setLevel(characterDto.getLevel()>0?characterDto.getLevel():1);

		// If no src default image
		theCharacterToReturn.setSrc(StringUtils.isEmpty(characterDto.getSrc())?DEFAULT_SRC:characterDto.getSrc());
		logger.debug(String.format("Src of the generate character %s", theCharacterToReturn.getSrc()) );

		theCharacterToReturn.setBodyLevel(new Level(1L, "D4"));
		theCharacterToReturn.setMindLevel(new Level(1L, "D4"));
		theCharacterToReturn.setCharmLevel(new Level(1L, "D4"));
		theCharacterToReturn.setQuirks(new HashSet<>());

		iCharacterDao.save(theCharacterToReturn);

		return theCharacterToReturn;
	}

	public void setStatisticLevel(CharacterDto theCharacterToCreate) {
		int bodyLevel = theCharacterToCreate.getRace()=="Poney terrestre" ? 1:0;
		int mindLevel = 0;
		int charmLevel = 1;

		// At level one a character can upgrade body or mind
		if (Math.random() < 0.5) {
			bodyLevel++;
		} else {
			mindLevel++;
		}
		// For each level upgrade a stat
		for (int i = 0; i < theCharacterToCreate.getLevel(); i++) {
			boolean updated = false;
			do {
				int random = ThreadLocalRandom.current().nextInt(3);
				switch (random) {
				case 0:
					if (talentService.getLevelService().isUpgradable(bodyLevel)) {
						bodyLevel++;
						updated = true;
					}
					break;
				case 1:
					if (talentService.getLevelService().isUpgradable(mindLevel)) {
						mindLevel++;
						updated = true;
					}
					break;
				case 2:
					if (talentService.getLevelService().isUpgradable(charmLevel)) {
						charmLevel++;
						updated = true;
					}
					break;
				default:
					break;
				}

			} while (!updated);
		}

		theCharacterToCreate.setBodyLevel(new LevelDto(talentService.getLevelService().getLevels().get(bodyLevel)));
		theCharacterToCreate.setMindLevel(new LevelDto(talentService.getLevelService().getLevels().get(mindLevel)));
		theCharacterToCreate.setCharmLevel(new LevelDto(talentService.getLevelService().getLevels().get(charmLevel)));

	}

}