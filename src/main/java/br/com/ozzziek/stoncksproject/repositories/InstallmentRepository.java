package br.com.ozzziek.stoncksproject.repositories;

import br.com.ozzziek.stoncksproject.entities.Installment;

import java.util.List;

public interface InstallmentRepository extends Repository<Installment> {

    void insertList(List<Installment> installmentList, Long termPurchaseId);
}
