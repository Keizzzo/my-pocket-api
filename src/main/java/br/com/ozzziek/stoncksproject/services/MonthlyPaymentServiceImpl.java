package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.MonthlyPayment;
import br.com.ozzziek.stoncksproject.repositories.FinancialReleaseRepository;
import br.com.ozzziek.stoncksproject.repositories.MonthlyPaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MonthlyPaymentServiceImpl implements MonthlyPaymentService{

    @Autowired
    private MonthlyPaymentRepository monthlyPaymentRepository;

    @Autowired
    private FinancialReleaseRepository financialReleaseRepository;

    @Override
    public Long insertMonthlyPayment(MonthlyPayment monthlyPayment) {

        var id = financialReleaseRepository.insert(monthlyPayment);

        monthlyPayment.setCode(id);

        return monthlyPaymentRepository.insert(monthlyPayment);
    }

    @Override
    public List<MonthlyPayment> listMonthlyPayment(String month) {
        return monthlyPaymentRepository.list(month);
    }

    @Override
    public void updateMonthlyPayment(Long id, MonthlyPayment financialRelease) {
        monthlyPaymentRepository.update(id, financialRelease);
    }

    @Override
    public void removeMonthlyPayment(Long id) {
        monthlyPaymentRepository.remove(id);
    }
}
