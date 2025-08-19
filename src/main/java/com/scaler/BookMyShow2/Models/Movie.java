package com.scaler.BookMyShow2.Models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private Integer durationMins;
    private List<String> actors;
    private Double rating;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;
}
