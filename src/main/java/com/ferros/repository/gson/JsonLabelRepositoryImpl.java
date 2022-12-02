package com.ferros.repository.gson;

import com.ferros.model.Label;
import com.ferros.repository.LabelRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JsonLabelRepositoryImpl implements LabelRepository {

    private final Gson gson = new Gson();
    private final String LABEL_FILE_LOCATION = "src/main/resources/labels.json";
    private final Path LABEL_FILE_PATH = Path.of(LABEL_FILE_LOCATION);

    private List<Label> getAllLabelsInternal() {
        try {
            String jsonString = Files.readString(LABEL_FILE_PATH);
            Type typeOfList = new TypeToken<ArrayList<Label>>() {
            }.getType();
            return gson.fromJson(jsonString, typeOfList);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private void writeLabelsToFile(List<Label> labels) {
        try {
            String labelsJson = gson.toJson(labels);
            Files.write(LABEL_FILE_PATH, labelsJson.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Integer generateId(List<Label> labels) {
        Label labelWithMaxId = labels.stream().max(Comparator.comparing(Label::getId)).orElse(null);
        return Objects.nonNull(labelWithMaxId) ? labelWithMaxId.getId() + 1 : 1;
    }

    @Override
    public Label getById(Integer id) {
        List<Label> labelList = getAllLabelsInternal();
        return labelList.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Label> getAll() {
        return getAllLabelsInternal();
    }

    @Override
    public Label save(Label label) {
        List<Label> labelList = getAllLabelsInternal();
        Integer newId = generateId(labelList);
        label.setId(newId);

        labelList.add(label);
        writeLabelsToFile(labelList);
        return label;
    }

    @Override
    public Label update(Label label) {
        List<Label> labelList = getAllLabelsInternal();
        for (Label labelItr : labelList) {
            if (labelItr.getId().equals(label.getId())) {
                labelItr.setName(label.getName());
            }
        }

        writeLabelsToFile(labelList);

        return label;
    }

    @Override
    public void deleteById(Integer id) {
        List<Label> labelList = getAllLabelsInternal();
        labelList.removeIf(label -> label.getId().equals(id));
        writeLabelsToFile(labelList);
    }




}
