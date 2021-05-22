package com.shallwe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shallwe.model.HotplaceVO;
import com.shallwe.model.MemberPlanVO;
import com.shallwe.service.HotplaceService;
import com.shallwe.service.MemberPlanService;
import com.shallwe.service.PlanServiceInterface;


@Controller
public class MapController {
	
	@Autowired
	PlanServiceInterface ps;
	
	@Autowired
	MemberPlanService mps;
	
	@Autowired
	HotplaceService hps;
	
	Logger logger = LoggerFactory.getLogger(MapController.class);
	
	@RequestMapping("/plan/showMap.do")
	public String showMap() {
		return "plan/locationRetrieveBySearch";
	}
	
	/*
	@RequestMapping("/plan/selectDeparture.do/{planid}")
	public String selectDepartureGet(Model model, @PathVariable String planid) {
		model.addAttribute("plan_id", planid);
		return "plan/SelectLocationByMember";
	}
	*/
	@RequestMapping("/plan/departure.do")
	public String selectDepartureGet(String plan_id, Model model) {
		model.addAttribute("plan_id", plan_id);
		return "plan/SelectLocationByMember";
	}
	
	@RequestMapping(value = "/plan/departure.do", method = RequestMethod.POST)
	public String selectDeparturePost(MemberPlanVO mpvo) {
		mps.updateMemberLocation(mpvo);
		logger.info(mpvo.toString());
		return "redirect:/plan/planlist.do";
	}
	
	@RequestMapping("/plan/midpoint.do")
	public String calculateMidpoint(HttpSession session, String plan_id, Model model) {
		String memberid = (String) session.getAttribute("memberid");
		
		String[] hotplace3 = mps.informMiddlePlace(plan_id);
		
		List<HotplaceVO> hotlist = new ArrayList<>();
		for(String hotplace:hotplace3) {
			HotplaceVO hotplaceVO = hps.selectHotplaceLocationByName(hotplace);
			hotlist.add(hotplaceVO);
		}
		
		String[] distances = mps.calculateMemberDistance(mps.selectMemberLocation(plan_id, memberid),hotlist);
		
		model.addAttribute("plan_id", plan_id);
		model.addAttribute("hotplaceList", hotlist);
		model.addAttribute("distances", distances);
		
		
		return "plan/retrieveActivityMain";
	}
	
	@RequestMapping("/plan/confirmHotplace.do")
	public String confirmHotplace(String plan_id, String hotplace_name, Model model) {
		ps.updateHotplace(plan_id, hotplace_name);
		model.addAttribute("plan_id", plan_id);
		return "redirect:/plan/midpoint.do";
	}
}
