package com.cooking.star.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LogController {

	@Autowired
	private LogService logService;
	
	
}
