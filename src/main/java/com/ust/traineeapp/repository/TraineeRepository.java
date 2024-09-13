package com.ust.traineeapp.repository;

import com.ust.traineeapp.model.Trainee;

import java.util.List;

public interface TraineeRepository {
    void addTrainee(Trainee trainee);
    void deleteTrainee(int id);
    Trainee getTrainee(int id);
    List<Trainee> getAllTrainees();

}
