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
public class MonthlyPayment extends TermPurchase {

    public MonthlyPayment(){}

    public MonthlyPayment(Long code, LocalDate date, String description, Double value, Category category, FinancialReleaseTypeEnum financialReleaseTypeEnum, Long id, BigDecimal totalValue, Integer validityDay, Integer billGenerateDay, String details, Boolean active) {
        super(code, date, description, value, category, financialReleaseTypeEnum, id, totalValue, validityDay, billGenerateDay, details, active);
    }
}
