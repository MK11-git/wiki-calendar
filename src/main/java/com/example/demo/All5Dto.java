package com.example.demo;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class All5Dto {

//    public All5Dto(int id, Date dt, Time starttime, String string, String string2, String string3) {
//		// TODO 自動生成されたコンストラクター・スタブ
//	} 
	private int id;
    private Date dt;
    private String starttime;
    private String theme;
    private String content;
    private String link;
	
	
	
}
