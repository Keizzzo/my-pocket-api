package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.entities.dtos.FinancialBalance;

import java.math.BigDecimal;
import java.util.List;

public interface FinanceReportController {

    BigDecimal getBalance(String month);
    FinancialBalance distributeValuesInCategory(BigDecimal balance);
}
