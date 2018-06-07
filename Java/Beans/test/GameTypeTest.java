import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njwb.joybeans.pojo.GameType;
import com.njwb.joybeans.service.GameTypeService;
import com.njwb.joybeans.util.PageModel;

public class GameTypeTest {
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void queryAllGameType() throws Exception {
		GameTypeService gameTypeService = (GameTypeService) context.getBean("gameTypeService");
		PageModel<GameType> pageModel = gameTypeService.queryAllGameType(2, 6, "", "");
		System.out.println(pageModel.getDataList().size());
	}

	@Test
	public void ableModifyStatus() throws Exception {
		GameTypeService gameTypeService = (GameTypeService) context.getBean("gameTypeService");
		if (gameTypeService.ableModifyStatus("1")) {
			System.out.println("能修改");
		} else {
			System.out.println("不能修改");
		}
		if (gameTypeService.ableModifyStatus("2")) {
			System.out.println("能修改");
		} else {
			System.out.println("不能修改");
		}
		if (gameTypeService.ableModifyStatus("3")) {
			System.out.println("能修改");
		} else {
			System.out.println("不能修改");
		}
		if (gameTypeService.ableModifyStatus("4")) {
			System.out.println("能修改");
		} else {
			System.out.println("不能修改");
		}
		if (gameTypeService.ableModifyStatus("6")) {
			System.out.println("能修改");
		} else {
			System.out.println("不能修改");
		}
		
	}
	
	@Test
	public void queryAllGameType2() throws Exception {
		GameTypeService gameTypeService = (GameTypeService) context.getBean("gameTypeService");
		List<GameType> list = gameTypeService.queryAllGameType();
		for (GameType gameType : list) {
			System.out.println(gameType.getTypeName());
		}
	}

	@Test
	public void updateGameType() throws Exception {
		GameTypeService gameTypeService = (GameTypeService) context.getBean("gameTypeService");
		GameType gameType = new GameType();
		gameType.setId("21");
		gameType.setTypeName("飞行类");
		gameType.setTypeStatus("2");
		gameTypeService.updateGameType(gameType);
	}
}
