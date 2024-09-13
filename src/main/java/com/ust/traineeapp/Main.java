package com.ust.traineeapp;
import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.TraineeRepository;
import com.ust.traineeapp.repository.TraineeRepositoryImpl;
import com.ust.traineeapp.util.JDBCConnectionUtil;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TraineeRepository repository = new TraineeRepositoryImpl();
        Trainee trainee=new Trainee("Deepak", LocalDate.of(2024,8,11), "Tamil","tamilNadu",1);
//        repository.addTrainee(trainee);
          List<Trainee>list=repository.getAllTrainees();
        list.stream().forEach(System.out::println);
//        repository.getTrainee(1);
//        repository.deleteTrainee(1);

    }
}
