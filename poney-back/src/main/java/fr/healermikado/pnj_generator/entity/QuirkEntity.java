package fr.healermikado.pnj_generator.entity;

import java.util.Objects;

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
public class QuirkEntity {

    @Id
    @Column(name = "id_quirk")
    private Long id;

    @Column(name="name_quirk")
    private String value;

    public QuirkEntity() {
    }

    public QuirkEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public QuirkEntity id(Long id) {
        this.id = id;
        return this;
    }

    public QuirkEntity value(String value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QuirkEntity)) {
            return false;
        }
        QuirkEntity quirkEntity = (QuirkEntity) o;
        return Objects.equals(id, quirkEntity.id) && Objects.equals(value, quirkEntity.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
    
}