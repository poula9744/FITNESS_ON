package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.ManagerDao;
import com.javaex.util.ListUtil;
import com.javaex.vo.AttendVo;
import com.javaex.vo.GeneralVo;
import com.javaex.vo.LessonVo;
import com.javaex.vo.ManagerVo;
import com.javaex.vo.MemberVo;
import com.javaex.vo.PtVo;

@Service
public class ManagerService {

	@Autowired
	private ManagerDao managerDao;

	// 관리자 멤버 리스트
	public Map<String, Object> exeList(ListUtil util) {

		// 한페이지당 출력 글 개수
		int listCnt = 10;

		// 페이지당 시작할 글 번호
		int startRowNo = (util.getPage() - 1) * 10;

		// listCnt와 startRowNo, keyword를 맵으로 묶는다
		Map<String, Object> limitMap = new HashMap<String, Object>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		limitMap.put("keyword", util.getKeyword());

		List<ManagerVo> list = managerDao.list2(limitMap);
		System.out.println(list);

		// 페이지당 버튼 개수
		int pageBtnCnt = 5;

		// 전체 글개수
		int totalCnt = managerDao.totalCount(util.getKeyword());

		// 마지막 버튼 번호
		int endPageBtnNo = (int) Math.ceil(util.getPage() / (double) pageBtnCnt) * pageBtnCnt;

		// 시작 버튼 번호
		int startPageNo = (endPageBtnNo - pageBtnCnt) + 1;

		// 다음 화살표 유무
		boolean next = false;
		if (listCnt * endPageBtnNo < totalCnt) { // 한페이지당글갯수(10) * 마지막버튼번호(5) < 전체글갯수 102개
			next = true;
		} else { // 다음화살표가 false일때 마지막 버튼 번호 정확히 계산
					// 187 --> 19 ==> 187/10 올림처리 => 19
					// Math.ceil(totalCnt/listCnt) = 19
			endPageBtnNo = (int) Math.ceil(totalCnt / (double) listCnt);

		}
		System.out.println(totalCnt);
		System.out.println(endPageBtnNo);
		System.out.println(startPageNo);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCnt", totalCnt);
		map.put("endPageBtnNo", endPageBtnNo);
		map.put("startPageNo", startPageNo);

		return map;
	}

	// 관리자 멤버 정보
	public Map<String, Object> exeMemberView(int no) {

		// 서버의 멤버값
		MemberVo mv = managerDao.memberS(no);

		// 이용권 최근거
		GeneralVo gv = managerDao.generalS(no);
		System.out.println(gv);

		// pt 횟수
		PtVo pv = managerDao.ptS(no);
		System.out.println(pv);

		// 출결기록
		List<AttendVo> attendList = managerDao.attendS(no);
		System.out.println(attendList);

		// pt이용기록
		List<LessonVo> lessonList = managerDao.lessonS(no);
		System.out.println(lessonList);

		// 결제기록
		List<GeneralVo> generalList = managerDao.generalSS(no);
		System.out.println(generalList);

		Map<String, Object> memberMap = new HashMap<String, Object>();
		memberMap.put("mv", mv);
		memberMap.put("gv", gv);
		memberMap.put("pv", pv);
		memberMap.put("attendList", attendList);
		memberMap.put("generalList", generalList);
		
		memberMap.put("lessonList", lessonList);
		

		System.out.println(memberMap);

		return memberMap;
	}

	// 회원 수정
	public int exeModify(MemberVo memberVo) {

		return managerDao.modify(memberVo);
	}

}
