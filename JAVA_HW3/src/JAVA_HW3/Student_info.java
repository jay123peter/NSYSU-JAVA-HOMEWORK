package JAVA_HW3;

public class Student_info{
	
	private String name;
	private int id;
	
	public Student_info(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public void show_data(){
		
		System.out.printf("Name:%s\n",name);
		System.out.printf("ID:%d\n",id);
		
	}

	public String getName(){
		return name;
	}
	
	public int getID(){
		return id;
	}
	
	
}//end class Student_inof
