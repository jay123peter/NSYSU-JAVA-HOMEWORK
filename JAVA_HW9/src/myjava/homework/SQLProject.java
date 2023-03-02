package myjava.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SQLProject {
	
	private static Connection connection = null;//connect database
	private static Statement statement = null;//execute SQL
	private static ResultSet resultset = null;//receive SQL	result 
	private static ResultSetMetaData resultsetmetadata = null;//SQL metadata
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		String account = null;//"java"
		String password = null;//"java"
		final String URL = "jdbc:mysql://localhost:3306/java_db?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
		
		//input account and check
		try{
			System.out.println("Please enter useraccount:");
			account = scan.next();
		} catch(InputMismatchException e) {
			System.out.println("input useraccount error!!!");
			scan.close();
			System.exit(1);
		}

		//input password and check
		try{
			System.out.println("Please enter userpassword:");
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
			if (!connection.isClosed() ||connection !=null){
				
				System.out.println("Connection establish success");
			
				//execute statement and print result
				if(statement.isClosed() || statement == null){
					 System.out.println("statement==null or close: can'nt use Query Statement object!!!");
				}else{
					
					System.out.println("Query 1:");
					resultset = statement.executeQuery("select avg(chinese) as c_avg, max(math) as m_max, min(chinese) as c_min from grades;");
					resultsetmetadata = resultset.getMetaData();
					pritresult(resultsetmetadata,resultset);
					
					System.out.println("Query 2:");
					resultset = statement.executeQuery("select id,chinese from grades order by chinese desc LIMIT 1;");
					resultsetmetadata = resultset.getMetaData();
					pritresult(resultsetmetadata,resultset);
					
					System.out.println("Query 3:");
					resultset = statement.executeQuery("select id, sex, birthmonth from students where id like 'A%' order by sex , birthmonth desc;");
					resultsetmetadata = resultset.getMetaData();
					pritresult(resultsetmetadata,resultset);
					
					System.out.println("Query 4:");
					resultset = statement.executeQuery("select avg(english) as e_avg from grades where id IN(select id from students where sex = 'F')");
					resultsetmetadata = resultset.getMetaData();
					pritresult(resultsetmetadata,resultset);
					
					System.out.println("Query 5:");
					resultset = statement.executeQuery("select sex, count(sex) as count from students where birthmonth between 6 and 10 group by sex;");
					resultsetmetadata = resultset.getMetaData();
					pritresult(resultsetmetadata,resultset);
				
				}
			}else{
				System.out.println("connection establish failure");
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
	public static void pritresult(ResultSetMetaData metadata,ResultSet resultset){
		try {
			
			//print meta data content
			int numberOfColums = metadata.getColumnCount();
			for(int i = 1; i <= numberOfColums; i++){
				System.out.print(metadata.getColumnName(i)+"\t");
			}
			System.out.println();
			
			//print data content
			while(resultset.next()){//print row
				for(int i = 1; i <= numberOfColums; i++){
					System.out.print(resultset.getObject(i)+"\t");//print colum
				}
				System.out.println();
			}
			System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//end of pritresult
	
}//end of class SQLProject
