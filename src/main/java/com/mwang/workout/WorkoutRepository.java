package com.mwang.workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, LocalDate> {}

