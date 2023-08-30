package co.yeadam.project;

public class Desc {
//	--apache-maven-quickstarat로 생성
//	resources 폴더 생성
//
//	--pom.xml
//	version 11로 고치기
//	메이븐에서 ojdbc8, lombok, mybaits 복사 붙여넣기
//
//	--resources 폴더 안에 mybatis-config.xml 생성
//	mybatis홈페이지 getting started에서 building SqlSessionFactory from xml 복붙
//	<configuration>밑에
//	<properties resource="database.properties"/>
//
//	mybatis홈페이지의 Configuration XML- Settings에서 이름 복붙
//	<settings>
//	  	<setting name="jdbcTypeForNull" value="NULL"/>
//	  	<setting name="mapUnderscoreToCamelCase" value="true"/>
//	</settings>
//
//	<mappers>
//	    <package name="co.yeadam.test"/>
//	</mappers>
//	 
//	 ${username} -> ${user}로 변경
//	${},#{} -> EL 표현식: properties가 가지고 있는 변수명 Key
//
//	--database.properties 생성
//	key, value 확인
//	사용자명 관례적으로 ${user}씀
//
//	--sql 테이블 생성
//
//	--DataSource 클래스 생성
//
//	--MemberVO 클래스 생성
//	@Data: lombok
//
//	--MemberService 인터페이스 생성
//	--MemberMapper 인터페이스 생성(MemberService와 내용같음)
//	--MemberMapper.xml에서 인터페이스 구현
//
//	--MemberServiceImpl 클래스 생성(MemberService를 인터페이스로)
//	map과 service를 연결
//
//	--MemberMenu 클래스 생성
//
//	--App에서 실행
//
//	java.security.MessageDigest ->암호화
//
//	어떤 메뉴이든 MemberVO 필요
//
//	product와 연결 : hello 되어있는거 refectory, rename로 test로 바꿔주고
//	product.mapper.xml 안에 hello -> test로 바꿔줘야함.
//
//	**SQL
//	select * from member;
//
//	insert into member(member_id, member_password, member_name)
//	values ('jiwon@yeadam.co.kr','1234','이지원');
//
//	select * from member where member_id = 'jiwon@yeadam.co.kr'
//	and member_password = ' 3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4';
//
//	update member set member_password = ' 3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'
//	where member_id = 'jiwon@yeadam.co.kr';
//
//	commit;
//	**
//
//	//프로젝트
//	1. CRUD -> 선택 : 게시판,쇼핑몰,학사관리 등(멤버관리로 회원만 게시글 작성권한)
//	   최소 테이블이 2개이상 이어야함.
//	   1.기능정의 2.화면구현(코드말고 손으로 메뉴 그리기) 3.table설계
//	   4.common, 서비스레이어, 메퍼... 생성
//	2. 자유주제 -> 게임 등
//	   DB 이용해도 좋고 안해도 좋음
//	   1.기능정의 2.DB (사용자가 몇점을 취득했는지)
//	   CRUD를 이용한 게임
//	   1.전투(일정시간 랜덤으로 돌리다가 시간이 지나면 레벨업)
//	   2.사용자마다 DB 정리
//	**8/31 오후2시30분 발표(시험)
//
//	Java 개인별 Project
//	1. 기간 2023.08.28 ~ 2023.08.31(오후 13시 10분까지)
//	2.주요일정
//	 2023.08.28: 프로젝트 개요 정의 및 기능 설계
//	 2023.08.29: 프로젝트 구성 및 DB 설계, 구현
//	 2023.08.31: 프로젝트 발표(오후2시30분 부터)
//	3.구현방법
//	 Maven 프로젝트 구성
//	 표현, 서비스, 맵퍼 영역 구분해서 구현
//	4.평가
//	 제출: 학생고유폴더 -> 본인이름.zip(.jar로 빌드해서)
//	 평가: 발표 및 소스코드 제출로 대체
//	*maven 배포절차
//	1. eclips -> project -> clean
//	2. project name 에서 RunAs -> java Application
//	3. main()의 Class 선택 후 실행
//	 -정상 동작 여부 확인 후
//	4. project name에서 RunAs -> maven install
//	5. target 폴더에서 lib 및 .jar 확인
//	6. cmd창에서 실행해본다. 오류발생시 위 과정을 재반복 한다.
//	 
//	 배포
//	 : run as -> maven-clean: 지우기, maven-install: 배포까는거
//	 workspace -> 프로젝트 -> target -> .jar파일
//	 cmd창에서 java -jar test-0.0.1-SNAPSHOT.jar
//	 ->실행
//	 cmd창에서 target에 들어와있으면 clean fail 뜰 수 있음
//	 프로젝트가 많으면 충돌가능성 있음, 클로즈나 딜리트(컴퓨터 폴더에는 남아있어야함)
//	-jar와 라이브러리 압축 후 공유폴더에 업로드
//
//배포 maven build옵션
//	<build>
//	<resources>
//		<resource>
//			<directory>src/main/resources</directory>
//		</resource>
//	</resources>
//	<plugins>
//		<plugin>
//			<groupId>org.apache.maven.plugins</groupId>
//			<artifactId>maven-dependency-plugin</artifactId>
//			<executions>
//				<execution>
//					<id>copy</id>
//					<phase>install</phase>
//					<goals>
//						<goal>copy-dependencies</goal>
//					</goals>
//					<configuration>
//						<outputDirectory>${project.build.directory}/lib</outputDirectory>
//					</configuration>
//				</execution>
//			</executions>
//		</plugin>
//
//		<plugin>
//			<groupId>org.apache.maven.plugins</groupId>
//			<artifactId>maven-jar-plugin</artifactId>
//			<version>2.3.2</version>
//			<configuration>
//				<archive>
//					<manifest>
//						<mainClass>co.yeadam.test.App</mainClass>
//						<addClasspath>true</addClasspath>
//						<classpathPrefix>lib/</classpathPrefix>
//					</manifest>
//				</archive>
//			</configuration>
//		</plugin>
//	</plugins>
//</build>
//
//**mybatis-datasource
//	private static SqlSessionFactory sqlSessionFactory;
//	private DataSource() {}
//	
//	public static SqlSessionFactory getInstance() {
//		String resource = "mybatis-config.xml";
//		InputStream inputStream;
//		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return sqlSessionFactory;
//	}
//	**
//	driver = oracle.jdbc.driver.OracleDriver
//			url = jdbc:oracle:thin:@localhost:1521:xe
//			user = jiwon
//			password = 1234
}
