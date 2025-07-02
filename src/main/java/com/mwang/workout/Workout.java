package com.mwang.workout;

import jakarta.persistence.*;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.List;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "workouts")
public class Workout {

    @Version
    private Integer version;

    @Id @GeneratedValue
    private LocalDate date;
    private String workout;
    private ArrayList<String> sets;

    public Workout(LocalDate date, String workout, ArrayList sets) {
        this.date = date;
        this.workout = workout;
        this.sets = sets;
    }

    public String getWorkout() {
        return workout;
    }

    public ArrayList<String> getSets() {
        return sets;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }
}
