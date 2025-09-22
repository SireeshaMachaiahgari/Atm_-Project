package atm_project.com;
import java.util.Scanner;
import java.util.Random;

public class PinGenerateClass {

    private int pinNum;
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    // Getter
    public int getPinNum() {
        return pinNum;
    }

    // Setter with validation
    public void setPinNum(int pinNum) {
        String pinNumber = Integer.toString(pinNum);
        if (pinNumber.length() == 4) {
            this.pinNum = pinNum;
        } else {
            System.out.println("❌ Invalid PIN number. Must be 4 digits.");
        }
    }

    // Method to set PIN with confirmation
    public void setPin() {
        while (true) {
            System.out.println("Set a 4-digit PIN number:");
            String value = sc.next();
            if (value.length() == 4 && value.matches("\\d{4}")) {
                int newPinNumber = Integer.parseInt(value);
                System.out.println("Confirm your PIN number:");
                String confirmValue = sc.next();
                if (confirmValue.equals(value)) {
                    setPinNum(newPinNumber);
                    System.out.println("✅ PIN generated successfully! Your PIN is: " + getPinNum());
                    break;
                } else {
                    System.out.println("❌ PIN numbers do not match. Try again.");
                }
            } else {
                System.out.println("❌ Enter a valid 4-digit number.");
            }
        }
    }

    // Generate PIN and OTP for new users
    public void pinGenerate() throws InterruptedException {
        System.out.println("Are you a new user? Press 1 for Yes, 2 for No:");
        int option = sc.nextInt();

        switch (option) {
            case 1: {
                System.out.println("Please generate your PIN number.");
                Thread.sleep(1000);

                // Set PIN
                setPin();

                // Generate 4-digit OTP
                int otp = 1000 + random.nextInt(9000);
                System.out.println("OTP sent: " + otp);

                // OTP validation
                System.out.print("Enter OTP: ");
                int enteredOtp = sc.nextInt();
                if (enteredOtp == otp) {
                    System.out.println("✅ OTP verified successfully!");
                } else {
                    System.out.println("❌ Incorrect OTP. Exiting...");
                    System.exit(0);
                }
                break;
            }
            case 2:
                System.out.println("Welcome back!");
                break;

            default:
                System.out.println("❌ Invalid choice. Exiting.");
                System.exit(0);
        }
    }
}
