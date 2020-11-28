package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ActiveCategories")
public class ActiveCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    public ActiveCategory() {};

    @Override
    public String toString() {
        return "ActiveCategory{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActiveCategory activeCategory = (ActiveCategory) o;

        return id == activeCategory.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
