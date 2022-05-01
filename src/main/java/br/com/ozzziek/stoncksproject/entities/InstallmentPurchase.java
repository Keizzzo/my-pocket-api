package br.com.ozzziek.stoncksproject.entities;

import br.com.ozzziek.stoncksproject.entities.enums.CategoryEnum;
import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public abstract class  InstallmentPurchase extends FinancialRelease{

    private BigDecimal totalValue;
    private Integer dueDay;
    private String details;
    private Boolean active;

    public InstallmentPurchase() {
    }

    public InstallmentPurchase(Long code, LocalDate date, String description, Double value, Category category, FinancialReleaseTypeEnum financialReleaseTypeEnum, BigDecimal totalValue, Integer dueDay, String details, Boolean active) {
        super(code, date, description, value, category, financialReleaseTypeEnum);
        this.totalValue = totalValue;
        this.dueDay = dueDay;
        this.details = details;
        this.active = active;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getDueDay() {
        return dueDay;
    }

    public void setDueDay(Integer dueDay) {
        this.dueDay = dueDay;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
