package co.fixgo.catalog.service;

import java.util.List;

import co.fixgo.catalog.dto.CategoryRequestDto;
import co.fixgo.catalog.dto.CategoryResponseDto;

public interface CategoryService {
    List<CategoryResponseDto> findAll();

    List<CategoryResponseDto> findActive();

    CategoryResponseDto findById(Long id);

    CategoryResponseDto findByName(String name);

    CategoryResponseDto save(CategoryRequestDto objRequest);

    CategoryResponseDto update(Long id, CategoryRequestDto objRequest);

    CategoryResponseDto deactivate(Long id);
}
