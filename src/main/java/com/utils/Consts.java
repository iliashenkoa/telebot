package com.utils;

/**
 * Different text consts.
 * @author ailiashenko
 * @version 0.1
 */
public final class Consts {

	private Consts() {
		throw new IllegalStateException("Utility class");
	}
	
	// non-printing characters

	public static final String LINE_SEPARATOR = System.lineSeparator();

	public static final String EMOJI_STAR = "\u2b50\ufe0f";

	public static final String EMOJI_MICRO = "\ud83c\udf99";

	public static final String EMOJI_DATE = "\ud83d\udcc5";

	public static final String EMOJI_ROCKSTAR = "\ud83d\udc68\u200d\ud83c\udfa4";

	public static final String EMOJI_GUITAR = "\ud83c\udfb8";

	public static final String EMOJI_EXC = "\u2757\ufe0f";

	public static final char SPACE = '\u0020';

	public static final String WHITE_CIRCLE = "\u26aa\ufe0f";

	public static final String RED_CIRCLE = "\ud83d\udd34";
	

	// commands
	
	public static final String INIT_CHAR_OF_COMMAND = "/";

	public static final String START = INIT_CHAR_OF_COMMAND + "start";

	public static final String HELP = INIT_CHAR_OF_COMMAND + "help";

	public static final String RANDOM_ALBUM = INIT_CHAR_OF_COMMAND + "ralbum";

	public static final String RANDOM_SINGLE = INIT_CHAR_OF_COMMAND + "rsingle";

	// search consts
	
	public static final String ALBUM = "album";
	
	public static final String SINGLE = "single";

	
	// magic numbers
	
	public static final short FLAG = -1;

	public static final short TOP_INDEX_F = 0;

	public static final short TOP_INDEX_L = 9;

	public static final short FIRST_PAGE = 1;

	// msg

	public static final String ERROR_MSG = "Bot didn't find anything. Please check your query!";
	
	public static final String LIST_COMMANDS = "List of all bot's commands:";
	
	public static final String HELP_INFO = "/help - give you main info about available commands";
	
	public static final String RALBUM_INFO = "/ralbum [genre] - bot sent you one random album or top of albums by some genre, which you input";
	
	public static final String RSINGLE_INFO = "/rsingle [genre] - bot sent you one random song or top of songs by some genre, which you input"; 


	// rm links
	public static final String RATEYOURMUSIC = "https://rateyourmusic.com/";

	public static final String PAGE = "customchart?page=";

	public static final String CHART_TYPE_ALBUM = "&chart_type=top&type=album&year=alltime";
	
	public static final String CHART_TYPE_SINGLE = "&chart_type=top&type=single&year=alltime";

	public static final String GENRES = "&genre_include=1&include_child_genres=1&genres=";

	public static final String END = "&include_child_genres_chk=1&include=both&origin_countries=&limit=none&countries=";

}
