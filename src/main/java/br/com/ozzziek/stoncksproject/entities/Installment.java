package br.com.ozzziek.stoncksproject.entities;

import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Installment extends MonthlyPayment{
    private Long id;
    private Integer totalInstallments;
    private Integer currentInstallment;
    private LocalDate validityDate;

    public Installment(){}

    public Installment(MonthlyPayment monthlyPayment, Long installmentId, Integer totalInstallments, Integer currentInstallment, LocalDate validityDate) {
        super(monthlyPayment.getCode(),
                monthlyPayment.getDate(),
                monthlyPayment.getDescription(),
                monthlyPayment.getValue(),
                monthlyPayment.getCategory(),
                FinancialReleaseTypeEnum.valueOf(monthlyPayment.getFinancialReleaseTypeEnum()),
                monthlyPayment.getId(),
                monthlyPayment.getTotalValue(),
                monthlyPayment.getValidityDay(),
                monthlyPayment.getBillGenerateDay(),
                monthlyPayment.getDetails(),
                monthlyPayment.getActive());

        this.id = installmentId;
        this.totalInstallments = totalInstallments;
        this.currentInstallment = currentInstallment;
        this.validityDate = validityDate;
    }

    public Installment(Long id, Integer totalInstallments, Integer currentInstallment, LocalDate validityDate){
        this.id = id;
        this.totalInstallments = totalInstallments;
        this.currentInstallment = currentInstallment;
        this.validityDate = validityDate;
    }
}
