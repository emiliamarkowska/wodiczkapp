package com.widoczka.wodiczkapp.model;

import javax.persistence.*;

@Entity
@Table(name = "CurrentUsageActivityLabels")
public class CurrentUsageActivityLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float amount;

    @JoinColumn
    @ManyToOne(name = "activity_label_id")
    private ActivityLabel activityLabel;
}
