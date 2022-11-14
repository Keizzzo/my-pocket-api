package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.entities.FinancialRelease;
import br.com.ozzziek.stoncksproject.entities.dtos.FinancialBalance;
import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@AllArgsConstructor
public class FinanceReportServiceImpl implements FinanceReportService {

    @Autowired
    private FinancialReleaseService financialReleaseService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public BigDecimal getBalance(String month) {

        List<FinancialRelease> monthlyReleases = financialReleaseService.listFinancialHystoric(month);

        Double sumInput = monthlyReleases.stream().filter(f -> f.getFinancialReleaseTypeEnum()
                        .equals(FinancialReleaseTypeEnum.INPUT.toString()))
                .map(FinancialRelease::getValue)
                .reduce(0.0, (subtotal, element) -> subtotal + element);

        Double sumOutput = monthlyReleases.stream().filter(f -> f.getFinancialReleaseTypeEnum()
                        .equals(FinancialReleaseTypeEnum.OUTPUT.toString()))
                .map(FinancialRelease::getValue)
                .reduce(0.0, (subtotal, element) -> subtotal + element);


        return new BigDecimal(sumInput - sumOutput).setScale(2, RoundingMode.HALF_UP);

    }

    @Override
    public FinancialBalance distributeValuesInCategory(String month) {

        List<FinancialRelease> monthlyReleases = financialReleaseService.listFinancialHystoric(month);

        FinancialBalance financialBalance = new FinancialBalance();

        Double sumInput = monthlyReleases.stream().filter(f -> f.getFinancialReleaseTypeEnum()
                        .equals(FinancialReleaseTypeEnum.INPUT.toString()))
                .map(FinancialRelease::getValue)
                .reduce(0.0, (subtotal, element) -> subtotal + element);

        financialBalance.setBalance(new BigDecimal(sumInput).setScale(2, RoundingMode.HALF_UP));

        List<Category> categories = categoryService.listCategories("ACTIVE");

        Long nItens = categories.stream()
                                .map(c -> financialBalance.getCategoryValues().put(c.getName(),
                                    new BigDecimal(c.getPercentual() * sumInput).setScale(2, RoundingMode.HALF_UP)))
                                .count();


        return financialBalance;
    }
}
