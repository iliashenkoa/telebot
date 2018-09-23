package com.utils;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.telebt.entity.MusicWork;
/**
 * Creating response msg by pattern.
 * @author ailiashenko
 * @version 0.1
 */
public class ResultMsgCreator {

	private static List<MusicWork> mwork;

	private static final Logger LOG = LogManager.getLogger(ResultMsgCreator.class);
	
	private ResultMsgCreator() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String responseMsg(String link, int position) throws IOException {
		mwork = HTMLParser.parseRMPage(link);
		if (mwork.isEmpty()) {
			return Consts.ERROR_MSG;
		}
		LOG.debug("result set is created");
		return mwork.get(position).toString();
	}

	public static String responseMsg(String link) throws IOException {
		mwork = HTMLParser.parseRMPage(link);
		if (mwork.isEmpty()) {
			LOG.warn("false query parameter");
			return Consts.ERROR_MSG;
		}
		StringBuilder sb = new StringBuilder();
		int last;
		if (mwork.size() - 1 < Consts.TOP_INDEX_L) {
			last = mwork.size();
		} else {
			last = Consts.TOP_INDEX_L;
		}
		List<MusicWork> topmwork = mwork.subList(Consts.TOP_INDEX_F, last);
		for (int c = 0; c < topmwork.size() - 1; c++) {
			sb.append(String.format("%s %s %s%s%3$s%2$s", topmwork.get(c).toString(),  Consts.LINE_SEPARATOR, Consts.WHITE_CIRCLE,  Consts.RED_CIRCLE));
		}
		sb.append(topmwork.get(topmwork.size() - 1).toString());
		LOG.debug("result set is created");
		return sb.toString();
	}
}
