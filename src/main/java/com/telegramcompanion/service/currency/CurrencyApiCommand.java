

package com.telegramcompanion.service.currency;

import com.telegramcompanion.service.serializator.MainManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.ArrayList;

public interface CurrencyApiCommand {
    MainManager manager = new MainManager();

    ArrayList<String> listCurrencyApiCommandSave = new ArrayList<>() {{
        add("курс");
        add("Курс");
    }};

    default boolean checkCurrencyApiCommand(String message) {
        if(checkCurrencyApiCommandList(message)) {
            return true;
        }
        return false;
    }
    default String mainCurrencyApiCommands(Update update, String message) {
        String result = null;
        if (checkCurrencyApiCommand(message) ) {

            try {
                CurrencyModel.currencies = CurrencyModel.convertCurrencies(getDollarRub());
                result = " 1$ = " + CurrencyModel.currencies.get("USD") + "руб.";
            } catch (Exception e) {
                result = "Ответ скрыт в тумане";
            }
        }
        return result;
    }

    private boolean checkCurrencyApiCommandList(String message) {
        for(String s : listCurrencyApiCommandSave) {
            if (message.startsWith(s)) {
                return true;
            }
        }
        return false;
    }

    private String getDollarRub(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String response = restTemplate.getForObject("https://api.currencyapi.com/v3/historical?apikey=cur_live_uVbuYe9BTZplm0ZGYCmID3K2rxX3Z06DTkOoDNXE&currencies=RUB&date=2023-08-26",String.class);


        return response;
    }
}
