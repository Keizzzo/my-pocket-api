package br.com.ozzziek.stoncksproject.entities;

import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "financial_release")
public class SimpleRelease extends FinancialRelease{

    public SimpleRelease() {
    }

    public SimpleRelease(Long code, LocalDate date, String description, Double value, Category category, FinancialReleaseTypeEnum financialReleaseTypeEnum) {
        super(code, date, description, value, category, financialReleaseTypeEnum);
    }
}
