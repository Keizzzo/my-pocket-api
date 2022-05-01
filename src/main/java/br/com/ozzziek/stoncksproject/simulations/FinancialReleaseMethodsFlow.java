package br.com.ozzziek.stoncksproject.simulations;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.entities.FinancialRelease;
import br.com.ozzziek.stoncksproject.entities.SimpleRelease;
import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;
import br.com.ozzziek.stoncksproject.services.FinancialReleaseService;
import br.com.ozzziek.stoncksproject.services.FinancialReleaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class FinancialReleaseMethodsFlow {

    @Autowired
    static FinancialReleaseService service;

    public static void main(String[] args) {

        FinancialRelease financialRelease = new SimpleRelease();

        var list = service.listFinancialHystoric("03");

        System.out.println(list);

        financialRelease.setDate(LocalDate.now());
        financialRelease.setDescription("Product A Line");
        financialRelease.setValue(100.00);
        financialRelease.setFinancialReleaseTypeEnum(FinancialReleaseTypeEnum.INPUT.name());
        financialRelease.setCategory(new Category("TEST", 0.25));

        var idGenerated = service.insertFinancialRelease(financialRelease);

        list = service.listFinancialHystoric("03");

        System.out.println(list);
//        list.stream().map(f -> System.out.println(f.getDescription())).collect(Collectors.toList());

    }

}
