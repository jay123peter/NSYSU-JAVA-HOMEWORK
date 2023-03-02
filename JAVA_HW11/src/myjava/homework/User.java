package myjava.homework;

import java.util.HashSet;
import java.util.Iterator;

public class User {
	
	private String username;
	private HashSet<User> friends = new HashSet<User>();

	public User(String username) {
		this.username = username;
		this.friends = new HashSet<User>();
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public HashSet<User> getFriends(){
		return this.friends;
	}
	
	public void addFriends(User user){
		friends.add(user);
	}
	
	//for test(check user friends name)
	/*public void print(){
		Iterator<User> iterator= friends.iterator();
		while(iterator.hasNext()){
	        System.out.println(iterator.next().username);
		}
		System.out.println();
	}*/
	

}
