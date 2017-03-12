package com.mcl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

@Entity
public class Catalogue {
    @Id
    @GeneratedValue
    private int id;

    @Size(min=1, message="Category cannot be empty")
    @NotNull(message="Category cannot be null")
    private String category;

    @Size(min=1, message="Product cannot be empty")
    @NotNull(message="Category cannot be null")
    private String product;

    @Size(min=1, message="locationId cannot be empty")
    private String locationId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getLocationId() {
        return this.locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return product;
    }

    public String toDisplay() {
        return "Category: " + category + " Product: " + product + " locationId: " + locationId;
    }

}