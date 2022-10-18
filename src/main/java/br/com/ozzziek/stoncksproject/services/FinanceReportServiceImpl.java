package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.FinancialRelease;
import br.com.ozzziek.stoncksproject.entities.dtos.FinancialBalance;
import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class FinanceReportServiceImpl implements FinanceReportService {

    @Autowired
    private FinancialReleaseService financialReleaseService;

    @Override
    public BigDecimal getBalance(String month) {

//        List<FinancialRelease> monthlyReleases = financialReleaseService.listFinancialHystoric(month);
//
//        Double balance = 0.0;
//
//        Double sumInput monthlyReleases.stream().filter(f -> f.getFinancialReleaseTypeEnum()
//                .equals(FinancialReleaseTypeEnum.INPUT.toString()))
//                .map(FinancialRelease::getValue)
//                .reduce(0.0, Double::sum);
//
//        Long itensCalculated = monthlyReleases.stream().map(f -> {
//            if (f.getFinancialReleaseTypeEnum().equals(FinancialReleaseTypeEnum.INPUT.toString())) {
//                balance += f.getValue();
//            }
//            if (f.getFinancialReleaseTypeEnum().equals(FinancialReleaseTypeEnum.OUTPUT.toString())) {
//                balance.subtract(BigDecimal.valueOf(f.getValue()));
//            }
//
//            return null;
//
//        }).count();
//
//        return sumInput;

        return null;

    }

    @Override
    public FinancialBalance distributeValuesInCategory(BigDecimal balance) {
        return null;
    }
}
