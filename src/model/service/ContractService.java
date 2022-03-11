package model.service;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		
		double parcela = contract.getTotalValue() / months;
		
		for(int i = 1; i <= months; i++) {
			
			double interest = parcela + onlinePaymentService.interest(parcela, i);
			double amount = interest + onlinePaymentService.paymentFee(interest);
		
			Date dueDate = dueDate(contract.getDate(), i);
			
			contract.getList().add(new Installment(dueDate, amount));
		
		}
		
	}
	
	public Date dueDate(Date date, int a) {
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);
		cal.add(Calendar.MONTH, a);
		return cal.getTime();
	}
	
}
