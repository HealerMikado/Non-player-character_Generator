package fr.healermikado.pnj_generator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Name
 */
@Entity
@Table(name="tokens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token")
    private Long id;

    @Column(name = "token")
    private String token;
}