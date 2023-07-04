package com.templateproject.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.entity.Category;
import com.templateproject.api.repository.CategoryRepository;

@RestController
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Une route /categories/{slug}/articles qui récupère les articles de la
    // catégorie défini dans slug
    // Avec une limite et un offset pour l’auto scroll (ex :
    // /articles?offset=xx&limit=xx). Il faut prévoir un next, un previous et un
    // count en plus des résultats
}