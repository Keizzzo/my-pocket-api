package br.com.ozzziek.stoncksproject.repositories;

import br.com.ozzziek.stoncksproject.entities.FinancialRelease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FinancialReleaseRepositoryJpa extends JpaRepository<FinancialRelease, Long> {

    //How do I set a query for a sql request?
//    List<FinancialRelease> findByMonth(Date date);
}
