package myjava.homework;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Magician extends Adventurer {

	private static final int  ColdBeam = 1;
	private static final int  EnergyShield = 2;
	private static final int  Heal = 3;
	
	//constructor initializes
	public Magician() {
		setHp(40);
		setAtk(20);
		setUnique(0);
	}

	// attack(ColdBeam)
	@Override
	public int attack_skill(){
		Random ran = new Random();
		int damage = getAtk()*4 + ran.nextInt(10) + 1;
		setdamage(damage);
		return getdamage();
	}
	
	//defense(EnergyShield)
	@Override 
	public int defense_skill(){
		Random ran = new Random();
		int defense = getAtk()*4 + ran.nextInt(10) + 1;
		setUnique(defense);
		return getUnique();
	}
	
	//add hp(Heal)
	@Override 
	public int buff_skill(){
		Random ran = new Random();
		int addhp = getAtk()*2 + ran.nextInt(10) + 1;
		setHp(addhp+getHp());
		return addhp;
	}
	
	//choice items
	@Override
	public int action(){
		int option = 0;
		int action = 0;
		

		
		while(true){
		
			//print items and check input
			Scanner scan = new Scanner(System.in);
			
			try {
				System.out.println("(1)Cold Beam\t (2)Energy Shield\t (3)Heal");
				System.out.print("Action (By default(1)):");
				option = scan.nextInt();
			}catch(InputMismatchException e){
				option = 4;//item default
			}
			
			//items
			switch(option){
			
				case ColdBeam:
					System.out.println("[Cold Beam]: "+ attack_skill() +" damage");
					action = 1;
					break;
					
				case EnergyShield:
					System.out.println("[Energy Shield]: Shield +"+defense_skill()+" points");
					action = 2;
					break;
					
				case Heal:
					System.out.println("[Heal]:HP + "+buff_skill()+" points");
					action = 3;
					break;
					
				default:
					System.out.println("[Cold Beam]: "+ attack_skill() +" damage");
					action = 1;
					break;
					
			}//end of switch
			break;
			
		}//end of while
		return action;// return you item
	
	}//end of action
	
}//end of class Magician
