package myjava.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONObject;


public class Server {

	private final static int serverport = 12345;//server port
	private static ServerSocket serversocket;//server socket
	private static Socket connectsocket;//for connection client(socket);
			
	public static void main(String[] args){
		
		User [] users = new User[5];
		HashMap<String,User> friendsmap = new HashMap<String,User>();
		PrintStream writer;
        BufferedReader reader;
		
      //building server socket
		try{
			serversocket = new ServerSocket(serverport);
			connectsocket = serversocket.accept();//wait and receive client socket
			serversocket.close();//not serve for other client ,so close socket 
		}catch(IOException e){
			System.out.println("socket cann't new");
			e.printStackTrace();
			System.exit(1);
		}

		
		try{
			writer = new PrintStream(connectsocket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(connectsocket.getInputStream()));
			
			//check client request 
			if(reader.readLine().equals("request")){
				//create user and add user friends
				//users[1] = Duncan,users[2] = Parker,users[3] = Ginobili
				//users[4] = Leonard, users[5] = James
				
				users[0] = new User("Duncan");
				users[1] = new User("Parker");
				users[2] = new User("Ginobili");
				users[3] = new User("Leonard");
				users[4] = new User("James");
				
				users[0].addFriends(users[1]);
				users[0].addFriends(users[2]);
				users[0].addFriends(users[3]);
				
				users[1].addFriends(users[0]);
				users[1].addFriends(users[2]);		
			
				users[2].addFriends(users[0]);
				users[2].addFriends(users[1]);
				
				users[3].addFriends(users[0]);
				users[3].addFriends(users[4]);
				
				users[4].addFriends(users[0]);
				users[4].addFriends(users[1]);
				users[4].addFriends(users[2]);
				users[4].addFriends(users[3]);
				
				//put in hash map store
				friendsmap.put("Duncan", users[0]);
				friendsmap.put("Parker", users[1]);
				friendsmap.put("Ginobili", users[2]);
				friendsmap.put("Leonard", users[3]);
				friendsmap.put("James", users[4]);
			
				//send client user name and user friends
				//map pour in set , set pour in iterator because take out user object(name , friends)from map from hash set 
				Set<String> friendsset = friendsmap.keySet();
				Iterator <String> friendskey = friendsset.iterator();
				String key;
				
				while(friendskey.hasNext()){
					JSONObject object = new JSONObject();
					key = friendskey.next();
					writer.println(key);// send key for client(key = user name)
					writer.flush();

					Iterator <User> friendsvalve = friendsmap.get(key).getFriends().iterator();//take out user friends name
					while(friendsvalve.hasNext()){
						object.put(key, friendsvalve.next().getUsername());
						writer.println(object.get(key));
						writer.flush();
					}
					writer.println("next");//for talk client next user
					writer.flush();
				}
				writer.close();
				//connectsocket.close();
				
			}//end of if
			
		}catch(IOException e){
			System.out.println("socket cann't open");
			e.printStackTrace();
			System.exit(1);
		}
		
	}//end of main

}//end of class Server
