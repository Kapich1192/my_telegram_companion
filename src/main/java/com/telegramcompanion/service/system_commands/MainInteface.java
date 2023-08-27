package com.telegramcompanion.service.system_commands;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface MainInteface {
    default String mainInterfaceCommand(Update update) {


        return "";
    }
}
