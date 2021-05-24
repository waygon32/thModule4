package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.DecimalFormat;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max=20)
    private String name;

    @NotNull
    @Min(0)
    private double area;

    @NotNull
    @Min(0)
    private long population;

    @NotNull
    @Min(0)
    private double gdp;

    @NotBlank
    private String description;

    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public City(Long id,@NotBlank @Size(min = 2, max=20) String name,@NotNull @Min(0) double area,@NotNull @Min(0) long population,@NotNull @Min(0) double gdp,  @NotBlank String description, Country country) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.country = country;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
