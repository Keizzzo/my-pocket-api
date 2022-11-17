package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.Installment;
import br.com.ozzziek.stoncksproject.entities.dtos.InstallmentBody;
import br.com.ozzziek.stoncksproject.services.InstallmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class InstallmentControllerImpl implements InstallmentController{

    @Autowired
    private InstallmentService installmentService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/installment/{termPurchaseId}", method = RequestMethod.POST)
    @Override
    public void insertInstallment(@RequestBody InstallmentBody installmentBody, @PathVariable Long termPurchaseId) {
        installmentService.insertInstallment(installmentBody.getTotalInstallments(), installmentBody.getValidityDay(), termPurchaseId);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/installment", method = RequestMethod.GET)
    @Override
    public List<Installment> listInstallment(@RequestParam String termPurchaseId) {
        return installmentService.listInstallment(termPurchaseId);
    }
}
