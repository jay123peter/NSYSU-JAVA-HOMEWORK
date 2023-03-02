package myjava.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HW10_Main {

	private static Connection connection = null;//connect database
	private static Statement statement = null;//execute SQL
	private static ResultSet resultset = null;//receive SQL	result 
	private static ResultSetMetaData resultsetmetadata = null;//SQL meta data
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String account = null;		//"java"
		String password = null;		//"java"
		final String URL = "jdbc:mysql://localhost:3306/java_db?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
		
		//input account and check
		try{
			System.out.println("MYSQL Database account:");
			account = scan.next();
		} catch(InputMismatchException e) {
			System.out.println("input account error!!!");
			scan.close();
			System.exit(1);
		}

		//input password and check
		try{
			System.out.println("MYSQL Database password:");
			password = scan.next();
		} catch(InputMismatchException e) {
			System.out.println("input password error!!!");
			scan.close();
			System.exit(1);	
		}
	
		try{
			//registered java database driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//connection to java database
			connection = DriverManager.getConnection(URL,account,password);
			statement = connection.createStatement();
			
			//check connection
			if (!connection.isClosed() || connection !=null){
				
				System.out.println("Connection to database success");
			
				//execute statement and print result
				if(statement.isClosed() || statement == null){
					 System.out.println("statement==null or close: can'nt use Query Statement object!!!");
				}else{
					
					//fot cat execute and print
					resultset = statement.executeQuery("select * from cat;");
					resultsetmetadata = resultset.getMetaData();					
					System.out.println("-------------------[cat]-------------------");
					printresult(resultset,resultsetmetadata);
					System.out.println("-------------------------------------------");
	
					System.out.println();
					
					//for dog execute and print
					resultset = statement.executeQuery("select * from dog;");
					resultsetmetadata = resultset.getMetaData();
					System.out.println("-------------------[dog]-------------------");
					printresult(resultset,resultsetmetadata);
					System.out.println("-------------------------------------------");
					
				}
			}else{
				System.out.println("connection establish to failure");
			}
		} catch(SQLException e1) {
			System.out.println("SQLException :" + e1.getMessage());
		} catch (ClassNotFoundException e2) {
	        System.out.println("cann't finding driver!!!");
	    } catch (IllegalAccessException e3) {
	        System.out.println("cann't reading driver!!!");
	    } catch (InstantiationException e4) {
	    	System.out.println("cann't loading driver!!!");
	    } finally {
			try{
				
				if(resultset != null && !resultset.isClosed()){
					resultset.close(); //Recycling ResultSet object 
					resultset = null;
				}
				
				if(statement != null && !statement.isClosed()){
					statement.close(); //Recycling Statement object
					statement = null;
				}
				
				if(connection != null && !connection.isClosed()){
					connection.close(); //Interrupted database connection
					connection = null;
				}
				
			} catch(Exception e5) {
				e5.printStackTrace();
			}//end of catch
			
		}//end of finally
		
	}//end of main

	//print result
	public static <T> void printresult(ResultSet resultset,ResultSetMetaData resultsetmetadata){
		
		HashSet<Animal> hs = new HashSet<Animal>();
		ArrayList<Animal> al = new ArrayList<Animal>();
        ArrayList<T> BloodPressure = new ArrayList<T>();
        ArrayList<T> Weight = new ArrayList<T>();
        HealthCheck<T> hc = new HealthCheck<T>();
		
		try {
			//store animal for hashset, because	removed same database
			while(resultset.next()){//resultset row
				Animal animal = new Animal((String)resultset.getObject(1),(String)resultset.getObject(2),resultset.getObject(3),resultset.getObject(4));//resultset Column
				hs.add(animal);
			}
			
			//take hashset give to arraylist
			Iterator<Animal> iterator = hs.iterator();
			while(iterator.hasNext()){
			        Animal tmp = iterator.next();
			        al.add(tmp);
			       	StringTokenizer tokens = new StringTokenizer(tmp.toString(),", ");
		       		tokens.nextToken();
		       		tokens.nextToken();
		       		BloodPressure.add((T) tokens.nextToken());
		       		Weight.add((T) tokens.nextToken());
			}

			//gain Weight type column and BloodPressure column type for judgment
			int type1 = resultsetmetadata.getColumnType(3);
			int type2 = resultsetmetadata.getColumnType(4);
			
			printlist(al);//print list
			
			System.out.println("MaxWeight: "+ hc.MaxWeight(Weight,type1,type2));
	        System.out.println("MinWeight: "+ hc.MinWeight(Weight,type1,type2));
	        System.out.println("AverageWeight: "+ hc.AverageWeight(Weight));
	        System.out.println("MaxBloodPressure: "+ hc.MaxBloodPressure(BloodPressure,type1,type2));
	        System.out.println("MinBloodPressure: " + hc.MinBloodPressure(BloodPressure,type1,type2));
	        System.out.println("AverageBloodPressure: "+ hc.AverageBloodPressure(BloodPressure)); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//end of print result
	
	//print list for cat and dog ex:CatList : {(Andy, M, 30.2258, 8)...
	public static void printlist(ArrayList<Animal> al){
		System.out.print("List : {");
		for(Animal animal : al){
			System.out.print("("+animal+"), ");
		}
		System.out.println("}");
	}//end of print list
	
}//end of class HW10_Main
