package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.Category;
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
        repository.insertList(categories);
    }
}
