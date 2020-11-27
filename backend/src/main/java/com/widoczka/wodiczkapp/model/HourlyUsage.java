package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HourlyUsage")
public class HourlyUsage {

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

    public HourlyUsage() {}

    public HourlyUsage(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HourlyUsage{" +
                "id=" + id +
                ", date=" + date +
                ", sum=" + sum +
                '}';
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
