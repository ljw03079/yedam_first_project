package co.yeadam.project.employee.menu;

import java.util.List;
import java.util.Scanner;

import co.yeadam.project.common.SHA256;
import co.yeadam.project.employee.service.EmployeeService;
import co.yeadam.project.employee.service.EmployeeVO;
import co.yeadam.project.employee.serviceImpl.EmployeeServiceImpl;

public class EmployeeMenu {
		private Scanner sc = new Scanner(System.in);
		private EmployeeService dao = new EmployeeServiceImpl();
		List<EmployeeVO> employees = dao.employeeSelectList();
		private SHA256 sha256 = new SHA256();
		
		private void EmployeeTitle() {
			System.out.println("============================");
			System.out.println("          직 원 관 리         ");
			System.out.println("============================");
			System.out.println("       1. 직원 전체 조회       ");
			System.out.println("       2. 직원 한건 조회       ");
			System.out.println("       3. 내 정보 수정        ");
			System.out.println("       4. 계정 삭제           ");
			System.out.println("       5. 홈 가 기           ");
			System.out.println("============================");
			System.out.print("원하는 작업을 선택하세요>> ");
		}
		
		private void subTitle() {
			System.out.println("============================");
			System.out.println("          수 정 항 목         ");
			System.out.println("============================");
			System.out.println("       1. 비 밀 번 호         ");
			System.out.println("       2. 이      름         ");
			System.out.println("       3. 직      업         ");
			System.out.println("       4. 뒤 로 가 기         ");
			System.out.println("============================");
			System.out.print("수정할 항목을 선택하세요>> ");
		}
		public void run() {
			boolean b = false;
			
			do {
				EmployeeTitle();
				int key = sc.nextInt(); sc.nextLine();
				System.out.println();
				System.out.println();
				switch(key) {
				case 1:
					EmployeeSelectList();
					break;
				case 2:
					EmployeeSelectName();
					break;
				case 3:
					EmployeeUpdate();
					break;
				case 4:
					EmployeeDelete();
					break;
				case 5:
					b=true;
					break;
				default:
					System.out.println("[잘못된 작업번호 입니다.]");
					System.out.println();
					System.out.println();
				}
			}while(!b);
		}

		private void EmployeeDelete() {
			EmployeeVO employee = new EmployeeVO();
			System.out.print("아이디를 입력하세요>> ");
			employee.setEmployeeId(sc.nextLine());
			System.out.print("패스워드를 입력하세요>> ");
			employee.setEmployeePassword(sc.nextLine());
			employee.setEmployeePassword(sha256.encrypt(employee.getEmployeePassword()));

			employee = dao.employeeSelect(employee);
			if (employee != null) {
				EmployeeVO e = new EmployeeVO();
				e.setEmployeeId(employee.getEmployeeId());
				System.out.print("정말 삭제하시겠습니까?(예:1, 아니오:2)>> ");
				int answer = sc.nextInt();
				if(answer == 1) {
					int n = dao.employeeDelete(e);
					if(n != 0) {
						System.out.println("[계정 삭제 성공]");
						System.out.println();
						System.out.println();
					}else {
						System.out.println("[계정 삭제 실패]");
						System.out.println();
						System.out.println();
					}
				}
			} else {
				System.out.println("[아이디 또는 패스워드가 일치하지 않습니다]");
				System.out.println();
				System.out.println();
			}
		}

		private void EmployeeUpdate() {
			EmployeeVO employee = new EmployeeVO();
			System.out.print("아이디를 입력하세요>> ");
			employee.setEmployeeId(sc.nextLine());
			System.out.print("패스워드를 입력하세요>> ");
			employee.setEmployeePassword(sc.nextLine());
			employee.setEmployeePassword(sha256.encrypt(employee.getEmployeePassword()));

			employee = dao.employeeSelect(employee);
			if (employee != null) {
				EmployeeVO e = new EmployeeVO();
				e.setEmployeeId(employee.getEmployeeId());
				subTitle();
				int key = sc.nextInt(); sc.nextLine();
				System.out.println();
				System.out.println();
				switch(key) {
				case 1:
					System.out.print("수정할 비밀먼호를 입력하세요>> ");
					e.setEmployeePassword(sc.nextLine());
					e.setEmployeePassword(sha256.encrypt(e.getEmployeePassword()));
					break;
				case 2:
					System.out.print("수정할 이름을 입력하세요>> ");
					e.setEmployeeName(sc.nextLine());
					break;
				case 3:
					System.out.print("수정할 직업을 선택하세요(1: 의사, 2: 간호사, 3: 그 외)>> ");
					int job = sc.nextInt(); sc.nextLine();
					switch(job) {
					case 1:
						e.setEmployeeJob("의사");
						break;
					case 2:
						e.setEmployeeJob("간호사");
						break;
					case 3:
						e.setEmployeeJob("그 외");
						break;
					}
					break;
				case 4:
					return;
				default:
					System.out.println("[잘못된 작업번호 입니다.]");
					System.out.println();
					System.out.println();
				}
				int n = dao.employeeUpdate(e);
				
				if(n != 0) {
					System.out.println("[내 정보 수정 성공]");
					System.out.println();
					System.out.println();
				}else {
					System.out.println("[내 정보 수정 실패]");
					System.out.println();
					System.out.println();
				}
			} else {
				System.out.println("[아이디 또는 패스워드가 일치하지 않습니다]");
				System.out.println();
				System.out.println();
			}
		}

		private void EmployeeSelectName() {
			EmployeeVO employee = new EmployeeVO();			
			System.out.print("조회할 직원 이름을 선택하세요>> ");
			String name = sc.nextLine();
			employee.setEmployeeName(name);
			employee = dao.employeeSelectName(employee);
			
			if(employee != null) {
				System.out.println("-----------------------------");
				System.out.println("아이디: "+employee.getEmployeeId());
				System.out.println("이름: "+employee.getEmployeeName());
				System.out.println("직업: "+employee.getEmployeeJob());
				System.out.println("직원번호: "+employee.getEmployeeNum());
				System.out.println("-----------------------------");
				System.out.println();
				System.out.println();
			}else {
				System.out.println("[입력하신 이름은 존재하지 않습니다]");
				System.out.println();
				System.out.println();
			}
		}

		private void EmployeeSelectList() {
			System.out.println("============================");
			System.out.println("        직 원 전 체 조 회       ");
			System.out.println("============================");
			System.out.println("\t아이디\t|\t이름\t|\t직업\t|\t직원번호\t|");
			System.out.println("-----------------------------------------------------------------");
			
			for(EmployeeVO e : employees) {
				System.out.print("\t"+e.getEmployeeId()+"\t");
				System.out.print("\t"+e.getEmployeeName()+"\t");
				System.out.print("\t"+e.getEmployeeJob()+"\t");
				System.out.println("\t"+e.getEmployeeNum()+"\t");
			}
			System.out.println();
			System.out.println();
		}
		
		public int getMaxNum() {
			int num = 0;
			for (int i = 0; i < employees.size(); i++) {
				if (employees.get(i).getEmployeeNum() > num) {
					num = employees.get(i).getEmployeeNum();
				}
			}
			return num + 1;
		}
}
