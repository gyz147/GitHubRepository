import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njwb.joybeans.pojo.SecretCard;
import com.njwb.joybeans.service.SecretCardService;
import com.njwb.joybeans.util.DateUtil;

public class SecretCardTest {
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void insertSecretCards() {
		SecretCardService secretCardService = (SecretCardService) context.getBean("secretCardService");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cardNumbers", 10);
		param.put("provStr", "5,6");
		param.put("beansNumber", 100);
		param.put("startTime", DateUtil.str2Date("2016-11-19", "yyyy-MM-dd"));
		param.put("endTime", DateUtil.str2Date("2016-12-19", "yyyy-MM-dd"));
		// secretCardService.insertSecretCards(param);
	}

	@Test
	public void querySecretPrice() throws Exception {
		SecretCardService secretCardService = (SecretCardService) context.getBean("secretCardService");
		SecretCard secretCard = secretCardService.querySecretPrice("CAC7789697", "070F8C");
		System.out.println(secretCard.getBeansNumbers());
	}

}
