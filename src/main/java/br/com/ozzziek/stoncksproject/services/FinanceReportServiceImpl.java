package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.dtos.FinancialBalance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class FinanceReportServiceImpl implements FinanceReportService{
    @Override
    public BigDecimal getBalance(String month) {
        return null;
    }

    @Override
    public FinancialBalance distributeValuesInCategory(BigDecimal balance) {
        return null;
    }
}
