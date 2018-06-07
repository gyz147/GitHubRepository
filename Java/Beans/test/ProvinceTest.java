import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njwb.joybeans.pojo.Province;
import com.njwb.joybeans.service.ProvinceService;

public class ProvinceTest {
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void queryAllNotSecretCard() throws Exception {
		ProvinceService provinceService = (ProvinceService) context.getBean("provinceService");
		List<Province> list = provinceService.queryAllNotSecretCard();
		for (Province province : list) {
			System.out.println(province.getProvName());
		}
	}

	@Test
	public void queryAllNotBeansExchange() throws Exception {
		ProvinceService provinceService = (ProvinceService) context.getBean("provinceService");
		List<String>list=provinceService.queryAllNotBeansExchange("山");
		for (String prov : list) {
			System.out.println(prov);
		}
	}
}
