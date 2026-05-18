package com.cooking.star.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooking.star.member.MemberDTO;
import com.cooking.star.member.RoleDTO;
import com.cooking.star.myrecipe.MyRecipeDTO;

@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	public List<MemberDTO> getMemberList()throws Exception {
        return adminMapper.getMemberList();
    }

    public List<MyRecipeDTO> getRecipeList()throws Exception {
        return adminMapper.getRecipeList();
    }

    public int getMemberCount()throws Exception {
        return adminMapper.getMemberCount();
    }
	
	public int getRecipeCount()throws Exception{
		
		return adminMapper.getRecipeCount();
	}
	
	public List<RoleDTO> getRoleList()throws Exception{
		
		return adminMapper.getRoleList();
	}
	
	public int updateMemberRole(String username, Long roleNum)throws Exception{
		
		return adminMapper.updateMemberRole(username, roleNum);
	}
    
}
