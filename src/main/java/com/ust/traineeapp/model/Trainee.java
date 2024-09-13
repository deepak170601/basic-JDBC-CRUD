package com.ust.traineeapp.model;

import java.time.LocalDate;
import com.ust.traineeapp.model.Trainee;
public record Trainee( String name, LocalDate dateJoined, String language, String place, int projectId) {

}
