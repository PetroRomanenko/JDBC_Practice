package com.ferros.repository.database;

import com.ferros.model.Label;
import com.ferros.model.Post;
import com.ferros.model.PostStatus;
import com.ferros.model.Writer;
import com.ferros.repository.PostRepository;
import com.ferros.repository.WriterRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class SqlWriterRepositoryImpl implements WriterRepository {
    DBConnection dbConnection = new DBConnection();
    Connection connection = null;

    @Override
    public Writer getById(Integer integer) {
        String sql = "SELECT * from post WHERE id=?;";

        Integer id;
        String firstname;
        String lastname;


        try {
            connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                firstname = resultSet.getString("firstname");
                lastname = resultSet.getString("lastname");
                return new Writer(id, firstname, lastname, getAllPostsByThisWritersId(id));

            }
        } catch (SQLException e) {
            System.out.println("Unable to create statement get by id");
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return null;
    }

    @Override
    public List<Writer> getAll() {
        String sql = "SELECT * FROM writer;";
        connection = dbConnection.getConnection();
        Writer writer;
        List<Writer> writerList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                writer = new Writer(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        getAllPostsByThisWritersId(resultSet.getInt("id")));
                writerList.add(writer);
            }
            return writerList;
        }catch (SQLException e){
            System.out.println("Problem with connections, in get all mathod");
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return null;
    }

    @Override
    public Writer save(Writer writer) {
        String sql = "INSERT INTO writer (firstname, lastname) " +
                "VALUES (?,?);";
        dbConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,writer.getFirstName());
            preparedStatement.setString(2,writer.getLastName());
            int resultSet = preparedStatement.executeUpdate();
            if ( resultSet>0){
                System.out.println("Successfully inserted post");
            }
        }catch(SQLException e){
            System.out.println("Unable create statement");
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection();
        }
        return null;
    }

    @Override
    public Writer update(Writer writer) {
        String sql = "UPDATE post SET firstname =?, lastname = ? WHERE id = ? ;";
        connection = dbConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, writer.getFirstName());
            preparedStatement.setString(1, writer.getLastName());
            preparedStatement.setInt(3, writer.getId());
            int resultSet = preparedStatement.executeUpdate();
            if(resultSet>0){
                System.out.println("Successfully updated post");
            }
            return writer;

        }catch (SQLException e){
            System.out.println("Unable to update post");
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection();
        }
        return null;
    }

    @Override
    public void deleteById(Integer integer) {
            String sql = "DELETE FROM writer WHERE id = ?;";
            connection = dbConnection.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,integer);
                int resultSet = preparedStatement.executeUpdate();
                if(resultSet>0){
                    System.out.println("Successfully deleted label");
                }

            }catch (SQLException e){
                System.out.println("Unable to delete post ");
                e.printStackTrace();
            }finally {
                dbConnection.closeConnection();
            }

    }

    public List<Post> getAllPostsByThisWritersId(Integer id) {
        SqlPostRepositoryImpl sqlPostRepository = new SqlPostRepositoryImpl();

        String sql = "SELECT * FROM post" +
                "JOIN postwriter as pw ON post.id =pw.post_id" +
                "JOIN writer ON writer.id=pw.writer_id WHERE writer.id=?; ";
        try {
            connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Post> postList = new ArrayList<>();
            while (resultSet.next()) {
                Post post = new Post(resultSet.getInt("id"),
                        resultSet.getString("content"),
                        resultSet.getLong("created"),
                        resultSet.getLong("updated"),
                        PostStatus.valueOf(resultSet.getString("post_status")));
                postList.add(post);
            }
            return postList;

        } catch (SQLException e) {
            System.out.println("Unable to create statement get by id");
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        //Дописать метод
        return null;
    }

    public void saveWriterToPost(Writer writer, Post post){
        String sql ="INSERT INTO postwriter( post_id, writer_id)" +
                    "VALUES (?,?);";
        try{
            connection =dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(2,writer.getId());
            preparedStatement.setInt(1,post.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Unable to create statement save writer to post");
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection();
        }
    }
}
