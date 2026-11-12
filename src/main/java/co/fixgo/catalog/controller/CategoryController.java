package co.fixgo.catalog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.fixgo.catalog.dto.CategoryRequestDto;
import co.fixgo.catalog.dto.CategoryResponseDto;
import co.fixgo.catalog.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryResponseDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/active")
    public List<CategoryResponseDto> findActive() {
        return categoryService.findActive();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/name/{name}")
    public CategoryResponseDto findByName(@PathVariable String name) {
        return categoryService.findByName(name);
    }

    @PostMapping
    public CategoryResponseDto save(@RequestBody CategoryRequestDto objRequest) {
        return categoryService.save(objRequest);
    }

    @PutMapping("/{id}")
    public CategoryResponseDto update(@PathVariable Long id, @RequestBody CategoryRequestDto objRequest) {
        return categoryService.update(id, objRequest);
    }

    @DeleteMapping("/{id}")
    public CategoryResponseDto deactivate(@PathVariable Long id) {
        return categoryService.deactivate(id);
    }
}
