package myjava.homework;
//Represents a withdrawal ATM transaction
public class Loan extends Transaction{
	/* Fill your code here */
	private Integer amount;
	private Keypad keypad;
	
	//Construction initialization
	public Loan(int account,Screen screen,BankDatabase bankdatabase,Keypad inputkeypad){
		super(account,screen,bankdatabase);
		keypad = inputkeypad;
	}
	
	//loan the money and confirm account level
	public void execute(){
		getscreen().displayMessageLine("Your debt:"+getBankDatabase().getDebt(getAccountNumber().intValue()));
		switch(getBankDatabase().getCreditLevel(getAccountNumber().intValue())){
			case 'A':
				if(getBankDatabase().getDebt(getAccountNumber().intValue())<12000){
					getscreen().displayMessage("Your loan limit is "+(12000-getBankDatabase().getDebt(getAccountNumber().intValue()))+" How much do you want to loan:");
					amount = keypad.getInput();
					if(amount==0){
						getscreen().displayMessageLine("input error,please try again \n");
					}else if(amount<=(12000-getBankDatabase().getDebt(getAccountNumber().intValue()))){
						getscreen().displayMessageLine("Transaction Success\n");
						getBankDatabase().loan(getAccountNumber().intValue(), amount);
					}else{
						getscreen().displayMessageLine("Transaction Error, You have not much Loan Limit!\n");
					}
				}else{
					getscreen().displayMessageLine("Sorry,You can't loan any money now.Please repay your debt at our counter!\n");
				}
				break;
				
			case 'B':
				if(getBankDatabase().getDebt(getAccountNumber().intValue())<9000){
					getscreen().displayMessage("Your loan limit is "+(9000-getBankDatabase().getDebt(getAccountNumber().intValue()))+" How much do you want to loan:");
					amount = keypad.getInput();
					if(amount==0){
						getscreen().displayMessageLine("input error,please try again \n");
					}else if(amount<=(9000-getBankDatabase().getDebt(getAccountNumber().intValue()))){
						getscreen().displayMessageLine("Transaction Success\n");
						getBankDatabase().loan(getAccountNumber().intValue(), amount);
					}else{
						getscreen().displayMessageLine("Transaction Error, You have not much Loan Limit!\n");
					}
				}else{
					getscreen().displayMessageLine("Sorry,You can't loan any money now.Please repay your debt at our counter!\n");
				}
				break;
				
			case 'C':
				if(getBankDatabase().getDebt(getAccountNumber().intValue())<7000){
					getscreen().displayMessage("Your loan limit is "+(7000-getBankDatabase().getDebt(getAccountNumber().intValue()))+" How much do you want to loan:");
					amount = keypad.getInput();
					if(amount==0){
						getscreen().displayMessageLine("input error,please try again \n");
					}else if(amount<=(7000-getBankDatabase().getDebt(getAccountNumber().intValue()))){
						getscreen().displayMessageLine("Transaction Success\n");
						getBankDatabase().loan(getAccountNumber().intValue(), amount);
					}else{
						getscreen().displayMessageLine("Transaction Error, You have not much Loan Limit!\n");
					}
				}else{
					getscreen().displayMessageLine("Sorry,You can't loan any money now.Please repay your debt at our counter!\n");
				}
				break;

		}
	}
}
