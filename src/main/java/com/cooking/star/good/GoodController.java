package com.cooking.star.good;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cooking.star.myrecipe.MyRecipeDTO;

@Controller
@RequestMapping("/myrecipe/*")
public class GoodController {
	@Autowired
	private GoodService goodService;
	
	@PostMapping("good")
	@ResponseBody
	public GoodResponseDTO good(MyRecipeDTO myRecipeDTO, GoodDTO goodDTO, Principal principal )throws Exception{
		
		String username= principal.getName();
		
		return goodService.toggleGood(myRecipeDTO, goodDTO, username);
		
		
		
		
		
	}

}
