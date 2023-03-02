package myjava.homework;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Fighter extends Adventurer {

	private static final int  Brandish = 1;
	private static final int  IronBody = 2;
	private static final int  Rage = 3;
	
	//constructor initializes
	public Fighter(){
		setHp(80);
		setAtk(40);
		setUnique(10);
	}

	//attack(Brandish)
	@Override
	public int attack_skill(){
		Random ran = new Random();
		int damage = getAtk() + ran.nextInt(10) + 1;
		setdamage(damage);
		return getdamage();
	}
	
	//defense(IronBody)
	@Override 
	public int defense_skill(){
		setUnique(getUnique() * 2);
		return getUnique();
	}
	
	//add atk(Rage)
	@Override 
	public int buff_skill(){
		setAtk(getAtk() * 2);
		return getAtk();
	}
	
	//choice items
	@Override
	public int action(){
		
		int option = 0;
		int action = 0;
	
		//choice items
		while(true){
			
			//print items and check input
			Scanner scan = new Scanner(System.in);
			
			try{
				System.out.println("(1)Brandish\t (2)Iron Body\t (3)Rage");
				System.out.print("Action (By default(1)):");
				option = scan.nextInt();
			}catch(InputMismatchException e){
				option = 4;//item default
			}
			
			//items
			switch(option){
			
				case Brandish:
					System.out.println("[Brandish]: "+attack_skill()+" damage");
					action = 1;
					break;
					
				case IronBody:
					System.out.println("[Iron Body]: DEF + " +(defense_skill()/2)+" ,now you DEF:"+getUnique());
					action = 2;
					break;
					
				case Rage:
					System.out.println("[Rage]: ATK + "+(buff_skill()/2) +" ,now you ATK:"+getAtk());
					action = 3;
					break;
					
				default:
					System.out.println("[Brandish]: "+ attack_skill() +" damage");
					action = 1;
					break;

			}//end of switch
			break;
			
		}//end of while
		return action;// return you item
		
	}//end of action
	
}//end of class Fighter
