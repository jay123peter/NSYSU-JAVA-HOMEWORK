package myjava.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class server {

	private final static int serverport = 12345;//server port
	private static ServerSocket serversocket;//server socket
	private static information tmp;//temporary
	private static ArrayList<information> customerdata = new ArrayList<>();
			
	public static void main(String[] args){
		
		Socket connectsocket;//for connection client(socket)
		PrintStream writer;
        BufferedReader reader;
		boolean error = false;
		boolean [] exist = { false, false };
		String newaccount;
		int option = 0;
		int newpassword;
		int money = 0, totalmoney = 0;
		
      //initializes value and building server socket
		try{
			serversocket = new ServerSocket(serverport);
			tmp = new information("a",123,50);
			customerdata.add(tmp);
		}catch(IOException e){
			System.out.println("socket cann't new");
			e.printStackTrace();
			System.exit(1);
		}

		
		try{
			connectsocket = serversocket.accept();//wait and receive client socket
			serversocket.close();//not serve for other client ,so close socket 
			writer = new PrintStream(connectsocket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(connectsocket.getInputStream()));
			
			//check client request 
			if( reader.readLine().equals("request")){
				
				//receive client action
				while(true){
					
					option = Integer.parseInt(reader.readLine());
					switch(option){
						case 1:
							//receive new account
							newaccount = reader.readLine();
						
							//search have the same account
							for(int i=0;i<customerdata.size();i++){
								if(customerdata.get(i).getAccount().equals(newaccount)){
									writer.println("find");
									writer.flush();
									error = true;
								}
							}
							
							//check error
							if(error){
								error = false;
								break;
							}
							writer.println("notfind");
							writer.flush();
							
							//receive new password
							newpassword = Integer.parseInt(reader.readLine()); 
							
							//store new customer data
							tmp = new information(newaccount,newpassword,0);
							customerdata.add(tmp);
							break;
							
						case 2:
							//login account confirm and return 
	
							//receive new account and new password
							newaccount = reader.readLine();
							newpassword = Integer.parseInt(reader.readLine());
							
							//check account and password(1)
							for(int i=0;i<customerdata.size();i++){
								if(customerdata.get(i).getAccount().equals(newaccount)){
									exist[0] = true;
									money = customerdata.get(i).getMoney();//get account money
								}
								if(customerdata.get(i).getPassword() == newpassword){
									exist[1] = true;
								}
							}
							
							//check account and password(2)
							if( (exist[0]==true) && (exist[1]==true) ){
								writer.println("find");
								writer.flush();
								exist[0] = false;
								exist[1] = false;
							}else{
								writer.println("notfind");
								writer.flush();
								exist[0] = false;
								exist[1] = false;
								break;
							}
							
							//receive new password
							totalmoney = money + Integer.parseInt(reader.readLine());
							writer.println(totalmoney);
							
							//store new customer data 
							for(int i=0;i<customerdata.size();i++){
								if(customerdata.get(i).getAccount().equals(newaccount)){
									customerdata.set(i,new information(customerdata.get(i).getAccount(),customerdata.get(i).getPassword(),totalmoney));
								}
							}
							break;
							
						case 3:
							//leave
							try {
								connectsocket.close();
								System.exit(0);
							} catch (IOException e) {
								System.out.println("close error");
								e.printStackTrace();
								System.exit(1);
							}
							break;
							
						default:
							System.out.println("option error!!");
							break;
							
					}//end of switch
					
				} //end of while
				
			}//end of if
		}catch(IOException e){
			System.out.println("socket cann't open");
			e.printStackTrace();
			System.exit(1);
		}
		
	}//end of main
	
}//end of class server
