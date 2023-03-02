package myjava.homework.part2;

import java.util.ArrayList;

public class ItemList {
	
	private ArrayList<String> item;

	public ItemList(){
		this.item = new ArrayList<>();
	}

	public void addItem(String item){
		this.item.add(item);
	}
	
	public void remove(String item){
		if(this.item.isEmpty()==true){
			System.out.printf("item list is empty\n");
		}else{
			for(int i=0;i<this.item.size() ;i++){
				if(this.item.get(i).equals(item)){
					this.item.remove(i);
				}
				System.out.printf("\n");
			}
		}
	}
	
	public void printList(){
			if(item.isEmpty()==true){
				System.out.printf("item list is NULL\n");
			}else{
				for(int i=0; i<item.size(); i++){
					System.out.printf("%d : %s\n",i+1 ,item.get(i));
				}
				System.out.printf("\n");
			}	
	}
	
}//end class ItemList
