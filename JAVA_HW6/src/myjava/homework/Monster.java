package myjava.homework;

import java.util.Random;

public class Monster {
	
	private int hp;
	private int atk;
	private int damage;
	
	public Monster() {
		Random ran = new Random();
		int hp = 150 + ran.nextInt(150)+1;
		setHp(hp);
		int atk = 30 +ran.nextInt(5)+1;
		setAtk(atk);
		System.out.println("[Monster appeared!]");
	}
	
	public int getHp(){
		return this.hp;
	}
	
	public int getAtk(){
		return this.atk;
	}

	public int getdamage(){
		return this.damage;
	}
	
	public void setHp(int hp){
		this.hp = hp;
	}
	
	public void setAtk(int atk){
		this.atk = atk;
	}
	
	public void setdamage(int damage){
		this.damage = damage;
	}
	
	public void action(){
		Random ran = new Random();
		int atk = getAtk()+ran.nextInt(5)+1;
		setdamage(atk);
		System.out.println("[Monster]: "+getdamage() +" damage");
	}

}
