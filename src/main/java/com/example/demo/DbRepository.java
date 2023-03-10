package com.example.demo;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class DbRepository {
	private final JdbcTemplate jdbcTemplate;

	public List<All5Dto> getAll(int list3size) {
//        long miliseconds = System.currentTimeMillis();
//        Date date = new Date(miliseconds);
		int num ;
        if(list3size >30) {
        	num = 0;
        }else {
        	num = 30 - list3size;
        }
//        TIME_FORMAT(starttime, '%H:%i')
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 WHERE dt > ADDTIME(now(),'177:00:00') ORDER BY dt ASC,starttime ASC LIMIT "+num; //,dt,starttime,theme,content,link
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),    //null , 
//					(SimpleDateFormat) db5.get("starttime"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list;
	}
	
	
	
	
	
	
	
	public List<All5Dtotest> getAlltest(int list3size) {
//      long miliseconds = System.currentTimeMillis();
//      Date date = new Date(miliseconds);
		int num ;
      if(list3size >30) {
      	num = 0;
      }else {
      	num = 30 - list3size;
      }
//      TIME_FORMAT(starttime, '%H:%i')
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 WHERE dt > ADDTIME(now(),'177:00:00') ORDER BY dt ASC,starttime ASC LIMIT "+num; //,dt,starttime,theme,content,link
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dtotest> list = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list.add(new All5Dtotest(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	public List<All5Dto> getAll111() {
//      long miliseconds = System.currentTimeMillis();
//      Date date = new Date(miliseconds);
      
      
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 ORDER BY dt ASC,starttime ASC"; //,dt,starttime,theme,content,link
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),    //null , 
//					(SimpleDateFormat) db5.get("starttime"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list;
	}
	public List<All5Dto> getAll111id() {
//      long miliseconds = System.currentTimeMillis();
//      Date date = new Date(miliseconds);
      
      
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 ORDER BY id DESC"; //,dt,starttime,theme,content,link
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),    //null , 
//					(SimpleDateFormat) db5.get("starttime"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list;
	}
	
	
	
	
	
	public List<All5Dto> getAll3() {
//      long miliseconds = System.currentTimeMillis();
//      Date date = new Date(miliseconds);
      
      
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 WHERE (dt >= SUBTIME(now(), '15:00:00') and dt <= ADDTIME(now(),'177:00:00')) ORDER BY dt ASC,starttime ASC LIMIT 40"; //,dt,starttime,theme,content,link
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list3 = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list3.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),    //null , 
//					(SimpleDateFormat) db5.get("starttime"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list3;
	}
	
	
	
	public List<All5Dto1> getAll16() {
		String sql1 = "select distinct(theme) from all5 ORDER BY theme ASC";
		List<Map<String, Object>> dbList1 = jdbcTemplate.queryForList(sql1);
		List<All5Dto1> list1 = new ArrayList<>();
		for (Map<String, Object> db5 : dbList1) {
			list1.add(new All5Dto1(
					(String) db5.get("theme")
					));
		}
		return list1;
	}
	
	public List<All5Dto1> getAll17(String strnot) {
		String sql1 = "select distinct(theme) from all5 WHERE " + strnot +" ORDER BY theme ASC";
		List<Map<String, Object>> dbList1 = jdbcTemplate.queryForList(sql1);
		List<All5Dto1> list1 = new ArrayList<>();
		for (Map<String, Object> db5 : dbList1) {
			list1.add(new All5Dto1(
					(String) db5.get("theme")
					));
		}
		return list1;
	}
	
	
	
	public List<All5Dto> getAll19() {
        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 WHERE dt >= SUBTIME(now(), '15:00:00') ORDER BY dt ASC"; 
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),    //null , 
//					(SimpleDateFormat) db5.get("starttime"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list;
	}
	
	
	
	

	//??????????????????/509??????????????????
	
	public int deleteById(int id) {
	    return jdbcTemplate.update("DELETE FROM all5 WHERE id=?", id);
	  }
	
	
	
	
	
	
	
	

//	//????????????
	public List<All5Dto> searchBythemeall(String theme) {
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 where theme='" + theme +"' AND dt > ADDTIME(now(),'177:00:00') ORDER BY dt ASC,starttime ASC"; 
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list;
	
	}
	
	public List<All5Dto> searchBythemeall01(String theme) {
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 where theme='" + theme +"' AND (dt >= SUBTIME(now(), '15:00:00') and dt <= ADDTIME(now(),'177:00:00')) ORDER BY dt ASC,starttime ASC"; 
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list01 = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list01.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list01;
	
	}
	
	
	public List<All5Dto> searchBythemeall02(String theme) {
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 where theme='" + theme +"' AND dt < SUBTIME(now(), '15:00:00') ORDER BY dt ASC,starttime ASC"; 
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list02 = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list02.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list02;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	//???????????????theme???
	public List<All5Dto> searchBytheme1(String[] theme) {
		String str = "";
		for(int i = 0; i < theme.length; i++)
		{
			if(i > 0) {
				str = str + " or ";
			}
		    str = str + "theme='"+theme[i] +"'";
		}
//        long miliseconds = System.currentTimeMillis();
//        Date date = new Date(miliseconds);
		
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 where (" + str +") AND dt > ADDTIME(now(),'177:00:00') ORDER BY dt ASC,starttime ASC LIMIT 30";
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list;
	
	}
	
//	//???????????????theme???list3?????????
	public List<All5Dto> searchBytheme11(String[] theme) {
		String str = "";
		for(int i = 0; i < theme.length; i++)
		{
			if(i > 0) {
				str = str + " or ";
			}
		    str = str + "theme='"+theme[i] +"'";
		}
//        long miliseconds = System.currentTimeMillis();
//        Date date = new Date(miliseconds);
		
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 where (" + str +") AND (dt >= SUBTIME(now(), '15:00:00') and dt <= ADDTIME(now(),'177:00:00')) ORDER BY dt ASC,starttime ASC LIMIT 30"; 
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list3 = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list3.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list3;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	//???????????????theme???
	public List<All5Dto> searchBythemeall2(String[] theme) {
		String str = "";
		for(int i = 0; i < theme.length; i++)
		{
			if(i > 0) {
				str = str + " or ";
			}
		    str = str + "theme='"+theme[i] +"'";
		}
		
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 where (" + str +") AND  dt > ADDTIME(now(),'177:00:00') ORDER BY dt ASC,starttime ASC"; 
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list;
	
	}	
//	//???????????????theme???
	public List<All5Dto> searchBythemeall21(String[] theme) {
		String str = "";
		for(int i = 0; i < theme.length; i++)
		{
			if(i > 0) {
				str = str + " or ";
			}
		    str = str + "theme='"+theme[i] +"'";
		}
		
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 where (" + str +") AND (dt >= SUBTIME(now(), '15:00:00') and dt <= ADDTIME(now(),'177:00:00')) ORDER BY dt ASC,starttime ASC"; 
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list3 = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list3.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list3;
	
	}	
//	//???????????????theme???
	public List<All5Dto> searchBythemeall22(String[] theme) {
		String str = "";
		for(int i = 0; i < theme.length; i++)
		{
			if(i > 0) {
				str = str + " or ";
			}
		    str = str + "theme='"+theme[i] +"'";
		}
		
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 where (" + str +") AND dt < SUBTIME(now(), '15:00:00') ORDER BY dt ASC,starttime ASC"; 
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list4 = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list4.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list4;
	
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//????????????id????????????
	public List<All5Dto> searchByid(int id) {
		String sql = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 where id=" + id ; 
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		List<All5Dto> list = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list;
	
	}
	
//	//UPDATE?????????id????????????
	public List<All5Dto> updateByid(int id,Date dt,String strtime,String content,String link) {
		String sql = "UPDATE all5 SET dt='"+ dt +"',starttime='" + strtime + "',content='" + content + "',link='" + link +"' WHERE id=" + id  ; 
//		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql);
		jdbcTemplate.queryForList(sql);
        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
		String sql1 = "select id,dt,TIME_FORMAT(starttime, '%H:%i'),theme,content,link from all5 WHERE dt >= SUBTIME(now(), '15:00:00') ORDER BY dt ASC"; 
		List<Map<String, Object>> dbList = jdbcTemplate.queryForList(sql1);
		List<All5Dto> list = new ArrayList<>();
		for (Map<String, Object> db5 : dbList) {
			list.add(new All5Dto(
					(int) db5.get("id"),
					(Date) db5.get("dt"),
					(String) db5.get("TIME_FORMAT(starttime, '%H:%i')"),
					(String) db5.get("theme"),
					(String) db5.get("content"),
					(String) db5.get("link")
					));
		}
		return list;
	
	}
	
	
	
	
	
	
	//INSERT3
//	
//    private DataSource dataSource = null;
//
//    public void insert3(Date dt) {  //DbAll5Bean 
////        final String sql = "insert into person(first_name, family_name) values(?, ?)";
////        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
////        jt.update(sql, new Object[]{person.getFirstName(),
////                                    person.getFamilyName()});
//        final String sql = "insert into all5(dt) values(?)";
//        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
//        jt.update(sql, new Object[]{dt});
//    }
    
//    
//	public int insertById(Date dt,String theme,String content,String link) {
//	    return jdbcTemplate.update("insert into all5(dt,theme,content,link) values(?,?,?,?)",dt,theme,content,link);
//	  }
	
	public int insertById1(Date dt,Time starttime) {
	    return jdbcTemplate.update("insert into all5(dt,starttime) values(?,?)",dt,starttime);
	  }
	
	public int insertById1(String strDate,String theme) {
	    return jdbcTemplate.update("insert into all5(dt,theme) values(?,?)",strDate,theme);
	  }
	
	public int insert3(Date dt,Time starttime,String theme,String content,String link) {
	    return jdbcTemplate.update("insert into all5(dt,starttime,theme,content,link) values(?,?,?,?,?)",dt,starttime,theme,content,link);
	  }
	public int insert3(String strDate,Time starttime,String theme,String content,String link) {
	    return jdbcTemplate.update("insert into all5(dt,starttime,theme,content,link) values(?,?,?,?,?)",strDate,starttime,theme,content,link);
	  }
	
	public int insert3(Date dt,String theme,String content,String link) {
	    return jdbcTemplate.update("insert into all5(dt,theme,content,link) values(?,?,?,?)",dt,theme,content,link);
	  }
	
	//Time????????????
	public int insert3(Date dt,String strtime,String theme,String content,String link) {
	    return jdbcTemplate.update("insert into all5(dt,starttime,theme,content,link) values(?,?,?,?,?)",dt,strtime,theme,content,link);
	  }
	
	//UPDATE??????jdbcTemplate?????????
	public int update2(int id,Date dt,String strtime,String content,String link) {
	    String sql = ""
	            + "UPDATE all5 SET "
	                + "dt = ? ,starttime = ? ,content = ? ,link = ? "
	            + "WHERE" + " id = ?;";
		
	    return jdbcTemplate.update(
	    		sql
	    		,dt
	    		,strtime
	    		,content
	    		,link
	    		,id);
	  }
	
	
	
//	//Time????????????
//	public int insert3(Date dt,String strtime,String theme,String content) {
//	    return jdbcTemplate.update("insert into all5(dt,starttime,theme,content,link) values(?,?,?,?)",dt,strtime,theme,content);
//	  }

//	
//	public int insert3(Date dt,Time starttime,String theme,String content) {
//	    return jdbcTemplate.update("insert into all5(dt,starttime,theme,content) values(?,?,?,?)",dt,starttime,theme,content);
//	  }	
//
//	public int insert3(Date dt,String theme,String content) {
//	    return jdbcTemplate.update("insert into all5(dt,theme,content) values(?,?,?)",dt,theme,content);
//	  }
//	
	
	
	
	
	
}