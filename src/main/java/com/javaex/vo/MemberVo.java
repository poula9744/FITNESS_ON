package com.javaex.vo;

public class MemberVo {

	//필드
	private int no;
	private String id;
	private String password;
	private String name;
	private String address;
	private String gender;
	private String hp;
	private int age;
	private int lockerNo;
	private int period;
	private String approval;
	
	private int attendNo;
	private String entryTime;
	private String leaveTime;
	
	private String regDate;
	private String deadline;
	private int price;
	
	private int ptCount;
	private String trainerName;
	
	
	//생성자
	public MemberVo() {
		super();
	}

	public MemberVo(int no, String id, String password, String name, String address, String gender, String hp, int age,
			int lockerNo, int period, String approval) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.hp = hp;
		this.age = age;
		this.lockerNo = lockerNo;
		this.period = period;
		this.approval = approval;
	}
	
	

	public MemberVo(int no, String id, String password, String name, String address, String gender, String hp, int age,
			int lockerNo, int period, String approval, int attendNo, String entryTime, String leaveTime) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.hp = hp;
		this.age = age;
		this.lockerNo = lockerNo;
		this.period = period;
		this.approval = approval;
		this.attendNo = attendNo;
		this.entryTime = entryTime;
		this.leaveTime = leaveTime;
	}
	
	

	public MemberVo(int no, String id, String password, String name, String address, String gender, String hp, int age,
			int lockerNo, int period, String approval, int attendNo, String entryTime, String leaveTime, String regDate,
			String deadline, int price, int ptCount, String trainerName) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.hp = hp;
		this.age = age;
		this.lockerNo = lockerNo;
		this.period = period;
		this.approval = approval;
		this.attendNo = attendNo;
		this.entryTime = entryTime;
		this.leaveTime = leaveTime;
		this.regDate = regDate;
		this.deadline = deadline;
		this.price = price;
		this.ptCount = ptCount;
		this.trainerName = trainerName;
	}

	//메소드 - g/s
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLockerNo() {
		return lockerNo;
	}

	public void setLockerNo(int lockerNo) {
		this.lockerNo = lockerNo;
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
	
	

	public int getAttendNo() {
		return attendNo;
	}

	public void setAttendNo(int attendNo) {
		this.attendNo = attendNo;
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

	
	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public int getPtCount() {
		return ptCount;
	}

	public void setPtCount(int ptCount) {
		this.ptCount = ptCount;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//메소드 - 일반
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", address="
				+ address + ", gender=" + gender + ", hp=" + hp + ", age=" + age + ", lockerNo=" + lockerNo
				+ ", period=" + period + ", approval=" + approval + "]";
	}
	
	
	
	
	
	
	
	
}