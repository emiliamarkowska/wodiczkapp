package com.wodiczka.wodiczkapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "CurrentUsagesCategories")
public class CurrentUsageCategory {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "current_usage_id")
    private CurrentUsage currentUsage;
    @Getter
    @Setter
    private float rate;

    public CurrentUsageCategory(Category category, CurrentUsage currentUsage, float rate){
        this.category = category;
        this.currentUsage = currentUsage;
        this.rate = rate;
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
