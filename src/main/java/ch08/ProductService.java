package ch08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//데이터 샘플을 제공해주는 클래스
public class ProductService {
	Map<String, Product> products = new HashMap<>();
	//해쉬맵은 키랑 밸류 저장
	
	public ProductService() {
		Product p = new Product("101", "아이폰12", "애플", 1200000, "2020.12.12");
		products.put("101", p);
		
		p = new Product("102", "삼전우주폰", "삼성", 1300000, "2021.2.2");
		products.put("102", p);
		
		p = new Product("103", "엘지듀얼폰", "엘지", 1500000, "2022.3.2");
		products.put("103", p);	
	}
	
	//모든 상품의 데이터를 가져오는 메소드(select*from)
	public List<Product> findAll(){
		return new ArrayList<>(products.values());
	}
	
	// id로 원하는 상품을 가져오는 메소드(select*from where id="102")
	public Product find(String id) {
		return products.get(id);
	}
}
