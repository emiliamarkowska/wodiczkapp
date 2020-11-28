package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "ActiveCategories")
public class ActiveCategory {
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
    private LocalDateTime dateTime;

    public ActiveCategory(Category category, LocalDateTime localDateTime) {
        this.category = category;
        this.dateTime = localDateTime;
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
