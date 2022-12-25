package com.ferros;

import com.ferros.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) throws SQLException {
        Integer labelId = 11;
    var result = getLabelsById(labelId);
        System.out.println(result);





    }

    private static List<Integer> getLabelsById(Integer labelId) throws SQLException {
        String sql = """
                SELECT id 
                FROM label
                WHERE id = ?
                """;
        List<Integer> result = new ArrayList<>();
        try (var connection = JdbcUtils.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,labelId);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result.add(resultSet.getObject("id", Integer.class));
            }
        }
        return result;

    }
}
