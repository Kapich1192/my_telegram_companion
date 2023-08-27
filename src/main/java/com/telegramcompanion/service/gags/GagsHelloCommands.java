package com.telegramcompanion.service.gags;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;

public interface GagsHelloCommands {
    ArrayList<String> hello = new ArrayList<>(){{
        add("Hello");
        add("Привет");
        add("привет");
    }};
    private boolean checkHelloMessage(String message) {
        for(String s: hello) {
            if(message.startsWith(s)) return true;
        }
        return false;
    }
    default boolean checkGagsHelloCommand(String message) {
        if(checkHelloMessage(message)) {
            return true;
        }
        return false;
    }
    default String mainGagsCommands(Update update, String message) {
        String result = null;
        if (checkHelloMessage(message) ) {
            result = arbitrarySwearing(update);
        }
        return result;
    }

    private String arbitrarySwearing(Update update) {
        return SwearWordRandomizer.getSwear();
    }
}
