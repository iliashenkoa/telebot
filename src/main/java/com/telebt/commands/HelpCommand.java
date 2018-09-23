package com.telebt.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import com.utils.Consts;

/**
 * Return just main info (list of commands).
 * @author ailiashenko
 * @version 0.1
 */

public class HelpCommand implements Command {

	@Override
	public SendMessage execute(Message msg) {
		SendMessage helpMsg = new SendMessage();
		helpMsg.setChatId(msg.getChatId().toString());
		helpMsg.enableHtml(true);
		helpMsg.setText(String.format("%s%s%s%s%s%2$s%4$s%s%2$s%4$s%s", "<b>"+Consts.LIST_COMMANDS+"</b>", Consts.LINE_SEPARATOR, "<code>","- ", Consts.HELP_INFO, Consts.RALBUM_INFO, Consts.RSINGLE_INFO+"</code>"));
		return helpMsg;
	}

}
