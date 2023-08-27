package com.telegramcompanion.service.currency;

import lombok.Data;

import java.util.HashMap;

@Data
public class CurrencyModel {
    private String nameCurrency;
    private String value;
    public static  HashMap<String, String> currencies = new HashMap<>();
    public static HashMap<String,String> convertCurrencies (String src) {
        HashMap<String,String> temp = new HashMap<>();
        String[] array = src.split(",");
        String usd = array[2].split(":")[1];

        usd = usd.substring(0,usd.length()-3);

        usd = String.format("%.2f",(double)Double.parseDouble(usd));
        temp.put("USD",usd);

        return temp;
    }
}
