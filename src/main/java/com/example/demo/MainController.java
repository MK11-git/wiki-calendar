package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final DbRepository dbRepository;

	@GetMapping("/")
	public String write1(Model model) {

		List<All5Dto> list3 = dbRepository.getAll3();
		model.addAttribute("DbList3", list3);
		
		
		List<All5Dto> list = dbRepository.getAll(list3.size());
		model.addAttribute("DbList", list);

		String strnot = "";
		strnot = strnot + "theme!=''";
		List<All5Dto1> list17 = dbRepository.getAll17(strnot);
		model.addAttribute("DbList17", list17);

		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
		String[] str = new String[1];
		str[0] = "未選択";
		model.addAttribute("continents", str);

		String str3 = "気になるカレンダーを☑チェック、🖊編集してみよう!";
		model.addAttribute("str3", str3);

		String ret2 = ret2return(list, list3);

		model.addAttribute("ret2", ret2);
		

//		LocalDateTime todaydate1 = LocalDateTime.now();
//
//		String test5 = "test";
//		model.addAttribute("test5", todaydate1);

		return "test507.html";
	}
	
	
	
	
	@GetMapping("/test")
	public String write1test(Model model) {

		List<All5Dto> list3 = dbRepository.getAll3();
		model.addAttribute("DbList3", list3);
		
		
		List<All5Dtotest> list = dbRepository.getAlltest(list3.size());
		model.addAttribute("DbList", list);

		String strnot = "";
		strnot = strnot + "theme!=''";
		List<All5Dto1> list17 = dbRepository.getAll17(strnot);
		model.addAttribute("DbList17", list17);

		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
		String[] str = new String[1];
		str[0] = "未選択";
		model.addAttribute("continents", str);

		String str3 = "気になるカレンダーを☑チェック、🖊編集してみよう!";
		model.addAttribute("str3", str3);

		String ret2 = ret2returntest(list, list3);

		model.addAttribute("ret2", ret2);
		

//		LocalDateTime todaydate1 = LocalDateTime.now();
//
//		String test5 = "test";
//		model.addAttribute("test5", todaydate1);

		return "test507.html";
	}
	
	
	
	
	
	public static String ret2returntest(List<All5Dtotest> list, List<All5Dto> list3) {

		String ret2 = null;
		int num = 1;

		if (num == 1) {
			if (list3.size() == 0) {
				if (list.size() == 0) {
					ret2 = "本日以降の予定はありません。";
				} else {
					Date listdaymin = list.get(0).getDt();
					LocalDate todaydate = LocalDate.now();
					java.util.Date todayday = localDate2Date(todaydate);
					int ret = differenceDays(listdaymin, todayday);
					if (ret == 0) {
						ret2 = "▼本日!!";
					} else {
						if (ret == 1) {
							ret2 = "▼明日!";
						} else {
							ret2 = "▼あと" + ret + "日";
						}
					}
				}
			} else {
				Date test = list3.get(0).getDt();
				LocalDate todaydate = LocalDate.now();
				java.util.Date todayday = localDate2Date(todaydate);
				int ret = differenceDays(test, todayday);
				if (ret == 0) {
					ret2 = "▼本日!!";
				} else {
					if (ret == 1) {
						ret2 = "▼明日!";
					} else {
						ret2 = "▼あと" + ret + "日";
					}

				}

			}

		} else {
			ret2 = "カレンダーを選択してください";
		}

		return ret2;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public static java.util.Date localDate2Date(final LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static int differenceDays(Date date1, java.util.Date todayday) {
		long datetime1 = date1.getTime();
		long datetime2 = todayday.getTime();
		long one_date_time = 1000 * 60 * 60 * 24;
		long diffDays = (datetime1 - datetime2) / one_date_time;
		return (int) diffDays;
	}

	public static String ret2return(List<All5Dto> list, List<All5Dto> list3) {

		String ret2 = null;
		int num = 1;

		if (num == 1) {
			if (list3.size() == 0) {
				if (list.size() == 0) {
					ret2 = "本日以降の予定はありません。";
				} else {
					Date listdaymin = list.get(0).getDt();
					LocalDate todaydate = LocalDate.now();
					java.util.Date todayday = localDate2Date(todaydate);
					int ret = differenceDays(listdaymin, todayday);
					if (ret == 0) {
						ret2 = "▼本日!!";
					} else {
						if (ret == 1) {
							ret2 = "▼明日!";
						} else {
							ret2 = "▼あと" + ret + "日";
						}
					}
				}
			} else {
				Date test = list3.get(0).getDt();
				LocalDate todaydate = LocalDate.now();
				java.util.Date todayday = localDate2Date(todaydate);
				int ret = differenceDays(test, todayday);
				if (ret == 0) {
					ret2 = "▼本日!!";
				} else {
					if (ret == 1) {
						ret2 = "▼明日!";
					} else {
						ret2 = "▼あと" + ret + "日";
					}

				}

			}

		} else {
			ret2 = "カレンダーを選択してください";
		}

		return ret2;
	}

//	@PostMapping("/")
//	public String write1post(Model model) {
//		List<All5Dto> list = dbRepository.getAll();
//		model.addAttribute("DbList", list);
//		String strnot = "";
//		strnot = strnot + "theme!=''";
//		List<All5Dto1> list17 = dbRepository.getAll17(strnot);
//		model.addAttribute("DbList17", list17);
//
//		List<All5Dto1> list1 = dbRepository.getAll16();
//		model.addAttribute("DbList1", list1);
//
//		String[] str = new String[1];
//		str[0] = "未選択";
//		model.addAttribute("continents", str);
//
//		return "test507.html";
//	}

	//	@GetMapping("/555")
	//	public String write2(Model model) {
	//		return "redirect:/";
	//	}
	//	

	//削除して、そのthemeで全期間表示
	@PostMapping("/d")
	public String write509(@RequestParam int id, String theme, Model model) {
		dbRepository.deleteById(id);
		List<All5Dto> list = dbRepository.searchBythemeall(theme);
		model.addAttribute("DbList", list);

		List<All5Dto> list3 = dbRepository.searchBythemeall01(theme);
		model.addAttribute("DbList3", list3);
		List<All5Dto> list02 = dbRepository.searchBythemeall02(theme);
		model.addAttribute("DbList4", list02);

		String strnot = "";
		strnot = strnot + "theme!='" + theme + "'";
		List<All5Dto1> list17 = dbRepository.getAll17(strnot);
		model.addAttribute("DbList17", list17);

		List<All5Dto1> list16 = dbRepository.getAll16();
		model.addAttribute("DbList1", list16);
		model.addAttribute("continents", theme);
		List<String> list5 = new ArrayList<String>();
		list5.add(theme);
		model.addAttribute("DbList5", list5);

		String ret2 = ret2return(list, list3);

		model.addAttribute("ret2", ret2);

		return "test507.html";
	}

	//
	//	//theme全期間検索
	//	@GetMapping("/a")
	//	public String write510(@RequestParam String theme,Model model) {
	////		dbRepository.searchBytheme(theme);
	//		List<All5Dto> list = dbRepository.searchBythemeall(theme);
	//		model.addAttribute("DbList",list);
	//		List<All5Dto1> list1 = dbRepository.getAll16();
	//		model.addAttribute("DbList1",list1);
	//		return "test507.html";
	//	}
	//theme全期間検索
	@GetMapping("/a")
	public String write510(@RequestParam String[] theme, Model model) {

		List<All5Dto> list = dbRepository.searchBythemeall2(theme);
		model.addAttribute("DbList", list);

		List<All5Dto> list3 = dbRepository.searchBythemeall21(theme);
		model.addAttribute("DbList3", list3);

		List<All5Dto> list4 = dbRepository.searchBythemeall22(theme);
		model.addAttribute("DbList4", list4);

		String strnot = "";
		for (int i = 0; i < theme.length; i++) {
			if (i > 0) {
				strnot = strnot + " AND ";
			}
			strnot = strnot + "theme!='" + theme[i] + "'";
		}
		List<All5Dto1> list17 = dbRepository.getAll17(strnot);
		model.addAttribute("DbList17", list17);
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);

		model.addAttribute("continents", theme);

		List<String> list5 = new ArrayList<String>();
		for (int i = 0; i < theme.length; i++) {
			if (theme[i] != "") {
				list5.add(theme[i]);
			}
		}
		model.addAttribute("DbList5", list5);

		
		String ret2;
		int num = 0;
		for (int i = 0; i < theme.length; i++) {
			if (theme[i] != "") {
				num = 1;
			}
		}
		if (num == 1) {
			ret2 = ret2return(list, list3);
		} else {
			ret2 = "カレンダーを選択してください";
		}
		

		model.addAttribute("ret2", ret2);

		return "test507.html";
	}

	//複数theme検索post
	@PostMapping("/ca-1")
	public String write510_1(@RequestParam String[] theme, Model model) {
		//		dbRepository.searchBytheme(theme);
		List<All5Dto> list = dbRepository.searchBytheme1(theme);
		model.addAttribute("DbList", list);
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
		return "test507.html";
	}

	//複数theme検索get
	@GetMapping("/ca")
	public String write510_2(@RequestParam String[] theme, Model model) {
		//		dbRepository.searchBytheme(theme);
		List<All5Dto> list = dbRepository.searchBytheme1(theme);
		model.addAttribute("DbList", list);
		List<All5Dto> list3 = dbRepository.searchBytheme11(theme);
		model.addAttribute("DbList3", list3);
		String str = "";
		for (int i = 0; i < theme.length; i++) {
			if (i > 0) {
				str = str + "&";
			}
			str = str + "theme=" + theme[i];
		}

		String strnot = "";
		for (int i = 0; i < theme.length; i++) {
			if (i > 0) {
				strnot = strnot + " AND ";
			}
			strnot = strnot + "theme!='" + theme[i] + "'";
		}
		List<All5Dto1> list17 = dbRepository.getAll17(strnot);
		model.addAttribute("DbList17", list17);
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
		model.addAttribute("continents", theme);
		model.addAttribute("str", str);

		List<String> list5 = new ArrayList<String>();
		for (int i = 0; i < theme.length; i++) {
			if (theme[i] != "") {
				list5.add(theme[i]);
			}
		}
		model.addAttribute("DbList5", list5);

		String ret2;
		int num = 0;
		for (int i = 0; i < theme.length; i++) {
			if (theme[i] != "") {
				num = 1;
			}
		}
		if (num == 1) {
			ret2 = ret2return(list, list3);
		} else {
			ret2 = "カレンダーを選択してください";
		}
		model.addAttribute("ret2", ret2);

		return "test507.html";
	}

	//	//INSERT文
	//	@PostMapping("/511")
	//	public String write511(@RequestParam Date dt,Time starttime,String theme,String content,String link,Model model) {
	//		List<All5Dto> list = dbRepository.insert1(dt,starttime,theme,content,link,model);
	//		model.addAttribute("DbList",list);
	//		return "test507.html";
	//	}

	//	//INSERT文2
	//	@PostMapping("/512")
	//	public String write512(@RequestParam Date dt,Model model) {
	//		List<All5Dto> list = dbRepository.insert2(dt);
	//		model.addAttribute("DbList",list);
	//		return "test507.html";
	//	}
	//	
	////
	//	//INSERT文4 成功
	//	@PostMapping("/514")
	//	public String write514(@RequestParam Date dt,String theme,String content,String link,Model model) {
	//		dbRepository.insertById(dt,theme,content,link);
	//		List<All5Dto> list = dbRepository.getAll();
	//		model.addAttribute("DbList",list);
	//		return "test507.html";
	//	}
	//	
	//	//INSERT文
	//	@PostMapping("/515")
	//	public String write515(@RequestParam Date dt,Time starttime,Model model) {
	//		dbRepository.insertById1(dt,starttime);
	//		List<All5Dto> list = dbRepository.getAll();
	//		model.addAttribute("DbList",list);
	//		List<All5Dto1> list1 = dbRepository.getAll16();
	//		model.addAttribute("DbList1",list1);
	//		return "test507.html";
	//	}
	//	
	//	
	//	//INSERT文
	//	@PostMapping("/515-1")
	//	public String write515_1(@RequestParam Date dt,String theme,Model model) {
	//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//		String strDate = dateFormat.format(dt);
	//		
	//		dbRepository.insertById1(strDate,theme);
	//		List<All5Dto> list = dbRepository.getAll();
	//		model.addAttribute("DbList",list);
	//		List<All5Dto1> list1 = dbRepository.getAll16();
	//		model.addAttribute("DbList1",list1);
	//		return "test507.html";
	//	}
	//	

	//	//INSERT文3startなし
	//	@PostMapping("/513")
	//	public String write513_1(@RequestParam Date dt,String theme,String content,String link,Model model) {
	//		dbRepository.insert3(dt,theme,content,link);  
	//		List<All5Dto> list = dbRepository.getAll();
	//		model.addAttribute("DbList",list);
	//		List<All5Dto1> list1 = dbRepository.getAll16();
	//		model.addAttribute("DbList1",list1);
	//		return "test507.html";
	//	}
	//	@PostMapping("/513")
	//	public String write513(@RequestParam Date dt,String theme,String content,Model model) {
	//		dbRepository.insert3(dt,theme,content);  
	//		List<All5Dto> list = dbRepository.getAll();
	//		model.addAttribute("DbList",list);
	//		List<All5Dto1> list1 = dbRepository.getAll16();
	//		model.addAttribute("DbList1",list1);
	//		return "test507.html";
	//	}
	//	//INSERT文3
	//	@PostMapping("/513")
	//	public String write513(@RequestParam Date dt,Time starttime,String theme,String content,Model model) {
	//		dbRepository.insert3(dt,starttime,theme,content);  
	//		List<All5Dto> list = dbRepository.getAll();
	//		model.addAttribute("DbList",list);
	//		List<All5Dto1> list1 = dbRepository.getAll16();
	//		model.addAttribute("DbList1",list1);
	//		return "test507.html";
	//	}

	//
	//	//INSERT文3
	//	@PostMapping("/513")
	//	public String write513(@RequestParam Date dt,Time starttime,String theme,String content,String link,Model model) {
	//		dbRepository.insert3(dt,starttime,theme,content,link);  
	//		List<All5Dto> list = dbRepository.getAll();
	//		model.addAttribute("DbList",list);
	//		List<All5Dto1> list1 = dbRepository.getAll16();
	//		model.addAttribute("DbList1",list1);
	//		return "test507.html";
	//	}
	//	

	//INSERT文3
	@PostMapping("/i")
	public String write513_1(@RequestParam Date dt, String starttime, String theme, String content, String link,
			Model model) {
		//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//		String strDate = dateFormat.format(dt);
		//		String strtime = starttime +":00";
		String strtime = starttime;

		dbRepository.insert3(dt, strtime, theme, content, link);
		//		List<All5Dto> list = dbRepository.getAll();
		//		model.addAttribute("DbList", list);
		String[] theme1 = new String[1];
		theme1[0] = theme;
		List<All5Dto> list = dbRepository.searchBythemeall2(theme1);
		model.addAttribute("DbList", list);

		List<All5Dto> list3 = dbRepository.searchBythemeall21(theme1);
		model.addAttribute("DbList3", list3);

		List<All5Dto> list4 = dbRepository.searchBythemeall22(theme1);
		model.addAttribute("DbList4", list4);

		String strnot = "";
		strnot = strnot + "theme!='" + theme + "'";
		List<All5Dto1> list17 = dbRepository.getAll17(strnot);
		model.addAttribute("DbList17", list17);

		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);

		model.addAttribute("continents", theme);
		List<String> list5 = new ArrayList<String>();
		list5.add(theme);
		model.addAttribute("DbList5", list5);

		String ret2 = ret2return(list, list3);

		model.addAttribute("ret2", ret2);

		return "test507.html";
	}

	//	public String write513_1(@RequestParam Date dt,String theme,String content,String link,Model model) {
	//		dbRepository.insert3(dt,theme,content,link);  
	//		List<All5Dto> list = dbRepository.getAll();
	//		model.addAttribute("DbList",list);
	//		List<All5Dto1> list1 = dbRepository.getAll16();
	//		model.addAttribute("DbList1",list1);
	//		return "test507.html";
	//	}

	@GetMapping("/516")
	public String write16(Model model) {
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
		return "test507.html";
	}

	@GetMapping("/519")
	public String write19(Model model) {
		List<All5Dto> list = dbRepository.getAll19();
		model.addAttribute("DbList", list);

		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);

		return "test507.html";
	}

	@GetMapping("/update")
	public String write19update(@RequestParam int id, Model model) {
		List<All5Dto> list = dbRepository.searchByid(id);
		model.addAttribute("DbList", list);
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);

		return "update.html";
	}

	@PostMapping("/update1")
	public String write19update(@RequestParam int id, Date dt, String theme, String starttime, String content,
			String link, Model model) {

		String strtime = starttime; //+":00"
		//		List<All5Dto> list = dbRepository.updateByid(id,dt,strtime,content,link);
		dbRepository.update2(id, dt, strtime, content, link);
		//		List<All5Dto> list = dbRepository.getAll();
		//		model.addAttribute("DbList",list);
		List<All5Dto> list = dbRepository.searchBythemeall(theme);
		model.addAttribute("DbList", list);
		List<All5Dto> list3 = dbRepository.searchBythemeall01(theme);
		model.addAttribute("DbList3", list3);
		List<All5Dto> list02 = dbRepository.searchBythemeall02(theme);
		model.addAttribute("DbList4", list02);

		String strnot = "";
		strnot = strnot + "theme!='" + theme + "'";
		List<All5Dto1> list17 = dbRepository.getAll17(strnot);
		model.addAttribute("DbList17", list17);

		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);

		model.addAttribute("continents", theme);
		List<String> list5 = new ArrayList<String>();
		list5.add(theme);
		model.addAttribute("DbList5", list5);

		String ret2 = ret2return(list, list3);

		model.addAttribute("ret2", ret2);

		return "test507.html";
	}

	@GetMapping("/checkall")
	public String write111(Model model) {
		List<All5Dto> list = dbRepository.getAll111();
		model.addAttribute("DbList", list);

		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
		model.addAttribute("DbList17", list1);

		return "test507.html";
	}

	@GetMapping("/checkallid")
	public String write111id(Model model) {
		List<All5Dto> list = dbRepository.getAll111id();
		model.addAttribute("DbList", list);

		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
		model.addAttribute("DbList17", list1);

		return "test507.html";
	}

}
