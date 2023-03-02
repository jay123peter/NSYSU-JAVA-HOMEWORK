package myjava.homework.part1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		//ArrayList<String> list = new ArrayList<>(); = ArrayList<String> list = new ArrayList<String>();
		ArrayList<Studentinformation> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int option = 0 , number;
		
		while(true){
			
				try{
					System.out.printf("Type 1: add a student's data(student ID, student name and score)\n");
					System.out.printf("Type 2:show student's data\n");
					System.out.printf("Type 3:show all student's data\n");
					option = scan.nextInt();
				}catch(InputMismatchException e){
					System.out.printf("please input int math\n\n");
					System.exit(1);
				}
				
				switch(option){
				    
					case 1:
						// add a student's data
						int score = 0;
						String id = new String();
						String name = new String();
						Studentinformation studentinformation  = new Studentinformation();
						
						System.out.printf("add new student's data:\n");
						
						try{
							System.out.printf("student id:");
							id = scan.next();
						}catch(InputMismatchException e){
							System.out.printf("error,please input string\n\n");
							System.exit(1);
						}
						
						try{
							System.out.printf("student name:");
							name = scan.next();
						}catch(InputMismatchException e){
							System.out.printf("error,please input string\n\n");
							System.exit(1);
						}
						
						try{
							System.out.printf("score:");
							score = scan.nextInt();
						}catch(InputMismatchException e){ 
							System.out.printf("please input int math\n\n");
							System.exit(1);
						}
							
						//store student's data
						studentinformation.setData(name,id,score);
						list.add(studentinformation);
						System.out.printf("this is student %d\n\n",list.size());
						break;

					case 2:
						// show student's data
						number = 0;
					
						System.out.printf("To show which student's information:");
						
						try{
							number=scan.nextInt();
						}catch(InputMismatchException e){
							System.out.printf("please input int math");
							System.exit(1);
						}
						
						if(number > list.size()){
							System.out.printf("Data no found\n\n");
						}else{
							list.get(number-1).show_data();
							System.out.printf("This is student %d\n\n",number);
						}

						break;
						
					case 3:
						// show all student's data
						int pass = 0, fail = 0;
					
						System.out.printf("======Student's Data======\n");
						if(list.isEmpty() == true){
							System.out.printf("\tNULL\t\n");
						}else{
							for(number = 0;number<list.size();number++){
								System.out.printf("number:%d\n",number + 1);
								list.get(number).show_data();
								if(list.get(number).getScore()>=70){
									pass++;
								}else{
									fail++;
								}
								System.out.printf("\n");
							}
						
						}
						System.out.printf("=============================\n");						
						System.out.printf("pass: %d\n",pass);
						System.out.printf("no pass: %d\n\n",fail);
						
						break;
						
					case 4:
						//end of program
						System.out.printf("BYE!!\n");
						scan.close();
						System.exit(0);
						break;
						
					default:
						//INPUT Wrong Number
						System.out.printf("Wrong Number!!\n\n");
						continue;
						
				}//end switch
				
		}//end while
		
	}//end main
	
}// end class Controller