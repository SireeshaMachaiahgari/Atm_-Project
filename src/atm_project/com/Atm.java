package atm_project.com;

public interface Atm {
	void withdraw(double amount);
	void deposit(double amount);
	void balanceEnquiry();
	void resetPin();
	void uPay();
	void loan();
	void checkCIBILScore();
}
