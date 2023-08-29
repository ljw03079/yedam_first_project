package co.yeadam.project.chart.service;

import java.util.Date;

import lombok.Data;

@Data
public class ChartVO {
	private String chartContent;
	private Date visitDate;
	private Date nextVisitDate;
	private String disease;
	private int patientId;
	private int employeeNum;
	private String medicineName;
	private String medicineDose;
}
