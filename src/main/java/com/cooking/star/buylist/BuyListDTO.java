package com.cooking.star.buylist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BuyListDTO {

	private Long buyNum; //프라이머리키
	private String username; //유저 id
	private String productName; //상품명
	private Long productPrice; //상품 개당 가격
	private Long productEa; //상품수량
	private Long buyPrice; //결제금액
}
