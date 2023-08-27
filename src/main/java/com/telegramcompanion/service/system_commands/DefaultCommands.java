package com.telegramcompanion.service.system_commands;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface DefaultCommands {
    default boolean checkDefaultCommand(String message) {
        if(message.equals("/start")) {
            return true;
        } else if (message.equals("/info")) {
            return true;
        }
        return false;
    }
    default String mainDefaultCommands(Update update, String message) {
        String result = null;
        if (message.equals("/start")) {
            result = commandStart(update);
        } else if (message.equals("/info")) {
            result = commandInfo(update);
        }
        return result;
    }
    default String commandStart(Update update){
        return "Hi " + update.getMessage().getChat().getFirstName() + " " + update.getMessage().getChat().getUserName() + "!";
    }

    default String commandInfo(Update update) {
        return "Бот разработан @kapich1192 \n" +
                "Поддерживаются команды: \n" +
                "1. /info - вывод справочной информации \n"
                ;
    }

}
