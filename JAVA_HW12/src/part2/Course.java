package part2;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Course {

	public static void main(String[] args) {
		Map<Integer,ArrayList<String>> student = new HashMap<Integer,ArrayList<String>>();
		ArrayList<String> list;
		StringTokenizer tokens;
		Scanner scan = new Scanner(System.in);
		String Data;
		String Key;
		String course;
		
		while(true){
			try{
				System.out.print("Please Input Data:");
				Data = scan.nextLine();
				
				if(Data.equals("-1")) break;
				
				tokens = new StringTokenizer(Data," ");
				Key = tokens.nextToken();
				course = tokens.nextToken();

				//search  have this key?,put in old student or create new list  
				
				if(student.containsKey(Integer.parseInt(Key))){
					student.get(Integer.parseInt(Key)).add(course);
				}else{
					list = new ArrayList<String>();
					list.add(course);
					student.put(Integer.parseInt(Key), list);
				}
				
			}catch(Exception e){
				System.out.println("Number Format Exception , please input again");
			}
		}//end of while	
		
		/*
		Set<Entry<Integer, ArrayList<String>>> SetMap = student.entrySet();
		Iterator<Entry<Integer, ArrayList<String>>> iterator =  SetMap.iterator();
		*/
		
		//print finally list
		/*Iterator<Entry<Integer, ArrayList<String>>> iterator = student.entrySet().iterator();
		System.out.print("List:[");
		while(iterator.hasNext()){
			System.out.print(iterator.next()+", ");
		}
		System.out.print("]");*/
		
		//print finally list
		Map<Integer,ArrayList<String>> treeMap = new TreeMap<>(student);
		
		System.out.print("List:[");
        for (Entry<Integer, ArrayList<String>> entry : treeMap.entrySet()) {
            System.out.printf(" %s = %s",entry.getKey(), entry.getValue());
        }
        System.out.print("]");
		
	}//end of main
	
}//end of class Course