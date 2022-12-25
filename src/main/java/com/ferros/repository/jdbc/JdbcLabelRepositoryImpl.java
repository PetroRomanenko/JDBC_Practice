package com.ferros.repository.jdbc;

import com.ferros.model.Label;
import com.ferros.repository.LabelRepository;
import com.ferros.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcLabelRepositoryImpl implements LabelRepository {
    JdbcUtils jdbcUtils = new JdbcUtils();
    Connection connection = null;
    @Override
    public Label getById(Integer integer) {
        String sql = "select * from label WHERE id=?;";

        int id;
        String stringLabel;
        try {
            connection = jdbcUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,integer);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                id = resultSet.getInt("id");
                stringLabel = resultSet.getString("label");

                return new Label(id, stringLabel);
            }  else {
                System.out.println("такого id не существует");
            }

        } catch (SQLException e) {
            System.out.println("Unable to create statement get by id");
            e.printStackTrace();
        } finally {
            jdbcUtils.closeConnection();
        }

        return null;
    }

    public Label getByLabelName(String labelName) {
        String sql = "SELECT * FROM label WHERE label = ?;";
        Integer id;
        String stringLabel;
        try {
            connection = jdbcUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, labelName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                id = resultSet.getInt("id");
                stringLabel = resultSet.getString("label");
                return new Label(id, stringLabel);
            }else {
                System.out.println("такого id не существует");
            }


        } catch (SQLException e) {
            System.out.println("Unable to create statement get by label");
            e.printStackTrace();
        } finally {
            jdbcUtils.closeConnection();
        }

        return null;
    }

        @Override
    public List<Label> getAll() {
        String sql ="SELECT * FROM label;";
        connection = jdbcUtils.getConnection();
        Label label;
        List<Label> labelList= new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                label = new Label(resultSet.getInt("id"),resultSet.getString("label"));
                labelList.add(label);
            }
            return labelList;
        } catch (SQLException e) {
            System.out.println("Problem with connections");
            e.printStackTrace();
        }finally {
            jdbcUtils.closeConnection();
        }


        return null;
    }

    @Override
    public Label save(Label label) {
        String sql ="INSERT INTO label (label) VALUES (?);";
        connection = jdbcUtils.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, label.getName());
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet>0){
                System.out.println("Successfully inserted label");
            }
            label=getByLabelName(label.getName());

            return getById(label.getId());
        } catch (SQLException e) {
            System.out.println("Unable create statement");
            e.printStackTrace();
        }finally {
            jdbcUtils.closeConnection();
        }

        return null;
    }

    @Override
    public Label update(Label label) {
        String sql = "UPDATE label SET label =? WHERE id=?;";
        connection = jdbcUtils.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,label.getName());
            preparedStatement.setInt(2,label.getId());
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet>0){
                System.out.println("Successfully updated label");
            }

        } catch (SQLException e) {
            System.out.println("Unable to update label");
            e.printStackTrace();
        }

        return getById(label.getId());
    }

    @Override
    public void deleteById(Integer integer) {
        String sql ="DELETE FROM label WHERE id=?;";
        connection = jdbcUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, integer);
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                System.out.println("Successfully inserted label");
            }
        } catch(SQLException e){
            System.out.println("Unable to delete label ");
            e.printStackTrace();
    }


}
}
