package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		// int count = trainerDao.addPhoto(trainerVo);
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

	// 로그인 후 메인화면
	public TrainerVo exeSelectTrainerInfo(int no) {
		System.out.println("TrainerService.exeSelectTrainerInfo()");

		TrainerVo trainerVo = trainerDao.selectTrainerInfo(no);
		return trainerVo;
	}
	
	//////////////////////////////////////////////////////////////////////////
	// 트레이너소개 및 pt등록창
	public List<TrainerVo> exeTrainerList() {
		System.out.println("TrainerService.exeTrainerList()");

		List<TrainerVo> TrainerList = trainerDao.trainerList();

		return TrainerList;
	}

	// 트레이너 등록폼(수정)
	public TrainerVo exeTrainerinsertform(int no) {
		System.out.println("TrainerService.exeTrainerinsertform");

		TrainerVo trainerVo = trainerDao.trainerinsertform(no);

		return trainerVo;
	}

	// 트레이너 수정(등록,수정){
	public void exeTrainerupdateinsert(int trainerNo, MultipartFile file, String career) {
		System.out.println("TrainerService.exeTrainerupdateinsert()");

		// 파일저장 폴더
		String saveDir = "C:\\javaStudy\\upload";

		// (0)파일관련 정보수집
		// 오리지날 파일명
		String orgName = file.getOriginalFilename();
		System.out.println("orgName:" + orgName);

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println("exName:" + exName);

		// 저장 파일명(겹치지 않아야 한다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName:" + saveName);

		// 파일 사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize:" + fileSize);

		// 파일 전체 경로(저장파일명 포함)
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath:" + filePath);

		// (1)파일정보를 DB에 저장
		// *vo묶어주고

		TrainerVo trainerVo = new TrainerVo(trainerNo, saveName, orgName, filePath, fileSize, career);
		System.out.println(trainerVo);
		// *db에 저장
		System.out.println(".......DB저장완료");
		trainerDao.trainerupdateinsert(trainerVo);
		// (2)파일을 하드디스크에 저장

		// 파일 저장
		try {
			byte[] fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		;

	}

}