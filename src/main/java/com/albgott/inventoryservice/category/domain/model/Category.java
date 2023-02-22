package com.albgott.inventoryservice.category.domain.model;

import com.albgott.inventoryservice.business.domain.model.Business;
import com.albgott.inventoryservice.category.domain.event.CategoryDescriptionModifiedDomainEvent;
import com.albgott.inventoryservice.category.domain.event.CategoryNameModifiedDomainEvent;
import com.albgott.inventoryservice.shared.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lombok.NonNull;

import java.awt.*;
import java.util.UUID;

@Entity(name = "category")
@Table(name = "categories", uniqueConstraints = {@UniqueConstraint(columnNames = {"business_id","name"})})
public class Category extends AggregateRoot {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String name;
    private String description;
    private Color color;
    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    protected Category() {
    }

    public Category(@NonNull UUID id, @NonNull String name, String description, Color color,
                     @NonNull Business business) {
        this.id = id;
        this.name = name.trim().toLowerCase();
        this.description = description == null? "" : description.trim();
        this.color = color == null? Color.ORANGE : color;
        this.business = business;
    }

    public Category(UUID id, String name, Business business) {
        this(id,name,null,null,business);
    }

    public Category(UUID id, String name, String description, Business business) {
        this(id,name,description,null,business);
    }

    public Category(UUID id, String name, Color color, Business business) {
        this(id,name,null,color,business);
    }

    public void modifyColor(Color newColor){
        if(newColor == null || newColor.equals(this.color)) return;
        this.color = newColor;
    }

    public void modifyName(String newName){
        if(newName == null || newName.equals(this.name)) return;
        this.name = newName.trim().toLowerCase();
        record(new CategoryNameModifiedDomainEvent(id.toString(),name));
    }

    public void modifyDescription(String newDescription){
        if(newDescription == null || newDescription.equals(this.description)) return;
        this.description = newDescription.trim();
        record(new CategoryDescriptionModifiedDomainEvent(id.toString(),description));
    }

    public String id() {
        return id.toString();
    }

    public String name() {
        return name;
    }

    public String businessId() {
        return business.id().toString();
    }

    public String description() {
        return description;
    }

    public String color(){
        return String.format("[%s,%s,%s]",color.getRed(),color.getGreen(), color.getBlue());
    }
}
