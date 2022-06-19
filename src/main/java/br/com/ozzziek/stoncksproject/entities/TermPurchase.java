package br.com.ozzziek.stoncksproject.entities;

import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

//@Entity
@Getter
@Setter
public abstract class TermPurchase extends FinancialRelease{

    private Long id;
    private BigDecimal totalValue;
    private Integer validityDay;
    private Integer billGenerateDay;
    private String details;
    private Boolean active;


    public TermPurchase() {
    }


    public TermPurchase(Long code, LocalDate date, String description, Double value, Category category, FinancialReleaseTypeEnum financialReleaseTypeEnum, Long id, BigDecimal totalValue, Integer validityDay, Integer billGenerateDay, String details, Boolean active) {
        super(code, date, description, value, category, financialReleaseTypeEnum);
        this.id = id;
        this.totalValue = totalValue;
        this.validityDay = validityDay;
        this.billGenerateDay = billGenerateDay;
        this.details = details;
        this.active = active;
    }

}
