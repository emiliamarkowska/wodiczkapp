package com.wodiczka.wodiczkapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "MonthlyUsages")
public class MonthlyUsage {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private LocalDate date;
    @Getter
    @Setter
    private float sum;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public MonthlyUsage(LocalDate date, float sum, Category category) {
        this.date = date;
        this.sum = sum;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonthlyUsage record = (MonthlyUsage) o;

        return id == record.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
