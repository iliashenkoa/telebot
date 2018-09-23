package com.telebt.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * Main method of all commands.
 * @author ailiashenko
 * @version 0.1
 */
public interface Command {
	public SendMessage execute(Message msg);
}
