package org.project;

public class MoneyDto {
	private int custNo;
	private String custName;
	private String grade;
	private int price;
	
	public MoneyDto(int custNo, String custName, String grade, int price) {
		super();
		this.custNo = custNo;
		this.custName = custName;
		this.grade = grade;
		this.price = price;
	}

	public int getCustNo() {
		return custNo;
	}

	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
