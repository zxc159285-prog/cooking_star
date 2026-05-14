package com.cooking.star.log;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
	
	@Autowired
	private LogMapper logMapper;

	// 검색기록 저장
	public int insertLog(LogDTO logDTO) throws Exception {
		//비로그인상태면 db에 저장안함
		if(logDTO.getUsername() ==null || logDTO.getUsername().isEmpty()) {
			return 0;
		}
		return logMapper.insertLog(logDTO);
	}

	// 검색순위 조회
	public List<Map<String, Object>> logRanking() throws Exception {
		return logMapper.logRanking();
	}

}
