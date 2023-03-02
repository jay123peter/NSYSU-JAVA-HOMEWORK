package myjava.homework;
//Represents a balance inquiry ATM transaction

public class BalanceInquiry extends Transaction {
	/* Fill your code here */
	
	//Construction initialization
	public BalanceInquiry(int account,Screen screen,BankDatabase bankdatabase){
		super(account,screen,bankdatabase);
	}
	
	public void execute(){
		getscreen().displayMessageLine("Balance Information");
		getscreen().displayMessageLine("Total Balance:"+getBankDatabase().getTotalBalance(getAccountNumber().intValue())+"\n");
	}
}
