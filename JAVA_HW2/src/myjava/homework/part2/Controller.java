package myjava.homework.part2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String itemname = new String();
		ItemList itemlist = new ItemList();
		
		while(true){
			
			int option =0;
			
			try{
				System.out.printf("type 1:add item to List\n");
				System.out.printf("type 2:remove item form list\n");
				System.out.printf("type 3:show the list\n");
				option = scan.nextInt();
			}catch(InputMismatchException e){
				System.out.printf("please input int math\n\n");
				System.exit(1);
			}
			
			switch(option){
				 case 1:
					//add item to List
					System.out.printf("Add item name:");
					try{
						itemname = scan.next(); 
					}catch(InputMismatchException e){
							System.out.printf("please input String \n");
							System.exit(1);
					}
					itemlist.addItem(itemname);
					System.out.printf("\n");
					break;
					 
				 case 2:
					 //remove item form list
					 System.out.printf("remove item name:");
					 try{
						 itemname = scan.next();
					 }catch(InputMismatchException e){
							System.out.printf("please input String \n");
							System.exit(1);
					 }
					 itemlist.remove(itemname);
					 break;
					 
				 case 3:
					 //show the list
					 System.out.printf("show the list\n");
					 itemlist.printList();
					 break;
					 
				 case 4:
					 // end of program
					 System.out.printf("BYE!!\n");
					 scan.close();
					 System.exit(0);
					 break;
					 
				default:
					//Wrong number
					System.out.printf("Wrong number!!\n");
					System.exit(1);
					break;
					
			}//end switch
			
		}//end while

	}//end main

}//end class Controller
