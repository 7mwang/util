package com.mwang.workout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping("/workout")
public class WorkoutController {

    ArrayList<String> testsets = new ArrayList<String>() {{
        add("Chest Fly 6x145 6x145");
        add("Incline Smith 8x155");
    }};

    Workout workout = new Workout(LocalDate.now(), "Chest Upper", testsets);

    @Autowired
    private WorkoutService workoutService;

    @PostMapping("/workout/add")
    public void addWorkout(Workout workout) {
        workoutService.save(workout);
    }
    @GetMapping("/")
    public String info() {
        return "hello";
    }
    @GetMapping("/test")
    public void testdata() {
        addWorkout(workout);
    }

}