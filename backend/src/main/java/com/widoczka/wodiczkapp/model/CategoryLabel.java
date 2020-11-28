package com.widoczka.wodiczkapp.model;

import javax.persistence.*;

@Entity
@Table(name = "ActivityLabels")
public class CategoryLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Float rate;

    public CategoryLabel() {};

    public CategoryLabel(String name) {
        this.name = name;
    }

    public CategoryLabel(Float rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRate() { return rate; }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CategoryLabel{" +
                "id=" + id +
                ", name=" + name +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryLabel activityLabel = (CategoryLabel) o;

        return id == activityLabel.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
