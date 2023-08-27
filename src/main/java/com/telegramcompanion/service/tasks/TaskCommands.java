package com.telegramcompanion.service.tasks;

import com.telegramcompanion.model.tasks.Task;
import com.telegramcompanion.service.serializator.MainManager;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;

public interface TaskCommands {
    MainManager manager = new MainManager();
    ArrayList<String> listCommandSave = new ArrayList<>() {{
        add("сохрани задачу");
        add("Сохрани задачу");
        add("Cохрани задачку");
        add("сохрани задачку");
    }};

    default boolean checkTaskCommand(String message) {
        if(checkTaskCommandList(message)) {
            return true;
        }
        return false;
    }
    default String mainTaskCommands(Update update, String message) {
        String result = null;
        if (checkTaskCommand(message) ) {
            Task task = new Task();
            task.setId(1l);
            task.setTitle(message);
            manager.saveTask(task,update.getMessage().getChat().getUserName());
            result = "Сохранил задачу";
        }
        return result;
    }

    private boolean checkTaskCommandList(String message) {
        for(String s : listCommandSave) {
            if (message.startsWith(s)) {
                return true;
            }
        }
        return false;
    }
}
