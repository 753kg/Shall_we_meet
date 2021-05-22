package com.shallwe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shallwe.model.ActivityVO;
import com.shallwe.model.CafeVO;
import com.shallwe.model.RestaurantVO;
import com.shallwe.model.SafetyRestaurantVO;
import com.shallwe.service.ActivityService;


@Controller
public class ActivityController {
	
	@Autowired
	ActivityService service;
	
	Logger logger = LoggerFactory.getLogger(ActivityController.class);
	
	@RequestMapping("/plan/activitylist.do")
	public String activitylist(Model model, String location_name) {
		logger.info(location_name);
		model.addAttribute("location_name", location_name);
		return "activity/activitylist";
	}
	
	@RequestMapping("/activity/getTotalPage.do")
	@ResponseBody
	public int totalPage(Model model, String location_name, String type) {
		int displayData = 5;
		int totalData = 0;
		int totalPage = 0;
		switch (type) {
		case "r":
			totalData = service.countRestByLoc(location_name);
			totalPage = getTotalPage(totalData, displayData);
			break;
		case "c":
			totalData = service.countCafeByLoc(location_name);
			totalPage = getTotalPage(totalData, displayData);
			break;
		case "a":
			totalData = service.countActByLoc(location_name);
			totalPage = getTotalPage(totalData, displayData);
			break;
		case "s":
			totalData = service.countSafetyByLoc(location_name);
			totalPage = getTotalPage(totalData, displayData);
			break;
		default:
			break;
		}
		return totalPage;
	}

	private static int getTotalPage(int totalData, int displayData) {
		int totalPage = 0;
		totalPage = totalData / displayData;
		if(totalData % displayData > 0) totalPage++;
		return totalPage;
	}
	
	@RequestMapping("/activity/getNPage.do")
	public String getNPage(Model model, String location_name, String type, int page) {
		logger.info("getNPage>> " + location_name + ", " + type + ", " + page);
		int displayData = 5;
		int startNum = (page - 1) * displayData + 1;
		int endNum = page * displayData;
		
		String path = "";
		switch (type) {
		case "r":
			List<RestaurantVO> rlist = service.selectRestByLoc(location_name, startNum, endNum);
			model.addAttribute("rlist", rlist);
			path = "restaurant_page";
			break;
		case "c":
			List<CafeVO> clist = service.selectCafeByLoc(location_name, startNum, endNum);
			model.addAttribute("clist", clist);
			path = "cafe_page";
			break;
		case "a":
			List<ActivityVO> alist = service.selectActByLoc(location_name, startNum, endNum);
			model.addAttribute("alist", alist);
			path = "activity_page";
			break;
		case "s":
			List<SafetyRestaurantVO> slist = service.selectSafetyByLoc(location_name, startNum, endNum);
			model.addAttribute("slist", slist);
			path = "safety_page";
			break;
		default:
			break;
		}
		logger.info("activity/" + path);
		return "activity/" + path;
	}
}
