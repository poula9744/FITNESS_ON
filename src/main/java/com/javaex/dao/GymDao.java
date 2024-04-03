package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MemberVo;

@Repository
public class GymDao {

	@Autowired
	private SqlSession sqlSession;

	//일반회원권 승인
	public int approve(int no) {
		System.out.println("GymDao.registerMembership()");
		int result = sqlSession.insert("gym.approve", no);
		return result;
	}
	
	
	// 일반회원권 등록1
	public int registerMembership(MemberVo memberVo) {
		System.out.println("GymDao.registerMembership()");
		int result = sqlSession.insert("gym.registerMembership", memberVo);
		return result;
	}
	
	//일반회원권 등록 2: 수정
	public int registerMembership2(MemberVo memberVo) {
		System.out.println("GymDao.registerMembership2()");
		int result = sqlSession.update("gym.registerMembership2", memberVo);
		return result;
	}

	// 일반회원권 만료일
	public String membershipOver(int no) {
		System.out.println("GymDao.membershipOver()");
		String over = sqlSession.selectOne("gym.membershipOver", no);
		return over;
	}

	// 일반회원 입장
	public int entry(int no) {
		System.out.println("GymDao.entry()");
		System.out.println(no);
		int count = sqlSession.update("gym.entry", no);
		return count;
	}

	// 일반회원 운동 시작시
	public String trainingStartTime(int no) {
		System.out.println("GymDao.trainingStartTime()");
		System.out.println(no);
		String trainingStartTime = sqlSession.selectOne("gym.trainingStartTime", no);
		System.out.println(trainingStartTime);
		return trainingStartTime;
	}

	// 일반회원 퇴장
	public int leave(int no) {
		System.out.println("GymDao.leave()");
		System.out.println(no);
		int count = sqlSession.update("gym.leave", no);
		return count;
	}

	// 일반회원 운동 종료시
	public String trainingEndTime(int no) {
		System.out.println("GymDao.trainingEndTime()");
		System.out.println(no);
		String trainingEndTime = sqlSession.selectOne("gym.trainingEndTime", no);
		System.out.println(trainingEndTime);
		return trainingEndTime;
	}
}