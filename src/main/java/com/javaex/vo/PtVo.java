package com.javaex.vo;

public class PtVo {

	//필드
	private int no;
	private int trainerNo;
	private int ptCount;
	private int ptTotal;
	private String trainingDate;
	private String comment;
	
	//생성자
	public PtVo() {
		super();
	}

	public PtVo(int no, int trainerNo, int ptCount, int ptTotal, String trainingDate, String comment) {
		super();
		this.no = no;
		this.trainerNo = trainerNo;
		this.ptCount = ptCount;
		this.ptTotal = ptTotal;
		this.trainingDate = trainingDate;
		this.comment = comment;
	}

	//메소드 - g/s
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getTrainerNo() {
		return trainerNo;
	}

	public void setTrainerNo(int trainerNo) {
		this.trainerNo = trainerNo;
	}

	public int getPtCount() {
		return ptCount;
	}

	public void setPtCount(int ptCount) {
		this.ptCount = ptCount;
	}

	public int getPtTotal() {
		return ptTotal;
	}

	public void setPtTotal(int ptTotal) {
		this.ptTotal = ptTotal;
	}

	public String getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	//메소드 - 일반
	@Override
	public String toString() {
		return "PtVo [no=" + no + ", trainerNo=" + trainerNo + ", ptCount=" + ptCount + ", ptTotal=" + ptTotal
				+ ", trainingDate=" + trainingDate + ", comment=" + comment + "]";
	}
	
	
	
	
}