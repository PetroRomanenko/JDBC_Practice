package com.ferros.controller;

import com.ferros.model.Post;
import com.ferros.model.Writer;
import com.ferros.repository.WriterRepository;
import com.ferros.repository.database.SqlWriterRepositoryImpl;
import com.ferros.repository.gson.JsonWriterRepositoryImpl;

import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository = new SqlWriterRepositoryImpl();
    public Writer saveWriter(String firstName, String lastName, List<Post> postList){
        Writer writer = new Writer(null, firstName,lastName, postList);
        return writerRepository.save(writer);
    }

    public Writer findWriterById(Integer id){
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters(){
        return writerRepository.getAll();
    }

    public Writer update(Writer writer){
        writerRepository.update(writer);
        return  writer;
    }

    public void deleteWriterById(Integer id){
        writerRepository.deleteById(id);
    }

    public void printWriterList(List<Writer> writers){
//        writerRepository.printList(writers);
    }

}
