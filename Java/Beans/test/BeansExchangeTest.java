import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njwb.joybeans.pojo.BeansExchange;
import com.njwb.joybeans.service.BeansExchangeService;

public class BeansExchangeTest {
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void queryById() throws Exception {
		BeansExchangeService beansExchangeService = (BeansExchangeService) context.getBean("beansExchangeService");
		BeansExchange beansExchange = beansExchangeService.queryById("1");
		System.out.println(beansExchange.getProvName());
	}

	@Test
	public void update() throws Exception {
		BeansExchangeService beansExchangeService = (BeansExchangeService) context.getBean("beansExchangeService");
		beansExchangeService.editBeanExchange("1", "2");
	}

}
