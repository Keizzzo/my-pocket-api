package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.entities.dtos.FinancialBalance;
import br.com.ozzziek.stoncksproject.services.FinanceReportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class FinanceReportControllerImpl implements FinanceReportController {

    @Autowired
    private FinanceReportService financeReportService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/financial-resource/balance", method = RequestMethod.GET)
    @Override
    public BigDecimal getBalance(@RequestParam String month) {
        return financeReportService.getBalance(month);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/financial-resource/redistributed-values", method = RequestMethod.GET)
    @Override
    public FinancialBalance distributeValuesInCategory(@RequestParam BigDecimal balance) {
        return null;
    }
}
