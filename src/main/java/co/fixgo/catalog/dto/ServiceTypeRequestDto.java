package co.fixgo.catalog.dto;

public class ServiceTypeRequestDto {
    private String name;
    private String description;
    private Boolean urgentAllowed;
    private Double referencePrice;
    private Boolean active;
    private Long categoryId;

    public ServiceTypeRequestDto() {
    }

    public ServiceTypeRequestDto(String name, String description, Boolean urgentAllowed,
            Double referencePrice, Boolean active, Long categoryId) {
        this.name = name;
        this.description = description;
        this.urgentAllowed = urgentAllowed;
        this.referencePrice = referencePrice;
        this.active = active;
        this.categoryId = categoryId;
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
}
