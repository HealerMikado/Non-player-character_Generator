package fr.healermikado.pnj_generator.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Just an entity to get some src to display image in the GUI
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
	


	public RaceImage() {
	}

	public RaceImage(Long id, Long id_race, String src) {
		this.id = id;
		this.id_race = id_race;
		this.src = src;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_race() {
		return this.id_race;
	}

	public void setId_race(Long id_race) {
		this.id_race = id_race;
	}

	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public RaceImage id(Long id) {
		this.id = id;
		return this;
	}

	public RaceImage id_race(Long id_race) {
		this.id_race = id_race;
		return this;
	}

	public RaceImage src(String src) {
		this.src = src;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof RaceImage)) {
			return false;
		}
		RaceImage raceImage = (RaceImage) o;
		return Objects.equals(id, raceImage.id) && Objects.equals(id_race, raceImage.id_race) && Objects.equals(src, raceImage.src);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, id_race, src);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", id_race='" + getId_race() + "'" +
			", src='" + getSrc() + "'" +
			"}";
	}


}
