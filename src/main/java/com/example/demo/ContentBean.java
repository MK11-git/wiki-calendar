package com.example.demo;

import java.io.Serializable;

public class ContentBean implements Serializable{
	  private String date;
	  private String contentname;
	  private String[] time;
	  private String hoge;


	  public ContentBean(){
	  }
	  
	  public void setDate(String date){
	    this.date = date;
	  }
	  public void setContentname(String contentname){
	    this.contentname = contentname;
	  }
	  public void setTime(String[] time){
	    this.time = time;
	  }
	  
	  public String getDate(){
	    return date;
	  }
	  public String getContentname(){
	    return contentname;
	  }
	  public String[] getTime(){
	    return time;
	  }
	  
	  
	  
	  
	  public void setHoge(String hoge){
		    this.hoge = hoge;
		  }
		  
		  public String getHoge(){
		    return hoge;
		  }
	  
	  
	  
	  

	}

