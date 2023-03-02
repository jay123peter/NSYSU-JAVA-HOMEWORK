package myjava.homework;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class fourStarGame {
	private ArrayList<Integer> userNums= new ArrayList<>();
	private ArrayList<Integer> winNums = new ArrayList<>();
	 
	public void fourtStarGame(){
		userNums = new ArrayList<>();
		winNums = new ArrayList<>();
	}

	public void generateUserNums(){
		int inputerror=0;
		String str;
		
		while(true){
			//store input line
			Scanner scan = new Scanner(System.in);
			try{
				System.out.printf("Input four user numbers:");
				str = scan.nextLine();
			}catch(Exception e){
				System.out.printf("Wrong input, try again\n");
				scan.close();
				continue;
			}
			//Delimiter line and store in userNums
			try{
				//add number and check number <10
				scan = new Scanner(str);
				while(scan.hasNextInt()){
					int num = scan.nextInt();
					if(num < 10){
						this.userNums.add(num);
						//System.out.println(num + "**"); //for error
					}else{
						System.out.printf("Wrong number, please input number<10\n");
						inputerror = 1;
						break;
					}
				}
			
				//check input whether 4 sets of numbers
				if(userNums.size() != 4 && inputerror == 0){
					 System.out.printf("please input 4 sets of numbers\n");
					 inputerror = 1;
				}
				
				//check input ok or error
				if(inputerror==1){
					inputerror = 0;
					userNums.clear();
					scan.close();
					continue;
				}
				break;
				
			}catch(InputMismatchException e){
				System.out.printf("Wrong input, try again\n");
				scan.close();
				continue;
			}catch(Exception e){
				System.out.printf("exception error\n");
				scan.close();
				System.exit(1);
			}
		}
	}
	
	public void generateWinNums(){
		//add and check WinNums
		int ran =0;
		Random randoms = new Random();
		for(int num=0; num<4; num++){
			while(true){
				ran = randoms.nextInt(10); 
				if(winNums.indexOf(ran) == -1){ //Check whether there is the same
					if(winNums.add(ran) == false){ //check add success or failure
						num--;
						continue;
					}
					break;
				}
			}
		}
		//print Win numbers
		System.out.printf("Win numbers:");
		for(int num=0; num<4; num++){
			System.out.printf("%d  ",winNums.get(num));
		}
		System.out.printf("\n");
	}
	
	public ArrayList<Integer> getUserNums(){
		return userNums;
	}
	
	public ArrayList<Integer> getWinNums(){
		return winNums;
	}
}
