package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.FinancialRelease;
import br.com.ozzziek.stoncksproject.entities.SimpleRelease;
import br.com.ozzziek.stoncksproject.repositories.FinancialReleaseRepository;
import br.com.ozzziek.stoncksproject.repositories.FinancialReleaseRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FinancialReleaseServiceImpl implements FinancialReleaseService{

    @Autowired
    private FinancialReleaseRepository financialReleaseRepository;

    @Autowired
    private FinancialReleaseRepositoryJpa financialReleaseRepositoryJpa;

    @Override
    public Long insertFinancialRelease(FinancialRelease financialRelease) {

        return financialReleaseRepository.insert(financialRelease);

    }

    @Override
    public Double calculateBalance() {
        return null;
    }

    @Override
    public List<FinancialRelease> listFinancialHystoric(String month) {

        return financialReleaseRepository.list(month);

    }

    @Override
    public void updateFinancialRelease(Long id, FinancialRelease financialRelease) {
        financialReleaseRepository.update(id, financialRelease);
    }

    @Override
    public void removeFinancialRelease(Long id) {

        var financialRelease = new SimpleRelease();
        financialRelease.setCode(id);

        financialReleaseRepositoryJpa.delete(financialRelease);
    }
}
