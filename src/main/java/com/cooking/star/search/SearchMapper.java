package com.cooking.star.search;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchMapper {

	public int save(SearchDTO searchDTO)throws Exception;
	
	
	
}
