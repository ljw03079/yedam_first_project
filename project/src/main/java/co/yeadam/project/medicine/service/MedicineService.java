package co.yeadam.project.medicine.service;

import java.util.List;

public interface MedicineService {
	List<MedicineVO> medicineSelectList();
	List<MedicineVO> medicineSelect(MedicineVO vo);
}
