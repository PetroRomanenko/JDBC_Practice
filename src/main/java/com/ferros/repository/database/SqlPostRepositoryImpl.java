package com.ferros.repository.database;

import com.ferros.model.Label;
import com.ferros.model.Post;
import com.ferros.model.PostStatus;
import com.ferros.repository.PostRepository;
import com.google.gson.internal.LinkedTreeMap;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqlPostRepositoryImpl implements PostRepository {
    DBConnection dbConnection = new DBConnection();
    Connection connection = null;

    public Integer getNextIdForNewPost(){
        Integer id;
        String sql = "SELECT MAX(id) FROM post;";
        connection = dbConnection.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()){
                id=resultSet.getInt("id");
                return id+1;
            }
        }catch (SQLException e){
            System.out.println("Problem with connections, in get all mathod");
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }

        return null;
    }
    @Override
    public Post getById(Integer integer) {
        String sql = "select * from post WHERE id = ?;";

         Integer id;
         String content;
         Long created;
         Long updated;
         PostStatus status;

         try {
             connection =dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1, integer);
             ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()){
                 id= resultSet.getInt("id");
                 content = resultSet.getString("content");
                 created = resultSet.getLong("created");
                 updated = resultSet.getLong("updated");
                 status=PostStatus.valueOf(resultSet.getString("post_status"));

                return new Post(id,content,created,updated,status);
             }
         }catch (SQLException e){
             System.out.println("Unable to create statement get by id");
             e.printStackTrace();
         } finally {
             dbConnection.closeConnection();
         }
        return null;
    }

    @Override
    public List<Post> getAll() {
        String sql = "SELECT * FROM post;";
        connection = dbConnection.getConnection();
        Post post;
        List<Post> postList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                post = new Post(
                     resultSet.getInt("id"),
                     resultSet.getString("content"),
                     resultSet.getLong("created"),
                     resultSet.getLong("updated"),
                     PostStatus.valueOf(resultSet.getString("post_status")));
                postList.add(post);
            }
            return postList;
        }catch (SQLException e){
            System.out.println("Problem with connections, in get all mathod");
            e.printStackTrace();
        } finally {
        dbConnection.closeConnection();
    }
        return null;
    }

    @Override
    public Post save(Post post) {
        String sql = "INSERT INTO post (content, created, post_status) " +
                "VALUES (?,?,?);";
        dbConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,post.getContent());
            preparedStatement.setLong(2,getCurrentTime(post));
            preparedStatement.setString(3,PostStatus.ACTIVE.name());
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
        Post savedPost = getPostByContent(post);
        return savedPost;
    }
    public Post getPostByContent(Post post){
        String sql = "select * from post WHERE content = ?;";

        Integer id;
        String content;
        Long created;
        Long updated;
        PostStatus status;

        try {
            connection =dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, post.getContent());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                id= resultSet.getInt("id");
                content = resultSet.getString("content");
                created = resultSet.getLong("created");
                updated = resultSet.getLong("updated");
                status=PostStatus.valueOf(resultSet.getString("post_status"));
                Post postRequired =new  Post(id,content,created,updated,status);
                postRequired.setLabels(getAllLabelsInPost(postRequired));
                return postRequired;
            }
        }catch (SQLException e){
            System.out.println("Unable to create statement get by content");
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return null;
    }

    @Override
    public Post update(Post post) {
        String sql = "UPDATE post SET content =?, update = ?, post_status = ? WHERE id = ? ;";
        connection = dbConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, post.getContent());
            preparedStatement.setLong(2,getCurrentTime(post));
            preparedStatement.setString(3,PostStatus.UNDER_REVIEW.name());
            preparedStatement.setInt(4,post.getId());
            int resultSet = preparedStatement.executeUpdate();
            if(resultSet>0){
                System.out.println("Successfully updated post");
            }

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
        String sql = "DELETE FROM post WHERE id = ?;";
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

    private Long getCurrentTime(Post post) {
        return new Date().getTime();
    }

    public void saveLabelInPost(Post post, Label label){
        update(post);
        SqlLabelRepositoryImpl repository =new SqlLabelRepositoryImpl();
        repository.save(label);
        String sql ="INSERT INTO label_post (post_id, label_id) \" +\n" +
                "                \"VALUES (?,?);\"";
        try {
            connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,post.getId());
            preparedStatement.setInt(2,label.getId());
            preparedStatement.executeUpdate();
    }catch (SQLException e){
            System.out.println("Unable to create statement get by id");
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection();
        }
    }

    public List<Label> getAllLabelsInPost(Post post){
        String sql ="SELECT * FROM label " +
                "JOIN label_post ON label.id =label_post.label_id " +
                "JOIN post ON post.id=label_post.post_id WHERE label.id=?; ";
        try{
            connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,post.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Label> labelList = new ArrayList<>();
            while (resultSet.next()){
                Label label = new Label(resultSet.getInt("id"),
                                        resultSet.getString("label"));
                labelList.add(label);
            }
            return labelList;
        } catch (SQLException e){
            System.out.println("Unable to create statement get all labels in post");
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    return null;
    }


}
