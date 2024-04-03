package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.ManagerService;
import com.javaex.util.JsonResult;
import com.javaex.util.ListUtil;
import com.javaex.vo.MemberVo;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	//관리자 멤버 메인
	@PostMapping("/api/gym/manager")
	public Map<String, Object> memberList(@RequestBody ListUtil util ) {
		System.out.println("/gym/manager");
		
		System.out.println(util);
		
		Map<String, Object> map = managerService.exeList(util);
		
		return map;
	}
	
	//관리자 멤버 1명 기본
	@PostMapping("/api/gym/manager/member/{no}")
	public Map<String, Object> memberView(@PathVariable("no") int no) {
		System.out.println("member");
		
		System.out.println(no);
		
		return managerService.exeMemberView(no);
	}
	
	//관리자가 수정해주기
	@PutMapping("/api/gym/manager")
	public JsonResult modify(@RequestBody MemberVo memberVo) {
		System.out.println("MemberController.modifyMember()");
		System.out.println(memberVo);
		managerService.exeModify(memberVo);
		return JsonResult.success(memberVo);
	}
	
	
}
