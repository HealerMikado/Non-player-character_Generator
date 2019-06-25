package fr.healermikado.pnj_generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * QuirkEntity
 */
@Entity
@Table(name = "quirks")
@Getter
@Setter
public class QuirkEntity {

    @Id
    @Column(name = "id_quirk")
    private Long id;

    @Column(name="name_quirk")
    private String value;
    
}