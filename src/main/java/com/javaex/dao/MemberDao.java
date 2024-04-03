package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MemberVo;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;

	// 로그인
	public MemberVo memberSelectByIdPw(MemberVo memberVo) {
		System.out.println("MemberDao.memberSelectByIdPw()");
		MemberVo authUser = sqlSession.selectOne("member.selectByIdPw", memberVo);
		return authUser;
	}

	// 회원가입
	public int join(MemberVo memberVo) {
		System.out.println("MemberDao.userModify()");
		int count = sqlSession.insert("member.join", memberVo);
		System.out.println(count);
		return count;
	}

	// id 중복체크
	public int check(String id) {
		System.out.println("MemberDao.userModify()");
		int count = sqlSession.selectOne("member.idCheck", id);
		System.out.println(count);
		return count;
	}

	// 로그인 후 메인화면
	public MemberVo selectMemberInfo(int no) {
		System.out.println("MemberDao.selectMemberInfo()");
		MemberVo memberInfo = sqlSession.selectOne("member.selectMemberInfo", no);
		System.out.println(memberInfo);
		return memberInfo;
	}

	// 회원정보 수정폼
	public MemberVo memberSelectOneByNo(int no) {
		System.out.println("MemberDao.memberSelectOneByNo()");
		System.out.println(no);
		MemberVo memberVo = sqlSession.selectOne("member.selectMember", no);
		System.out.println(memberVo);
		return memberVo;
	}

	// 회원정보수정
	public int memberUpdate(MemberVo memberVo) {
		System.out.println("MemberDao.memberUpdate()");
		int count = sqlSession.update("member.update", memberVo);
		System.out.println(count);
		return count;
	}
}