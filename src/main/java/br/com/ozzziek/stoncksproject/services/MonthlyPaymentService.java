package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.MonthlyPayment;

import java.util.List;


public interface MonthlyPaymentService {
    Long insertMonthlyPayment(MonthlyPayment monthlyPayment);
    List<MonthlyPayment> listMonthlyPayment(String month);
    void updateMonthlyPayment(Long id, MonthlyPayment monthlyPayment);
    void removeMonthlyPayment(Long id);
}
