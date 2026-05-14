package com.cooking.star.mycooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cooking.star.file.FileManager;

@Service
public class MyCookingService {

	@Autowired
	private MyCookingMapper myCookingMapper;
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.mycooking}")
	private String name;
	
	public List<MyCookingDTO> list()throws Exception{
		
		return myCookingMapper.list();
		
	}	
	
	
	
	
	public int create(MyCookingDTO myCookingDTO,MultipartFile [] attach)throws Exception {
		
		int result = myCookingMapper.create(myCookingDTO);
		
		if(attach == null) {
			
			return result;
		}
		for(MultipartFile f : attach) {
			
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName=fileManager.fileSave(name, f);
			
			MyCookingFIleDTO myCookingFIleDTO = new MyCookingFIleDTO();
			myCookingFIleDTO.setCookingNum(myCookingDTO.getCookingNum());
			myCookingFIleDTO.setOriName(f.getOriginalFilename());
			myCookingFIleDTO.setFileName(fileName);
			
			result= myCookingMapper.addFile(myCookingFIleDTO);
			
		}
		
		return result;
		
		
	
	}
	
	
	
}
