package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.exceptions.BusinessRulesException;
import br.com.ozzziek.stoncksproject.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Category>> listCategories(String status) {
        return ResponseEntity.ok(categoryService.listCategories(status));
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    @Override
    public ResponseEntity<Void> insertList(List<Category> categories) {

        categoryService.insertList(categories);

        return ResponseEntity.status(200).build();

    }


    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @RequestMapping(value = "/categories", method = RequestMethod.PUT)
    @Override
    public void updateCategory(List<Category> categories) {

        categoryService.updateCategory(categories);
    }

}
