package com.cooking.star.buylist;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyListMapper {

	public int setBuyList(BuyListDTO buyListDTO)throws Exception;
	
	public List<BuyListDTO> getBuyList(BuyListDTO buyListDTO)throws Exception;
}
