package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.TrainerService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.TrainerVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class TrainerController {

	@Autowired
	private TrainerService trainerService;

	// 로그인
	@PostMapping("/api/trainer/login")
	public JsonResult login(@RequestBody TrainerVo trainerVo, HttpServletResponse response) {
		System.out.println("TrainerController.login()");

		TrainerVo authTrainer = trainerService.exeLogin(trainerVo);
		System.out.println(authTrainer);

		if (authTrainer != null) {
			// 토큰 발급 헤더에 실어 보낸다
			JwtUtil.createTokenAndSetHeader(response, "" + authTrainer.getTrainerNo());
			return JsonResult.success(authTrainer);
		} else {
			return JsonResult.fail("로그인 실패");
		}
	}

	// 회원가입
	@PostMapping("/api/trainer/join")
	public int join(@RequestBody TrainerVo trainerVo) {
		System.out.println("TrainerController.join()");
		int count = trainerService.exeJoin(trainerVo);
		return count;
	}

	// 아이디 중복체크
	@PutMapping("/api/trainer/join") // get으로 하면 안되는데 왤까요?
	public int idCheck(@RequestBody TrainerVo trainerVo) {
		System.out.println("TrainerController.idCheck()");
		String id = trainerVo.getId();
		System.out.println(id);
		int count = trainerService.exeCheck(id);
		return count;
	}

	// 회원정보 완료: 한명 정보 가져오기
	@GetMapping("/api/trainer/join")
	public JsonResult joinOk(HttpServletRequest request) {
		System.out.println("TrainerController.joinOk()");

		int no = JwtUtil.getNoFromHeader(request);

		if (no != -1) {
			TrainerVo trainerVo = trainerService.exeModifyForm(no);
			System.out.println(trainerVo);
			return JsonResult.success(trainerVo);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 회원정보 수정폼: 한명 정보 가져오기
	@GetMapping("/api/trainer/modify")
	public JsonResult modifyform(HttpServletRequest request) {
		System.out.println("TrainerController.modifyform()");

		int no = JwtUtil.getNoFromHeader(request);

		if (no != -1) {
			TrainerVo trainerVo = trainerService.exeModifyForm(no);
			System.out.println(trainerVo);
			return JsonResult.success(trainerVo);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 수정
	@PutMapping("/api/trainer/modify")
	public JsonResult modifyUser(@RequestBody TrainerVo trainerVo, HttpServletRequest request) {
		System.out.println("TrainerController.modifyUser()");
		int no = JwtUtil.getNoFromHeader(request);
		trainerVo.setTrainerNo(no);
		System.out.println(no);
		if (no != -1) { // 정상
			trainerService.exeModify(trainerVo);
			return JsonResult.success(trainerVo.getName());
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 로그인 후 메인정보
	@GetMapping("/api/trainer/main")
	public JsonResult selectTrainerInfo(HttpServletRequest request) {
		System.out.println("TrainerController.selectTrainerInfo()");
		int no = JwtUtil.getNoFromHeader(request);
		System.out.println(no);
		if (no != -1) { // 정상
			TrainerVo trainerInfo = trainerService.exeSelectTrainerInfo(no);
			return JsonResult.success(trainerInfo);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	///////////////////////////////////////////////////////
	///              트레이너 소개                    //
	//트레이너 소개창
	@GetMapping("api/trainer/trainerintroduction")
	public JsonResult trainerintroduction() {
		System.out.println("TrainerController.trainerintroduction()");

		List<TrainerVo> TrainerList = trainerService.exeTrainerList();

		System.out.println(TrainerList);

		return JsonResult.success(TrainerList);
	}

	//트레이너 등록폼(수정폼)
	@GetMapping("api/trainer/trainerupdateinsert")
	public JsonResult trainerupdateinsertform(HttpServletRequest request) {
		System.out.println("TrainerController.trainerupdateinsertform()");

		int no = JwtUtil.getNoFromHeader(request);

		TrainerVo trainerVo = trainerService.exeTrainerinsertform(no);
		System.out.println(trainerVo);
		return JsonResult.success(trainerVo);
	}

	//트레이너 수정(등록,수정)
	@PutMapping("api/trainer/trainerupdateinsert")
	public JsonResult trainerupdateinsert(@RequestParam int trainerNo, @RequestParam String career,
			@RequestParam MultipartFile file) {
		System.out.println("TrainerController.trainerupdateinsert()");

		trainerService.exeTrainerupdateinsert(trainerNo, file, career);

		return JsonResult.success("성공");
	}

}