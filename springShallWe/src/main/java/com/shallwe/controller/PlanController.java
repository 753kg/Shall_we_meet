package com.shallwe.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shallwe.model.MakePlanVO;
import com.shallwe.model.PlanVO;
import com.shallwe.service.PlanServiceInterface;

@Controller
public class PlanController {
	
	@Autowired
	PlanServiceInterface service;

	Logger logger = LoggerFactory.getLogger(PlanController.class);
	
	@RequestMapping("/plan/planlist.do")
	public String retrievePlan(HttpSession session, Model model) {
		String memberid = (String) session.getAttribute("memberid");
		logger.info("session에 저장된 memberid: " + memberid);
		if(memberid == null) return "redirect:/login.do";
		else{
			List<PlanVO> planlist = service.selectPlanByMemberId(memberid);
			model.addAttribute("planlist", planlist);
			return "plan/retrievePlan";
		}
	}
	
	@RequestMapping("/plan/makeplan.do")
	public String makePlanForm() {
		return "plan/makePlan";
	}
	
	@RequestMapping(value = "/plan/makeplan.do", method = RequestMethod.POST)
	public String makePlan(MakePlanVO mpvo, HttpServletRequest request) {
		List<String> friendlist = new ArrayList<>();
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			if(name.substring(0, 1).equals("f")) {
				String value = request.getParameter(name);
				friendlist.add(value);
			}
		}
		mpvo.setFriendlist(friendlist);
		logger.info(mpvo.toString());
		service.makePlan(mpvo);
		
		return "redirect:/plan/planlist.do";
	}
}
