package fr.healermikado.pnj_generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Just an entity to get some src to display image in the GUI
 * @author S4LWO8
 *
 */
@Entity
@Table(name = "image_race")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RaceImage {

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_race")
	private Long id_race;
	
    @Column(name = "src", columnDefinition = "VARCHAR(500)")
	private String src;
	

}
