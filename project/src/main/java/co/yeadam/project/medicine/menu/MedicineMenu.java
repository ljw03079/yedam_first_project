package co.yeadam.project.medicine.menu;

import java.util.List;
import java.util.Scanner;

import co.yeadam.project.medicine.service.MedicineService;
import co.yeadam.project.medicine.service.MedicineVO;
import co.yeadam.project.medicine.serviceImpl.MedicineServiceImpl;

public class MedicineMenu {
	private Scanner sc = new Scanner(System.in);
	private MedicineService dao = new MedicineServiceImpl();
	List<MedicineVO> medicines = dao.medicineSelectList();
	MedicineVO vo = new MedicineVO();
	List<MedicineVO> medicine = dao.medicineSelect(vo);
	
	private void medicineTitle() {
		System.out.println("============================");
		System.out.println("          약 물 조 회         ");
		System.out.println("============================");
		System.out.println("       1. 약물 전체 조회       ");
		System.out.println("       2. 약물 한건 조회       ");
		System.out.println("       3. 홈 가 기           ");
		System.out.println("============================");
		System.out.print("원하는 작업을 선택하세요>> ");
	}
	
	public void run() {
		boolean b = false;
		
		do {
			medicineTitle();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				medicineSelectList();
				break;
			case 2:
				medicineSelect();
				break;
			case 3:
				b = true;
				break;
			default:
				System.out.println("[잘못된 작업번호 입니다.]");
			}
		}while(!b);
	}

	private void medicineSelect() {
		System.out.print("조회할 약물 이름을 선택하세요(첫글자만 대문자로 입력)>> ");
		String name = sc.nextLine();
		vo.setMedicineName(name);
		medicine = dao.medicineSelect(vo);
		
		if(medicine != null) {
			for(MedicineVO m : medicine) {
			System.out.println("-----------------------------");
			System.out.println("약물명: "+m.getMedicineName());
			System.out.println("용량: "+m.getMedicineDose());
			System.out.println("빈도: "+m.getMedicineFrequency());
			System.out.println("복용법: "+m.getMedicineMethod());
			System.out.println("제약회사: "+m.getPharmCompany());
			}
		}else {
			System.out.println("[입력하신 약물은 존재하지 않습니다]");
		}
		System.out.println("-----------------------------");
	}

	private void medicineSelectList() {
		System.out.println("============================");
		System.out.println("        약 물 전 체 조 회       ");
		System.out.println("============================");
		System.out.println("\t약물명\t|\t용량\t|\t제약회사\t|");
		System.out.println("-------------------------------------------------");
		
		for(MedicineVO m : medicines) {
			System.out.print("\t"+m.getMedicineName()+"\t");
			System.out.print("\t"+m.getMedicineDose()+"\t");
			System.out.println("\t"+m.getPharmCompany()+"\t");
		}
	}
}
