
package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GymDao;
import com.javaex.vo.MemberVo;

@Service
public class GymService {

	@Autowired
	private GymDao gymDao;

	//일반회원권 승인
	public int exeApprove(int no) {
		System.out.println("GymService.exeApprove()");
		int result = gymDao.approve(no);
		return result;
	}
	

	// 일반회원권 등록
	public int exeRegisterMembership(MemberVo memberVo) {
		System.out.println("GymService.exeRegisterMembership()");
		int result = gymDao.registerMembership(memberVo);
		gymDao.registerMembership2(memberVo);
		return result;
	}

	
	// 일반회원권 만료일
	public String exeMemberOver(int no) {
		System.out.println("GymService.exeMemberOver()");
		String over = gymDao.membershipOver(no);
		return over;
	}

	// 일반회원 입장
	public String exeEntry(int no) {
		System.out.println("GymService.exeEntry()");
		gymDao.entry(no);
		String trainingStartTime = gymDao.trainingStartTime(no);
		return trainingStartTime;
	}

	// 일반회원 퇴장
	public String exeLeave(int no) {
		System.out.println("GymService.exeLeave()");
		gymDao.leave(no);
		String trainingEndTime = gymDao.trainingEndTime(no);
		return trainingEndTime;
	}

	

}
