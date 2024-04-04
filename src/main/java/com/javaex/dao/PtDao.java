package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PtVo;

@Repository
public class PtDao {

	@Autowired
	private SqlSession sqlSession;

	public int registration(PtVo ptVo) {
		System.out.println("PtDao.registration()");

		int count = sqlSession.insert("pt.insert", ptVo);

		return count;
	}

	// 리스트(검색O,페이징 O)
	public List<PtVo> memberList(Map<String, Object> limiMap) {
		System.out.println("PtDao.memberList");

		List<PtVo> ptList = sqlSession.selectList("pt.selectlist", limiMap);

		System.out.println(ptList);

		return ptList;
	}

	// 글 전체 갯수 //리스트(검색O,페이징O)
	public int selectmemberTotalCnt(String keyword) {
		System.out.println("PtDao.selectmemberTotalCnt()");

		int totalCount = sqlSession.selectOne("pt.selectMemberTotalCnt", keyword);

		return totalCount;
	}

	// 리스트(검색O,페이징 O)
	public List<PtVo> memberList2(Map<String, Object> limiMap) {
		System.out.println("PtDao.memberList");

		List<PtVo> ptList = sqlSession.selectList("pt.selectlistAll", limiMap);

		System.out.println(ptList);

		return ptList;
	}

}
