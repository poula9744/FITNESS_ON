package com.javaex.vo;

public class GeneralVo {

	//필드
	private int no;
	private String regDate;
	private String deadline;
	private int price;
	
	private String name; 
	
	
	//생성자
	public GeneralVo() {
		super();
	}


	public GeneralVo(int no, String regDate, String deadline, int price, String name) {
		super();
		this.no = no;
		this.regDate = regDate;
		this.deadline = deadline;
		this.price = price;
		this.name = name;
	}


	//메소드 - g/s
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	//메소드 - 일반 
	@Override
	public String toString() {
		return "GeneralVo [no=" + no + ", regDate=" + regDate + ", deadline=" + deadline + ", price=" + price
				+ ", name=" + name + "]";
	}
	
	

}
