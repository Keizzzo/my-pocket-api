package br.com.ozzziek.stoncksproject.entities;

import br.com.ozzziek.stoncksproject.entities.enums.TipoPrazoEnum;

public abstract class Prazo {
    private Double partialValue;
    private Integer validityDay;
    private String description;
    private TipoPrazoEnum tipoPrazo;

    public Double getPartialValue() {
        return partialValue;
    }

    public Integer getValidityDay() {
        return validityDay;
    }

    public String getDescription() {
        return description;
    }

    public TipoPrazoEnum getTipoPrazo() {
        return tipoPrazo;
    }

    public void setPartialValue(Double partialValue) {
        this.partialValue = partialValue;
    }

    public void setValidityDay(Integer validityDay) {
        this.validityDay = validityDay;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTipoPrazo(TipoPrazoEnum tipoPrazo) {
        this.tipoPrazo = tipoPrazo;
    }
}
