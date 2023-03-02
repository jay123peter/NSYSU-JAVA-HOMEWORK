package JAVA_HW3;

import java.util.ArrayList;

public class Student_list {

	private ArrayList<Student_info> list = new ArrayList<Student_info>();
	
	public void add(Student_info addinfo){
		this.list.add(addinfo);
		System.out.println();
	}
	
	public int remove(String name){
		if(list.isEmpty()==true){
			System.out.printf("the list is empty\n");
		}else{
			for(int i =0; i<list.size(); i++){
				if(list.get(i).getName().equals(name)){
					list.remove(i);
					return 1;
				}
			}
		}
		return 0;
	}
	
	public int remove(int id){
		if(list.isEmpty()==true){
			System.out.printf("the list is empty\n");
		}else{
			for(int i =0; i<list.size(); i++){
				if(list.get(i).getID() == id){
					list.remove(i);
					return 1;
				}
			}
		}
		return 0;
	}
	
	public void display(){
		if(list.isEmpty() == true){
			System.out.printf("[NULL]\n");
		}else{
			for(int i= 0;i<list.size();i++){
				System.out.printf("<%d>\n",i+1);
				list.get(i).show_data();
			}
		}
		System.out.println();
	}
	
}//end class Student_list
