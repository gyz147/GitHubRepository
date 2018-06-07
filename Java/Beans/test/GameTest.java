import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njwb.joybeans.pojo.Game;
import com.njwb.joybeans.service.GameService;
import com.njwb.joybeans.util.CodeUtil;
import com.njwb.joybeans.util.PageModel;
import com.njwb.joybeans.util.UUIDGenerator;

public class GameTest {
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void queryAllGame() throws Exception {
		GameService gameService = (GameService) context.getBean("gameService");
		PageModel<Game> pageModel = gameService.queryAllGame(1, 6, "%%", "");
		System.out.println(pageModel.getCnt());
		System.out.println(pageModel.getDataList().size());
	}

	@Test
	public void addGame() throws Exception {
		String a = "abcd.efg.jpg";
		System.out.println(CodeUtil.getSuffix(a));
	}

	@Test
	public void gameNameIsExist() throws Exception {
		GameService gameService = (GameService) context.getBean("gameService");
		if (gameService.gameNameIsExist("三目童")) {
			System.out.println("存在");
			;
		} else {
			System.out.println("不存在");
		}
	}

	@Test
	public void queryByID() throws Exception {
		GameService gameService = (GameService) context.getBean("gameService");
		Game game = gameService.queryById("21");
		System.out.println(game.getGameName());
	}

	@Test
	public void updateGame() throws Exception {
		GameService gameService = (GameService) context.getBean("gameService");
		Game game = new Game();
		game.setId("2");
		game.setGameName("三目童子");
		game.setGameType("1");
		game.setGamePicture("");// 只能为空，不能为null
		game.setGameDetail("射击冒险刺激");
		game.setGameStatus("1");
		game.setGameFee("10");
		game.setGameBeans("10");
		gameService.updateGame(game);
	}
}
