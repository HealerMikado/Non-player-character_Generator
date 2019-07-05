package fr.healermikado.pnj_generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * QuirkEntity
 */
@Entity
@Table(name = "quirks")

public class QuirkEntity {

    @Id
    @Column(name = "id_quirk")
    private Long id;

    @Column(name="name_quirk")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    

    
}