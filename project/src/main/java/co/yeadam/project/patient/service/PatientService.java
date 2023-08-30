package co.yeadam.project.patient.service;

import java.util.List;
import java.util.Map;

import co.yeadam.project.chart.service.ChartVO;

public interface PatientService {
	List<PatientVO> patientSelectList();
	PatientVO patientSelect(PatientVO vo);
	int patientInsert(PatientVO vo);
	int patientUpdate(PatientVO vo);
	int patientDelete(PatientVO vo);
	List<Map<String,Object>> patientJoin(String s);
}
