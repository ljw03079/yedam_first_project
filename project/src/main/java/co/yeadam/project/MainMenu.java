package co.yeadam.project;

import java.util.Scanner;

import co.yeadam.project.chart.menu.ChartMenu;
import co.yeadam.project.common.SHA256;
import co.yeadam.project.employee.menu.EmployeeMenu;
import co.yeadam.project.employee.service.EmployeeService;
import co.yeadam.project.employee.service.EmployeeVO;
import co.yeadam.project.employee.serviceImpl.EmployeeServiceImpl;
import co.yeadam.project.medicine.menu.MedicineMenu;
import co.yeadam.project.patient.menu.PatientMenu;

public class MainMenu {
	private EmployeeMenu em = new EmployeeMenu();
	private PatientMenu pm = new PatientMenu();
	private MedicineMenu mm = new MedicineMenu();
	private ChartMenu cm = new ChartMenu();
	private EmployeeService dao = new EmployeeServiceImpl();
	EmployeeVO vo = new EmployeeVO();
	private Scanner sc = new Scanner(System.in);
	
	private void title() {
		System.out.println("============================");
		System.out.println(" Electronic Medical Record ");
		System.out.println("============================");
		System.out.println("       1. 직 원 관 리         ");
		System.out.println("       2. 환 자 관 리         ");
		System.out.println("       3. 약 물 조 회         ");
		System.out.println("       4. 진 료 기 록         ");
		System.out.println("       5. 종      료         ");
		System.out.println("============================");
		System.out.print("원하는 작업을 선택하세요>> ");
	}

	public void run() {
		boolean b = false;
		
		if(EmployeeLogin()) {
			do {
				title();
				int key =sc.nextInt(); sc.nextLine();
				System.out.println();
				System.out.println();
				switch(key) {
				case 1:
					em.run();
					break;
				case 2:
					pm.run();
					break;
				case 3:
					mm.run();
					break;
				case 4:
					cm.run();
					break;
				case 5:
					b=true;
					sc.close();
					System.out.println("[시스템을 종료합니다]");
					break;
				default:
					System.out.println("[잘못된 작업번호 입니다.]");
					System.out.println();
					System.out.println();
				}
			}while(!b);
		}
	}

	private boolean EmployeeLogin() {
		SHA256 sha256 = new SHA256();
		boolean b = false;
		
			System.out.println("============================");
			System.out.println("  Login: 1번, Register: 2번  ");
			System.out.println("============================");
			System.out.print("원하는 작업을 선택하세요>> ");
			int first = sc.nextInt();
			sc.nextLine();
			System.out.println();
			System.out.println();
			if (first == 1) {
				System.out.println("============================");
				System.out.println("            Login          ");
				System.out.println("============================");
				System.out.print("아이디를 입력하세요>> ");
				vo.setEmployeeId(sc.nextLine());
				System.out.print("패스워드를 입력하세요>> ");
				vo.setEmployeePassword(sc.nextLine());
				vo.setEmployeePassword(sha256.encrypt(vo.getEmployeePassword()));

				vo = dao.employeeSelect(vo);
				if (vo != null) {
					System.out.println("[" + vo.getEmployeeName() + "님 환영합니다]");
					System.out.println();
					System.out.println();
					b = true;
				} else {
					System.out.println("[아이디 또는 패스워드가 일치하지 않습니다]");
					System.out.println("***시스템을 재시작하세요***");
				}
			}
			else if(first == 2) {
				EmployeeVO registerVo = new EmployeeVO();
				System.out.println("============================");
				System.out.println("           Register         ");
				System.out.println("============================");
				System.out.print("아이디를 입력하세요>> ");
				registerVo.setEmployeeId(sc.nextLine());
				System.out.print("패스워드를 입력하세요>> ");
				registerVo.setEmployeePassword(sc.nextLine());
				registerVo.setEmployeePassword(sha256.encrypt(registerVo.getEmployeePassword()));
				System.out.print("이름을 입력하세요>> ");
				registerVo.setEmployeeName(sc.nextLine());
				System.out.print("직업을 선택하세요(1: 의사, 2: 간호사, 3: 그 외)>> ");
				int job = sc.nextInt(); sc.nextLine();
				switch(job) {
				case 1:
					registerVo.setEmployeeJob("의사");
					break;
				case 2:
					registerVo.setEmployeeJob("간호사");
					break;
				case 3:
					registerVo.setEmployeeJob("그 외");
					break;
				}
				registerVo.setEmployeeNum(em.getMaxNum());//직원번호 부여
				
				int n = dao.employeeInsert(registerVo);
				if(n != 0) {
					System.out.println("[회원 가입 완료]");
					System.out.println();
					System.out.println();
				}else {
					System.out.println("[회원 가입 실패]");
				}
				System.out.println("***시스템을 재시작하세요***");
			} else {
				System.out.println("[잘못된 작업번호 입니다.]");
				System.out.println("***시스템을 재시작하세요***");
			}
		return b;
	}
}
