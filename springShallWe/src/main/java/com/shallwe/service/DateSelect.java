package com.shallwe.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shallwe.dao.DateDAO;
import com.shallwe.model.DateCountVO;
import com.shallwe.model.DateOptionVO;
import com.shallwe.model.DateVO;
import com.shallwe.model.MemberPlanVO;

@Service
public class DateSelect {

	@Autowired
	DateDAO dao;
	
	Logger logger = LoggerFactory.getLogger(DateSelect.class);

	public int insertMasterDate(String planid, String hostdate) {
		return dao.insertMasterDate(planid, hostdate);
	}

	public int convertArrayInsertMaDate(String planid, String hostdates) {
		String[] sphostdates = hostdates.split(",");
		int result = 0;
		for (String s : sphostdates) {
			System.out.println(s);
			result = dao.insertMasterDate(planid, s);
		}
		return result;
	}

	// 占쎈탣占쎌삏 占쎈툡占쎌뵠占쎈탵�몴占� 占쎈꽰占쎈퉸 MemberDAO占쎈퓠占쎄퐣 member_id占쏙옙 plan_id�몴占�
	// 獄쏆룇釉섓옙�궔占쎈뼄.
	public List<MemberPlanVO> selectAllMembers(String planid) throws SQLException {
		List<MemberPlanVO> list = dao.selectMemIdplanId(planid);
		if (list.size() == 0)
			throw new SQLException("planId占쏙옙 memberId�몴占� 獄쏆룇釉섓옙�궞 占쎈땾 占쎈씨占쎈뮸占쎈빍占쎈뼄.");
		return list;
	}

	public List<DateOptionVO> selectHostDates(String planid) throws SQLException {
		List<DateOptionVO> list = dao.selectHostDates(planid);
		if (list.size() == 0)
			throw new SQLException("占쎄텊筌욑옙 甕곕뗄�맄 筌뤴뫖以� error");
		return list;
	}

	public int updateMemberDates(String planid, String memberid, String memberdates) throws SQLException {
		String[] mdates = memberdates.split(",");
		int result = 0;
		for (String s : mdates) {
			String fs = s.replace("-", "/");
			logger.info(planid + ", " + memberid + ", " + fs);
			result = dao.updateMemberDates(planid, memberid, fs);
		}
		return result;
	}

	public int updateFixDate(String date, String planid) throws SQLException {
		int result = dao.updateFixDate(date, planid);
		if (result == 0)
			throw new SQLException("筌ㅼ뮇伊� 占쎈튋占쎈꺗 占쎄텊筌욎뮆占쏙옙 占쎄퐨占쎄문占쎈막 占쎈땾 占쎈씨占쎈뮸占쎈빍占쎈뼄.");
		return result;

	}

	public List<DateVO> selectAllDates(String planid) throws SQLException {
		List<DateVO> dlist = dao.selectAllDates(planid);
		if (dlist.size() == 0)
			throw new SQLException("date 筌뤴뫖以� 占쎈퓠占쎌쑎");
		return dlist;
	}

	public DateCountVO selectCountNDate(String planid) throws SQLException {
		// List<DateVO> dlist = dao.selectAllDates(planid);
		DateCountVO dc = dao.selectCountNDate(planid);
		logger.info(dc.toString());
		if (dc.getCount() == "0") {
			System.out.println("만날 운명이 아닙니다...");
		}
		return dc;
	}

}
