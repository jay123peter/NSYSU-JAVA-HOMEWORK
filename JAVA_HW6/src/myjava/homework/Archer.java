package myjava.homework;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Archer extends Adventurer {

	private static final int  ArrowBlow = 1;
	private static final int  SeedBoost = 2;
	private static final int  CriticalShot = 3;
	private int CRI = 0;
	
	//constructor initializes
	public Archer() {
		setHp(70);
		setAtk(60);
		setUnique(40);
	}

	// attack(ArrowBlow)
	@Override
	public int attack_skill(){
		Random ran = new Random();
		int damage;
		int CRIRan = (int) (Math.random() * 100 +1);
		if(CRIRan > CRI){
			//CRI failure
			damage = getAtk() + ran.nextInt(10) + 1;
		}else{
			//CRI succeed
			damage = getAtk() + ran.nextInt(10) + 1;
			damage = damage * 2;
		}
		setdamage(damage);
		return getdamage();
	}
	
	//defense(SeedBoost)
	@Override 
	public int defense_skill(){
		setUnique(getUnique() * 2);
		if(getUnique() <= 100){
			return getUnique();
		}else{
			setUnique(100);
			return getUnique();
		}
	}
	
	//skill(CriticalShot)
	@Override 
	public int buff_skill(){
		this.CRI = this.CRI + 25;
		if(CRI<=100){
			return CRI;
		}else{
			CRI = 100;
			return CRI;	
		}
	}
	
	public int getCRI(){
		return CRI;
	}
	
	//choice items
	@Override
	public int action(){
		
		int option = 0;
		int action = 0;
		
		while(true){
			
			//print items and check input
			Scanner scan = new Scanner(System.in);
			
			try{
				System.out.println("(1)Arrow Blow\t (2)Seed Boost\t (3)Critical Shot");
				System.out.print("Action (By default(1)):");
				option = scan.nextInt();
			}catch(InputMismatchException e){
				option = 4;//item default
			}
			
			//items
			switch(option){
			
				case ArrowBlow:
					System.out.println("[Arrow Blow]: "+attack_skill()+" damage");
					action = 1;
					break;
					
				case SeedBoost:
					System.out.println("[Seed Boost]: EVA "+defense_skill()+"%");
					action = 2;
					break;
					
				case CriticalShot:
					System.out.println("[Critical Shot]: CRI "+buff_skill()+"%");
					action = 3;
					break;
					
				default:
					System.out.println("[Arrow Blow]: "+attack_skill()+" damage");
					action = 1;
					break;
					
			}//end of switch
			break;
			
		}//end of while
		return action;// return you item
	
	}//end of action

}//end of class Archer
