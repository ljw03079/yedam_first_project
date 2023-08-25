package co.yeadam.hello.product.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yeadam.hello.product.service.ProductService;
import co.yeadam.hello.product.service.ProductVO;
import co.yeadam.hello.product.serviceImpl.ProductServiceImpl;

public class ProductManager {// 제품관리 메뉴
	// 1.제품 등록 2.조회 3.전체조회 4.수정 5.삭제 /원하는 작업을 입력하세요, 제품코드 입력, 제품명 입력, 제품가격 입력... 받고
	// DB작업 이후 다시 메뉴 -> 비즈니스설계
	private Scanner sc = new Scanner(System.in);
	ProductService dao = new ProductServiceImpl();

	private void mainTitle() {
		System.out.println("=========================");
		System.out.println("====   제  품  관  리  ====");
		System.out.println("=== 1. 제 품 전 체 조 회 ===");
		System.out.println("=== 2. 제 품 한 건 조 회 ===");
		System.out.println("=== 3. 제 품 등 록 ========");
		System.out.println("=== 4. 제 품 수 정 ========");
		System.out.println("=== 5. 제 품 삭 제 ========");
		System.out.println("=== 6. 종           료 ===");
		System.out.println("=========================");
		System.out.println("= 작업번호를 선택 하세요...");
	}

	public void run() {
		boolean b = false;
		do {
			mainTitle();
			int jobCode = sc.nextInt();
			sc.nextLine();
			switch (jobCode) {
			case 1:
				// 제품 조회 루틴
				System.out.println("------------------------------");
				System.out.println("--------- 제 품 전 체 목 록 -----");
				System.out.println("------------------------------");
				productList(); // 조회 메소드
				System.out.println("------------------------------");
				break;
			case 2:
				// 제품 한건 조회 루틴
				System.out.println("------------------------------");
				System.out.println("조회할 제품코드를 입력하세요");
				String id = sc.nextLine();
				productSelect(id);
				break;
			case 3:
				// 제품 등록 루틴
				System.out.println("---------- 제 품 등 록 ---------");
				productInsert();
				break;
			case 4:
				// 제품 수정 루틴
				System.out.println("---------- 제 품 수 정 ---------");
				productUpdate();
				break;
			case 5:
				// 제품 삭제 루틴
				System.out.println("---------- 제 품 삭 제 ---------");
				productDelete();
				break;
			case 6:
				// 작업종료 루틴
				b = true;
				System.out.println("작업이 종료 됩니다. Bye Bye~~~~~");
				sc.close();
				break;
			}
		} while (!b);
	}

	private void productDelete() {
		ProductVO vo = new ProductVO();
		System.out.println("==삭제할 제품의 코드 입력하세요?");
		vo.setProductId(sc.nextLine());
		int n = dao.productDelete(vo);
		if(n != 0) {
			System.out.println("==제품 정보 변경을 성공했습니다...");
		}else {
			System.out.println("==제품 정보 변경을 삭제했습니다...");
		}
	}

	private void productUpdate() {
		// 먼저 수정 항목 선택
		ProductVO vo = new ProductVO();
		System.out.println("==수정할 제품의 코드 입력하세요?");
		vo.setProductId(sc.nextLine());
		subtitle();
		int key = sc.nextInt();
		sc.nextLine();
		switch (key) {
		case 1:
			System.out.println("=== 제품명을 입력하세요 ===");
			vo.setProductName(sc.nextLine());
			System.out.println("=== 제품가격을 입력하세요 ===");
			vo.setProductPrice(sc.nextInt()); sc.nextLine();
			System.out.println("=== 제품모델을 입력하세요 ===");
			vo.setProductModel(sc.nextLine());
			break;
		case 2:
			System.out.println("=== 제품명을 입력하세요 ===");
			vo.setProductName(sc.nextLine());
			break;
		case 3:
			System.out.println("=== 제품가격을 입력하세요 ===");
			vo.setProductPrice(sc.nextInt()); sc.nextLine();
			break;
		case 4:
			System.out.println("=== 제품모델을 입력하세요 ===");
			vo.setProductModel(sc.nextLine());
			break;
		default:
			System.out.println("==잘못된 항목입니다.");
		}
		
		int n = dao.productUpdate(vo);
		
		if(n != 0) {
			System.out.println("==제품 정보 변경을 성공했습니다...");
		}else {
			System.out.println("==제품 정보 변경을 실패했습니다...");
		}
	}

	private void subtitle() {
		System.out.println("==========================");
		System.out.println("===수정할 항목번호를 선택하세요.");
		System.out.println("==========================");
		System.out.println("==1. 모든 항복 =============");
		System.out.println("==2. 제 품 명 =============");
		System.out.println("==3. 제 품 가 격 ===========");
		System.out.println("==4. 제 품 모 델 ===========");
		System.out.println("==========================");
		System.out.println("==수정항목 선택??==> ");
	}

	private void productInsert() {
		// 제품 등록
		ProductVO vo = new ProductVO();
		System.out.println("==제품 코드 입력하세요?");
		vo.setProductId(sc.nextLine());
		System.out.println("==제품명을 입력하세요?");
		vo.setProductName(sc.nextLine());
		System.out.println("==제품가격을 입력세요?");
		vo.setProductPrice(sc.nextInt());
		sc.nextLine();
		System.out.println("==제품규격을 입력하세요?");
		vo.setProductModel(sc.nextLine());

		int n = dao.productInsert(vo);
		if (n != 0) {
			System.out.println("==제품 등록을 성공했다.");
		} else {
			System.out.println("==제품 등록을 실패했다.");
		}
	}

	private void productSelect(String id) {
		// 제품 한건 조회
		ProductVO vo = new ProductVO();
		vo.setProductId(id);
		vo = dao.productSelect(vo);

		if (vo != null) {
			vo.toString();
		} else {
			System.out.println("제품코드가 존재하지 않습니다.");
		}
	}

	private void productList() {
		// 제품 전체 목록 조회
		List<ProductVO> products = new ArrayList<ProductVO>();

		products = dao.productSelectList();
		for (ProductVO p : products) {
			p.toString();
		}
	}
}
//개인프로젝트: 쇼핑몰, 제품관리, 학생관리, 게시판 등등 아니면 게임도 가능 원하는 주제로 구현
//MVC: model, view, control
//보여주는 영역(처리된 결과를 보여줌) <-> 서비스 영역(service 인터페이스 + VO객체) /연결은 ServiceImpl통해(sqlsession, map)/
//<-> 레퍼지토리 영역(my batis):mapper 인터페이스(CRUD)(src/../resource > mybatis-config.xml > Database properties파일) <-> 레거시 영역(DBMS)
//서비스영역과 레퍼지토리 영역은 비즈니스 영역, 보여주는 영역: 프레젠테이션 영역

// https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.28
// https://mybatis.org/mybatis-3/ko/getting-started.html
// https://mvnrepository.com/artifact/org.mybatis/mybatis/3.5.13
// https://xianeml.tistory.com/44

//ctl shift x -> 대문자
//maven, mybatis
//db관련 프로젝트: service, serviceImpl, mapper, menu 4-5가지 정도로 만듦

//정보통신망법, 개인정보보호법