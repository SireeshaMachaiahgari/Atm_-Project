package atm_project.com;

public class OtpValidation {
	public static void otpValidation(int otp) {
		System.out.println("😍 OTP:"+otp+" 🙈🙉🙊");
		
		
		    do {
		    	System.out.println("🙏 please enter the otp , which you received to the registered mobile number");
				 int userOTP=Main.sc.nextInt();
				 if(otp==userOTP) {
			    	new PinGenerateClass().setPin();
			    	break;
			    }else {
			    	System.out.println("invalid otp");
			    }
			} while (true);
	}
}

