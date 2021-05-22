package com.shallwe.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shallwe.model.DateCountVO;
import com.shallwe.model.DateOptionVO;
import com.shallwe.service.DateSelect;

@Controller
public class DateController {
	
	@Autowired
	DateSelect service;
	
	Logger logger = LoggerFactory.getLogger(DateController.class);

	@RequestMapping("/plan/showCalendar.do")
	public String showCalendar() {
		return "date/masterSelectDate";
	}
	
	@RequestMapping("/plan/selectDate.do")
	public String selectDate(String plan_id, Model model) {
		List<DateOptionVO> dolist = null;
		try {
			dolist = service.selectHostDates(plan_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("hdall", dolist);
		model.addAttribute("plan_id", plan_id);
		return "date/masterdates_retrieve";
	
	}
	
	@RequestMapping("/plan/insertDate.do")
	public String insertDate(String plan_id, String dates, Model model, HttpSession session) {
		
    	String member_id = (String) session.getAttribute("memberid");
    	logger.info(plan_id + ", " + member_id + ", " + dates);
		try {
			model.addAttribute("mlist", service.updateMemberDates(plan_id, member_id, dates));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/plan/planlist.do";
	
	}
	
	@RequestMapping("/plan/fixDate.do")
	public String fixDate(String plan_id, Model model, HttpSession session) {
		DateCountVO dlist = null;
		try {
			dlist = service.selectCountNDate(plan_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		if(dlist.getCount().equals("1")) return "date/seeyounexttime";
		else {
			model.addAttribute("mdall", dlist);
			model.addAttribute("plan_id", plan_id);
			return "date/memberdates_retrieve";
		}
	
	}
	
	@RequestMapping("/plan/updateFixDate.do")
	public String updateFixDate(String plan_id, String dates, Model model) {
		try {
			service.updateFixDate(dates, plan_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/plan/planlist.do";
	
	}
	
}
