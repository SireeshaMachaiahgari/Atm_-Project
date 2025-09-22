package atm_project.com;
import java.util.Scanner;
public class AtmClass implements Atm {
	    private double balance;
	    private int pin;
	    private final Scanner sc = new Scanner(System.in);

	    public AtmClass(double balance,int pin) {
	       this.balance=balance;
	        this.pin=pin;
	       
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (amount <= 0) {
	            System.out.println("❌ Invalid withdrawal amount.");
	        } else if (amount > balance) {
	            System.out.println("❌ Insufficient funds. Current Balance: ₹" + balance);
	        } else {
	            balance  = amount;
	            System.out.println("✅ Withdrawn ₹" + amount + ". Remaining Balance: ₹" + balance);
	        }
	    }

		@Override
		public void deposit(double amount) {
			if (amount <= 0) {
	            System.out.println("❌ Invalid deposit amount.");
	        } else {
	            balance += amount;
	            System.out.println("✅ Deposited ₹" + amount + ". New Balance: ₹" + balance);
	        }
			
		}

		@Override
		public void balanceEnquiry() {
	        System.out.println("💰 Current Balance: ₹" + balance);

			
		}

		@Override
		public void resetPin() {
			System.out.print("Enter your current PIN: ");
	        int currentPin = sc.nextInt();
	        if (currentPin == pin) {
	            System.out.print("Enter new 4-digit PIN: ");
	            int newPin = sc.nextInt();
	            if (String.valueOf(newPin).length() == 4) {
	                pin = newPin;
	                System.out.println("🔑 PIN reset successfully!");
	            } else {
	                System.out.println("❌ Invalid PIN. Must be 4 digits.");
	            }
	        } else {
	            System.out.println("❌ Incorrect PIN. Cannot reset.");
	        }
			
		}

		@Override
		public void uPay() {
			System.out.print("Enter UPI amount to transfer: ₹");
	        double amount = sc.nextDouble();
	        if (amount > 0 && amount <= balance) {
	            withdraw(amount);
	            System.out.println("📲 UPI Payment processed successfully.");
	        } else {
	            System.out.println("❌ UPI payment failed. Invalid amount or insufficient balance.");
	        }
			
		}

		@Override
		public void loan() {
			System.out.print("Enter loan amount required: ₹");
	        double loanAmount = sc.nextDouble();
	        System.out.println("📄 Loan request for ₹" + loanAmount + " submitted. Bank will contact you.");
	    }
			
		

		@Override
		public void checkCIBILScore() {
			 int cibilScore = 650 + (int) (Math.random() * 200); // Random score for demo
		        System.out.println("📊 Your current CIBIL score is: " + cibilScore);
		    }
			
		}

	    // ... (other methods: deposit, balanceEnquiry, resetPin, uPay, loan, checkCIBILScore)
	