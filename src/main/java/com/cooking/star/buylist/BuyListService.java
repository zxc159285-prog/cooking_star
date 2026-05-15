package com.cooking.star.buylist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cooking.star.cart.CartDTO;
import com.cooking.star.cart.CartMapper;

@Service
public class BuyListService {
	
	@Autowired
	private BuyListMapper buyListMapper;
	
	@Autowired 
	private CartMapper cartMapper;
	
	

	@Transactional
	public int setBuyList(BuyListDTO buyListDTO) throws Exception{
		String username=buyListDTO.getUsername();
		CartDTO cartDTO = new CartDTO();
		cartDTO.setUsername(username);
		
		
		List<CartDTO> ar = cartMapper.list(cartDTO);
	
		int result=0;
		
		if (ar != null && !ar.isEmpty()) {
			for(CartDTO cart : ar) {
				BuyListDTO buy=new BuyListDTO();
				buy.setUsername(username);
				buy.setProductName(cart.getProductName());
	            buy.setProductPrice(cart.getProductPrice());
	            buy.setProductEa(cart.getProductEa());
	            
	         // 총 결제 금액 계산
	            buy.setBuyPrice(cart.getProductPrice() * cart.getProductEa());
	            
	            //몇개 저장했는지 알기위해 += 를 사용 저장될때마다 1+1+1+1 이런식으로 저장됨
	            result += buyListMapper.setBuyList(buy);
			}
			cartMapper.buyDelete(cartDTO);
		}
		
		return result;
	}

	public List<BuyListDTO> getBuyList(BuyListDTO buyListDTO) throws Exception{
		return buyListMapper.getBuyList(buyListDTO);
	}

}
