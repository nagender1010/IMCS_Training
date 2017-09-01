package trng.imcs.util;

import java.util.ArrayList;
import java.util.List;

import imcs.core.model.Credentials;
import imcs.core.model.Department;

public class EmpUtil {

	public static List<Department> getDepartmentList() {

		Department d1 = new Department(1, "Development");
		Department d2 = new Department(2, "Production");
		Department d3 = new Department(3, "Account");
		Department d4 = new Department(4, "HR");

		List<Department> deptList = new ArrayList<>();
		deptList.add(d1);
		deptList.add(d2);
		deptList.add(d3);
		deptList.add(d4);

		return deptList;

	}

	public List<Credentials> getCredentials() {

		Credentials cred = new Credentials("abc", "123");
		Credentials cred1 = new Credentials("def", "123");
		Credentials cred2 = new Credentials("ghi", "123");
		Credentials cred3 = new Credentials("jkl", "123");
		Credentials cred4 = new Credentials("mno", "123");

		List<Credentials> credList = new ArrayList<>();
		credList.add(cred);
		credList.add(cred1);
		credList.add(cred2);
		credList.add(cred3);
		credList.add(cred4);


		return credList;

	}

}
