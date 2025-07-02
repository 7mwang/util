package com.mwang.workout;

import jakarta.persistence.*;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    private LocalDate date;

    private String workout;


    @ElementCollection
    private List<String> sets = new ArrayList<>();



    public Workout() {}

    public Workout(LocalDate date, String workout, ArrayList sets) {
        this.date = date;
        this.workout = workout;
        this.sets = sets;
    }

    public String getWorkout() {
        return workout;
    }

    public List<String> getSets() {
        return sets;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }
}
