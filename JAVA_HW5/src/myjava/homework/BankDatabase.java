package myjava.homework;
//Represents the bank account information database
public class BankDatabase {
private Account[] accounts; // array of Accounts
	
    // no-argument BankDatabase constructor initializes accounts
	public BankDatabase () {
		accounts = new Account[3];  // just 3 accounts for testing
		accounts[0] = new Account(123, 321, 5000,'A');
		accounts[1] = new Account(456, 654, 3000,'B');
		accounts[2] = new Account(789, 987, 1000,'C');
	}
	
	/* Fill your code here */
	
	//confirm account and return your account
	public Account confirmaccount(int account){
		for(Account i : accounts){
			if(i.getAccountNumber() == account){
				return i;
			}
		}
		return null;
	}
	
	//confirm account and pin
	public Boolean authenticateUser(int account ,int pin){
		Account useraccount = confirmaccount(account);
		if(useraccount != null){
			if(useraccount.validatePIN(pin)){
				return true;
			}
		}
		return false;
	}
	
	//inquiry Total Balance
	public Integer getTotalBalance(int account){
		return confirmaccount(account).gettotalBalance();
	}
	
	//inquiry the CreditLevel
	public char getCreditLevel(int account){
		return confirmaccount(account).getcreditLevel();
	}
	
	//inquiry the debt
	public Integer getDebt(int account){
		return confirmaccount(account).getdebt();
	}
	
	//store the money
	public void credit(int userAccount,int amount){
		confirmaccount(userAccount).credit(amount);
	}
	
	//take the money
	public void debit(int userAccount,int amount){
		confirmaccount(userAccount).debit(amount);
	}
	
	//borrow the money
	public void loan(int userAccount,int amount){
		confirmaccount(userAccount).loan(amount);
	}
	
}
