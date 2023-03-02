package myjava.homework;

import java.util.InputMismatchException;

public class ATM {
	/* Fill your code here */
	private Boolean userAuthenticate;
	private BankDatabase bankdatabase = new BankDatabase();
	private Transaction transaction; //for Polymorphism use 
	private Screen screen = new Screen();
	private Keypad keypad = new Keypad();
	
	public void run(){
		Integer account =0;
		Integer pin = 0;
		while(true){
			screen.displayMessageLine("Welcome!");
			//input you account and check account == 0

				screen.displayMessage("Please enter your account number:");
				account = keypad.getInput();
				if(account.intValue()==0){
					screen.displayMessageLine("input account error,please try again!!\n");
					continue;
				}
		
			//input you pin and check pin == 0
		
				screen.displayMessage("Please enter your pin:");
				pin = keypad.getInput();
				if(pin.intValue()==0){
					screen.displayMessageLine("input pin error,please try again!!\n");
					continue;
				}
	
			//check out you account and pin
			userAuthenticate = bankdatabase.authenticateUser(account, pin);
			if(userAuthenticate == true){
				int item = 0;
				while(item != 5){
					//choice the item
					try{
						screen.displayMessageLine("Main_nemu:");
						screen.displayMessageLine("1.View my balance");
						screen.displayMessageLine("2.Withdraw");
						screen.displayMessageLine("3.Deposit");
						screen.displayMessageLine("4.Loan");
						screen.displayMessageLine("5.Exit");
						screen.displayMessage("Enter a choice:");
						item = keypad.getInput();
					}catch(InputMismatchException e){
						screen.displayMessageLine("input error!! please input string try again\n!");
						continue;
					}
					
					
					switch(item){
						case 1:
							//View my balance //for Polymorphism use 
							transaction = new BalanceInquiry(account,screen,bankdatabase); 
							transaction.execute();
							break;
							
						case 2:
							//Withdraw money //for Polymorphism use 
							transaction = new Withdrawal(account,screen,bankdatabase,keypad);
							transaction.execute();
							break;
							
						case 3:
							//Deposit money //for Polymorphism use 
							transaction = new Deposit(account,screen,bankdatabase,keypad);
							transaction.execute();
							break;
							
						case 4:
							//Loan money //for Polymorphism use 
							transaction = new Loan(account,screen,bankdatabase,keypad);
							transaction.execute();
							break;
							
						case 5:
							//exit of account
							screen.displayMessageLine("Log out of account!!\n");
							break;
							
						default:
							//other item
							screen.displayMessageLine("Wrong input item¡Atry again.\n");
							continue;
							
					}//end of switch 
					
				}//end of second while
				
			}else{
				//print error account or error pin
				screen.displayMessageLine("input account or pin error,please try again\n");
			}
			
		}//end of first while
		
	}//end of run

}//end of class ATM
