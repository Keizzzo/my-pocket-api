package br.com.ozzziek.stoncksproject.entities.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstallmentBody {
    private Integer totalInstallments;
    private Integer validityDay;
}
