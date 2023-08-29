package co.yeadam.project.patient.service;

import java.util.List;

public interface PatientService {
	List<PatientVO> patientSelectList();
	PatientVO patientSelect(PatientVO vo);
	String employeeNameSelect(PatientVO vo);
	int patientInsert(PatientVO vo);
	int patientUpdate(PatientVO vo);
	int patientDelete(PatientVO vo);
}
