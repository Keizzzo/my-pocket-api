package br.com.ozzziek.stoncksproject.entities;

public class Category {

    private String name;
    private Double percentual;

    public Category() {}

    public Category(String name){
        this.name = name;
        this.percentual = 0.0;
    }
    public Category(String name, Double percentual){
        this.name = name;
        this.percentual = percentual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }
}
