package com.cooking.star.mycooking;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyCookingDTO {

	private Long cookingNum;
	private String username;
	private String cookingTitle;
	private String cookingRecipe;
	private String cookingContents;
	private LocalDate cookingDate;
	
	
}
