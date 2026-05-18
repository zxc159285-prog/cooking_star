package com.cooking.star.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cooking.star.member.MemberDTO;
import com.cooking.star.member.RoleDTO;
import com.cooking.star.myrecipe.MyRecipeDTO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@GetMapping("dashboard")
	public void dashboard(Model model)throws Exception{
		
		int memberCount=adminService.getMemberCount();
		int recipeCount=adminService.getRecipeCount();
		model.addAttribute("member", memberCount);
		model.addAttribute("recipe", recipeCount);
	}
	@GetMapping("memberList")
	public void memberList(Model model)throws Exception{
		
		List<MemberDTO> ar=adminService.getMemberList();
		List<RoleDTO> roleList=adminService.getRoleList();
		
		model.addAttribute("memberList", ar);
		model.addAttribute("roleList", roleList);
	}
	
	@PostMapping("memberRoleUpdate")
	public String memberRoleUpdate(@RequestParam("username") String username, @RequestParam("roleNum") Long roleNum)throws Exception{
		
		adminService.updateMemberRole(username, roleNum);
		
		return "redirect:/admin/memberList";
	}
	
	@GetMapping("recipeList")
	public void recipeList(Model model)throws Exception{
		List<MyRecipeDTO>ar = adminService.getRecipeList();
		
		model.addAttribute("recipeList", ar);
		
	}
	
	
	
	
	
	
}
