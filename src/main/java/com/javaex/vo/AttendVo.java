package com.javaex.vo;

public class AttendVo {
	private int attendNo;
	private int no;
	private String entryTime;
	private String leaveTime;

	public AttendVo() {
		super();
	}

	public AttendVo(int attendNo, int no, String entryTime, String leaveTime) {
		super();
		this.attendNo = attendNo;
		this.no = no;
		this.entryTime = entryTime;
		this.leaveTime = leaveTime;
	}

	public int getAttendNo() {
		return attendNo;
	}

	public void setAttendNo(int attendNo) {
		this.attendNo = attendNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	@Override
	public String toString() {
		return "AttendVo [attendNo=" + attendNo + ", no=" + no + ", entryTime=" + entryTime + ", leaveTime=" + leaveTime
				+ "]";
	}
}
