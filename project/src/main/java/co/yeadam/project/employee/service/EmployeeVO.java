package co.yeadam.project.employee.service;

import lombok.Data;

@Data
public class EmployeeVO {
	private String employeeId;
	private String employeePassword;
	private String employeeName;
	private String employeeJob;
	private int employeeNum;
}
