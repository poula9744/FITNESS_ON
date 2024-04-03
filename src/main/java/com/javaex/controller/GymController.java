package com.javaex.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GymService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.MemberVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class GymController {

	@Autowired
	private GymService gymService;

	// 일반회원권 신청확인
	@PutMapping("/api/gym/manager/{no}")
	public JsonResult approve(@PathVariable("no") int no) {
		System.out.println("ManagerController.approve()");
		int result = gymService.exeApprove(no);
		return JsonResult.success(result);
	}

	// 일반회원권 신청요청
	@PutMapping("/api/general/register")
	public JsonResult registerMembership(@RequestBody MemberVo memberVo, HttpServletRequest request) {
		System.out.println("GymController.registerMembership()");

		int no = JwtUtil.getNoFromHeader(request);

		LocalDate now = LocalDate.now();
		LocalDate deadline = now.plusDays(memberVo.getPeriod());
		String regDate = Date.valueOf(now).toString();
		String sqlDate = Date.valueOf(deadline).toString();

		memberVo.setRegDate(regDate);
		memberVo.setDeadline(sqlDate);

		memberVo.setApproval("신청");
		System.out.println(memberVo);
		if (no != -1) {
			int result = gymService.exeRegisterMembership(memberVo);
			System.out.println(result);
			return JsonResult.success(result);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 일반회원권 만료일
	@GetMapping("/api/general")
	public JsonResult membershipOverDay(HttpServletRequest request) {
		System.out.println("GymController.registerMembership()");

		int no = JwtUtil.getNoFromHeader(request);
		if (no != -1) {
			String over = gymService.exeMemberOver(no);
			System.out.println(over);
			return JsonResult.success(over);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 일반회원 운동 시작
	@PostMapping("/api/general/start")
	public JsonResult entry(HttpServletRequest request) {
		System.out.println("GymController.entry()");

		int no = JwtUtil.getNoFromHeader(request);
		if (no != -1) {
			String trainingStartTime = gymService.exeEntry(no);
			System.out.println(trainingStartTime);
			return JsonResult.success(trainingStartTime);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 일반회원 운동 종료
	@PutMapping("/api/general/end")
	public JsonResult leave(HttpServletRequest request) {
		System.out.println("GymController.entry()");

		int no = JwtUtil.getNoFromHeader(request);
		if (no != -1) {
			String trainingEndTime = gymService.exeLeave(no);
			System.out.println(trainingEndTime);
			return JsonResult.success(trainingEndTime);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

}