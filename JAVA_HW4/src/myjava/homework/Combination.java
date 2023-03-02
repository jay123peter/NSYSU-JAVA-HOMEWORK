package myjava.homework;

public class Combination extends fourStarGame{
	public void checkOfWin(){
		int num=0;
		//check Combination whether there is the same(order can not same)
		for(int i =0;i<4;i++){
			if(this.getUserNums().contains(this.getWinNums().get(i))){
				num++;
			}
		}
		//print win or lose
		if(num==4){
			System.out.printf("**You win!\n");
		}else{
			System.out.printf("**You lose!\n");
		}
		
	}
}
