package myjava.homework;
//Represents a bank account

public class Account {
	/* Fill your code here */
	private Integer accountNumber;
	private Integer pin;
	private Integer totalBalance;
	private Integer debt;
	private char creditLevel;

	//Construction initialization
	public Account(int account, int pin, int money, char creditlevel) {
		accountNumber = new Integer(account);
		this.pin = new Integer(pin);
		totalBalance = new Integer(money);
		creditLevel = creditlevel;
		debt = new Integer(0);
	}
	
	//confirm pin
	public Boolean validatePIN(int inputpin){
		if(this.pin.equals(inputpin)){
			return true;
		}else{
			return false;
		}
	}
	
	//inquiry account
	public Integer getAccountNumber(){
		return accountNumber;
	}
	
	//inquiry  total balance
	public Integer gettotalBalance(){
		return totalBalance;
	}
	
	//inquiry creditLevel
	public char getcreditLevel(){
		return creditLevel;
	}
	
	//inquiry debt
	public Integer getdebt(){
		return debt;
	}
	
	//store the money
	public void credit(int credit){
		totalBalance = totalBalance + credit; 
	}
	
	//take the money
	public void debit(int debit){
		totalBalance = totalBalance - debit;
	}
	
	//borrow the money
	public void loan(int loan){
		debt = debt +loan;
	}
	
	
}
