package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		System.out.println("Enter Contract Data: ");
		System.out.print("Number: ");
		int n = sc.nextInt();
		System.out.print("Date(dd/mm/yyyy): ");
		String dateString = sc.next();
		LocalDate date = LocalDate.parse(dateString, fmt);
		System.out.print("Contract Value: ");
		double value = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int i = sc.nextInt();
		
		Contract contract = new Contract(n, date, value);
		ContractService contractService = new ContractService(new PaypalService());	
		
		contractService.processContract(contract, i);
		
		for (Installment ins : contract.getInstallment()) {
			System.out.println(ins);
		}
		
		
		sc.close();

	}

}
