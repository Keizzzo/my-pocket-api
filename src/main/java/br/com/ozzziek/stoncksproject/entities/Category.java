package br.com.ozzziek.stoncksproject.entities;

import br.com.ozzziek.stoncksproject.entities.enums.CategoryStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double percentual;
    private String status;

    public Category() {}

    public Category(Long id){
        this.id = id;
    }

    public Category(String name){
        this.name = name;
        this.percentual = 0.0;
    }
    public Category(String name, Double percentual, CategoryStatusEnum categoryStatusEnum){
        this.name = name;
        this.percentual = percentual;
        this.status = categoryStatusEnum.name();
    }

    public Category(Long id, String name, Double percentual, CategoryStatusEnum categoryStatusEnum){
        this.id = id;
        this.name = name;
        this.percentual = percentual;
        this.status = categoryStatusEnum.name();
    }

}
