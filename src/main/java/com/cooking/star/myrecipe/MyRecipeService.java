package com.cooking.star.myrecipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cooking.star.file.FileManager;
import com.cooking.star.mycooking.MyCookingDTO;
import com.cooking.star.pager.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyRecipeService {

	@Value("${app.myrecipe}")
	private String name;

	@Autowired
	private MyRecipeMapper myRecipeMapper;

	@Autowired
	private FileManager fileManager;

	

	
	
	
	public int create(MyRecipeDTO myRecipeDTO, MultipartFile attach) throws Exception {

		int result = myRecipeMapper.create(myRecipeDTO);

		if (attach != null && !attach.isEmpty()) {
			String fileName = fileManager.fileSave(name, attach);
			RecipeFileDTO recipeFileDTO = new RecipeFileDTO();
			recipeFileDTO.setFileName(fileName);
			recipeFileDTO.setOriName(attach.getOriginalFilename());

			recipeFileDTO.setRecipeNum(myRecipeDTO.getRecipeNum());
			myRecipeMapper.addRecipeimg(recipeFileDTO);

		}
		return result;
	}
	
	public List<MyRecipeDTO> myList(Pager pager,MyRecipeDTO myRecipeDTO) throws Exception {

		
		pager.makeStartNum();

		pager.makeBlock(myRecipeMapper.getMyCount(pager,myRecipeDTO));
		
		return myRecipeMapper.myList(pager,myRecipeDTO);
	}
	

	public List<MyRecipeDTO> allList(Pager pager) throws Exception {

		pager.makeStartNum();

		pager.makeBlock(myRecipeMapper.getCount(pager));
		return myRecipeMapper.allList(pager);
	}

	public MyRecipeDTO detail(MyRecipeDTO myRecipeDTO)throws Exception{
		return myRecipeMapper.detail(myRecipeDTO);
	}
	
	public int update(MyRecipeDTO myRecipeDTO,MultipartFile attach)throws Exception{
		return myRecipeMapper.update(myRecipeDTO,attach);
	}
	
	public int updateHit(MyRecipeDTO myRecipeDTO)throws Exception{
		
		return myRecipeMapper.updateHit(myRecipeDTO);
	}
	
	@Transactional
	public int delete(MyRecipeDTO myRecipeDTO)throws Exception{
		
		//글정보와 파일정보 조회
		MyRecipeDTO detail = myRecipeMapper.detail(myRecipeDTO);
		
		// 🌟 [핵심 안전장치]: DB가 CASCADE로 날아가기 전에 파일 DTO 객체를 자바 변수에 따로 안전하게 복사해둡니다.
	    RecipeFileDTO targetFile = null;
	    if (detail != null && detail.getRecipeFileDTO() != null) {
	        targetFile = detail.getRecipeFileDTO();
	    }
	    
		//db의 recipefile테이블에서 포링키 케스케이드설정하면 db에서 파일정보도 같이지워짐
		int result=myRecipeMapper.delete(myRecipeDTO);
		
		 // 3. DB 삭제가 성공했고, 아까 따로 빼둔 파일 정보(targetFile)가 존재한다면 물리 파일 삭제!
		if (result > 0 && targetFile != null && targetFile.getFileName() != null && !targetFile.getFileName().isEmpty()) {
	        
	        // 공용 파일매니저의 원래 규칙대로 안전하게 파일명을 던집니다.
	        fileManager.fileDelete("myrecipe", targetFile);
	     
		}
	    return result;
	}
	
}
