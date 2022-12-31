package com.example.demo;

import java.sql.Date;
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
		List<All5Dto> list = dbRepository.getAll();
		model.addAttribute("DbList", list);

		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);

		return "test507.html";
	}

	@PostMapping("/")
	public String write1post(Model model) {
		List<All5Dto> list = dbRepository.getAll();
		model.addAttribute("DbList", list);
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
		return "test507.html";
	}

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
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
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
		//		dbRepository.searchBytheme(theme);
//		String themeStr = "";
//		list themeStr1 ;
//		for (int i = 0; i < theme.length; i++) {
//			if(theme[i] =="") {}
//			else {
//			themeStr1 = theme[i];
//			}
//		}
//		
//		if (theme.length < 6) {
//			for (int i = 0; i < theme.length; i++) {
//
//				themeStr = theme[i] + "　";
//			}
//			themeStr = themeStr + "を表示中";
//		}
//		if (theme.length > 5) {
//			int n = theme.length - 5;
//			themeStr = theme[0] + "　" + theme[1] + "　" + theme[2] + "　" + theme[3] + "　" + theme[4] + "...他" + n
//					+ "テーマを表示中";
//		}
//		model.addAttribute("themeStr", themeStr);

		List<All5Dto> list = dbRepository.searchBythemeall2(theme);
		model.addAttribute("DbList", list);
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
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
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
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
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
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
		List<All5Dto1> list1 = dbRepository.getAll16();
		model.addAttribute("DbList1", list1);
		//		model.addAttribute("DbList",list);

		return "test507.html";
	}

}
