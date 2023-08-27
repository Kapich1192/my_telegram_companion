package com.telegramcompanion.service.system_commands;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

public interface SecurityInterface {
    HashMap<String,String> users = new HashMap<>(){{
        put("Димон","kapich1192");
    }};
    default boolean checkUser(Update update){
        if(users.containsValue(update.getMessage().getChat().getUserName()))
            return true;
        else return false;
    }

    default String warningSecurity(Update update) {
        return "Вам отказано в авторизации @" + update.getMessage().getChat().getUserName() + "!\n" +
                "Обратитесь к администратору для получения доступа.";
    }
}
