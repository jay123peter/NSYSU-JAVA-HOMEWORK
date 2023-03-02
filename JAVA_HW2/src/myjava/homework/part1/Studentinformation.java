package myjava.homework.part1;

public class Studentinformation {
	
	private String id;
	private String name;
	private int score;
	
	public Studentinformation(){
		this.id = new String();
		this.name = new String();
		this.score = 0;
	}
	
	public void setID(String id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public String getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setData( String name,String id, int score){
		this.name = name;
		this.id = id;
		this.score = score;
	}
	
	public void show_data(){
		
		System.out.printf("Student id:%s \nStudent name:%s \n",id ,name);
		
		if(score >= 70){
			System.out.printf("Student %s pass this project\n",name);
		}else{
			System.out.printf("Student %s not pass this project\n",name);
		}
		
	}
	
}
