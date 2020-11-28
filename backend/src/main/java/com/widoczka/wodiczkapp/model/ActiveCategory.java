package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ActiveCategories")
public class ActiveCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Getter
    @Setter
    private LocalDateTime dateTime;

    public ActiveCategory() {};

    public ActiveCategory(Category category){
        this.category = category;
    }

    public ActiveCategory(Category category, LocalDateTime localDateTime) {
        this.category = category;
        this.dateTime = localDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ActiveCategory{" +
                "id=" + id +
                "dateTime=" + dateTime +
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
