package co.yeadam.project.employee.service;

import java.util.List;

public interface EmployeeService {
	List<EmployeeVO> employeeSelectList();
	EmployeeVO employeeSelect(EmployeeVO vo);
	EmployeeVO employeeSelectName(EmployeeVO vo);
	int employeeInsert(EmployeeVO vo);
	int employeeUpdate(EmployeeVO vo);
	int employeeDelete(EmployeeVO vo);
}
