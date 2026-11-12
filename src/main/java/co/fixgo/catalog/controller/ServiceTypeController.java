package co.fixgo.catalog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.fixgo.catalog.dto.ServiceTypeRequestDto;
import co.fixgo.catalog.dto.ServiceTypeResponseDto;
import co.fixgo.catalog.service.ServiceTypeService;

@RestController
@RequestMapping("/api/service-types")
public class ServiceTypeController {
    private final ServiceTypeService serviceTypeService;

    public ServiceTypeController(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping
    public List<ServiceTypeResponseDto> findAll() {
        return serviceTypeService.findAll();
    }

    @GetMapping("/active")
    public List<ServiceTypeResponseDto> findActive() {
        return serviceTypeService.findActive();
    }

    @GetMapping("/urgent")
    public List<ServiceTypeResponseDto> findUrgent() {
        return serviceTypeService.findUrgent();
    }

    @GetMapping("/category/{categoryId}")
    public List<ServiceTypeResponseDto> findByCategoryId(@PathVariable Long categoryId) {
        return serviceTypeService.findByCategoryId(categoryId);
    }

    @GetMapping("/search")
    public List<ServiceTypeResponseDto> searchByName(@RequestParam String name) {
        return serviceTypeService.searchByName(name);
    }

    @GetMapping("/{id}")
    public ServiceTypeResponseDto findById(@PathVariable Long id) {
        return serviceTypeService.findById(id);
    }

    @PostMapping
    public ServiceTypeResponseDto save(@RequestBody ServiceTypeRequestDto objRequest) {
        return serviceTypeService.save(objRequest);
    }

    @PutMapping("/{id}")
    public ServiceTypeResponseDto update(@PathVariable Long id, @RequestBody ServiceTypeRequestDto objRequest) {
        return serviceTypeService.update(id, objRequest);
    }

    @DeleteMapping("/{id}")
    public ServiceTypeResponseDto deactivate(@PathVariable Long id) {
        return serviceTypeService.deactivate(id);
    }
}
