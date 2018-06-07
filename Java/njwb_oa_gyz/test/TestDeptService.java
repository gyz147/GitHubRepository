import com.njwb.oa.entity.Dept;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.factory.ApplicationContext;
import com.njwb.oa.service.DeptService;

public class TestDeptService {
	public static void main(String[] args) throws OAException {
		DeptService deptService = (DeptService) ApplicationContext.getBean("deptService");

		// List<Dept> deptList = deptService.queryAll();
		//		
		// System.out.println(deptList.size());

		Dept dept = new Dept();
		dept.setDeptNo("A0006");
		dept.setDeptName("namexxx");
		dept.setDeptLoc("locxxx");
		dept.setDeptManager("managerxxx");
		deptService.add(dept);
	}
}
