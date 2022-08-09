package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;


public class ContractService {
	
	private OnlinePaymentService onlinePayment;
	
	
	public ContractService(OnlinePaymentService onlinePayment) {
		this.onlinePayment = onlinePayment;
		
	}
	public void processContract(Contract contract, int months) {
		
		double monthlySubTotal = contract.getTotalValue() / months;		
		
		for (int i=1; i<= months; i++) {
			LocalDate date = addMonth(contract.getDate(), i);
			double sumInterest  = monthlySubTotal + onlinePayment.interest(monthlySubTotal, i);
			double total = sumInterest + onlinePayment.paymentFee(sumInterest);
			contract.addInstallment(new Installment(date, total));		
			
		}
						
	}
	
	public LocalDate addMonth(LocalDate date, int n) {
		 return date.plusMonths(n);
		
		
	}
}
