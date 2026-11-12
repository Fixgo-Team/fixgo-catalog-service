package co.fixgo.catalog.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.fixgo.catalog.dto.CategoryRequestDto;
import co.fixgo.catalog.dto.CategoryResponseDto;
import co.fixgo.catalog.model.Category;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryRequestDto objRequest) {
        Category objCategory = new Category();
        objCategory.setName(objRequest.getName());
        objCategory.setDescription(objRequest.getDescription());
        if (objRequest.getActive() == null) {
            objCategory.setActive(true);
        } else {
            objCategory.setActive(objRequest.getActive());
        }
        return objCategory;
    }

    public void updateEntity(Category objCategory, CategoryRequestDto objRequest) {
        objCategory.setName(objRequest.getName());
        objCategory.setDescription(objRequest.getDescription());
        if (objRequest.getActive() != null) {
            objCategory.setActive(objRequest.getActive());
        }
    }

    public CategoryResponseDto toResponseDto(Category objCategory) {
        return new CategoryResponseDto(
                objCategory.getId(),
                objCategory.getName(),
                objCategory.getDescription(),
                objCategory.getActive());
    }

    public List<CategoryResponseDto> toResponseDtoList(List<Category> objCategories) {
        List<CategoryResponseDto> objList = new ArrayList<>();
        for (Category objCategory : objCategories) {
            objList.add(toResponseDto(objCategory));
        }
        return objList;
    }
}
