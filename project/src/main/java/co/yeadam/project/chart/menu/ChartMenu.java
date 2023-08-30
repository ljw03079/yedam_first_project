package co.yeadam.project.chart.menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import co.yeadam.project.chart.service.ChartService;
import co.yeadam.project.chart.service.ChartVO;
import co.yeadam.project.chart.serviceImpl.ChartServiceImpl;
import co.yeadam.project.employee.service.EmployeeService;
import co.yeadam.project.employee.service.EmployeeVO;
import co.yeadam.project.employee.serviceImpl.EmployeeServiceImpl;

public class ChartMenu {
	private Scanner sc = new Scanner(System.in);
	private ChartService dao = new ChartServiceImpl();
	private EmployeeService edao = new EmployeeServiceImpl();
	ChartVO c = new ChartVO();
	List<ChartVO> charts = dao.chartSelect(c);
	List<EmployeeVO> employees = edao.employeeSelectList();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	private void Title() {
		System.out.println("============================");
		System.out.println("          진 료 기 록         ");
		System.out.println("============================");
		System.out.println("       1. 환자별 진료 기록      ");
		System.out.println("       2. 진료 기록 추가       ");
		System.out.println("       3. 진료 기록 수정       ");
		System.out.println("       4. 홈 가 기           ");
		System.out.println("============================");
		System.out.print("원하는 작업을 선택하세요>> ");
	}
	
	private void modifyTitle() {
		System.out.println("============================");
		System.out.println("          수 정 항 목         ");
		System.out.println("============================");
		System.out.println("       1. 진 료 내 용         ");
		System.out.println("       2. 다음 방문 날짜       ");
		System.out.println("       3. 약      물         ");
		System.out.println("       4. 뒤 로 가 기         ");
		System.out.println("============================");
		System.out.print("수정할 항목을 선택하세요>> ");
	}
	
	public void run() {
		boolean b = false;
		
		do {
			Title();
			int key = sc.nextInt(); sc.nextLine();
			System.out.println();
			System.out.println();
			switch(key) {
			case 1:
				ChartSelect();
				break;
			case 2:
				ChartInsert();
				break;
			case 3:
				ChartUpdate();
				break;
			case 4:
				b=true;
				break;
			default:
				System.out.println("[잘못된 작업번호 입니다.]");
				System.out.println();
				System.out.println();
			}
		}while(!b);
	}

	private void ChartUpdate() {
		modifyTitle();
		int key = sc.nextInt(); sc.nextLine();
		System.out.println();
		System.out.println();
		switch(key) {
		case 1:
			c = updateTitle();
			System.out.print("진료내용을 수정하세요>> ");
			c.setChartContent(sc.nextLine());
			break;
		case 2:
			c = updateTitle();
			System.out.print("다음 방문날짜를 수정하세요>> ");
			try {
				c.setNextVisitDate(sdf.parse(sc.nextLine()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			c = updateTitle();
			System.out.print("약물명을 입력하세요>> ");
			c.setMedicineName(sc.nextLine());
			System.out.print("용량을 입력하세요>> ");
			int dose = sc.nextInt(); sc.nextLine(); 
			c.setMedicineDose(dose);
			System.out.print("복용법을 입력하세요>> ");
			c.setMedicineMethod(sc.nextLine());
			break;
		case 4:
			return;
		default:
			System.out.println("[잘못된 작업번호 입니다.]");
			System.out.println();
			System.out.println();
			return;
		}
		int n = dao.chartUpdate(c);
		
		if(n != 0) {
			System.out.println("[차트 수정 성공]");
			System.out.println();
			System.out.println();
		}else {
			System.out.println("[차트 수정 실패]");
			System.out.println();
			System.out.println();
		}
	}

	private ChartVO updateTitle() {
		System.out.print("수정할 환자번호를 입력하세요>> ");
		int pn = sc.nextInt(); sc.nextLine();
		c.setPatientId(pn);
		System.out.print("수정할 차트의 방문날짜를 입력하세요(yyyy-MM-dd HH:mm:ss)>> ");
		Date vd;
		try {
			vd = sdf.parse(sc.nextLine());
			c.setVisitDate(vd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print("수정할 차트의 담당의사 번호를 입력하세요>> ");
		int en = sc.nextInt(); sc.nextLine();
		c.setEmployeeNum(en);
		return c;
	}
	
	private void ChartInsert() {
		Date date = new Date();
		System.out.println("============================");
		System.out.println("          차 트 작 성         ");
		System.out.println("============================");
		
		System.out.print("환자 번호를 입력하세요>> ");
		int pn = sc.nextInt(); sc.nextLine();
		c.setPatientId(pn);
		System.out.print("담당의사 번호를 입력하세요>> ");
		int en = sc.nextInt(); sc.nextLine();
		c.setEmployeeNum(en);
		System.out.print("질병을 입력하세요>> ");
		String d = sc.nextLine();
		c.setDisease(d);
		System.out.print("진료기록을 입력하세요>> ");
		String cc = sc.nextLine();
		c.setChartContent(cc);
		System.out.print("처방하는 약물명을 입력하세요>> ");
		String mn = sc.nextLine();
		c.setMedicineName(mn);;
		System.out.print("약물용량을 입력하세요>> ");
		int dose = sc.nextInt(); sc.nextLine();
		c.setMedicineDose(dose);
		System.out.print("약물복용법을 입력하세요>> ");
		String mm = sc.nextLine();
		c.setMedicineMethod(mm);
		System.out.print("다음방문날짜를 입력하세요(yyyy-MM-dd HH:mm:ss)>> ");
		Date nvd;
		try {
			nvd = sdf.parse(sc.nextLine());
			c.setNextVisitDate(nvd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setVisitDate(date);
		int n = dao.chartInsert(c);
		if(n != 0) {
			System.out.println("[환자 등록 완료]");
			charts.add(c);
			System.out.println();
			System.out.println();
		}else {
			System.out.println("[환자 등록 실패]");
			System.out.println();
			System.out.println();
		}
	}

	private void ChartSelect() {
		System.out.println("============================");
		System.out.println("         환자별 진료 기록       ");
		System.out.println("============================");
		System.out.print("조회할 환자 번호를 입력하세요>> ");
		int patientId = sc.nextInt(); sc.nextLine();
		c.setPatientId(patientId);
		charts = dao.chartSelect(c);
		
		if(charts != null) {
			for(ChartVO c : charts) {
				System.out.println("-----------------------------");
				System.out.println("방문날짜: "+sdf.format(c.getVisitDate()));
				System.out.println("다음방문날짜: "+sdf.format(c.getNextVisitDate()));
				System.out.println("질병: "+c.getDisease());
				System.out.println("약물명: "+c.getMedicineName()+", 용량: "+c.getMedicineDose()+"mg");
				System.out.println("약물복용법: "+c.getMedicineMethod());
				System.out.println("진료기록: "+c.getChartContent());
				System.out.println("주치의: "+c.getEmployeeNum());
			}
		}else {
			System.out.println("[입력하신 번호는 존재하지 않습니다]");
			System.out.println();
			System.out.println();
		}
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println();
	}
}
