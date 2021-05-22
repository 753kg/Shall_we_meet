package com.shallwe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shallwe.model.DateCountVO;
import com.shallwe.model.DateOptionVO;
import com.shallwe.model.DateVO;
import com.shallwe.model.MemberPlanVO;

@Repository
public class DateDAO {

	@Autowired
	SqlSession sqlsession;
	
	Logger logger = LoggerFactory.getLogger(DateDAO.class);

	String namespace = "com.shallwe.date.";

	public List<MemberPlanVO> selectMemIdplanId(String planid) {
		return sqlsession.selectList(namespace + "selectMemIdplanId", planid);
	}

	// 방장
	// 방장의 날짜 범위를 저장한다. (servlet에서 반복시켜야 한다.)
	public int insertMasterDate(String planid, String hostdate) {
		Map<String, String> map = new HashMap<>();
		map.put("planid", planid);
		map.put("hostdate", hostdate);
		return sqlsession.insert(namespace + "insertMasterDate", map);
	}

	// 멤버
	// 멤버아이디 플랜아이디를 받아와서 dates에 날짜 삽입한다.
	public int updateMemberDates(String planid, String memberid, String memberdates) {
		logger.info(planid + ", " + memberid + ", " + memberdates);
		Map<String, String> map = new HashMap<>();
		map.put("planid", planid);
		map.put("memberid", memberid);
		map.put("memberdates", memberdates);
		return sqlsession.insert(namespace + "updateMemberDates", map);
	}

	// fix방장
	// selectAllDates로 받아온 값을 보고 한가지 date를 fix한다.
	public int updateFixDate(String date, String planid) {
		Map<String, String> map = new HashMap<>();
		map.put("planid", planid);
		map.put("date", date);
		return sqlsession.update(namespace + "updateFixDate", map);
	}

	// 방장
	// 방장이 선택한 dates들을 뿌려준다. for문반복
	public List<DateOptionVO> selectHostDates(String planid) {
		return sqlsession.selectList(namespace + "selectHostDates", planid);

	}

	// fix방장
	// dates 테이블에서 planid사용하여 date(모두) 받아오기
	public List<DateVO> selectAllDates(String planid) {
		return sqlsession.selectList(namespace + "selectAllDates", planid);

	}

	// fix방장
	// dates 테이블에서 planid사용하여 date(모두) 받아오기
	public DateCountVO selectCountNDate(String planid) {
		DateCountVO dc = sqlsession.selectOne(namespace + "selectCountNDate", planid);
		logger.info(dc.toString());
		return dc;

	}

}