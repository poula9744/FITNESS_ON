package com.javaex.vo;

public class LessonVo {
	private int lNo;
	private int ptNo;
	private String comment;
	private String lDate;

	private int no;
	private String ptCount;
	private String ptTotal;
	
	public LessonVo() {
		super();
	}

	public LessonVo(int lNo, int ptNo, String comment, String lDate) {
		super();
		this.lNo = lNo;
		this.ptNo = ptNo;
		this.comment = comment;
		this.lDate = lDate;
	}

	public LessonVo(int ptNo, String comment, String lDate, int no) {
		super();
		this.ptNo = ptNo;
		this.comment = comment;
		this.lDate = lDate;
		this.no = no;
	}

	public LessonVo(int lNo, int ptNo, String comment, String lDate, int no) {
		super();
		this.lNo = lNo;
		this.ptNo = ptNo;
		this.comment = comment;
		this.lDate = lDate;
		this.no = no;
	}
	
	

	public LessonVo(int lNo, int ptNo, String comment, String lDate, int no, String ptCount, String ptTotal) {
		super();
		this.lNo = lNo;
		this.ptNo = ptNo;
		this.comment = comment;
		this.lDate = lDate;
		this.no = no;
		this.ptCount = ptCount;
		this.ptTotal = ptTotal;
	}

	public int getlNo() {
		return lNo;
	}

	public void setlNo(int lNo) {
		this.lNo = lNo;
	}

	public int getPtNo() {
		return ptNo;
	}

	public void setPtNo(int ptNo) {
		this.ptNo = ptNo;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getlDate() {
		return lDate;
	}

	public void setlDate(String lDate) {
		this.lDate = lDate;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	
	public String getPtCount() {
		return ptCount;
	}

	public void setPtCount(String ptCount) {
		this.ptCount = ptCount;
	}

	public String getPtTotal() {
		return ptTotal;
	}

	public void setPtTotal(String ptTotal) {
		this.ptTotal = ptTotal;
	}

	@Override
	public String toString() {
		return "LessonVo [lNo=" + lNo + ", ptNo=" + ptNo + ", comment=" + comment + ", lDate=" + lDate + "]";
	}

}
