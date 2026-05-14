package com.cooking.star.log;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class LogDTO {

	private Long logNum;
	private String username;
	private String logTitle;
	private LocalDate logDate;
}
