package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.MonthlyPayment;
import br.com.ozzziek.stoncksproject.services.MonthlyPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MonthlyPaymentControllerImpl implements MonthlyPaymentController{

    @Autowired
    private MonthlyPaymentService monthlyPaymentService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/monthly-payment", method = RequestMethod.GET)
    @Override
    public List<MonthlyPayment> listMonthlyPayment(String month) {
        return monthlyPaymentService.listMonthlyPayment(month);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/monthly-payment", method = RequestMethod.POST)
    @Override
    public Long insertFinancialRelease(MonthlyPayment monthlyPayment) {
        return monthlyPaymentService.insertMonthlyPayment(monthlyPayment);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/monthly-payment/{id}", method = RequestMethod.PUT)
    @Override
    public void updateFinancialRelease(Long id, MonthlyPayment monthlyPayment) {
        monthlyPaymentService.updateMonthlyPayment(id, monthlyPayment);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/monthly-payment/{id}", method = RequestMethod.DELETE)
    @Override
    public void removeFinancialRelease(Long id) {
        monthlyPaymentService.removeMonthlyPayment(id);
    }
}
