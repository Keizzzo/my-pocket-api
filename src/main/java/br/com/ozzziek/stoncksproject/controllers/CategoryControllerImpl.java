package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryControllerImpl implements CategoryController{

    @Autowired
    private CategoryService categoryService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @Override
    public List<Category> listCategories(String status) {
        return categoryService.listCategories(status);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    @Override
    public void insertList(List<Category> categories) {
        categoryService.insertList(categories);
    }
}
