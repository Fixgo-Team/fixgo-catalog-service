package co.fixgo.catalog.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.fixgo.catalog.dto.ServiceTypeRequestDto;
import co.fixgo.catalog.dto.ServiceTypeResponseDto;
import co.fixgo.catalog.model.Category;
import co.fixgo.catalog.model.ServiceType;

@Component
public class ServiceTypeMapper {
    public ServiceType toEntity(ServiceTypeRequestDto objRequest, Category objCategory) {
        ServiceType objServiceType = new ServiceType();
        objServiceType.setName(objRequest.getName());
        objServiceType.setDescription(objRequest.getDescription());
        objServiceType.setReferencePrice(objRequest.getReferencePrice());
        objServiceType.setCategory(objCategory);
        if (objRequest.getUrgentAllowed() == null) {
            objServiceType.setUrgentAllowed(false);
        } else {
            objServiceType.setUrgentAllowed(objRequest.getUrgentAllowed());
        }
        if (objRequest.getActive() == null) {
            objServiceType.setActive(true);
        } else {
            objServiceType.setActive(objRequest.getActive());
        }
        return objServiceType;
    }

    public void updateEntity(ServiceType objServiceType, ServiceTypeRequestDto objRequest, Category objCategory) {
        objServiceType.setName(objRequest.getName());
        objServiceType.setDescription(objRequest.getDescription());
        objServiceType.setReferencePrice(objRequest.getReferencePrice());
        objServiceType.setCategory(objCategory);
        if (objRequest.getUrgentAllowed() != null) {
            objServiceType.setUrgentAllowed(objRequest.getUrgentAllowed());
        }
        if (objRequest.getActive() != null) {
            objServiceType.setActive(objRequest.getActive());
        }
    }

    public ServiceTypeResponseDto toResponseDto(ServiceType objServiceType) {
        return new ServiceTypeResponseDto(
                objServiceType.getId(),
                objServiceType.getName(),
                objServiceType.getDescription(),
                objServiceType.getUrgentAllowed(),
                objServiceType.getReferencePrice(),
                objServiceType.getActive(),
                objServiceType.getCategory().getId(),
                objServiceType.getCategory().getName());
    }

    public List<ServiceTypeResponseDto> toResponseDtoList(List<ServiceType> objServiceTypes) {
        List<ServiceTypeResponseDto> objList = new ArrayList<>();
        for (ServiceType objServiceType : objServiceTypes) {
            objList.add(toResponseDto(objServiceType));
        }
        return objList;
    }
}
