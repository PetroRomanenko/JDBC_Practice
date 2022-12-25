package com.ferros.repository.jdbc;

import com.ferros.model.Post;
import com.ferros.model.PostStatus;
import com.ferros.model.Writer;
import com.ferros.repository.WriterRepository;
import com.ferros.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcWriterRepositoryImpl implements WriterRepository {

    private Writer mapResultSetToWriter(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String firstname = resultSet.getString("firstname");
        String lastname = resultSet.getString("lastname");
        return new Writer(id, firstname, lastname, null);
    }

    @Override
    public Writer getById(Integer integer) {
        //TODO: use one query with join and enhanced result Set to Object mapping
        String sql = "SELECT * from writer WHERE id=? LEFT JOIN " +
                "SELECT * FROM post" +
                "                JOIN postwriter as pw ON post.id =pw.post_id" +
                "                JOIN writer ON writer.id=pw.writer_id WHERE writer.id=?; ";

        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql)){
            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
              return mapResultSetToWriter(resultSet);

            }
        } catch (SQLException e) {
            System.out.println("Unable to create statement get by id");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Writer> getAll() {
        String sql = "SELECT * FROM writer;";

        Writer writer;
        List<Writer> writerList = new ArrayList<>();
        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(sql)){

            ResultSet resultSet = preparedStatement.executeQuery(sql);

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
        }
        return null;
    }

    @Override
    public Writer save(Writer writer) {
        String sql = "INSERT INTO writer (firstname, lastname) " +
                "VALUES (?,?);";
        try(PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(sql)){
            preparedStatement.setString(1,writer.getFirstName());
            preparedStatement.setString(2,writer.getLastName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if ( resultSet.next()){
                System.out.println("Successfully inserted post");
            }
        }catch(SQLException e){
            System.out.println("Unable create statement");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Writer update(Writer writer) {
        String sql = "UPDATE post SET firstname =?, lastname = ? WHERE id = ? ;";

        try(PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(sql)){

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
        }
        return null;
    }

    @Override
    public void deleteById(Integer integer) {
            String sql = "DELETE FROM writer WHERE id = ?;";

            try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(sql)){
                preparedStatement.setInt(1,integer);
                int resultSet = preparedStatement.executeUpdate();
                if(resultSet>0){
                    System.out.println("Successfully deleted label");
                }

            }catch (SQLException e){
                System.out.println("Unable to delete post ");
                e.printStackTrace();
            }

    }

    public List<Post> getAllPostsByThisWritersId(Integer id) {
        JdbcPostRepositoryImpl sqlPostRepository = new JdbcPostRepositoryImpl();

        String sql = "SELECT * FROM post" +
                "JOIN postwriter as pw ON post.id =pw.post_id" +
                "JOIN writer ON writer.id=pw.writer_id WHERE writer.id=?; ";
        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(sql)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Post> postList = new ArrayList<>();
            while (resultSet.next()) {
                //TODO: Вставить медод мапинг обьекта пост
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
        }
        //Дописать метод
        return null;
    }

    public void saveWriterToPost(Writer writer, Post post){
        String sql ="INSERT INTO postwriter( post_id, writer_id)" +
                    "VALUES (?,?);";
        try(PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(sql)){

            preparedStatement.setInt(2,writer.getId());
            preparedStatement.setInt(1,post.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Unable to create statement save writer to post");
            e.printStackTrace();
        }
    }
}
