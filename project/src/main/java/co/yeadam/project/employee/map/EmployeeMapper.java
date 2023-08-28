package co.yeadam.project.employee.map;

import java.util.List;

import co.yeadam.project.employee.service.EmployeeVO;

public interface EmployeeMapper {
	EmployeeVO employeeSelect(EmployeeVO vo);
	int employeeInsert(EmployeeVO vo);
	int employeeUpdate(EmployeeVO vo);
	int employeeDelete(EmployeeVO vo);
}