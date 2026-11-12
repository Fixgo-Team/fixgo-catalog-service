package co.fixgo.catalog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.fixgo.catalog.dto.ServiceTypeRequestDto;
import co.fixgo.catalog.dto.ServiceTypeResponseDto;
import co.fixgo.catalog.mapper.ServiceTypeMapper;
import co.fixgo.catalog.model.Category;
import co.fixgo.catalog.model.ServiceType;
import co.fixgo.catalog.repository.CategoryRepository;
import co.fixgo.catalog.repository.ServiceTypeRepository;
import co.fixgo.catalog.service.ServiceTypeService;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    private final ServiceTypeRepository serviceTypeRepository;
    private final CategoryRepository categoryRepository;
    private final ServiceTypeMapper serviceTypeMapper;

    public ServiceTypeServiceImpl(ServiceTypeRepository serviceTypeRepository,
            CategoryRepository categoryRepository, ServiceTypeMapper serviceTypeMapper) {
        this.serviceTypeRepository = serviceTypeRepository;
        this.categoryRepository = categoryRepository;
        this.serviceTypeMapper = serviceTypeMapper;
    }

    @Override
    public List<ServiceTypeResponseDto> findAll() {
        return serviceTypeMapper.toResponseDtoList(serviceTypeRepository.findAll());
    }

    @Override
    public List<ServiceTypeResponseDto> findActive() {
        return serviceTypeMapper.toResponseDtoList(serviceTypeRepository.findByActiveTrueAndCategoryActiveTrue());
    }

    @Override
    public List<ServiceTypeResponseDto> findUrgent() {
        return serviceTypeMapper.toResponseDtoList(serviceTypeRepository.findByUrgentAllowedTrueAndActiveTrue());
    }

    @Override
    public List<ServiceTypeResponseDto> findByCategoryId(Long categoryId) {
        return serviceTypeMapper.toResponseDtoList(serviceTypeRepository.findByCategoryId(categoryId));
    }

    @Override
    public List<ServiceTypeResponseDto> searchByName(String name) {
        return serviceTypeMapper.toResponseDtoList(serviceTypeRepository.findByNameContainingIgnoreCase(name));
    }

    @Override
    public ServiceTypeResponseDto findById(Long id) {
        ServiceType objServiceType = serviceTypeRepository.findById(id).orElse(null);
        if (objServiceType == null) {
            return null;
        }
        return serviceTypeMapper.toResponseDto(objServiceType);
    }

    @Override
    public ServiceTypeResponseDto save(ServiceTypeRequestDto objRequest) {
        Category objCategory = categoryRepository.findById(objRequest.getCategoryId()).orElse(null);
        if (objCategory == null) {
            return null;
        }
        ServiceType objServiceType = serviceTypeMapper.toEntity(objRequest, objCategory);
        ServiceType objSaved = serviceTypeRepository.save(objServiceType);
        return serviceTypeMapper.toResponseDto(objSaved);
    }

    @Override
    public ServiceTypeResponseDto update(Long id, ServiceTypeRequestDto objRequest) {
        ServiceType objServiceType = serviceTypeRepository.findById(id).orElse(null);
        if (objServiceType == null) {
            return null;
        }
        Category objCategory = categoryRepository.findById(objRequest.getCategoryId()).orElse(null);
        if (objCategory == null) {
            return null;
        }
        serviceTypeMapper.updateEntity(objServiceType, objRequest, objCategory);
        ServiceType objSaved = serviceTypeRepository.save(objServiceType);
        return serviceTypeMapper.toResponseDto(objSaved);
    }

    @Override
    public ServiceTypeResponseDto deactivate(Long id) {
        ServiceType objServiceType = serviceTypeRepository.findById(id).orElse(null);
        if (objServiceType == null) {
            return null;
        }
        objServiceType.setActive(false);
        ServiceType objSaved = serviceTypeRepository.save(objServiceType);
        return serviceTypeMapper.toResponseDto(objSaved);
    }
}
