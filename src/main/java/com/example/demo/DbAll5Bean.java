package com.example.demo;

import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DbAll5Bean {
	private int id;
    private Date dt;
    private Time starttime;
//    String stshort =  starttime.toString() ;
//    stshort = stshort.substring(0, stshort.length()-3);
    private String theme;
    private String content;
    private String link;

}
