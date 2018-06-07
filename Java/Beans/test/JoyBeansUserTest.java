import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njwb.joybeans.pojo.JoyBeansUser;
import com.njwb.joybeans.service.JoyBeansUserService;
import com.njwb.joybeans.util.PageModel;

public class JoyBeansUserTest {
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void login() throws Exception {
		JoyBeansUserService joyBeansUserService = (JoyBeansUserService) context.getBean("joyBeansUserService");
		JoyBeansUser joyBeansUser = joyBeansUserService.loginByAccountPwd("gyz", "gyz");
		System.out.println(joyBeansUser.getUserName());
		System.out.println(joyBeansUser.getId());
	}

	@Test
	public void getCode() throws Exception {
		JoyBeansUserService joyBeansUserService = (JoyBeansUserService) context.getBean("joyBeansUserService");
		// System.out.println(joyBeansUserService.getCord("lw"));
	}

	@Test
	public void queryAll() throws Exception {
		JoyBeansUserService joyBeansUserService = (JoyBeansUserService) context.getBean("joyBeansUserService");
		PageModel<JoyBeansUser> pageModel = joyBeansUserService.queryAll(1, 6, "", "", "");
		List<JoyBeansUser> list = pageModel.getDataList();
		for (JoyBeansUser joyBeansUser : list) {
			System.out.println(joyBeansUser.getUserName());
		}
		System.out.println(pageModel.getCnt());
	}

	@Test
	public void register() throws Exception {
		JoyBeansUserService joyBeansUserService = (JoyBeansUserService) context.getBean("joyBeansUserService");
		JoyBeansUser joyBeansUser = new JoyBeansUser();
		joyBeansUser.setUserName("郑理");
		joyBeansUser.setUserAccount("zl");
		joyBeansUser.setUserPwd("zl");
		joyBeansUser.setUserPhone("18360922522");
		// joyBeansUserService.register(joyBeansUser);
	}

	@Test
	public void queryBalance() throws Exception {
		JoyBeansUserService joyBeansUserService = (JoyBeansUserService) context.getBean("joyBeansUserService");
		JoyBeansUser joyBeansUser = joyBeansUserService.queryBalanceByAccount("gyz");
		System.out.println(joyBeansUser.getBeansBalance());
	}
	
	@Test
	public void addSecretBalance() throws Exception {
		JoyBeansUserService joyBeansUserService = (JoyBeansUserService) context.getBean("joyBeansUserService");
		//joyBeansUserService.addSecretBalance("100", "65","103");
	}
}
