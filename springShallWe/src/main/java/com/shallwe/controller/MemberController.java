package com.shallwe.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shallwe.model.MemberVO;
import com.shallwe.service.MemberServiceInterface;

@Controller
public class MemberController {
	
	@Autowired
	MemberServiceInterface service;
	
	Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping("/register.do")
	public String register() {
		return "login/register";
	}
	
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String insertMember(MemberVO member) {
		logger.info(member.toString());
		int result = service.insertMember(member);
		logger.info(result > 0 ? "회원가입성공" : "회원가입실패");
		return "redirect:/main.do";
	}
	
	@RequestMapping("/idCheck.do/{memberid}")
	@ResponseBody
	public int idCheck(@PathVariable String memberid) {
		MemberVO member = service.idChk(memberid);
		if(member == null) return 0;
		else return 1;
	}
	
	@RequestMapping(value = "/login.do")
	public String loginGet(String memberid, String memberpw, HttpSession session) {
		return "login/login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public int login(String memberid, String memberpw, HttpSession session) {
		logger.info("memberid: " + memberid + " , memberpw: " + memberpw);
		MemberVO member = service.loginChk(memberid, memberpw);
		if(member != null) {
			session.setAttribute("memberid", memberid);
			return 1;
		}
		else return 0;
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main.do";
	}
}
