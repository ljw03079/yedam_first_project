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
	EmployeeVO vo = new EmployeeVO();
	private Login log =new Login();
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
		
		if(log.EmployeeLogin() != null) {
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

	
}
