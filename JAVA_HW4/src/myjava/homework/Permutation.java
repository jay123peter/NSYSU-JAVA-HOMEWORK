package myjava.homework;

public class Permutation extends fourStarGame {
	public void checkOfWin(){
		int num=0;
		//check Permutation whether there is the same(order must same)
		for(int i =0;i<4;i++){
			if(this.getUserNums().get(i).equals(this.getWinNums().get(i))){
				//System.out.println(getUserNums().get(i)+"!!"); //for error
				//System.out.println(getWinNums().get(i)+"??"); //for error
				num++;
			}
		}
		//print win or lose
		if(num==4){
			System.out.printf("**You win!\n");
		}else{
			System.out.printf("**You lose!\n");
		}
		
	}// end of checkOfWin
	
}// end of class Permutation
