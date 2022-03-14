package br.com.ozzziek.stoncksproject.entities;

import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public abstract class FinancialRelease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private LocalDate date;
    private String description;
    private Double value;
    private Category category;
    private FinancialReleaseTypeEnum financialReleaseTypeEnum;

    public FinancialRelease() {}

    public FinancialRelease(Long code, LocalDate date, String description, Double value, Category category, FinancialReleaseTypeEnum financialReleaseTypeEnum) {
        this.code = code;
        this.date = date;
        this.description = description;
        this.value = value;
        this.category = category;
        this.financialReleaseTypeEnum = financialReleaseTypeEnum;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Double getValue() {
        return value;
    }

    public Long getCode() {
        return code;
    }

    public FinancialReleaseTypeEnum getFinancialReleaseTypeEnum() {
        return financialReleaseTypeEnum;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setFinancialReleaseTypeEnum(FinancialReleaseTypeEnum financialReleaseTypeEnum) {
        this.financialReleaseTypeEnum = financialReleaseTypeEnum;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
