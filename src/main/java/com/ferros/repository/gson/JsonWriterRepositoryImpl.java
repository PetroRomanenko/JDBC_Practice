package com.ferros.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ferros.model.Writer;
import com.ferros.repository.WriterRepository;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JsonWriterRepositoryImpl implements WriterRepository {
    private final Gson gson = new Gson();
    private final String WRITER_FILE_LOCATION = "src/main/resources/writers.json";
    private final Path WRITER_FILE_PATH = Path.of(WRITER_FILE_LOCATION);

    private List<Writer> getAllWritersInternal(){
        try {
            String jsonString = Files.readString(WRITER_FILE_PATH);
            Type typeOfList = new TypeToken<ArrayList<Writer>>(){}.getType();
            return gson.fromJson(jsonString,typeOfList);
        }catch (IOException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private void writeWritersToFile(List<Writer> writers){
        try{
            String writersJson = gson.toJson(writers);
            Files.write(WRITER_FILE_PATH,writersJson.getBytes());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    private Integer generateId(List<Writer> writers){
        Writer writerWithMaxId = writers.stream().max(Comparator.comparing(Writer::getId)).orElse(null);
        return Objects.nonNull(writerWithMaxId)?writerWithMaxId.getId()+1:1;
    }


    @Override
    public Writer getById(Integer id) {
        List<Writer> writerList = getAllWritersInternal();
        return writerList.stream().filter(w -> w.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Writer> getAll() {
        return getAllWritersInternal();
    }

    @Override
    public Writer save(Writer writer) {
        List<Writer> writerList = getAllWritersInternal();
        Integer newId = generateId(writerList);
        writer.setId(newId);

        writerList.add(writer);
        writeWritersToFile(writerList);
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        List<Writer> writerList = getAllWritersInternal();
        for (Writer writerItr: writerList){
            if (writerItr.getId().equals(writer.getId())){
                writerItr.setFirstName(writer.getFirstName());
                writerItr.setLastName(writer.getLastName());
            }
        }
        writeWritersToFile(writerList);
        return writer;
    }

    @Override
    public void deleteById(Integer id) {
        List<Writer> writerList = getAllWritersInternal();
        writerList.removeIf(writer -> writer.getId().equals(id));
        writeWritersToFile(writerList);

    }



    public boolean isValidId(Integer id){
        boolean isValid=false;
        if (id>0){
            List<Writer> writerList = getAllWritersInternal();
            for( Writer writer:writerList){
                if (writer.getId().equals(id)){
                    isValid=true;
                break;}
            }
        }
        return isValid;
    }

}
