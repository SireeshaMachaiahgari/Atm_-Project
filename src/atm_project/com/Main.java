package atm_project.com;
import java.util.Scanner;

public class Main {
	 static Scanner sc = new Scanner(System.in);
	    static PinGenerateClass pin = new PinGenerateClass();  // your existing PinGenerateClass

	    public static void main(String[] args) throws InterruptedException {
			 System.out.println("Welcome To Unique ATM , KPHB 2nd Pahse😍😍😍");
				System.out.println("Please insert your card...😎😎😎");
				 System.out.println("🙏🙏 card under processing dont remove your card🙏🙏");




	        // Step 1: PIN generation / OTP verification for new users
	        pin.pinGenerate();  // ✅ This now generates PIN and OTP without account number

	        // Step 2: Ask user to set initial balance
	        System.out.print("Set initial balance: ₹");
	        double initialBalance = sc.nextDouble();

	        // Step 3: Create ATM object using the PIN generated
	         Atm atm = new AtmClass(10000.0 , 1234);

	        // Step 4: PIN verification to access ATM
	        System.out.print("\nEnter PIN to access ATM: ");
	        int enteredPin = sc.nextInt();
	        if (enteredPin != pin.getPinNum()) {
	            System.out.println("❌ Incorrect PIN. Exiting.");
	            sc.close();
	            return;
	        }
	        for(int i=1;i<=3;i++) {
				Thread.sleep(2000);
	        }
			

	        // Step 5: ATM Menu Loop
	        int choice;
	        do {
	            System.out.println("\n======= 🏧 ATM MENU =======");
	            System.out.println("1️⃣  Withdraw");
	            System.out.println("2️⃣  Deposit");
	            System.out.println("3️⃣  Check Balance");
	            System.out.println("4️⃣  Reset PIN");
	            System.out.println("5️⃣  UPI Payment");
	            System.out.println("6️⃣  Loan Request");
	            System.out.println("7️⃣  Check CIBIL Score");
	            System.out.println("8️⃣  Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1: // Withdraw
	                    System.out.print("Enter your PIN: ");
	                    int pinCheck = sc.nextInt();
	                    if (pinCheck == pin.getPinNum()) {
	                        System.out.print("Enter amount to withdraw: ₹");
	                        double withdrawAmount = sc.nextDouble();
	                        atm.withdraw(withdrawAmount);
	                    } else {
	                        System.out.println("❌ Incorrect PIN. Cannot proceed.");
	                    }
	                    break;

	                case 2: // Deposit
	                    System.out.print("Enter amount to deposit: ₹");
	                    double depositAmount = sc.nextDouble();
	                    atm.deposit(depositAmount);
	                    break;

	                case 3: // Check Balance
	                    atm.balanceEnquiry();
	                    break;

	                case 4: // Reset PIN
	                    atm.resetPin();
	                    break;

	                case 5: // UPI Payment
	                    System.out.print("Enter your PIN: ");
	                    int pinUPI = sc.nextInt();
	                    if (pinUPI == pin.getPinNum()) {
	                        atm.uPay();
	                    } else {
	                        System.out.println("❌ Incorrect PIN. Cannot proceed.");
	                    }
	                    break;

	                case 6: // Loan Request
	                    atm.loan();
	                    break;

	                case 7: // Check CIBIL Score
	                    atm.checkCIBILScore();
	                    break;

	                case 8: // Exit
	                    System.out.println("👋 Thank you for using our ATM. Goodbye!");
	                    break;

	                default:
	                    System.out.println("❌ Invalid choice. Please select again.");
	            }

	        } while (choice != 8);

	        sc.close();
	    }
	

}
