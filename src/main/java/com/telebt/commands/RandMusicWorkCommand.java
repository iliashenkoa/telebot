package com.telebt.commands;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import com.utils.Consts;
import com.utils.ResultMsgCreator;

/**
 * Create result message, that contains one or several music works/info about them.
 * @author ailiashenko
 * @version
 */
public class RandMusicWorkCommand implements Command {

	private static final Logger LOG = LogManager.getLogger(RandMusicWorkCommand.class);

	@Override
	public SendMessage execute(Message msg) {
		String result = null;
		String chartType;
		String mWorkType = null;
		if (msg.getText().contains(Consts.RANDOM_ALBUM)) {
			chartType = Consts.CHART_TYPE_ALBUM;
			mWorkType = Consts.ALBUM;
		} else {
			chartType = Consts.CHART_TYPE_SINGLE;
			mWorkType = Consts.SINGLE;
		}
		if (msg.getText().split("\\s+").length == 1) {
			int randomPageNum = ThreadLocalRandom.current().nextInt(1, 126);
			int randomArtistNum = ThreadLocalRandom.current().nextInt(0, 40);
			try {
				result = String.format("<b> %10s %5S</b> %s%s", "RANDOM", mWorkType, Consts.LINE_SEPARATOR,ResultMsgCreator.responseMsg(
						Consts.RATEYOURMUSIC + Consts.PAGE + randomPageNum + chartType + Consts.GENRES + Consts.END,
						randomArtistNum));
			} catch (IOException e) {
				LOG.error("error msg " + e);
				LOG.fatal("fatal error msg " + e);			}
		} else {
			try {
				result = String.format("<b> %10s %5SS</b> %s%s", "TOP", mWorkType, Consts.LINE_SEPARATOR,
						ResultMsgCreator.responseMsg(Consts.RATEYOURMUSIC + Consts.PAGE + Consts.FIRST_PAGE + chartType
						+ Consts.GENRES + msg.getText().split(" ", 2)[1] + Consts.END));
			} catch (IOException e) {
				LOG.error("error msg " + e);
				LOG.fatal("fatal error msg " + e);
			}
		}

		SendMessage randomMsg = new SendMessage();
		randomMsg.setChatId(msg.getChatId().toString());
		randomMsg.enableHtml(true);
		randomMsg.setText(result);
		return randomMsg;
	}

}
