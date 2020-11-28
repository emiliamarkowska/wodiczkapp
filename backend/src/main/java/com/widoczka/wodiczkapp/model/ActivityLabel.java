package com.widoczka.wodiczkapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ActivityLabels")
public class ActivityLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Float rate;

    public ActivityLabel () {};

    public ActivityLabel(String name) {
        this.name = name;
    }

    public ActivityLabel(Float rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRate() { return rate; }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ActivityLabel{" +
                "id=" + id +
                ", name=" + name +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityLabel activityLabel = (ActivityLabel) o;

        return id == activityLabel.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
