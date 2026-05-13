package com.cooking.star.myrecipe;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.cooking.star.pager.Pager;

@Mapper
public interface MyRecipeMapper {
	public Long getCount(Pager pager);
	public int create(MyRecipeDTO myRecipeDTO);
	public List<MyRecipeDTO> allList(Pager pager);
	public MyRecipeDTO detail(MyRecipeDTO myRecipeDTO);
	public int addRecipeimg(RecipeFileDTO recipeFileDTO);
	public int update(MyRecipeDTO myRecipeDTO,MultipartFile attach);

}
