package atm_project.com;

public class Bank {
	
	String accountHoldername="Sireesha";
   public static double accountNumber=123456789123L;
	long mbNumber=9876543212L;
	double totalBalance=20000;
	String ifscCode="P0000123";
	String branch="KPHB 2nd Phase";
     
	public static void checkBalance(double balance)
	{
		System.out.println("CheckBalance :"+balance);
	}
	public static void withdraw(double withdraw)
	{
	   System.out.println("Withdrawal Amount :"+withdraw);	
	}
	public static void deposit(double deposit)
	{
		System.out.println("Deposited Amount :"+deposit);
		
	}

}

	


