package co.yeadam.project.patient.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yeadam.project.chart.service.ChartVO;
import co.yeadam.project.common.DataSource;
import co.yeadam.project.patient.map.PatientMapper;
import co.yeadam.project.patient.service.PatientService;
import co.yeadam.project.patient.service.PatientVO;

public class PatientServiceImpl implements PatientService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private PatientMapper map = sqlSession.getMapper(PatientMapper.class);
	
	@Override
	public List<PatientVO> patientSelectList() {
		// TODO Auto-generated method stub
		return map.patientSelectList();
	}
	@Override
	public PatientVO patientSelect(PatientVO vo) {
		// TODO Auto-generated method stub
		return map.patientSelect(vo);
	}
	@Override
	public int patientInsert(PatientVO vo) {
		// TODO Auto-generated method stub
		return map.patientInsert(vo);
	}
	@Override
	public int patientUpdate(PatientVO vo) {
		// TODO Auto-generated method stub
		return map.patientUpdate(vo);
	}
	@Override
	public int patientDelete(PatientVO vo) {
		// TODO Auto-generated method stub
		return map.patientDelete(vo);
	}
	@Override
	public List<Map<String, Object>> patientJoin(String s) {
		// TODO Auto-generated method stub
		return map.patientJoin(s);
	}
}
