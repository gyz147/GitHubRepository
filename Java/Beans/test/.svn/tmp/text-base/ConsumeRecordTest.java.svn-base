import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njwb.joybeans.pojo.wrapper.ConsumeRecordWrapper;
import com.njwb.joybeans.service.ConsumeRecordService;
import com.njwb.joybeans.util.PageModel;

public class ConsumeRecordTest {
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void queryPhoneByAccount() throws Exception {
		ConsumeRecordService consumeRecordService = (ConsumeRecordService) context.getBean("consumeRecordService");
		PageModel<ConsumeRecordWrapper> pageModel=consumeRecordService.queryAllConsumerRecordByConsumerId(1, 5, "65");
		System.out.println(pageModel.getDataList().size());
		System.out.println(pageModel.getCnt());
	}

	@Test
	public void loginByAccountPwd() throws SQLException {

	}
}
