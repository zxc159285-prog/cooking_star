package com.cooking.star.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cooking.star.member.MemberDTO;
import com.cooking.star.member.RoleDTO;
import com.cooking.star.myrecipe.MyRecipeDTO;

@Mapper
public interface AdminMapper {

	
	public List<MemberDTO> getMemberList()throws Exception;
	
	public List<MyRecipeDTO>getRecipeList()throws Exception;
	
    public int getMemberCount() throws Exception;
	
    public int getRecipeCount() throws Exception;
    
    public List<RoleDTO> getRoleList() throws Exception;
    
    public int updateMemberRole(@Param("username") String username, @Param("roleNum") Long roleNum) throws Exception;
	
    
    
    
    
}
