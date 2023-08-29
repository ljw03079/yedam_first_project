package co.yeadam.project.employee.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yeadam.project.common.DataSource;
import co.yeadam.project.employee.map.EmployeeMapper;
import co.yeadam.project.employee.service.EmployeeService;
import co.yeadam.project.employee.service.EmployeeVO;

public class EmployeeServiceImpl implements EmployeeService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private EmployeeMapper map = sqlSession.getMapper(EmployeeMapper.class);
	
	@Override
	public List<EmployeeVO> employeeSelectList() {
		// TODO Auto-generated method stub
		return map.employeeSelectList();
	}

	@Override
	public EmployeeVO employeeSelect(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.employeeSelect(vo);
	}

	@Override
	public EmployeeVO employeeSelectName(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.employeeSelectName(vo);
	}
	
	@Override
	public int employeeInsert(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.employeeInsert(vo);
	}

	@Override
	public int employeeUpdate(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.employeeUpdate(vo);
	}

	@Override
	public int employeeDelete(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.employeeDelete(vo);
	}
}
