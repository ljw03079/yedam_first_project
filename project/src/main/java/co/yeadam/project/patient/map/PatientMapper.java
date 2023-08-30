package co.yeadam.project.patient.map;

import java.util.List;
import java.util.Map;

import co.yeadam.project.chart.service.ChartVO;
import co.yeadam.project.patient.service.PatientVO;

public interface PatientMapper {
	List<PatientVO> patientSelectList();
	PatientVO patientSelect(PatientVO vo);
	int patientInsert(PatientVO vo);
	int patientUpdate(PatientVO vo);
	int patientDelete(PatientVO vo);
	List<Map<String,Object>> patientJoin(String s);
}
