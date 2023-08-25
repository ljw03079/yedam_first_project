package co.yeadam.hello.product.serviceImpl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import co.yeadam.hello.product.mapper.ProductMapper;
import co.yeadam.hello.product.service.ProductService;
import co.yeadam.hello.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {
	private SqlSession sqlSession = co.yeadam.hello.common.DataSource.getInstance().openSession(true);//dao 얻어옴
	private ProductMapper map = sqlSession.getMapper(ProductMapper.class);//수행시킬 mapper 연결
	@Override
	public List<ProductVO> productSelectList() {
		// TODO Auto-generated method stub
		return map.productSelectList();
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		
		
		// TODO Auto-generated method stub
		return map.productSelect(vo);
	}

	@Override
	public int productInsert(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productInsert(vo);
	}

	@Override
	public int productDelete(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productDelete(vo);
	}

	@Override
	public int productUpdate(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productUpdate(vo);
	}

}