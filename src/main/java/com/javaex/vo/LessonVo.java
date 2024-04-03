package com.javaex.vo;

public class LessonVo {
	private int lNo;
	private int ptNo;
	private String comment;
	private String lDate;

	private int no;
	
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
	
	

	public LessonVo(int lNo, int ptNo, String comment, String lDate, int no) {
		super();
		this.lNo = lNo;
		this.ptNo = ptNo;
		this.comment = comment;
		this.lDate = lDate;
		this.no = no;
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

	@Override
	public String toString() {
		return "LessonVo [lNo=" + lNo + ", ptNo=" + ptNo + ", comment=" + comment + ", lDate=" + lDate + "]";
	}

}
