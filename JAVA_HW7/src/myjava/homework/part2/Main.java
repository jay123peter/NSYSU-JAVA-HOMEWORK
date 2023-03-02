package myjava.homework.part2;

import java.awt.BorderLayout;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class Main {

	public static void main(String[] args) {
		
		while(true){
			
			String id;
			
			//input your id   
			Scanner scan =new Scanner(System.in);
			try{
				System.out.println("Please input you ID:");
				id = scan.next();
			}catch(InputMismatchException e){
				System.out.println("Input error : only int");
				scan.close();
				continue;
			}
			
			JFrame frame = new JFrame("java_HW7_長條分佈圖");
			JFreeChart chart;
			CSVReadBAR csvreader = new CSVReadBAR("D:\\query_result.csv");
			
			//read csv data
			csvreader.readdata();
			
			//draw you want id data bar chart
			chart = csvreader.drawchart(id);
			
			//check id data exist
			if(chart==null){
				System.out.println(id + "can'nt not find");
				continue;
	 		} 
			
			//frame set
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//呼叫了 setDefaultCloseOperation 方法，這個方法是設定視窗標題列的關閉按鈕結束程式執行，提供 JFrame 類別的 staic 屬性 (field) EXIT_ON_CLOSE 當參數 (parameter)
			frame.getContentPane().add(BorderLayout.CENTER,new ChartPanel(chart));// frame add component(e.g. butten chart...)	//BorderLayout.CENTER 放在frame 的中間
			frame.revalidate();//revalidate() : 改變大小通知，加入新的元件或改變元件大小	// repaint(): 重新繪製通知，例如: 顏色, 文字改變, 等
			frame.setSize(1400, 500);//設定視窗的大小
			frame.setVisible(true);//setVisible() : 用來設定元件的可見性
		}
		
	}

}
