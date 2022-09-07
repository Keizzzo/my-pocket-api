package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.Installment;

import java.util.List;

public interface InstallmentService {

    List<Installment> listInstallment(String termPurchaseId);
    void insertInstallment(Integer totalInstallments, Integer validityDay, Long termPurchaseId);

}
