package com.aast.Domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNumber; 
	private String boardId;
	private String memberId;
	private String memberName;
	private String writer;
	private String title;
	private String content;
	private String image;
	private int readCount;
	private int commentCount;
	private int up;
	private int down;
	private int report;
	private int hitCount;
	private int pageStartNumber;
	private int pageEndNumber;
	private Timestamp writeDate;
}
