package com.ust.traineeapp.repository;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.util.JDBCConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TraineeRepositoryImpl implements TraineeRepository {

    @Override
    public void addTrainee(Trainee trainee) {
        String sql = "INSERT INTO Trainees (name, datejoined, language, place) VALUES (?, ?, ?, ?)";

        try (Connection connection = JDBCConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, trainee.name()); // Set name
            statement.setDate(2, java.sql.Date.valueOf(trainee.dateJoined())); // Convert LocalDate to java.sql.Date
            statement.setString(3, trainee.language()); // Set language
            statement.setString(4, trainee.place()); // Set place

            int rowCount = statement.executeUpdate();
            System.out.println(rowCount + " rows inserted");

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions properly in production code
        }
    }
    @Override
    public void deleteTrainee(int id) {
        Connection connection = JDBCConnectionUtil.getConnection();
        String sql = "delete from Trainees where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowCount = statement.executeUpdate();
            System.out.println(rowCount + " rows deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public Trainee getTrainee(int id) {
        Connection connection = JDBCConnectionUtil.getConnection();
        String sql = "select * from Trainees where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Date dateJoined = resultSet.getDate("datejoined");
                String language = resultSet.getString("language");
                String place = resultSet.getString("place");
                return new Trainee(name, dateJoined.toLocalDate(), language, place, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Trainee> getAllTrainees() {
        Connection connection = JDBCConnectionUtil.getConnection();
        String sql = "select * from Trainees";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Trainee>trainees=new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date dateJoined = resultSet.getDate("datejoined");
                String language = resultSet.getString("language");
                String place = resultSet.getString("place");
                Trainee trainee = new Trainee(name, dateJoined.toLocalDate(), language, place, id);
                trainees.add(trainee);
            }
            return trainees;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
