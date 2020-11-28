package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "AnnualUsage")
public class AnnualUsage {

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

    public AnnualUsage() {}

    public AnnualUsage(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AnnualUsage{" +
                "id=" + id +
                ", date=" + date +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnnualUsage record = (AnnualUsage) o;

        return id == record.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}