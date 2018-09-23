import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.telebt.Bot;

/**
 * Init and registration bot.
 * @author ailiashenko
 * @version 0.1
 */

public class Demo {

	private static final Logger LOG = LogManager.getLogger(Demo.class);
	
	public static void main(String[] args) throws IOException {
		
		ApiContextInitializer.init();
		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			botsApi.registerBot(new Bot());
			LOG.debug("new bot is registered");
		} catch (TelegramApiException e) {
			LOG.error("error msg " + e);
			LOG.fatal("fatal error msg " + e);
		}

	}
}
