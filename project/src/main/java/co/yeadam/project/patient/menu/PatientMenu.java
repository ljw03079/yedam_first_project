package co.yeadam.project.patient.menu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import co.yeadam.project.chart.service.ChartService;
import co.yeadam.project.chart.service.ChartVO;
import co.yeadam.project.chart.serviceImpl.ChartServiceImpl;
import co.yeadam.project.patient.service.PatientService;
import co.yeadam.project.patient.service.PatientVO;
import co.yeadam.project.patient.serviceImpl.PatientServiceImpl;

public class PatientMenu {
	private Scanner sc = new Scanner(System.in);
	private PatientService dao = new PatientServiceImpl();
	private ChartService cdao = new ChartServiceImpl();
	List<PatientVO> patients = dao.patientSelectList();
	PatientVO p = new PatientVO();
	Date date = new Date();
	SimpleDateFormat sdfY = new SimpleDateFormat("yyyy");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
		System.out.println("       1. 의사별 조회          ");
		System.out.println("       2. 전체 조회           ");
		System.out.println("       3. 날짜별 조회          ");
		System.out.println("       4. 뒤 로 가 기         ");
		System.out.println("============================");
		System.out.print("원하는 작업을 선택하세요>> ");
	}

	public void run() {
		boolean b = false;

		do {
			patientTitle();
			int key = sc.nextInt();
			sc.nextLine();
			System.out.println();
			System.out.println();
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
				System.out.println();
				System.out.println();
			}
		} while (!b);
	}

	private void patientDelete() {
		System.out.print("삭제할 환자번호를 입력하세요>> ");
		int pi = sc.nextInt();
		sc.nextLine();
		p.setPatientId(pi);
		int n = dao.patientDelete(p);
		for(int i=0; i<patients.size(); i++) {
			if(patients.get(i).getPatientId() == pi) {
				patients.remove(i);
			}
		}
		if (n != 0) {
			System.out.println("[환자 삭제 성공]");
			System.out.println();
			System.out.println();
		} else {
			System.out.println("[환자 삭제 실패]");
			System.out.println();
			System.out.println();
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
			double height = sc.nextDouble(); sc.nextLine();
			p.setPatientHeight(height);
			break;
		case 2:
			p = updateTitle();
			System.out.print("몸무게를 입력하세요>> ");
			double weight = sc.nextDouble(); sc.nextLine();
			p.setPatientWeight(weight);
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
			System.out.println();
		}
		int n = dao.patientUpdate(p);
		if (n != 0) {
			System.out.println("[환자 정보 수정 성공]");
			patients.set(p.getPatientId()-1,p);
			System.out.println();
			System.out.println();
		} else {
			System.out.println("[환자 정보 수정 실패]");
			System.out.println();
			System.out.println();
		}
	}

	private void patientInsert() {
		PatientVO vo = new PatientVO();
		System.out.println("============================");
		System.out.println("          환 자 등 록         ");
		System.out.println("============================");

		System.out.print("환자 이름을 입력하세요>> ");
		vo.setPatientName(sc.nextLine());

		boolean b = false;
		do {
			System.out.print("환자 성별을 입력하세요(남:1, 여:2)>> ");
			int gender = sc.nextInt();
			sc.nextLine();
			if (gender == 1) {
				vo.setPatientGender("남");
				b = true;
			} else if (gender == 2) {
				vo.setPatientGender("여");
				b = true;
			} else {
				System.out.println("[1번과 2번 중 택 1]");
			}
		} while (!b);

		System.out.print("환자 주민번호를 입력하세요(하이픈 포함)>> ");
		vo.setPatientResidentNumber(sc.nextLine());
		
		vo.getPatientResidentNumber().replace("-", "");
		int birthY = Integer.parseInt(vo.getPatientResidentNumber().substring(0, 2));
		if(birthY > 23) {
			birthY = birthY + 1900;
		}else {
			birthY = birthY +2000;
		}
		int age = Integer.parseInt(sdfY.format(date)) - birthY;
		vo.setPatientAge(age);
		
		System.out.print("주치의 번호를 입력하세요>> ");
		int en = sc.nextInt();
		sc.nextLine();
		vo.setEmployeeNum(en);

		vo.setPatientId(getMaxNum());
		
		int n = dao.patientInsert(vo);
		patients.add(vo);
		if(n != 0) {
			System.out.println("[환자 등록 완료]");
			System.out.println();
			System.out.println();
		}else {
			System.out.println("[환자 등록 실패]");
			System.out.println();
			System.out.println();
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
		System.out.print("조회할 환자 번호를 선택하세요>> ");
		int pi = sc.nextInt();sc.nextLine();
		p.setPatientId(pi);
		p = dao.patientSelect(p);
		if(p != null) {
			System.out.println("-----------------------------");
			System.out.println("환자번호: "+p.getPatientId());
			System.out.println("이름: "+p.getPatientName());
			System.out.println("성별: "+p.getPatientGender());
			System.out.println("나이: "+p.getPatientAge());
			System.out.println("연락처: "+p.getPatientTel());
			System.out.println("키: "+p.getPatientHeight()+"cm");
			System.out.println("몸무게: "+p.getPatientWeight()+"kg");
			System.out.println("주민번호: "+p.getPatientResidentNumber());
			System.out.println("담당의번호: "+p.getEmployeeNum());
			System.out.println("-----------------------------");
			System.out.println();
			System.out.println();
		}else {
			System.out.println("[입력하신 환자번호는 존재하지 않습니다]");
			System.out.println();
			System.out.println();
		}
	}

	private void patientSelectList() {
		listTitle();
		int key = sc.nextInt();
		sc.nextLine();
		System.out.println();
		System.out.println();
		switch (key) {
		case 1:
			int idxD = 0;
			System.out.println("============================");
			System.out.println("         의 사 별 조 회        ");
			System.out.println("============================");
			System.out.print("조회할 의사의 직원번호를 입력하세요>> ");
			int en = sc.nextInt(); sc.nextLine();
			System.out.println();
			System.out.println("  환자번호  |  이름  |  성별  |  나이  |  담당의번호   |");
			System.out.println("----------------------------------------------");
			for(int i=0; i<patients.size(); i++) {
				if(patients.get(i).getEmployeeNum() == en) {
					System.out.print("  " + patients.get(i).getPatientId() + "\t");
					System.out.print("    " + patients.get(i).getPatientName() + " ");
					System.out.print("    " + patients.get(i).getPatientGender() + "\t");
					System.out.print("    " + patients.get(i).getPatientAge() + "\t");
					System.out.println("    " + patients.get(i).getEmployeeNum());
					idxD += 1;
				}
			}
			System.out.println("<<환자 수: "+idxD+">>");
			System.out.println();
			System.out.println();
			break;
		case 2:
			int idx = 0;
			System.out.println("============================");
			System.out.println("        환 자 전 체 조 회       ");
			System.out.println("============================");
			System.out.println("  환자번호  |  이름  |  성별  |  나이  |  담당의번호   |");
			System.out.println("----------------------------------------------");
			for (PatientVO ps : patients) {
				System.out.print("  " + ps.getPatientId() + "\t");
				System.out.print("    " + ps.getPatientName() + " ");
				System.out.print("    " + ps.getPatientGender() + "\t");
				System.out.print("    " + ps.getPatientAge() + "\t");
				System.out.println("    " + ps.getEmployeeNum());
				idx += 1;
			}
			System.out.println("<<환자 수: "+idx+">>");
			System.out.println();
			System.out.println();
			break;
		case 3:
			chartJoin();
			System.out.println();
			System.out.println("============================");
			System.out.println("         날 짜 별 조 회        ");
			System.out.println("============================");
			System.out.println("  날짜  |  환자번호  |  이름  |  성별  |  나이  |  담당의번호  |  질병   |");
			System.out.println("---------------------------------------------------------------");
			//System.out.println("<<환자수: "+i+">>");
			break;
		case 4:
			break;
		default:
			System.out.println("[잘못된 작업번호 입니다.]");
			System.out.println();
			System.out.println();
		}
	}
	
	public void chartJoin() {
		ChartVO cvo = new ChartVO();
		List<ChartVO> charts = cdao.chartSelect(cvo);
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		System.out.print("조회할 날짜를 입력하세요(yyyy-MM-dd)>> ");
		String searchDate = sc.nextLine();
		for(int i=0; i<charts.size(); i++) {
			if(sdf.format(charts.get(i).getNextVisitDate()).equals(searchDate)) {
				cvo.setNextVisitDate(charts.get(i).getNextVisitDate());
				lists = dao.patientJoin(cvo);
				for(Map<String,Object> l : lists) {
					System.out.println(l.get("NEXT_VISIT_DATE")+"\t"+l.get("PATIENT_ID")+"\t"
							+l.get("PATIENT_NAME")+"\t"+l.get("PATIENT_GENDER")+"\t"+l.get("PATIENT_AGE")+"\t"
							+l.get("EMPLOYEE_NUM")+"\t"+l.get("DISEASE"));
				}
			}
		}
	}
}