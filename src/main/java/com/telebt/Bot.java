package com.telebt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.telebt.commands.HelpCommand;
import com.telebt.commands.RandMusicWorkCommand;
import com.telebt.commands.StartCommand;
import com.telebt.commands.UnknownCommand;
import com.utils.ConfigProperties;
import com.utils.Consts;

/**
 * Control over the logic of the main bot's commands.
 * @author ailiashenko
 * @version 0.1
 */

public class Bot extends TelegramLongPollingBot {

	private static final Logger LOG = LogManager.getLogger(Bot.class);
	
	private void exec(SendMessage s) {
		try {
			execute(s);
		} catch (TelegramApiException e) {
			LOG.error("error msg " + e);
			LOG.fatal("fatal error msg " + e);
		}
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			Message msg = update.getMessage();
			String[] input = msg.getText().split("\\s+", 2);
			switch (input[0]) {
			case Consts.START:
				exec(new StartCommand().execute(msg));
				LOG.debug("start command is used");
				break;
			case Consts.HELP:
				exec(new HelpCommand().execute(msg));
				LOG.debug("help command is used");
				break;
			case Consts.RANDOM_ALBUM:
				exec(new RandMusicWorkCommand().execute(msg));
				LOG.debug("random album command is used");
				break;
			case Consts.RANDOM_SINGLE:
				exec(new RandMusicWorkCommand().execute(msg));
				LOG.debug("random single command is used");
				break;
			default:
				exec(new UnknownCommand().execute(msg));
				LOG.debug("unknown command");
			}
		}

	}

	@Override
	public String getBotUsername() {
		return ConfigProperties.getProperty("username");
	}

	@Override
	public String getBotToken() {
		return ConfigProperties.getProperty("token");
	}

}
