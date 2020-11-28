package com.widoczka.wodiczkapp.model;

import javax.persistence.*;

@Entity
@Table(name = "CurrentUsageActivityLabels")
public class CurrentUsageCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "activity_label_id")
    private CategoryLabel activityLabel;

    @ManyToOne
    @JoinColumn(name = "current_usage_id")
    private CurrentUsage currentUsage;

    private float rate;

    public CurrentUsageCategory() {}

    public CurrentUsageCategory(CategoryLabel activityLabel, CurrentUsage currentUsage, float rate){
        this.activityLabel = activityLabel;
        this.currentUsage = currentUsage;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryLabel getActivityLabel() {
        return activityLabel;
    }

    public void setActivityLabel(CategoryLabel activityLabel) {
        this.activityLabel = activityLabel;
    }

    public CurrentUsage getCurrentUsage() {
        return currentUsage;
    }

    public void setCurrentUsage(CurrentUsage currentUsage) {
        this.currentUsage = currentUsage;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CurrentUsageCategory{" +
                "id=" + id +
                ", activityLabel=" + activityLabel +
                ", currentUsage=" + currentUsage +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentUsageCategory that = (CurrentUsageCategory) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
