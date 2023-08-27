package com.telegramcompanion.service.gags;

import java.util.ArrayList;
import java.util.Random;

public class SwearWordRandomizer {
    public static ArrayList<String> swearList = new ArrayList<>(){{
        add("Ну ты и чертилло");
        add("Неужели?!");
        add("Сколько можно уже?");
        add("Бля ты угараешь?");
        add("Парампампам");
        add("Пошли хуи пинать");
        add("Даже не думай");
        add("Иди работай чертилло");
    }};

    public static String getSwear() {
        Random random = new Random();
        int swearId = random.nextInt(swearList.size());
        return swearList.get(swearId);
    }
}
