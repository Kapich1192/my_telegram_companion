package com.telegramcompanion.service.ya_gpt;

import com.telegramcompanion.model.tasks.Task;
import com.telegramcompanion.service.serializator.MainManager;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;

public interface YandexGptCommands {
    MainManager manager = new MainManager();
    ArrayList<String> listYandexGptCommandSave = new ArrayList<>() {{
        add("Напиши текст");
        add("напиши текст");
        add("Напиши код");
        add("напиши код");
        add("Ответь на вопрос");
        add("ответь на вопрос");
    }};

    default boolean checkYandexGptCommand(String message) {
        if(checkYandexGptCommandList(message)) {
            return true;
        }
        return false;
    }
    default String mainYandexGptCommands(Update update, String message) {
        String result = null;
        if (checkYandexGptCommand(message) ) {



            result = "Отправил в Яндекс";
        }
        return result;
    }

    private boolean checkYandexGptCommandList(String message) {
        for(String s : listYandexGptCommandSave) {
            if (message.startsWith(s)) {
                return true;
            }
        }
        return false;
    }
}
