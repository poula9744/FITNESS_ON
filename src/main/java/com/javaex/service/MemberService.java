package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.MemberDao;
import com.javaex.vo.MemberVo;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;

	// 로그인
	public MemberVo exeLogin(MemberVo memberVo) {
		System.out.println("MemberService.exeLogin()");
		MemberVo authUser = memberDao.memberSelectByIdPw(memberVo);
		return authUser;
	}

	// 회원가입
	public int exeJoin(MemberVo memberVo) {
		System.out.println("MemberService.exeJoin()");
		int count = memberDao.join(memberVo);
		return count;
	}

	// id 중복체크용
	public int exeCheck(String id) {
		System.out.println("MemberService.exeCheck()");
		int count = memberDao.check(id);
		return count;
	}

	// 로그인 후 메인화면
	public MemberVo exeMemberInfo(int no) {
		System.out.println("MemberService.exeMemberInfo()");
		MemberVo memberInfo = memberDao.selectMemberInfo(no);
		return memberInfo;
	}

	// 회원정보 수정폼
	public MemberVo exeModifyForm(int no) {
		System.out.println("MemberService.exeModifyForm()");
		System.out.println(no);
		MemberVo memberVo = memberDao.memberSelectOneByNo(no);
		return memberVo;
	}

	// 성공후 회원정보 수정
	public int exeModify(MemberVo memberVo) {
		System.out.println("MemberService.exeModify()");

		int count = memberDao.memberUpdate(memberVo);
		System.out.println(memberVo);
		return count;
	}

}