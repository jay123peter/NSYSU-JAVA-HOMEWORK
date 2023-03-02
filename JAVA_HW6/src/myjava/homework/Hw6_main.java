package myjava.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Hw6_main {
	
	private static final int  Fighter = 1;
	private static final int  Magician = 2;
	private static final int  Archer = 3;
	
	public static void main(String[] args) {
		
		Archer archer;
		Adventurer adventurer;
		Monster monster;
		
		while(true){
			Scanner scan = new Scanner(System.in);
			int option = 0;
			
			//choice items and check input
			try{
				System.out.println("(1) Fighter\t (2)Magician\t (3)Archer");
				System.out.print("Choose your character (By default(1)):");
				option = scan.nextInt();
			}catch(InputMismatchException e){
				System.out.println("you input error,please try again");
				continue;
			}
			
			//items
			int action = 0;
			int damage = 0;
			int monhp = 0;
			int advhp = 0;
			switch(option){
			
				case Fighter:
					monster = new Monster();
					adventurer = new Fighter();
					while(adventurer.getHp()>0 && monster.getHp()>0){
						//Display status;
						System.out.println("-----Fighter-----\t-----Monster-----");
						System.out.println("HP: "+adventurer.getHp()+"\t\t\tHP:"+monster.getHp());
						System.out.println("ATK: "+adventurer.getAtk()+"\t\t\tATK: "+monster.getAtk());
						System.out.println("DEF: "+adventurer.getUnique());
						System.out.println("-----------------\t------------------");
						action = adventurer.action();//correspond you choice
						switch(action){
							case 1:
								monster.action();//get monster damage
								damage = adventurer.getUnique()-monster.getdamage();
								if(damage<0){
									//DEF < monster damage
									System.out.println("[Fighter]: HP "+ damage +" points");
									advhp = adventurer.getHp()+adventurer.getUnique()-monster.getdamage();
									adventurer.setHp(advhp);
								}else{
									//DEF > monster damage
									System.out.println("Monster damage cann't hurt you");
								}
								//you attack monster
								monhp = monster.getHp() - adventurer.getdamage();
								monster.setHp(monhp);
								break;
								
							case 2:
								monster.action();//get monster damage
								damage = adventurer.getUnique()-monster.getdamage();
								if(damage<0){
									//DEF < monster damage
									System.out.println("[Fighter]: HP "+ damage +" points");	
									advhp = adventurer.getHp()+adventurer.getUnique()-monster.getdamage();
									adventurer.setHp(advhp);
								}else{
									//DEF > monster damage
									System.out.println("Monster damage cann't hurt you");
								}
								break;
								
							case 3:
								monster.action();//get monster damage
								damage = adventurer.getUnique()-monster.getdamage();
								if(damage<0){
									//DEF < monster damage
									System.out.println("[Fighter]: HP "+ damage +" points");	
									advhp = adventurer.getHp()+adventurer.getUnique()-monster.getdamage();
									adventurer.setHp(advhp);
								}else{
									//DEF > monster damage
									System.out.println("Monster damage cann't hurt you");
								}
								break;
						}//end of switch
						System.out.println();
					}//end of while 
					
					//Display win or lose
					displayfinal(adventurer.getHp(),monster.getHp());
					break;
					
				case Magician:
					monster = new Monster();
					adventurer = new Magician();
					while(adventurer.getHp()>0 && monster.getHp()>0){
						//Display status;
						System.out.println("-----Magician-----\t-----Monster-----");
						System.out.println("HP: "+adventurer.getHp()+"\t\t\tHP:"+monster.getHp());
						System.out.println("ATK: "+adventurer.getAtk()+"\t\t\tATK: "+monster.getAtk());
						System.out.println("ES: "+adventurer.getUnique());
						System.out.println("------------------\t------------------");
						action = adventurer.action();//correspond you choice
						switch(action){
						case 1:
							monster.action();//get monster damage
							damage = adventurer.getUnique()-monster.getdamage();
							if(damage<0 && adventurer.getUnique()==0){
								//if damage < 0 monster can attack you¡Abecause you Energy Shield=0
								System.out.println("[Energy Shield]: shield - "+adventurer.getUnique());
								System.out.println("[Magician]: HP "+ damage +" points");	
								advhp = adventurer.getHp()+adventurer.getUnique()-monster.getdamage();
								adventurer.setHp(advhp);
							}else if(damage<0 && adventurer.getUnique()>0){
								//if damage < 0 monster can attack you¡Abut you same have Energy Shield resistance
								System.out.println("[Energy Shield]: shield - "+ adventurer.getUnique() +" points");
								adventurer.setUnique(0);
								System.out.println("[Magician]: HP "+ damage +" points");	
								advhp = adventurer.getHp()+damage;
								adventurer.setHp(advhp);
							}else if(damage>=0 && adventurer.getUnique()>0){
								//if damage>= 0 monster cann't attack you¡Abecause you have Energy Shield
								System.out.println("[Energy Shield]: shield - "+ monster.getdamage() +" points");
								adventurer.setUnique(adventurer.getUnique()-monster.getdamage());
							}
							
							//you attack monster
							monhp = monster.getHp() - adventurer.getdamage();
							monster.setHp(monhp);
							break;
							
						case 2:
							monster.action();//get monster damage
							damage = adventurer.getUnique()-monster.getdamage();
							if(damage<0 && adventurer.getUnique()==0){
								//if damage < 0 monster can attack you¡Abecause you Energy Shield=0
								System.out.println("[Energy Shield]: shield - "+adventurer.getUnique());
								System.out.println("[Magician]: HP "+ damage +" points");	
								advhp = adventurer.getHp()+adventurer.getUnique()-monster.getdamage();
								adventurer.setHp(advhp);
							}else if(damage<0 && adventurer.getUnique()>0){
								//if damage < 0 monster can attack you¡Abut you same have Energy Shield resistance
								System.out.println("[Energy Shield]: shield - "+ adventurer.getUnique() +" points");
								adventurer.setUnique(0);
								System.out.println("[Magician]: HP "+ damage +" points");	
								advhp = adventurer.getHp()+damage;
								adventurer.setHp(advhp);
							}else if(damage>=0 && adventurer.getUnique()>0){
								//if damage>= 0 monster cann't attack you¡Abecause you have Energy Shield
								System.out.println("[Energy Shield]: shield - "+ monster.getdamage() +" points");
								adventurer.setUnique(adventurer.getUnique()-monster.getdamage());
							}
							break;
							
						case 3:
							monster.action();//get monster damage
							damage = adventurer.getUnique()-monster.getdamage();
							if(damage<0 && adventurer.getUnique()==0){
								//if damage < 0 monster can attack you¡Abecause you Energy Shield=0
								System.out.println("[Energy Shield]: shield - "+adventurer.getUnique());
								System.out.println("[Magician]: HP "+ damage +" points");	
								advhp = adventurer.getHp()+adventurer.getUnique()-monster.getdamage();
								adventurer.setHp(advhp);
							}else if(damage<0 && adventurer.getUnique()>0){
								//if damage < 0 monster can attack you¡Abut you same have Energy Shield resistance
								System.out.println("[Energy Shield]: shield - "+ adventurer.getUnique() +" points");
								adventurer.setUnique(0);
								System.out.println("[Magician]: HP "+ damage +" points");	
								advhp = adventurer.getHp()+damage;
								adventurer.setHp(advhp);
							}else if(damage>=0 && adventurer.getUnique()>0){
								//if damage>= 0 monster cann't attack you¡Abecause you have Energy Shield
								System.out.println("[Energy Shield]: shield - "+ monster.getdamage() +" points");
								adventurer.setUnique(adventurer.getUnique()-monster.getdamage());
							}
							break;
							
						}//end of switch
						System.out.println();
					}//end of while
					
					//Display win or lose
					displayfinal(adventurer.getHp(),monster.getHp());
					break;
				case Archer:
					int evasionrate = 0;
					monster = new Monster();
					archer = new Archer();
					while(archer.getHp()>0 && monster.getHp()>0){
						//Display status;
						System.out.println("-----Archer-----\t-----Monster-----");
						System.out.println("HP: "+archer.getHp()+"\t\t\tHP:"+monster.getHp());
						System.out.println("ATK: "+archer.getAtk()+"\t\t\tATK: "+monster.getAtk());
						System.out.println("EVA: "+archer.getUnique());
						System.out.println("CRI: "+archer.getCRI());
						System.out.println("-----------------\t------------------");
						action = archer.action();
						switch(action){
							case 1:
								monster.action();//get monster damage
								evasionrate = (int) (Math.random() * 100 +1);
								if(evasionrate > archer.getUnique()){
									//Evasion failure!
									System.out.println("Evasion failure!");
									advhp = archer.getHp()-monster.getdamage();
									archer.setHp(advhp);
								}else{
									//Evasion succeed
									System.out.println("Evasion succeed!");
								}
								//you attack monster
								monhp = monster.getHp() - archer.getdamage();
								monster.setHp(monhp);
								break;
								
							case 2:
								monster.action();//get monster damage
								evasionrate = (int) (Math.random() * 100 +1);
								if(evasionrate > archer.getUnique()){
									//Evasion failure!
									System.out.println("Evasion failure!");
									advhp = archer.getHp()-monster.getdamage();
									archer.setHp(advhp);
								}else{
									//Evasion succeed
									System.out.println("Evasion succeed!");
								}
								break;
								
							case 3:
								monster.action();//get monster damage
								evasionrate = (int) (Math.random() * 100 +1);
								if(evasionrate > archer.getUnique()){
									//Evasion failure!
									System.out.println("Evasion failure!");
									advhp = archer.getHp()-monster.getdamage();
									archer.setHp(advhp);
								}else{
									//Evasion succeed
									System.out.println("Evasion succeed!");
								}
								
								break;
						}//end of switch
						System.out.println();
					}//end of while
					
					//Display win or lose
					displayfinal(archer.getHp(),monster.getHp());
					break;
					
				default:
					System.out.println("you input error,please try again");
					continue;
					
			}//end of switch
			
		}//end of while

	}//end of main
	
	public static void displayfinal(int player , int monster){
		if(monster<=0 && player>0){
			System.out.println("You win...");
		}else if(monster>0 && player<=0){
			System.out.println("You lose...");
		}else if(monster<=0 && player<=0){
			System.out.println("Lose everything...");
		}
	}//end of display final
	
	/*public static void displaystatus(Adventurer adventurer, Monster monster){
		System.out.println("-----Adventurer-----\t -----Monster-----");
		System.out.println("HP: "+adventurer.getHp()+"\t\t\tHP:"+monster.getHp());
		System.out.println("ATK: "+adventurer.getAtk()+"\t\t\tATK: "+monster.getAtk());
		System.out.println("EVA: "+adventurer.getUnique());
		System.out.println("--------------------\t ------------------");
	}*///end of display status
	
}//end of class Hw6_main
