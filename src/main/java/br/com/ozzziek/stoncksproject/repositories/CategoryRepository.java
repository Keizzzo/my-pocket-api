package br.com.ozzziek.stoncksproject.repositories;

import br.com.ozzziek.stoncksproject.entities.Category;

import java.util.List;

public interface CategoryRepository extends Repository<Category> {
    void insertList(List<Category> obj);
    void updateCategory(List<Category> categories);
    void deactivateCurrentCategories();
}
