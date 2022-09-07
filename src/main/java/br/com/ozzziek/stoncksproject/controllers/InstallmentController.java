package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.Installment;

import java.util.List;

public interface InstallmentController {

    void insertInstallment(Integer totalInstallments, Integer validityDay, Long termPurchaseId);
    List<Installment> listInstallment(String termPurchaseId);

}
