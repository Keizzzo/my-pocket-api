package br.com.ozzziek.stoncksproject.entities.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FinancialBalanceDashboardValue {

    private BigDecimal expectedExpense;
    private BigDecimal currentExpense;
    private BigDecimal available;

}
