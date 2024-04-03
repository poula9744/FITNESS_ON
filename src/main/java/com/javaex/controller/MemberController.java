package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.MemberService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.MemberVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 로그인
	@PostMapping("/api/member/login")
	public JsonResult login(@RequestBody MemberVo memberVo, HttpServletResponse response) {
		System.out.println("MemberController.login()");

		MemberVo authUser = memberService.exeLogin(memberVo);
		System.out.println(authUser);

		if (authUser != null) {
			// 토큰 발급 헤더에 실어 보낸다
			JwtUtil.createTokenAndSetHeader(response, "" + authUser.getNo());
			return JsonResult.success(authUser);
		} else {
			return JsonResult.fail("로그인 실패");
		}
	}

	// 회원가입
	@PostMapping("/api/member/join")
	public int join(@RequestBody MemberVo memberVo) {
		System.out.println("MemberController.join()");
		int count = memberService.exeJoin(memberVo);
		return count;
	}

	// 아이디 중복체크
	@PutMapping("/api/member/join")
	public int idCheck(@RequestBody MemberVo memberVo) {
		System.out.println("MemberController.idCheck()");
		System.out.println(memberVo);
		String id = memberVo.getId();
		System.out.println(id);
		int count = memberService.exeCheck(id);
		return count;
	}

	// 로그인 후 메인화면
	@GetMapping("/api/member/main")
	public JsonResult selectMemberInfo(HttpServletRequest request) {
		System.out.println("MemberController.selectMemberInfo()");

		int no = JwtUtil.getNoFromHeader(request);
		System.out.println(no);
		if (no != -1) {
			MemberVo memberInfo = memberService.exeMemberInfo(no);
			System.out.println(memberInfo);
			return JsonResult.success(memberInfo);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 수정폼(1명 데이터 가져오기)
	@GetMapping(value = "/api/member/modify")
	public JsonResult modifyform(HttpServletRequest request) {
		System.out.println("MemberController.modifyform()");

		// JWT 토큰에서 no 값을 추출
		int no = JwtUtil.getNoFromHeader(request);
		System.out.println(no);

		// 토큰을 사용하여 사용자 인증 및 회원 정보 가져오기
		MemberVo memberVo = memberService.exeModifyForm(no);

		return JsonResult.success(memberVo);

	}

	// 회원정보 수정
	@PutMapping("/api/member/modify")
	public JsonResult modifyMember(@RequestBody MemberVo memberVo, HttpServletRequest request) {
		System.out.println("MemberController.modifyMember()");

		// JWT 토큰에서 no 값을 추출
		int no = JwtUtil.getNoFromHeader(request);
		memberVo.setNo(no);
		if (no != -1) { // 정상
			memberService.exeModify(memberVo);
			return JsonResult.success(memberVo);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

}