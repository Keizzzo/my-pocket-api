package br.com.ozzziek.stoncksproject.entities;

import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "financial_release")
@Getter
@Setter
public abstract class FinancialRelease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long code;

    private LocalDate date;
    private String description;
    private Double value;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "financial_release_type")
    private String financialReleaseTypeEnum;

    public FinancialRelease() {}

    public FinancialRelease(Long code, LocalDate date, String description, Double value, Category category, FinancialReleaseTypeEnum financialReleaseTypeEnum) {
        this.code = code;
        this.date = date;
        this.description = description;
        this.value = value;
        this.category = category;
        this.financialReleaseTypeEnum = financialReleaseTypeEnum.name();
    }

}
