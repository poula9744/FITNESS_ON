package com.javaex.vo;

public class ManagerVo {
	private int no;
	private String name;
	private String hp;
	private int period;
	private String approval;
	private String deadline;
	private int lockerNo;
	private String tName; // 트레이너 이름
	private int ptTotal;
	private int ptCount;

	public ManagerVo() {
		super();
	}

	public ManagerVo(int no, String name, String hp, int period, String approval, String deadline, int lockerNo,
			String tName, int ptTotal, int ptCount) {
		super();
		this.no = no;
		this.name = name;
		this.hp = hp;
		this.period = period;
		this.approval = approval;
		this.deadline = deadline;
		this.lockerNo = lockerNo;
		this.tName = tName;
		this.ptTotal = ptTotal;
		this.ptCount = ptCount;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public int getLockerNo() {
		return lockerNo;
	}

	public void setLockerNo(int lockerNo) {
		this.lockerNo = lockerNo;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public int getPtTotal() {
		return ptTotal;
	}

	public void setPtTotal(int ptTotal) {
		this.ptTotal = ptTotal;
	}

	public int getPtCount() {
		return ptCount;
	}

	public void setPtCount(int ptCount) {
		this.ptCount = ptCount;
	}

	@Override
	public String toString() {
		return "ManagerVo1 [no=" + no + ", name=" + name + ", hp=" + hp + ", period=" + period + ", approval="
				+ approval + ", deadline=" + deadline + ", lockerNo=" + lockerNo + ", tName=" + tName + ", ptTotal="
				+ ptTotal + ", ptCount=" + ptCount + "]";
	}
}
