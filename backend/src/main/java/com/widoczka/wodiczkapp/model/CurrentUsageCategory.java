package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CurrentUsageCategory")
public class CurrentUsageCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @Getter
    @Setter
    private Category category;

    @ManyToOne
    @JoinColumn(name = "current_usage_id")
    @Getter
    @Setter
    private CurrentUsage currentUsage;

    @Getter
    @Setter
    private float rate;

    public CurrentUsageCategory() {}

    public CurrentUsageCategory(Category category, CurrentUsage currentUsage, float rate){
        this.category = category;
        this.currentUsage = currentUsage;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CurrentUsageCategory{" +
                "id=" + id +
                ", category=" + category +
                ", currentUsage=" + currentUsage +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentUsageCategory that = (CurrentUsageCategory) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
