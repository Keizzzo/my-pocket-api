package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.dtos.FinancialBalance;

import java.math.BigDecimal;

public interface FinanceReportService {

    BigDecimal getBalance(String month);
    FinancialBalance distributeValuesInCategory(BigDecimal balance);

}
