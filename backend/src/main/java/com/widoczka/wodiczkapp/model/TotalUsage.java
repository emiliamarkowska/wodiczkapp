package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TotalUsages")
public class TotalUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private LocalDate date;
    @Getter
    @Setter
    private int sum;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @Getter
    @Setter
    private Category category;

    public TotalUsage() {}

    public TotalUsage(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TotalUsage{" +
                "id=" + id +
                ", date=" + date +
                ", sum=" + sum +
                '}';
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
