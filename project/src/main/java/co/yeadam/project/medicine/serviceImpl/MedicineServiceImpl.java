package co.yeadam.project.medicine.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yeadam.project.common.DataSource;
import co.yeadam.project.medicine.map.MedicineMapper;
import co.yeadam.project.medicine.service.MedicineService;
import co.yeadam.project.medicine.service.MedicineVO;

public class MedicineServiceImpl implements MedicineService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MedicineMapper map = sqlSession.getMapper(MedicineMapper.class);
	
	@Override
	public List<MedicineVO> medicineSelectList() {
		return map.medicineSelectList();
	}

	@Override
	public List<MedicineVO> medicineSelect(MedicineVO vo) {
		return map.medicineSelect(vo);
	}

}
