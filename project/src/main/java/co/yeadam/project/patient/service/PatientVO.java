package co.yeadam.project.patient.service;

import lombok.Data;

@Data
public class PatientVO {
	private int patientId;
	private String patientName;
	private String patientGender;
	private String patientResidentNumber;
	private String patientTel;
	private String patientHeight;
	private String patientWeight;
	private int patientAge;
	private int employeeNum;
}