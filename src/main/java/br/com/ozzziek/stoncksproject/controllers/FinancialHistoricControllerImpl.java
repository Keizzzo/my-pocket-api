package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.FinancialRelease;
import br.com.ozzziek.stoncksproject.entities.SimpleRelease;
import br.com.ozzziek.stoncksproject.services.FinancialReleaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FinancialHistoricControllerImpl implements FinancialHistoricController{

    @Autowired
    private FinancialReleaseService financialReleaseService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/historic", method = RequestMethod.GET)
    @Override
    public List<FinancialRelease> historic(@RequestParam String queryParameter) {
        return financialReleaseService.listFinancialHystoric(queryParameter);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/historic", method = RequestMethod.POST)
    @Override
    public Long insertFinancialRelease(@RequestBody SimpleRelease financialRelease) {
        return financialReleaseService.insertFinancialRelease(financialRelease);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/historic/{id}", method = RequestMethod.PUT)
    @Override
    public void updateFinancialRelease(@PathVariable Long id, @RequestBody SimpleRelease financialRelease) {
        financialReleaseService.updateFinancialRelease(id, financialRelease);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/historic/{id}", method = RequestMethod.DELETE)
    @Override
    public void removeFinancialRelease(@PathVariable Long id) {
        financialReleaseService.removeFinancialRelease(id);
    }
}
