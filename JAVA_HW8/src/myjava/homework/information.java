package myjava.homework;

public class information {
	
	private String account;
	private int password;
	private int money;
	
	//constructor initializes
	public information(String account,int password,int money) {
		this.account = account;
		this.password = password;
		this.money = money;
	}

	public String getAccount(){
		return account;
	}
	
	public int getPassword(){
		return password;
	}
	
	public int getMoney(){
		return money;
	}
	
}
