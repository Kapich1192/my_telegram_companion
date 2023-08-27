package com.telegramcompanion.service.serializator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telegramcompanion.model.tasks.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public interface ManagerTask {
    default void saveTask(Task task, String userName) {
        String path = "calipso_companion/tasks/" + userName;
        String taskName = UUID.randomUUID().toString();
        new File(path).mkdirs();
        File file = new File(path + "/"+taskName+".json");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            ObjectMapper mapper = new ObjectMapper();
            String taskString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(task);
            writer.write(taskString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default void getTask(Long id) {

    }

    default void getAllTask() {

    }

}
