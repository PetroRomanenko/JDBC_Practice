package com.ferros.repository.jdbc;

import com.ferros.model.Label;
import com.ferros.model.Post;
import com.ferros.model.PostStatus;
import com.ferros.repository.PostRepository;
import com.ferros.utils.JdbcUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcPostRepositoryImpl implements PostRepository {
    JdbcUtils jdbcUtils = new JdbcUtils();
    Connection connection = null;
    private static final String GET_ALL_SQL = """
            SELECT id,
                   content,
                   created,
                   updated,
                   post_status 
            FROM post
            """;
    private static final String GET_BY_ID_SQL = GET_ALL_SQL + """
            WHERE ID = ?;
            """;
    private static final String SAVE_SQL = """
            INSERT INTO post (content, created, post_status)  
            VALUES (?,?,?)
            """;
    private static final String UPDATE_SQL = """
                UPDATE post 
                SET content = ?, 
                    updated = ?, 
                    post_status = ? 
                WHERE id = ? ;
            """;

    private static final String DELETE_SQL = """
            DELETE FROM post
            WHERE id = ? ;
            """;

    private static final String ADD_LABEL_INTO_POST_SQL = """
            INSERT INTO label_post (post_id, label_id)
            VALUES (? , ?) ;
            """;

    private static final String GET_ALL_LABELS_IN_POST = """
    SELECT * FROM label 
                JOIN label_post ON label.id =label_post.label_id 
                JOIN post ON post.id=label_post.post_id WHERE post.id=?;
        """;


    @Override
    public Post getById(Integer integer) {

        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(GET_BY_ID_SQL)) {
            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToPost(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Unable to create statement get by id");
            e.printStackTrace();
        }
        return null;
    }

    private static Post mapResultSetToPost(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String content = resultSet.getString("content");
        Long created=null;
        if (resultSet.getTimestamp("created")!=null) {
             created = resultSet.getTimestamp("created").getTime();
        }
        Long updated=null;
        if(resultSet.getTimestamp("updated")!=null) {
             updated = resultSet.getTimestamp("updated").getTime();
        }
        PostStatus status = PostStatus.valueOf(resultSet.getString("post_status"));
        List<Label> labelList = getAllLabelsInPost(id);

        return new Post(id, content, created, updated, status, labelList );
    }

    @Override
    public List<Post> getAll() {
        List<Post> postList = new ArrayList<>();
        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(GET_ALL_SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                postList.add(mapResultSetToPost(resultSet));
            }
            return postList;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Post save(Post post) {

        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(SAVE_SQL)) {
            preparedStatement.setString(1, post.getContent());
            preparedStatement.setTimestamp(2,  getCurrentTime(post));
            preparedStatement.setString(3, PostStatus.ACTIVE.name());
            preparedStatement.executeUpdate();
            ResultSet resultSet= preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return mapResultSetToPost(resultSet);
            }
        } catch (SQLException e) {

            throw new RuntimeException();
        }
        return null;
    }

//    public Post getPostByContent(Post post) {
//        String sql = "select * from post WHERE content = ?;";
//
//        Integer id;
//        String content;
//        Long created;
//        Long updated;
//        PostStatus status;
//
//        try {
//            connection = jdbcUtils.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, post.getContent());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                id = resultSet.getInt("id");
//                content = resultSet.getString("content");
//                created = resultSet.getLong("created");
//                updated = resultSet.getLong("updated");
//                status = PostStatus.valueOf(resultSet.getString("post_status"));
//                Post postRequired = new Post(id, content, created, updated, status);
//                postRequired.setLabels(getAllLabelsInPost(postRequired));
//                return postRequired;
//            }
//        } catch (SQLException e) {
//            System.out.println("Unable to create statement get by content");
//            e.printStackTrace();
//        } finally {
//            jdbcUtils.closeConnection();
//        }
//        return null;
//    }

    @Override
    public Post update(Post post) {
        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(UPDATE_SQL)){
            preparedStatement.setString(1, post.getContent());
            preparedStatement.setTimestamp(2, getCurrentTime(post));
            preparedStatement.setString(3, PostStatus.UNDER_REVIEW.name());
            preparedStatement.setInt(4, post.getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet =  preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                System.out.println("Successfully updated post");
                return mapResultSetToPost(resultSet);
            }

        } catch (SQLException e) {
            System.out.println("Unable to update post");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(Integer integer) {
        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(DELETE_SQL)){
            preparedStatement.setInt(1, integer);
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                System.out.println("Successfully deleted label");
            }

        } catch (SQLException e) {
            System.out.println("Unable to delete post ");
            e.printStackTrace();
        }
    }

    private Timestamp getCurrentTime(Post post) {
//
        return  new Timestamp(System.currentTimeMillis());
    }

    public void saveLabelInPost(Integer postID, Integer labelId){


        {
            try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(ADD_LABEL_INTO_POST_SQL)) {
                preparedStatement.setInt(1, postID);
                preparedStatement.setInt(2, labelId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Unable to create statement get by id");
                e.printStackTrace();
            }
        }
    }

    public static List<Label> getAllLabelsInPost(Integer postId) {

        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(GET_ALL_LABELS_IN_POST) ){
            preparedStatement.setInt(1, postId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Label> labelList = new ArrayList<>();
            while (resultSet.next()) {
                Label label = new Label(resultSet.getInt("id"),
                        resultSet.getString("label"));
                labelList.add(label);
            }
            return labelList;
        } catch (SQLException e) {
            System.out.println("Unable to create statement get all labels in post");
            e.printStackTrace();
        }
        return null;
    }


}
