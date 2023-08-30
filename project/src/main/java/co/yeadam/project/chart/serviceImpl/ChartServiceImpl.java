package co.yeadam.project.chart.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yeadam.project.chart.map.ChartMapper;
import co.yeadam.project.chart.service.ChartService;
import co.yeadam.project.chart.service.ChartVO;
import co.yeadam.project.common.DataSource;

public class ChartServiceImpl implements ChartService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ChartMapper map = sqlSession.getMapper(ChartMapper.class);
	
	@Override
	public List<ChartVO> chartSelect(ChartVO vo) {
		// TODO Auto-generated method stub
		return map.chartSelect(vo);
	}

	@Override
	public int chartInsert(ChartVO vo) {
		// TODO Auto-generated method stub
		return map.chartInsert(vo);
	}

	@Override
	public int chartUpdate(ChartVO vo) {
		// TODO Auto-generated method stub
		return map.chartUpdate(vo);
	}
}
