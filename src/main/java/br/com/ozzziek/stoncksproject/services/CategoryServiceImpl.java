package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.exceptions.BusinessRulesException;
import br.com.ozzziek.stoncksproject.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository repository;

    @Override
    public List<Category> listCategories(String status) {
        return repository.list(status);
    }

    @Override
    public void insertList(List<Category> categories) {

        verifyPercentage(categories);

        repository.deactivateCurrentCategories();
        repository.insertList(categories);
    }

    @Override
    public void updateCategory(List<Category> categories) {
        repository.updateCategory(categories);
    }

    private void verifyPercentage(List<Category> categories){
        Double percentage = categories.stream().map(c -> c.getPercentual()).reduce(0.0, (x, y) -> x+y);

        if(percentage != 1.0){
            throw new BusinessRulesException("O valor percentual deve ser de 100%. Valor Atual: " + (percentage*=100) + "%.");
        }
    }

}
