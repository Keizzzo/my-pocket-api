package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.Installment;
import br.com.ozzziek.stoncksproject.entities.dtos.InstallmentBody;

import java.util.List;

public interface InstallmentController {

    void insertInstallment(InstallmentBody installmentBody, Long termPurchaseId);
    List<Installment> listInstallment(String termPurchaseId);

}
