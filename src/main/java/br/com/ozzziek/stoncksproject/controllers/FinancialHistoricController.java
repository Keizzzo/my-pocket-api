package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.FinancialRelease;
import br.com.ozzziek.stoncksproject.entities.SimpleRelease;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FinancialHistoricController {
    List<FinancialRelease> historic(@RequestParam String queryParameter);
    Long insertFinancialRelease(@RequestBody SimpleRelease financialRelease);
    void updateFinancialRelease(@PathVariable Long id, @RequestBody SimpleRelease financialRelease);
    void removeFinancialRelease(@PathVariable Long id);
}
