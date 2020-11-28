package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MonthlyUsages")
public class MonthlyUsage {

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

    public MonthlyUsage() {}

    public MonthlyUsage(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MonthlyUsage{" +
                "id=" + id +
                ", date=" + date +
                ", sum=" + sum +
                '}';
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
