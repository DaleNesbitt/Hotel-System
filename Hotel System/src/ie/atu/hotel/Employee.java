package ie.atu.hotel;

import java.util.Scanner;

public class Employee extends Person implements Payable {
	private Date dob, startDate;
	private double salary;
	private int employeeNum;
	final double MAXSALARY = 150000;
	private static int nextNumber = 10000;
	
	Employee(){
		super();
		this.dob = new Date();
		this.startDate = new Date();
		this.salary = 0.0;
		this.employeeNum = nextNumber++;
	}
	
	public Employee(Name name, String phoneNumber, Date dob, Date startDate, Double salary) {
		super(name, phoneNumber);
		this.dob = dob;
		this.startDate = startDate;
		this.salary = salary;
		this.employeeNum = nextNumber++;
	}
	

	@Override
	public String toString() {
		return employeeNum + " " + name + "/t€" + String.format("%.2f", salary);
	}

	@Override
	public boolean equals(Object obj) {
		Employee eObj = (Employee) obj;
		if (obj instanceof Employee)
			eObj = (Employee) obj;
		else
			return false;
		
		return this.phoneNumber == eObj.phoneNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getEmployeeNum() {
		return employeeNum;
	}
	
	@Override
	public double calculatePay(double taxPercentage) {
		double pay = salary/12;
		pay -= (pay * (taxPercentage/100));
		return 0;
	}
	
	@Override
	public double incrementSalary(double incrementAmount) {
		salary += incrementAmount;
		if (salary > MAXSALARY)
			salary = MAXSALARY;
		return salary;
	}
	
	public void read() {
		Scanner kb=new Scanner(System.in);
		
		
	super.read();
	dob.read();
	startDate.read();
	System.out.print("Salary: ");
	this.salary = kb.nextDouble();
	kb.close();
	}


}
