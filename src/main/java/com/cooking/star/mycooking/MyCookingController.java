package com.cooking.star.mycooking;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/mycooking/*")
public class MyCookingController {

	@Autowired
	private MyCookingService myCookingService;
	
	@GetMapping("create")
	public void create()throws Exception {
		
		
	}
	@PostMapping("create")
	public void create(MyCookingDTO myCookingDTO,Principal principal,@RequestParam(name="attach",required = false) MultipartFile[] attach)throws Exception{
		String username=principal.getName();
		myCookingDTO.setUsername(username);
		
		myCookingService.create(myCookingDTO,attach);
		
	}
//	@GetMapping("list")
//	public void list (Model model)throws Exception{
//		
//		List<MyCookingDTO> ar=myCookingService.list();
//		
//		model.addAttribute("list", ar);
//	}
//	
	
	
}
