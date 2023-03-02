package myjava.homework;
//Abstract superclass Transaction represents an ATM transaction


public abstract class Transaction {
	/* Fill your code here */
	private Integer accountNumber;
	private Screen screen;
	private BankDatabase bankdatabase;

	//constructor initializes
	public Transaction(int account,Screen screen,BankDatabase bankdatabase){
		accountNumber = new Integer(account);
		this.screen = screen;
		this.bankdatabase = bankdatabase;
	}
	
	//inquiry account
	public Integer getAccountNumber(){
		return accountNumber;
	}
	
	public Screen getscreen(){
		return screen;
	}
	
	//inquiry bank database 
	public BankDatabase getBankDatabase(){
		return bankdatabase;
	}
	
	public abstract void execute();
}
