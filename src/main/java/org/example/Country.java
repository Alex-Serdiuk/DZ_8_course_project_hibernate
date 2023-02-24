package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String countryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<Brand> brands = new ArrayList<>();

    public Country() {
    }

    public int getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    public void addBrand(Brand brand){
        brands.add(brand);
        brand.setCountry(this);
    }
}
