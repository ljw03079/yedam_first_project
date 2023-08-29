package co.yeadam.project.chart.service;

import java.util.List;

public interface ChartService {
	List<ChartVO> chartSelect(ChartVO vo);
	int chartInsert(ChartVO vo);
	int chartUpdate(ChartVO vo);
	int chartDelete(ChartVO vo);
}