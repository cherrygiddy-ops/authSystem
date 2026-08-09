package com.authservice.system.client.controllers;


import com.authservice.system.client.dtos.CategoryResponseDto;
import com.authservice.system.client.services.AuthCategoriesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/categories")
@RequiredArgsConstructor
public class AuthCategoriesController {

    private final AuthCategoriesService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody String name) {
        return ResponseEntity.ok(categoryService.addCategory(name));
    }


    @GetMapping
    public List<CategoryResponseDto> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryDetails(@PathVariable String id) {
        return categoryService.getCategoryDetails(id);
    }

    @PutMapping("/{id}")
    public CategoryResponseDto updateCategory(@PathVariable String id,
                                              @RequestBody String name) {
        return categoryService.updateCategory(id, name);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }
}
