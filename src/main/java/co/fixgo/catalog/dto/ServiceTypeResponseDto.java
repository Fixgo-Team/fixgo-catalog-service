package co.fixgo.catalog.dto;

public class ServiceTypeResponseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean urgentAllowed;
    private Double referencePrice;
    private Boolean active;
    private Long categoryId;
    private String categoryName;

    public ServiceTypeResponseDto() {
    }

    public ServiceTypeResponseDto(Long id, String name, String description, Boolean urgentAllowed,
            Double referencePrice, Boolean active, Long categoryId, String categoryName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urgentAllowed = urgentAllowed;
        this.referencePrice = referencePrice;
        this.active = active;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
