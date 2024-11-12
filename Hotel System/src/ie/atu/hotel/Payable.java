package ie.atu.hotel;

public interface Payable {
	
	abstract double calculatePay(double taxPercentage);
	abstract double incrementSalary(double incrementAmount);
}
