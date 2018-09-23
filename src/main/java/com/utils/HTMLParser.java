package com.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.telebt.entity.MusicWork;

/**
 * Parsing rym pages using jsoup by some tags.
 * @author ailiashenko
 * @version 0.1
 */
public class HTMLParser {

	private HTMLParser() {
		throw new IllegalStateException("Utility class");
	}

	public static List<MusicWork> parseRMPage(String link) throws IOException {
		Document doc = Jsoup.connect(link).data("query", "Java").userAgent("Mozilla").cookie("auth", "token")
				.timeout(3000).get();
		List<MusicWork> fullInfo = new ArrayList<>();
		if (!doc.getElementsByClass("error").isEmpty()) {
			return fullInfo;
		} else {
			for (int c = 0; c < doc.getElementsByClass("pos_desktop").size(); c++) {
				String artist = doc.getElementsByClass("artist").get(c).text();
				String albumName = doc.getElementsByClass(Consts.ALBUM).get(c).text();
				String date = doc.getElementsByClass("chart_year").get(c).text();
				String genres = doc.getElementsByClass("chart_detail_line3").get(c).text();
				String rating = doc.getElementsByClass("chart_stats").get(c).text();
				fullInfo.add(new MusicWork(artist, albumName, date, genres, rating));
			}
			return fullInfo;
		}
	}

}
