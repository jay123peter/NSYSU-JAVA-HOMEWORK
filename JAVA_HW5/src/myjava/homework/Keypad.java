package myjava.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Keypad {
	
	private BufferedReader br;
	
	// initializes 
	public Keypad () {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/*
	 *  This function may throw some Exception if the user enters non-integer input.
	 *  You must use try...catch to deal with it.
	 */

	public Integer getInput(){
		/* Fill your code here */
		Integer number = null;
		String inputstring = new String();
		boolean error = false;
		
		try {
			inputstring = br.readLine();
			char[] chararray = inputstring.toCharArray();
			//check negative
			if(chararray[0]=='-'){
				System.out.println("you cann't type negative number!!");
				error = true;
			}else{
				//check array whether have ABC
				for(int i=0;i<chararray.length;i++){
					if(!Character.isDigit(chararray[i])){
						System.out.println("you cann't type char!! in the "+i+"("+chararray[i]+") order");
						error = true;
					}
				}
			}
		} catch (Exception e) {
			error = true;
		}
		
		//check error flag and return
		if(error == false){
			return number = new Integer(inputstring);
		}else{
			return number = new Integer(0);
		}
		
	}
	
}

