package com.cooking.star.good;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class GoodResponseDTO {

	private boolean good;
	private int goodCount;
	
}
