package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.FinancialRelease;
import br.com.ozzziek.stoncksproject.entities.MonthlyPayment;
import br.com.ozzziek.stoncksproject.entities.SimpleRelease;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface MonthlyPaymentController {

    List<MonthlyPayment> listMonthlyPayment(@RequestParam String month);
    Long insertFinancialRelease(@RequestBody MonthlyPayment monthlyPayment);
    void updateFinancialRelease(@PathVariable Long id, @RequestBody MonthlyPayment monthlyPayment);
    void removeFinancialRelease(@PathVariable Long id);

}
