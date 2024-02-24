package com.dev.consumer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "letter")
@Builder(toBuilder = true)
public class Letter {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String title;

    private String text;
}