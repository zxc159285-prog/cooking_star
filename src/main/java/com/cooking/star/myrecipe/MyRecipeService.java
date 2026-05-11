package com.cooking.star.myrecipe;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooking.star.pager.Pager;
@Service
public class MyRecipeService {

	@Autowired
	private MyRecipeMapper myRecipeMapper;
	
	public int create(MyRecipeDTO myRecipeDTO) throws Exception{
		return myRecipeMapper.create(myRecipeDTO);
	}
	public List<MyRecipeDTO> list(Pager pager) throws Exception{
		
		pager.makeStartNum();
		
		pager.makeBlock(myRecipeMapper.getCount(pager));
		return myRecipeMapper.list(pager);
	}
	
}
