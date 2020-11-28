package com.wodiczka.wodiczkapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "DailyUsages")
public class DailyUsage {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private LocalDateTime dateTime;

    public DailyUsage(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DailyUsage dailyUsage = (DailyUsage) o;

        return id == dailyUsage.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
