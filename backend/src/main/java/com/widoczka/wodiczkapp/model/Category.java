package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Float rate;

    public Category() {};

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

        Category activityLabel = (Category) o;

        return id == activityLabel.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
