package com.javaex.vo;

public class TrainerVo {

	//필드
	private int trainerNo;
	private String id;
	private String password;
	private String name;
	private String address;
	private String gender;
	private String hp;
	private int age;
	private String career;
	private String saveName;
	private String orgName;
	private String filePath;
	private long fileSize;
	
	private int totalMember;
	private int trainerMember;
	
	//생성자
	public TrainerVo() {
		super();
	}

	public TrainerVo(int trainerNo, String id, String password, String name, String address, String gender, String hp,
			int age, String career, String saveName, String orgName, String filePath, long fileSize) {
		super();
		this.trainerNo = trainerNo;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.hp = hp;
		this.age = age;
		this.career = career;
		this.saveName = saveName;
		this.orgName = orgName;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}
	
	

	public TrainerVo(int trainerNo, String id, String password, String name, String address, String gender, String hp,
			int age, String career, String saveName, String orgName, String filePath, long fileSize, int totalMember,
			int trainerMember) {
		super();
		this.trainerNo = trainerNo;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.hp = hp;
		this.age = age;
		this.career = career;
		this.saveName = saveName;
		this.orgName = orgName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.totalMember = totalMember;
		this.trainerMember = trainerMember;
	}

	//메소드 - g/s
	public int getTrainerNo() {
		return trainerNo;
	}

	public void setTrainerNo(int trainerNo) {
		this.trainerNo = trainerNo;
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

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	

	public int getTotalMember() {
		return totalMember;
	}

	public void setTotalMember(int totalMember) {
		this.totalMember = totalMember;
	}

	public int getTrainerMember() {
		return trainerMember;
	}

	public void setTrainerMember(int trainerMember) {
		this.trainerMember = trainerMember;
	}

	//메소드 - 일반 
	@Override
	public String toString() {
		return "TrainerVo [trainerNo=" + trainerNo + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", address=" + address + ", gender=" + gender + ", hp=" + hp + ", age=" + age + ", career=" + career
				+ ", saveName=" + saveName + ", orgName=" + orgName + ", filePath=" + filePath + ", fileSize="
				+ fileSize + "]";
	}
	
	
	
}