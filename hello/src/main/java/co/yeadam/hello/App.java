package co.yeadam.hello;

import java.util.ArrayList;
import java.util.List;

import co.yeadam.hello.product.menu.ProductManager;
import co.yeadam.hello.product.service.ProductService;
import co.yeadam.hello.product.service.ProductVO;
import co.yeadam.hello.product.serviceImpl.ProductServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ProductService dao = new ProductServiceImpl();
//        List<ProductVO> products = new ArrayList<ProductVO>();
//        
//        products = dao.productSelectList();
//        
//        for(ProductVO v : products) {
//        	v.toString();
//        }
    	ProductManager menu = new ProductManager();
    	menu.run();
    }
}
