package com.albgott.inventoryservice.business.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter()
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "businesses")
@Entity
public class Business {
    @Id
    private UUID id;

    @Column(unique = true,nullable = false)
    private String name;
}
