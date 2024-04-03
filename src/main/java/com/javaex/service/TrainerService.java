package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.TrainerDao;
import com.javaex.vo.TrainerVo;

@Service
public class TrainerService {

	@Autowired
	private TrainerDao trainerDao;

	// 로그인
	public TrainerVo exeLogin(TrainerVo trainerVo) {
		System.out.println("TrainerService.exeLogin()");
		TrainerVo authUser = trainerDao.trainerSelectByIdPw(trainerVo);
		return authUser;
	}

	// 회원가입용
	public int exeJoin(TrainerVo trainerVo) {
		System.out.println("TrainerService.exeJoin()");
		int count = trainerDao.join(trainerVo);
		//int count = trainerDao.addPhoto(trainerVo);
		return count;
	}

	// id 중복체크용
	public int exeCheck(String id) {
		System.out.println("TrainerService.exeCheck()");
		int count = trainerDao.check(id);
		return count;
	}

	// 회원정보 수정폼
	public TrainerVo exeModifyForm(int no) {
		System.out.println("TrainerService.exeModifyForm()");

		TrainerVo trainerVo = trainerDao.trainerSelectOneByNo(no);
		return trainerVo;
	}

	// 회원정보 수정
	public int exeModify(TrainerVo trainerVo) {
		System.out.println("TrainerService.exeModify()");

		int count = trainerDao.trainerUpdate(trainerVo);
		return count;
	}
	
	//로그인 후 메인화면 
	public TrainerVo exeSelectTrainerInfo(int no) {
		System.out.println("TrainerService.exeSelectTrainerInfo()");

		TrainerVo trainerVo = trainerDao.selectTrainerInfo(no);
		return trainerVo;
	}
	
}