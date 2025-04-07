package com.cristian.workout_tracker_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.List;

@Entity
@Table(name = "workout_sessions")
@Data
@NoArgsConstructor
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @OneToMany(mappedBy = "workout_session", cascade = CascadeType.ALL)
    private List<WorkoutExercise> exercises;
}
