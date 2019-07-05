package fr.healermikado.pnj_generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Just an entity to get some src to display image in the GUI
 * 
 * @author S4LWO8
 *
 */
@Entity
@Table(name = "image_race")
public class RaceImage {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "id_race")
	private Long id_race;

	@Column(name = "src", columnDefinition = "VARCHAR(500)")
	private String src;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_race() {
		return id_race;
	}

	public void setId_race(Long id_race) {
		this.id_race = id_race;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}
