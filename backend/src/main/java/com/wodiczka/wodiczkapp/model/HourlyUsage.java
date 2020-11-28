package com.wodiczka.wodiczkapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "HourlyUsages")
public class HourlyUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private LocalDateTime dateTime;
    @Getter
    @Setter
    private float sum;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public HourlyUsage(LocalDateTime dateTime, float sum, Category category) {
        this.dateTime = dateTime;
        this.sum = sum;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HourlyUsage record = (HourlyUsage) o;

        return id == record.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
