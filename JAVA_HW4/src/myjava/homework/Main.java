package myjava.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Combination com;
		Permutation per;
		Scanner scan = new Scanner(System.in);
		int option = 0;
		
		while(true){
			try{
				System.out.println("Choose your Four Star Game:(1.permutation 2.Combination 3.Exit)");
				option = scan.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Wrong input, try again.");
				scan.close();
				continue;
			}catch(Exception e){
				System.out.printf("exception error\n");
				scan.close();
				System.exit(1);
			}
			
			switch(option){
				//permutation
				case 1:
					per = new Permutation();
					per.generateWinNums();
					per.generateUserNums();
					per.checkOfWin();
					break;
				//Combination
				case 2:
					com = new Combination();
					com.generateWinNums();
					com.generateUserNums();
					com.checkOfWin();
					break;
					
				//exit program
				case 3:
					System.out.println("end of program!!");
					scan.close();
					System.exit(0);
					break;
					
				//default
				default:
					System.out.println("Wrong input, try again.");
					continue;
					
			}//end of switch
			
		}//end of while
		
	}//end of main
	
}//end of class main
