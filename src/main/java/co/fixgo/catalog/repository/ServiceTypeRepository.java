package co.fixgo.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.fixgo.catalog.model.ServiceType;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
    List<ServiceType> findByActiveTrueAndCategoryActiveTrue();

    List<ServiceType> findByCategoryId(Long categoryId);

    List<ServiceType> findByUrgentAllowedTrueAndActiveTrue();

    List<ServiceType> findByNameContainingIgnoreCase(String name);
}
