package ch0811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistService {

	Map<String, Regist> regists = new HashMap<>();
	//해쉬맵은 키랑 밸류 저장
	
	public RegistService() {
		Regist r = new Regist("101", "김지우", "서울시", "silver", "010-1111-1111");
		regists.put("101", r);
		
		r = new Regist("102", "홍길동", "인천시", "gold", "010-2222-2222");
		regists.put("102", r);
		
		r = new Regist("103", "율곡", "김포시", "vip", "010-3333-3333");
		regists.put("103", r);	
	}
	
	//모든 상품의 데이터를 가져오는 메소드(select*from)
	public List<Regist> findAll(){
		return new ArrayList<>(regists.values());
	}
	
	// id로 원하는 상품을 가져오는 메소드(select*from where id="102")
	public Regist find(String id) {
		return regists.get(id);
	}
}
