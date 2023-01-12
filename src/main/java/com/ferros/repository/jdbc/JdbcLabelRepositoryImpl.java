package com.ferros.repository.jdbc;

import com.ferros.model.Label;
import com.ferros.repository.LabelRepository;
import com.ferros.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcLabelRepositoryImpl implements LabelRepository {
    JdbcUtils jdbcUtils = new JdbcUtils();
    Connection connection = null;
    private static final String SAVE_SQL = """
            INSERT INTO label (label)\s
            VALUES (?);
            """;
    private static final String GET_ALL_SQL = """
            SELECT id,
                   label
            FROM label
            """;
    private static final String GET_BY_ID_SQL =GET_ALL_SQL+ """
            WHERE id_label=?;
            """;
    private static final String UPDATE_SQL = """
            UPDATE label
            SET label = ?
            WHERE id_label=?;
            """;

    private static final String DELETE_SQL = """
            DELETE  FROM label
            WHERE id_label = ?;
            """;

    private Label mapResultSetToLabel(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id_label");
        String labelName = resultSet.getString("label");
        return new Label(id, labelName);
    }

    @Override
    public Label getById(Integer id) {

        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(GET_BY_ID_SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return  mapResultSetToLabel(resultSet);
            }

        } catch (SQLException e) {
            System.out.println("Unable to create statement get by id");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public List<Label> getAll() {
        List<Label> labelList = new ArrayList<>();
        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(GET_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                labelList.add(mapResultSetToLabel(resultSet));
            }
            return labelList;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public Label save(Label label) {

        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(SAVE_SQL)) {
            preparedStatement.setString(1, label.getName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return mapResultSetToLabel(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Unable create statement");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Label update(Label label) {

        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, label.getName());
            preparedStatement.setInt(2, label.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Unable to update label");
            e.printStackTrace();
        }
        return getById(label.getId());
    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement preparedStatement =JdbcUtils.getPreparedStatement(DELETE_SQL)){
            preparedStatement.setInt(1, id);
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                // ЧТО тут написать хз
//                System.out.println("Successfully inserted label");
            }
        } catch (SQLException e) {
            System.out.println("Unable to delete label ");
            e.printStackTrace();
        }


    }
}
