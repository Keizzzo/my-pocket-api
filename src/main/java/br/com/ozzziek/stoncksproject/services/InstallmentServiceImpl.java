package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.Installment;
import br.com.ozzziek.stoncksproject.repositories.InstallmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InstallmentServiceImpl implements InstallmentService {

    @Autowired
    private InstallmentRepository installmentRepository;

    @Override
    public List<Installment> listInstallment(String termPurchaseId) {
        return installmentRepository.list(termPurchaseId);
    }

    @Override
    public void insertInstallment(Integer totalInstallments, Integer validityDay, Long termPurchaseId) {

        List<Installment> installmentList = generateParcels(totalInstallments, validityDay);
        installmentRepository.insertList(installmentList, termPurchaseId);
    }

    private List<Installment> generateParcels(Integer totalInstallments, Integer validityDay) {

        List<Installment> installmentList = new ArrayList<>();

        int anoBase = 0;

        for (int i = 1; i <= totalInstallments; i++) {
            var today = LocalDate.now();
            Installment installment = new Installment();

            var validityDate = LocalDate.of(today.getYear() + anoBase,
                    today.getMonth().plus(i).getValue(),
                    validityDay);

            installment.setValidityDate(validityDate);
            if (today.getMonth().plus(i).getValue() == 12) {
                anoBase++;
            }

           installmentList.add(installment);
        }

        return installmentList;

    }
}
