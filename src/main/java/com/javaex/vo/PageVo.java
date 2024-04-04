package com.javaex.vo;

public class PageVo {
	
	private int crtPage;
	private String keyword;

	public PageVo() {
		super();
	}

	public PageVo(int crtPage, String keyword) {
		super();
		this.crtPage = crtPage;
		this.keyword = keyword;
	}

	public int getCrtPage() {
		return crtPage;
	}

	public void setCrtPage(int crtPage) {
		this.crtPage = crtPage;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "PageVo [crtPage=" + crtPage + ", keyword=" + keyword + "]";
	}
}
