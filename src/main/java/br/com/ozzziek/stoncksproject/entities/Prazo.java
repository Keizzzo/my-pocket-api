package br.com.ozzziek.stoncksproject.entities;

import br.com.ozzziek.stoncksproject.entities.enums.TipoPrazoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public abstract class Prazo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double partialValue;
    private Integer validityDay;
    private String description;
    private TipoPrazoEnum tipoPrazo;

}
