package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.FinancialRelease;

import java.util.List;

public interface FinancialReleaseService {

    Long insertFinancialRelease(FinancialRelease financialRelease);
    List<FinancialRelease> listFinancialHystoric(String month);
    void updateFinancialRelease(Long id, FinancialRelease financialRelease);
    void removeFinancialRelease(Long id);
}
