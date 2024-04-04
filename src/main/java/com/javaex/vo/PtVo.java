package com.javaex.vo;

public class PtVo {

	//필드
	private int ptNo;
	private int no;
	private int trainerNo;
	private int ptCount;
	private int ptTotal;
	private String membername;
	private String trainername;
	
	//생성자
	public PtVo() {
		super();
	}

	public PtVo(int ptNo, int no, int trainerNo, int ptCount, int ptTotal, String membername, String trainername) {
		super();
		this.ptNo = ptNo;
		this.no = no;
		this.trainerNo = trainerNo;
		this.ptCount = ptCount;
		this.ptTotal = ptTotal;
		this.membername = membername;
		this.trainername = trainername;
	}

	public int getPtNo() {
		return ptNo;
	}

	public void setPtNo(int ptNo) {
		this.ptNo = ptNo;
	}

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

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getTrainername() {
		return trainername;
	}

	public void setTrainername(String trainername) {
		this.trainername = trainername;
	}

	@Override
	public String toString() {
		return "PtVo [ptNo=" + ptNo + ", no=" + no + ", trainerNo=" + trainerNo + ", ptCount=" + ptCount + ", ptTotal="
				+ ptTotal + ", membername=" + membername + ", trainername=" + trainername + "]";
	}
	
	
	
	
}