package br.com.ozzziek.stoncksproject.controllers;

import br.com.ozzziek.stoncksproject.entities.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CategoryController {
    ResponseEntity<List<Category>> listCategories(@RequestParam String status);
    ResponseEntity<Void> insertList(@RequestBody List<Category> categories);
    void updateCategory(@RequestBody List<Category> categories);
}
