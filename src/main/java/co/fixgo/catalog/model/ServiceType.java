package co.fixgo.catalog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_types")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "urgent_allowed", nullable = false)
    private Boolean urgentAllowed;

    @Column(name = "reference_price", nullable = false)
    private Double referencePrice;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public ServiceType() {
    }

    public ServiceType(Long id, String name, String description, Boolean urgentAllowed,
            Double referencePrice, Boolean active, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urgentAllowed = urgentAllowed;
        this.referencePrice = referencePrice;
        this.active = active;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getUrgentAllowed() {
        return urgentAllowed;
    }

    public void setUrgentAllowed(Boolean urgentAllowed) {
        this.urgentAllowed = urgentAllowed;
    }

    public Double getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(Double referencePrice) {
        this.referencePrice = referencePrice;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
