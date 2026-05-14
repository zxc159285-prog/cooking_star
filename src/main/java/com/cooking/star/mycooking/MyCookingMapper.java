package com.cooking.star.mycooking;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cooking.star.pager.Pager;

@Mapper
public interface MyCookingMapper {

	
	public int create(MyCookingDTO myCookingDTO)throws Exception;
	
	public List<MyCookingDTO>list()throws Exception;
	
	public int update(MyCookingDTO myCookingDTO)throws Exception;
	
	public int delete(MyCookingDTO myCookingDTO)throws Exception;
	
	public int addFile(MyCookingFIleDTO myCookingFIleDTO) throws Exception;
	
	
	
}
