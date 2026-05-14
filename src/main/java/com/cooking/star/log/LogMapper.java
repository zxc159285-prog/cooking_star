package com.cooking.star.log;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

	//검색기록 db에 저장
	public int insertLog(LogDTO logDTO)throws Exception;
	
	//검색순위 조회
	public List<Map<String,Object>> logRanking()throws Exception;
}
