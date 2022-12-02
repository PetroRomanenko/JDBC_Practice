package com.ferros.controller;

import com.ferros.model.Label;
import com.ferros.repository.LabelRepository;
import com.ferros.repository.database.SqlLabelRepositoryImpl;
import com.ferros.repository.gson.JsonLabelRepositoryImpl;

import java.util.List;

public class LabelController {
   private final LabelRepository labelRepository;
    public LabelController() {
         labelRepository = new SqlLabelRepositoryImpl();
    }

    public LabelController(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }



    public Label saveLabel(String name) {
        Label label = new Label(1, name);
        return labelRepository.save(label);
    }

    public Label findLabelById(Integer id){
        if (labelRepository.getById(id)!=null){
            Label label = labelRepository.getById(id);
            return label;
        }

        return null;
    }

    public List<Label> getAllLabels(){
        if (labelRepository.getAll()!=null){
            return labelRepository.getAll();
        }

        return null;
    }
    public Label update(Label label){
       try {
           if (label.getId() != null && label.getName() != null && (label.getId()) != null) {
               labelRepository.update(label);
               return label;
           }
       }catch (NullPointerException e){
           System.out.println("Label id is null");
           return null;
       }
     return null;
    }

    public Label deleteLabelByID(Integer id){
        if (labelRepository.getById(id)!=null) {
            Label label = labelRepository.getById(id);
            labelRepository.deleteById(id);
            return label;
        }
        return null;
    }


}
