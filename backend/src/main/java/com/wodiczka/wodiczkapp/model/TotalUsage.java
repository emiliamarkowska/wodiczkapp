package com.wodiczka.wodiczkapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "TotalUsages")
public class TotalUsage {
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
    @ManyToOne
    @JoinColumn(name = "category_id")
    @Getter
    @Setter
    private Category category;

    public TotalUsage(LocalDate date, float sum, Category category) {
        this.date = date;
        this.sum = sum;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TotalUsage record = (TotalUsage) o;

        return id == record.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
