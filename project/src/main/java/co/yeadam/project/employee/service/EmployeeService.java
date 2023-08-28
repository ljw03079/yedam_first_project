package co.yeadam.project.employee.service;

import java.util.List;

public interface EmployeeService {
	EmployeeVO employeeSelect(EmployeeVO vo);
	int employeeInsert(EmployeeVO vo);
	int employeeUpdate(EmployeeVO vo);
	int employeeDelete(EmployeeVO vo);
}
