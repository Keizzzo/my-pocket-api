package br.com.ozzziek.stoncksproject.entities.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class FinancialBalance {

    private BigDecimal balance;
    private Map<String, BigDecimal> categoryValues = new HashMap<>();

}
