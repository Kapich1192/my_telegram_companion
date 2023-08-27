package com.telegramcompanion.service.bot;

import com.telegramcompanion.config.BotConfig;
import com.telegramcompanion.service.currency.CurrencyApiCommand;
import com.telegramcompanion.service.gags.GagsHelloCommands;
import com.telegramcompanion.service.system_commands.DefaultCommands;
import com.telegramcompanion.service.system_commands.SecurityInterface;
import com.telegramcompanion.service.tasks.TaskCommands;
import com.telegramcompanion.service.ya_gpt.YandexGptCommands;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot
implements DefaultCommands, SecurityInterface, GagsHelloCommands, TaskCommands,
        YandexGptCommands, CurrencyApiCommand
{
    final BotConfig config;

    public TelegramBot(BotConfig config) {
        this.config = config;
    }
    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText()) {

            String messageText = update.getMessage().getText();
            long chartId = update.getMessage().getChatId();

            String result = "Прости брат не допилил еще";

            if(checkUser(update)) {

                if (checkDefaultCommand(messageText)) {
                    result = mainDefaultCommands(update, messageText);
                } else if(checkGagsHelloCommand(messageText)) {
                    result = mainGagsCommands(update, messageText);
                } else if(checkTaskCommand(messageText)) {
                    result = mainTaskCommands(update, messageText);
                } else if(checkYandexGptCommand(messageText)) {
                    result = mainYandexGptCommands(update, messageText);
                } else if(checkCurrencyApiCommand(messageText)) {
                    result = mainCurrencyApiCommands(update, messageText);
                }

            } else {
                result = warningSecurity(update);
            }
            if(result != null)
                sendMessageText(chartId,result);
            }
    }

    public void sendMessageText(long chartId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chartId));
        message.setText(textToSend);
        try{
            execute(message);
        } catch (TelegramApiException e) {

        }
    }

}

