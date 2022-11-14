package br.com.ozzziek.stoncksproject.services;

import br.com.ozzziek.stoncksproject.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories(String status);
    void insertList(List<Category> obj);
    void updateCategory(List<Category> categories);
}
