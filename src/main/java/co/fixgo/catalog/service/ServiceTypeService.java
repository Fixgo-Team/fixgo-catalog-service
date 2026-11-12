package co.fixgo.catalog.service;

import java.util.List;

import co.fixgo.catalog.dto.ServiceTypeRequestDto;
import co.fixgo.catalog.dto.ServiceTypeResponseDto;

public interface ServiceTypeService {
    List<ServiceTypeResponseDto> findAll();

    List<ServiceTypeResponseDto> findActive();

    List<ServiceTypeResponseDto> findUrgent();

    List<ServiceTypeResponseDto> findByCategoryId(Long categoryId);

    List<ServiceTypeResponseDto> searchByName(String name);

    ServiceTypeResponseDto findById(Long id);

    ServiceTypeResponseDto save(ServiceTypeRequestDto objRequest);

    ServiceTypeResponseDto update(Long id, ServiceTypeRequestDto objRequest);

    ServiceTypeResponseDto deactivate(Long id);
}
