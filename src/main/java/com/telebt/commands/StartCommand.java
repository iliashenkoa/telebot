package com.telebt.commands;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import com.utils.Consts;

/**
 * Hello msg and markup for keyboard.
 * @author ailiashenko
 * @version 0.1
 */
public class StartCommand implements Command {

	@Override
	public SendMessage execute(Message msg) {
		StringBuilder startMsgBuilder = new StringBuilder("<b>Hello</b> " + msg.getChat().getFirstName() + "!\n");
		startMsgBuilder.append(
				"These bot can help you to find best music albums of all time. For more information use command <b>/help</b>.");
		SendMessage startMessage = new SendMessage();
		startMessage.setChatId(msg.getChatId().toString());
		startMessage.enableHtml(true);
		startMessage.setText(startMsgBuilder.toString());

		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
		List<KeyboardRow> keyboard = new ArrayList<>();
		KeyboardRow row = new KeyboardRow();
		row.add(Consts.HELP);
		keyboard.add(row);
		row = new KeyboardRow();
		row.add(Consts.RANDOM_ALBUM);
		keyboard.add(row);
		row = new KeyboardRow();
		row.add(Consts.RANDOM_SINGLE);
		keyboard.add(row);
		keyboardMarkup.setKeyboard(keyboard);
		keyboardMarkup.setSelective(true);
		keyboardMarkup.setResizeKeyboard(true);
		keyboardMarkup.setOneTimeKeyboard(false);
		startMessage.setReplyMarkup(keyboardMarkup);
		return startMessage;
	}

}
