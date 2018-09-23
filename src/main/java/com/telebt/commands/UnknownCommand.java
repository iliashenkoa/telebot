package com.telebt.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * Msg for unknown command.
 * @author ailiashenko
 * @version 0.1
 */
public class UnknownCommand implements Command {

	@Override
	public SendMessage execute(Message msg) {
		SendMessage unknownMsg = new SendMessage();
		unknownMsg.setChatId(msg.getChatId().toString());
		unknownMsg.enableHtml(true);
		unknownMsg.setText(
				"<b>" + msg.getText() + "</b> " + "is unknown for this bot. To check full list of commands you need to send <b>/help</b> command.");
		return unknownMsg;
	}

}
