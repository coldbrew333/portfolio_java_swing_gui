package com.example.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookVO {
	
	private int num;
	private String name;
	private String writer;
	private String publisher;
	private String kategorie;
	private String count;
	private Timestamp regdate;
}	
	


