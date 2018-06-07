import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njwb.joybeans.service.SysUserService;

public class SysUserTest {
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void queryPhoneByAccount() throws Exception {
		SysUserService sysUserService = (SysUserService) context.getBean("sysUserService");
		String phone = sysUserService.getMessage("admin");
		System.out.println(phone);
	}

	@Test
	public void loginByAccountPwd() throws SQLException {

	}
}
