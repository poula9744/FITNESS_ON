package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PtService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.PageVo;
import com.javaex.vo.PtVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PtController {

	@Autowired
	private PtService ptService;

	// pt register
	@PostMapping("/api/pt/registration")
	public JsonResult ptRegistration(@RequestBody PtVo ptVo, HttpServletRequest request) {
		System.out.println("PtController.ptRegistration()");

		int no = JwtUtil.getNoFromHeader(request);
		System.out.println(no);

		ptVo.setNo(no);

		int count = ptService.exeregistration(ptVo);

		return JsonResult.success(count);
	}

	// 개인 회원 리스트
	@PostMapping("/api/pt/mymemberlist")
	public JsonResult mymemberlist(HttpServletRequest request, @RequestBody PageVo pageVo) {
		System.out.println("PtController.mymemberlist()");

		System.out.println(pageVo);

		int trainerNo = JwtUtil.getNoFromHeader(request);

		Map<String, Object> pMap = ptService.exeMyMemberList(trainerNo, pageVo.getCrtPage(), pageVo.getKeyword());
		System.out.println(pMap);
		return JsonResult.success(pMap);
	}

	// 전체 회원 리스트
	@PostMapping("/api/pt/memberlist")
	public JsonResult memberlist(@RequestBody PageVo pageVo) {
		System.out.println("PtController.memberlist()");

		System.out.println(pageVo);


		Map<String, Object> pMap = ptService.exeMemberList(pageVo.getCrtPage(), pageVo.getKeyword());
		System.out.println(pMap);
		return JsonResult.success(pMap);
	}
}
