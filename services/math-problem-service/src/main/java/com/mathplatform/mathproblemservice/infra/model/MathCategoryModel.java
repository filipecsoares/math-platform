package com.mathplatform.mathproblemservice.infra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MathCategoryModel {

    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    private String description;

    public MathCategoryModel() {
    }

    public MathCategoryModel(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public MathCategoryModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
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
}
