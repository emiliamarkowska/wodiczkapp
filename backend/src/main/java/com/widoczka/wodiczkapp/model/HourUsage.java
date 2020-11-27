package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "HourUsage")
public class HourUsage {

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

    public HourUsage(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HourUsage{" +
                "id=" + id +
                ", date=" + date +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HourUsage record = (HourUsage) o;

        return id == record.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
