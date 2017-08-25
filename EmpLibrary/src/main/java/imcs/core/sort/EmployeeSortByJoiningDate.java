package imcs.core.sort;

import java.util.Comparator;

import imcs.core.model.Employee;

//haven't used this class
public class EmployeeSortByJoiningDate implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getDateOfJoining().before(e2.getDateOfJoining())) {
			return -1;
		}if(e1.getDateOfJoining().after(e2.getDateOfJoining())) {
			return 1;
		}
		return 0;
	}

}
