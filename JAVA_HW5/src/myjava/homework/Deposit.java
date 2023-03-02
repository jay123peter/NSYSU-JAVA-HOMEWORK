package myjava.homework;
//Represents a deposit ATM transaction

public class Deposit extends Transaction{
	
	private Integer amount;
	private Keypad keypad;
	
	/* Fill your code here */
	
	//Construction initialization
	public Deposit(int account,Screen screen,BankDatabase bankdatabase,Keypad inputkeypad) {
		super(account,screen,bankdatabase);
		keypad = inputkeypad;
	}
	
	//store money and check
	public void execute(){
		while(true){
			getscreen().displayMessage("How much do you want to deposit:");
			amount = keypad.getInput();
			if(amount.intValue() <= 0){
				getscreen().displayMessageLine("you cann't input negative or zero\n");
			}else{
				getscreen().displayMessageLine("Success\n");
				getBankDatabase().credit(getAccountNumber().intValue(), amount);
				break;
			}
		}
	}
}
