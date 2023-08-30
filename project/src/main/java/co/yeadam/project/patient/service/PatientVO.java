package co.yeadam.project.patient.service;

import lombok.Data;

@Data
public class PatientVO {
	private int patientId;
	private String patientName;
	private String patientGender;
	private String patientResidentNumber;
	private String patientTel;
	private double patientHeight;
	private double patientWeight;
	private int patientAge;
	private int employeeNum;
}