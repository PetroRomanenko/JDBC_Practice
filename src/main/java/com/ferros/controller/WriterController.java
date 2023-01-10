package com.ferros.controller;

import com.ferros.model.Post;
import com.ferros.model.Writer;
import com.ferros.repository.WriterRepository;
import com.ferros.repository.jdbc.JdbcWriterRepositoryImpl;

import java.util.List;

public class WriterController {
    JdbcWriterRepositoryImpl writerRepo = new JdbcWriterRepositoryImpl();

    private final WriterRepository writerRepository = new JdbcWriterRepositoryImpl();
    public Writer saveWriter(String firstName, String lastName, List<Post> postList){
        if (firstName!=null&& lastName!=null){
        Writer writer = new Writer(firstName,lastName);
            return writerRepository.save(writer);
        }
        else return null;
    }

    public Writer findWriterById(Integer id){
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters(){
        return writerRepository.getAll();
    }

    public void saveWriterToPost(Integer writerID, Integer postID){
        if(writerID!=null&&postID!=null){
            writerRepo.saveWriterToPost(writerID,postID);
        }
    }

    public Writer update(Writer writer, Integer postID){
        writerRepository.update(writer);
        saveWriterToPost(writer.getId(), postID);

        return  writer;
    }

    public void deleteWriterById(Integer id){

        writerRepository.deleteById(id);
    }


}


