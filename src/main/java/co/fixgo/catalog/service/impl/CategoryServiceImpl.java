package co.fixgo.catalog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.fixgo.catalog.dto.CategoryRequestDto;
import co.fixgo.catalog.dto.CategoryResponseDto;
import co.fixgo.catalog.mapper.CategoryMapper;
import co.fixgo.catalog.model.Category;
import co.fixgo.catalog.repository.CategoryRepository;
import co.fixgo.catalog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryResponseDto> findAll() {
        return categoryMapper.toResponseDtoList(categoryRepository.findAll());
    }

    @Override
    public List<CategoryResponseDto> findActive() {
        return categoryMapper.toResponseDtoList(categoryRepository.findByActiveTrue());
    }

    @Override
    public CategoryResponseDto findById(Long id) {
        Category objCategory = categoryRepository.findById(id).orElse(null);
        if (objCategory == null) {
            return null;
        }
        return categoryMapper.toResponseDto(objCategory);
    }

    @Override
    public CategoryResponseDto findByName(String name) {
        Category objCategory = categoryRepository.findByNameIgnoreCase(name).orElse(null);
        if (objCategory == null) {
            return null;
        }
        return categoryMapper.toResponseDto(objCategory);
    }

    @Override
    public CategoryResponseDto save(CategoryRequestDto objRequest) {
        Category objCategory = categoryMapper.toEntity(objRequest);
        Category objSaved = categoryRepository.save(objCategory);
        return categoryMapper.toResponseDto(objSaved);
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryRequestDto objRequest) {
        Category objCategory = categoryRepository.findById(id).orElse(null);
        if (objCategory == null) {
            return null;
        }
        categoryMapper.updateEntity(objCategory, objRequest);
        Category objSaved = categoryRepository.save(objCategory);
        return categoryMapper.toResponseDto(objSaved);
    }

    @Override
    public CategoryResponseDto deactivate(Long id) {
        Category objCategory = categoryRepository.findById(id).orElse(null);
        if (objCategory == null) {
            return null;
        }
        objCategory.setActive(false);
        Category objSaved = categoryRepository.save(objCategory);
        return categoryMapper.toResponseDto(objSaved);
    }
}
