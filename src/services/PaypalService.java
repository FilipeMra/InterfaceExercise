package services;

public class PaypalService implements OnlinePaymentService {
	
	private static final double fee = 0.02;
	private static final double interest = 0.01;

	@Override
	public double interest(double amount, int months) {
		return amount * interest * months;
		
	}
	
	@Override
	public double paymentFee(double amount) {
		return amount * fee;
	}

	
	

}
