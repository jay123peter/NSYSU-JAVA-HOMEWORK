package myjava.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Client {

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
			System.out.println("Connection failure...\n");
			System.out.println("Because:clientsocket open error");
			e.printStackTrace();
			System.exit(1);
		}
	}//end of clientconnect
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		String serveraddress = "127.0.0.1";		//"127.0.0.1"
		int port = 12345;						//12345
			
		System.out.println("Connection...\n");
		
		clientconnect(serveraddress,port);
		
		System.out.println("Connection success...\n");
		
		try {
			String username;
			HashMap<String,HashSet> friendsmap = new HashMap<String,HashSet>();
			HashSet<String> friendsset;
			
			//print friends relationship and store in hash map
			System.out.println("Username:\t"+"Friends");
			while((username = reader.readLine())!=null){//read user name from server
				System.out.print(username+":\t\t{");
				String friend;
				friendsset = new HashSet<String>();
				
				while((friend = reader.readLine())!=null){//read user friends from server
					if(friend.equals("next")) break;
					friendsset.add(friend);
					System.out.print("\""+friend+"\",");
				}
				System.out.println("}");
				System.out.println("-------------------------------------------------");
				friendsmap.put(username, friendsset);
			}
			reader.close();
			
			System.out.println("Enter a name:");
			String name = scan.nextLine();
			
			//print Unidirectional and Bidirectional
			if(friendsmap.containsKey(name)){
				Iterator<String> Uniiterator = friendsmap.get(name).iterator();	
				HashSet<String> Unifriends = new HashSet<>();//for Bidirectional so collect friend name 
				
				System.out.println("Unidirectional:");
				while(Uniiterator.hasNext()){
					String Unitmp = Uniiterator.next();
					Unifriends.add(Unitmp);//for Bidirectional so collect friend name
					System.out.println(name + "----->" + Unitmp);
				}
				
				System.out.println("-------------------");
				
				Iterator <String> Biditerator = Unifriends.iterator();//HashSet Unifriends pour in Biditerator for check they relationship
				
				System.out.println("Bidirectional:");
				while(Biditerator.hasNext()){
					String Bidtmp = Biditerator.next();//take name of user friend 
					Iterator <String> Bestfriends = friendsmap.get(Bidtmp).iterator();//take friends of  user friend
					while(Bestfriends.hasNext()){
						String Bidtmp2 = Bestfriends.next();
						if(Bidtmp2.equals(name)){//check user friend whether have user name
							System.out.println(name + "<----->"+Bidtmp);
						}
					}
				}
				
			}else{
				System.out.println(name + "doesn't have friends");
			}
			//clientsocket.close;
			
		} catch (IOException e) {
			System.out.println("IO operate error");
			e.printStackTrace();
		}

	}//end of main

}//end of class Client
