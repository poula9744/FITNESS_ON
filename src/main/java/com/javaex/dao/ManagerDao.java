package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.AttendVo;
import com.javaex.vo.GeneralVo;
import com.javaex.vo.LessonVo;
import com.javaex.vo.ManagerVo;
import com.javaex.vo.MemberVo;
import com.javaex.vo.PtVo;

@Repository
public class ManagerDao {
	@Autowired
	private SqlSession sqlSession;

	// 관리자 멤버 리스트
	public List<ManagerVo> list1() {

		List<ManagerVo> memberList = sqlSession.selectList("manager.membermainlist");

		System.out.println(memberList);

		return memberList;
	}

	// 10개까지
	public List<ManagerVo> list2(Map<String, Object> limitMap) {
		System.out.println(limitMap);
		List<ManagerVo> memberList2 = sqlSession.selectList("manager.membermainlist2", limitMap);
		System.out.println(memberList2);

		return memberList2;
	}

	// 페이지계산
	public int totalCount(String keyword) {

		return sqlSession.selectOne("manager.total", keyword);

	}

	// 서버의 멤버값
	public MemberVo memberS(int no) {

		MemberVo mv = sqlSession.selectOne("manager.memberS", no);
		System.out.println(mv);
		return mv;
	}

	// 이용권 최근거
	public GeneralVo generalS(int no) {
		System.out.println("generalS");
		GeneralVo gv= sqlSession.selectOne("manager.generalS", no);
		System.out.println(gv);
		return gv;
	}

	// pt횟수
	public PtVo ptS(int no) {
		System.out.println("ptS");
		PtVo ptVo = sqlSession.selectOne("manager.ptS", no);
		System.out.println(ptVo);
		return ptVo;
	}

	// 출결기록
	public List<AttendVo> attendS(int no) {
		System.out.println("attendS");
		List<AttendVo> aList = sqlSession.selectList("manager.attendS", no);
		System.out.println(aList);
		return aList;
	}

	// pt이용기록
	public List<LessonVo> lessonS(int no) {
		System.out.println("lessonS");
		List<LessonVo> lVo = sqlSession.selectList("manager.lessonS", no);
		System.out.println(lVo);
		return lVo;
	}

	// 결제기록
	public List<GeneralVo> generalSS(int no) {
		System.out.println("generalSS");
		List<GeneralVo> gVo = sqlSession.selectList("manager.generalSS", no);
		System.out.println(gVo);
		return gVo;
	}
	
	//회원수정
	public int modify(MemberVo memberVo) {
		return sqlSession.update("manager.modify", memberVo);
	}
}
