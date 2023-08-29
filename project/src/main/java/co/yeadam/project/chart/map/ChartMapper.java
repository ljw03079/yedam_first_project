package co.yeadam.project.chart.map;

import java.util.List;

import co.yeadam.project.chart.service.ChartVO;

public interface ChartMapper {
	List<ChartVO> chartSelect(ChartVO vo);
	int chartInsert(ChartVO vo);
	int chartUpdate(ChartVO vo);
	int chartDelete(ChartVO vo);
}
