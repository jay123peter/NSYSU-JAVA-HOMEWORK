package myjava.homework;

public abstract class Adventurer implements Skill{

	private int hp;
	private int atk;
	private int unique;
	private int damage;
	
	public int getHp(){
		return this.hp;
	}
	
	public int getAtk(){
		return this.atk;
	}
	
	public int getUnique(){
		return this.unique;
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

	public void setUnique(int unique){
		this.unique = unique;
	}

	public void setdamage(int damage){
		this.damage = damage;
	}
	
	//inherit use (sub class)
	public abstract int action();
	
}

