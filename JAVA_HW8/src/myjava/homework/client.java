package myjava.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class client {
	
	private static Socket clientsocket =null;
	private static PrintStream writer;
    private static BufferedReader reader;

	public static void clientconnect(String serveraddress,int port) {
		//building client and server connection
		try {
			clientsocket = new Socket(serveraddress,port);
			if (clientsocket != null)
            {
				writer = new PrintStream(clientsocket.getOutputStream());//client transport server message for communication
				reader = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));//client receive server message for communication
				writer.println("request");//client Connection request
				writer.flush();
            }
		} catch (IOException e) {
			System.out.println("clientsocket open error");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		String newaccount;
		int newpassword;
		String serveraddress = "127.0.0.1";	//"127.0.0.1"
		int port = 12345;	//12345
		
		while(true){
				
			
			//input connect address
			try{
				System.out.println("input your address:");
				serveraddress = scan.next(); 
			} catch(InputMismatchException e) {
				System.out.println("input address error:please input string");
				scan.close();
				System.exit(1);
			}
			
			//input connect port
			try{
				System.out.println("input your port:");
				port = scan.nextInt(); 
			} catch(InputMismatchException e) {
				System.out.println("input port error:please input int");
				scan.close();
				System.exit(1);
			}
			
			System.out.println("Connection...\n");
			clientconnect(serveraddress,port);

			System.out.println("Connection success...\n");
		
			while(true){
				
				int option = 0;
				int money = 0;
				//input option
				try{
					System.out.println("Please input your option:");
					System.out.println("(1).Add new account");
					System.out.println("(2).Sign in ");
					System.out.println("(3).Leave");
					option = scan.nextInt();
					writer.println(option);
					writer.flush();
				} catch(InputMismatchException e) {
					System.out.println("input option error : please input int");
					scan.close();
					System.exit(1);
				}
				
				switch(option){
				
					case 1:
						//input you want add account/password and check
						try{
							System.out.println("add your new account:");
							newaccount = scan.next(); 
							writer.println(newaccount);
							writer.flush();
							
							 if(reader.readLine().equals("find")){
								System.out.println("error,have the same account");
							 	break;
							 }else{
								System.out.println("add your new password:");
								newpassword = scan.nextInt(); 
								writer.println(newpassword);
								writer.flush();
							 }
							
						} catch (IOException e) {
							System.out.println("add account or password error : please input string or int");
							scan.close();
							System.exit(1);
						}
						break;
						
					case 2:
						//input you want sign in account/password
						try{
							System.out.println("input your sign in account:");
							newaccount = scan.next(); 
							writer.println(newaccount);
							writer.flush();
							System.out.println("input your sign in password:");
							newpassword = scan.nextInt(); 
							writer.println(newpassword);
							writer.flush();
						} catch(InputMismatchException e) {
							System.out.println("sign in error : please input int or string");
							scan.close();
							System.exit(1);
						}

						//check and input you money
						try {
							if(reader.readLine().equals("find")){
								System.out.println("input your money:");
								money = scan.nextInt(); 
								writer.println(money);
								writer.flush();
								System.out.println(reader.readLine());
							 }else{
								System.out.println("cann't find	the account");
								break;
							 }
						} catch (IOException e) {
							System.out.println("reader result error");
							e.printStackTrace();
							scan.close();
							System.exit(1);
						}catch (InputMismatchException e) {
							System.out.println("input  error : please input int");
							e.printStackTrace();
							scan.close();
							System.exit(1);
						}
						
				
						break;
					case 3:
						//leave
						try {
							System.out.println("bye!! bye!!");
							clientsocket.close();
							System.exit(0);
						} catch (IOException e) {
							System.out.println("close error");
							e.printStackTrace();
							System.exit(1);
						}
						break;
					
					default:
						System.out.println("input error , please input 1 2 3 number");
						continue;
						
				}//end of switch
				
			}//end of while
			
		}//end of while
		
	}//end of main

}//end of class client