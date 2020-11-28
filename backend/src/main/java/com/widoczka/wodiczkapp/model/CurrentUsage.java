package com.widoczka.wodiczkapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CurrentUsages")
public class CurrentUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private LocalDateTime dateTime;

    public CurrentUsage() {}

    public CurrentUsage(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "CurrentUsage{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentUsage currentUsage = (CurrentUsage) o;

        return id == currentUsage.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
