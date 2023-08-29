package co.yeadam.project.medicine.map;

import java.util.List;

import co.yeadam.project.medicine.service.MedicineVO;

public interface MedicineMapper {
	List<MedicineVO> medicineSelectList();
	List<MedicineVO> medicineSelect(MedicineVO vo);
}
