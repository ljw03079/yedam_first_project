package co.yeadam.project.patient.map;

import java.util.List;

import co.yeadam.project.patient.service.PatientVO;

public interface PatientMapper {
	List<PatientVO> patientSelectList();
	PatientVO patientSelect(PatientVO vo);
	int patientInsert(PatientVO vo);
	int patientUpdate(PatientVO vo);
	int patientDelete(PatientVO vo);
}
