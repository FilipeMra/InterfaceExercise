package services;

public class PaypalService implements OnlinePaymentService {
	
	private static final double FEE = 0.02;
	private static final double INTEREST = 0.01;

	@Override
	public double interest(double amount, int months) {
		return amount * INTEREST * months;
		
	}
	
	@Override
	public double paymentFee(double amount) {
		return amount * FEE;
	}

	
	

}
