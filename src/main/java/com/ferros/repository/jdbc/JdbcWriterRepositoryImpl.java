package com.ferros.repository.jdbc;

import com.ferros.model.Post;
import com.ferros.model.Writer;
import com.ferros.repository.WriterRepository;
import com.ferros.utils.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcWriterRepositoryImpl implements WriterRepository {

    private static final String GET_ALL_SQL = """
            SELECT * from writer w
            LEFT JOIN post_writer pw on w.writer_id = pw.writer_id
                                    LEFT JOIN post p on post_id = p.id 
                                      
            """;
    // LEFT JOIN post_writer pw on w.id = pw.writer_id
    //                     LEFT JOIN post p on post_id = p.id  
    private static final String GET_BY_ID_SQL = GET_ALL_SQL + " WHERE w.writer_id = ?";

    private static final String SAVE_SQL = """
            INSERT INTO writer (firstname, lastname) 
                            VALUES (?,?);
            """;

    private static final String UPDATE_SQL = """
            UPDATE writer SET firstname =?, lastname = ? WHERE writer_id = ? ;
            """;

    private static final String DELETE_SQL = """
            DELETE FROM writer WHERE writer_id = ?;
            """;

    private static final String SAVE_WRITER_OF_THE_POST_SQL = """
            INSERT INTO post_writer( post_id, writer_id)
                                VALUES (?,?);
            """;


    private Writer mapResultSetToWriter(ResultSet resultSet) throws SQLException {
        List<Post> postList = new ArrayList<>();
        Integer id = resultSet.getInt("writer_id");
        String firstname = resultSet.getString("firstname");
        String lastname = resultSet.getString("lastname");
        while (resultSet.next()){
            JdbcPostRepositoryImpl postRepository = new JdbcPostRepositoryImpl();

            Post post = postRepository.getById(resultSet.getInt(id));

            postList.add(post);
        }
        return new Writer(id, firstname, lastname, postList);
    }

    @Override
    public Writer getById(Integer integer) {


        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(GET_BY_ID_SQL)){
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

        List<Writer> writerList = new ArrayList<>();
        try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(GET_ALL_SQL)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
               writerList.add(mapResultSetToWriter(resultSet));
            }
            return writerList;
        }catch (SQLException e){
            System.out.println("Problem with connections, in get all method");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Writer save(Writer writer) {

        try(PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(SAVE_SQL)){
            preparedStatement.setString(1,writer.getFirstName());
            preparedStatement.setString(2,writer.getLastName());
             preparedStatement.executeUpdate();
            ResultSet resultSet= preparedStatement.getGeneratedKeys();
            if ( resultSet.next()){
                System.out.println("Successfully inserted post");
                return mapResultSetToWriter(resultSet);
            }
        }catch(SQLException e){
            System.out.println("Unable create statement");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Writer update(Writer writer) {

        try(PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(UPDATE_SQL)){
            preparedStatement.setString(1, writer.getFirstName());
            preparedStatement.setString(1, writer.getLastName());
            preparedStatement.setInt(3, writer.getId());

            int resultSet = preparedStatement.executeUpdate();
            if(resultSet>0){
                System.out.println("Successfully updated post");
                return writer;
            }

        }catch (SQLException e){
            System.out.println("Unable to update post");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

            try (PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(DELETE_SQL)){
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



    public void saveWriterToPost(Integer writerID, Integer postID){

        try(PreparedStatement preparedStatement = JdbcUtils.getPreparedStatementWithGeneratedKeys(SAVE_WRITER_OF_THE_POST_SQL)){

            preparedStatement.setInt(2,writerID);
            preparedStatement.setInt(1,postID);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Unable to create statement save writer to post");
            e.printStackTrace();
        }
    }
}
