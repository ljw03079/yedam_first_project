package co.yeadam.project.patient.menu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import co.yeadam.project.patient.service.PatientService;
import co.yeadam.project.patient.service.PatientVO;
import co.yeadam.project.patient.serviceImpl.PatientServiceImpl;

public class PatientMenu {
	private Scanner sc = new Scanner(System.in);
	private PatientService dao = new PatientServiceImpl();
	List<PatientVO> patients = dao.patientSelectList();
	PatientVO p = new PatientVO();
	Date date = new Date();
	SimpleDateFormat sdfY = new SimpleDateFormat("yyyy");

	private void patientTitle() {
		System.out.println("============================");
		System.out.println("          환 자 관 리         ");
		System.out.println("============================");
		System.out.println("       1. 환자 전체 조회       ");
		System.out.println("       2. 환자 한건 조회       ");
		System.out.println("       3. 환자 등록           ");
		System.out.println("       4. 환자 수정           ");
		System.out.println("       5. 환자 삭제           ");
		System.out.println("       6. 홈 가 기           ");
		System.out.println("============================");
		System.out.print("원하는 작업을 선택하세요>> ");
	}

	private void modifyTitle() {
		System.out.println("============================");
		System.out.println("          수 정 항 목         ");
		System.out.println("============================");
		System.out.println("       1. 키                ");
		System.out.println("       2. 몸 무 게           ");
		System.out.println("       3. 연 락 처           ");
		System.out.println("       4. 뒤 로 가 기         ");
		System.out.println("============================");
		System.out.print("원하는 작업을 선택하세요>> ");
	}

	private void listTitle() {
		System.out.println("============================");
		System.out.println("         환 자 리 스 트        ");
		System.out.println("============================");
		System.out.println("       1. 날짜별 조회          ");
		System.out.println("       2. 전체 조회           ");
		System.out.println("       3. 뒤 로 가 기         ");
		System.out.println("============================");
		System.out.print("원하는 작업을 선택하세요>> ");
	}

	public void run() {
		boolean b = false;

		do {
			patientTitle();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				patientSelectList();
				break;
			case 2:
				patientSelect();
				break;
			case 3:
				patientInsert();
				break;
			case 4:
				patientUpdate();
				break;
			case 5:
				patientDelete();
				break;
			case 6:
				b = true;
				break;
			default:
				System.out.println("[잘못된 작업번호 입니다.]");
			}
		} while (!b);
	}

	private void patientDelete() {
		System.out.print("삭제할 환자번호를 입력하세요>> ");
		int pi = sc.nextInt();
		sc.nextLine();
		p.setPatientId(pi);
		int n = dao.patientDelete(p);
		if (n != 0) {
			System.out.println("[환자 삭제 성공]");
		} else {
			System.out.println("[환자 삭제 실패]");
		}

	}

	private PatientVO updateTitle() {
		System.out.print("수정할 환자번호를 입력하세요>> ");
		int pn = sc.nextInt();
		sc.nextLine();
		p.setPatientId(pn);
		return p;
	}

	private void patientUpdate() {
		modifyTitle();
		int key = sc.nextInt();
		sc.nextLine();
		switch (key) {
		case 1:
			p = updateTitle();
			System.out.print("키를 입력하세요>> ");
			p.setPatientHeight(sc.nextLine());
			break;
		case 2:
			p = updateTitle();
			System.out.print("몸무게를 입력하세요>> ");
			p.setPatientWeight(sc.nextLine());
			break;
		case 3:
			p = updateTitle();
			System.out.print("연락처를 입력하세요>> ");
			p.setPatientTel(sc.nextLine());
			break;
		case 4:
			return;
		default:
			System.out.println("[잘못된 작업번호 입니다.]");
		}
		int n = dao.patientUpdate(p);
		if (n != 0) {
			System.out.println("[환자 정보 수정 성공]");
		} else {
			System.out.println("[환자 정보 수정 실패]");
		}
	}

	private void patientInsert() {
		System.out.println("============================");
		System.out.println("          환 자 등 록         ");
		System.out.println("============================");

		System.out.print("환자 이름을 입력하세요>> ");
		p.setPatientName(sc.nextLine());

		boolean b = false;
		do {
			System.out.print("환자 성별을 입력하세요(남:1, 여:2)>> ");
			int gender = sc.nextInt();
			sc.nextLine();
			if (gender == 1) {
				p.setPatientGender("남");
				b = true;
			} else if (gender == 2) {
				p.setPatientGender("여");
				b = true;
			} else {
				System.out.println("[1번과 2번 중 택 1]");
			}
		} while (!b);

		System.out.print("환자 주민번호를 입력하세요(하이픈 포함)>> ");
		p.setPatientResidentNumber(sc.nextLine());
		
		p.getPatientResidentNumber().replace("-", "");
		int birthY = Integer.parseInt(p.getPatientResidentNumber().substring(0, 2));
		int age = Integer.parseInt(sdfY.format(date)) - birthY;
		p.setPatientAge(age);
		
		System.out.print("주치의 번호를 입력하세요>> ");
		int en = sc.nextInt();
		sc.nextLine();
		p.setEmployeeNum(en);

		p.setPatientId(getMaxNum());
		
		int n = dao.patientInsert(p);
		if(n != 0) {
			System.out.println("[환자 등록 완료]");
		}else {
			System.out.println("[환자 등록 실패]");
		}
	}
	
	private int getMaxNum() {
		int num = 0;
		for (int i = 0; i < patients.size(); i++) {
			if (patients.get(i).getPatientId() > num) {
				num = patients.get(i).getPatientId();
			}
		}
		return num + 1;
	}
	
	private void patientSelect() {
		
	}

	private void patientSelectList() {
		listTitle();
		int key = sc.nextInt();
		sc.nextLine();
		switch (key) {
		case 1:
			System.out.println("============================");
			System.out.println("         날 짜 별 조 회        ");
			System.out.println("============================");
			System.out.println("  환자번호  |  이름  |  성별  |  나이  |  주치의번호  |");
			System.out.println("----------------------------------------------");
			break;
		case 2:
			System.out.println("============================");
			System.out.println("        환 자 전 체 조 회       ");
			System.out.println("============================");
			System.out.println("  환자번호  |  이름  |  성별  |  나이  |  주치의번호  |");
			System.out.println("----------------------------------------------");
			for (PatientVO p : patients) {
				System.out.print("  " + p.getPatientId() + "\t");
				System.out.print("    " + p.getPatientName() + " ");
				System.out.print("    " + p.getPatientGender() + "\t");
				System.out.print("    " + p.getPatientAge() + "\t");
//				System.out.println("    "+dao.employeeNameSelect(p));
			}
			break;
		case 3:
			break;
		default:
			System.out.println("[잘못된 작업번호 입니다.]");
		}
	}
}
