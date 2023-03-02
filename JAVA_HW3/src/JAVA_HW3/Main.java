package JAVA_HW3;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String studentname = new String();
		Student_list list =new Student_list();
		Student_info info;
		int option = 0, studentid = 0, removenumber =0;

		while(true){

			try{
				
				System.out.printf("<1> Add one student to the list.\n");
				System.out.printf("<2> Remove one student form the list.\n");
				System.out.printf("<3> Display the student list.\n");
				System.out.printf("<4> Exit.\n");
				System.out.printf("Input:");
				option = scan.nextInt();

			}catch(InputMismatchException e){
				System.out.printf("[Error] Wrong Input\n");
				System.out.printf("[Error] try again\n\n");
				scan.next();
				continue;
			}
			
			switch(option){
				case 1:
					//Add one student to the list
					try{
						System.out.printf("Student's name:");
						studentname = scan.next();
					}catch(Exception e){
						System.out.printf("input error\n");
						System.exit(1);
					}
					
					try{
						System.out.printf("Student's ID:");
						studentid = scan.nextInt();
					}catch(InputMismatchException e){
						System.out.printf("input error\n");
						System.exit(1);
					}
					// store info
					info =new Student_info(studentname,studentid);
					list.add(info);
					// or list.add(new Student_info(studentname,studentid));
					break;
				
				case 2:
					//Remove one student form the list
					try{
						System.out.printf("Remove from <1>name <2>id\n");
						System.out.printf("Input:");
						removenumber = scan.nextInt();
					}catch(InputMismatchException e){
						System.out.printf("input error\n");
						System.exit(1);
					}
					int remove = 3;
					if(removenumber == 1 || removenumber == 2 ){
						//select Remove from <1>name <2>id
				
						if(removenumber == 1){
							System.out.printf("Student's name:");
							studentname = scan.next();
							remove = list.remove(studentname);							System.out.println(remove);
							if(remove == 0){
								System.out.printf("%s is not in the list\n",studentname);
							}else{
								System.out.printf("%s is remove\n",studentname);
							}
							System.out.println();
						}else{
							System.out.printf("Student's ID:");
							studentid = scan.nextInt();
							remove = list.remove(studentid);
							if(remove == 0){
								System.out.printf("%d is not in the list\n",studentid);
							}else{
								System.out.printf("id:%d is remove\n",studentid);
							}
							System.out.println();
						}
					}else{
						//input not 1 or 2
						System.out.printf("please input 1 or 2\n");
						System.exit(1);
					}
					break;
				
				case 3:
					//Display the student list
					list.display();
					break;
				
				case 4:
					//end of program
					System.out.printf("BYE!!\n");
					scan.close();
					System.exit(0);
					break;
				
				default:
					//input wrong number
					System.out.printf("Worng Number!!\n\n");
					continue;
			}//end switch
			
		}//end while
		
	}//end main

}//end class Main
