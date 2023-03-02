package myjava.homework;
//Represents a withdrawal ATM transaction
public class Withdrawal extends Transaction {
	/* Fill your code here */
	private Integer amount;
	private Keypad keypad;
	
	//constructor initializes
	public Withdrawal(int account,Screen screen,BankDatabase bankdatabase,Keypad inputkeypad){
		super(account,screen,bankdatabase);
		 this.keypad = inputkeypad;
	}
	
	//take the money and check
	public void execute(){
		while(true){
			getscreen().displayMessage("How much do you want to withdrawal:");
			amount = keypad.getInput();
			if(amount.intValue() <= 0){
				getscreen().displayMessageLine("you cann't input negative or zero\n");
			}else if(amount > getBankDatabase().getTotalBalance(getAccountNumber())){
				getscreen().displayMessageLine("Account money is not enough\n");
			}else{
				getscreen().displayMessageLine("Success\n");
				getBankDatabase().debit(getAccountNumber().intValue(),amount);
				break;
			}
		}
	}
}
