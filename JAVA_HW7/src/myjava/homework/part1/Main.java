package myjava.homework.part1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class Main {

	public static void main(String[] args) {
		
		JFreeChart[] chart;
		JFrame frame = new JFrame("java_HW7_圓餅圖");
		CSVReadPIE csvreader = new CSVReadPIE("D:\\query_result.csv");
		
		//read csv data
		csvreader.readdata();
		
		//draw pie chart
		chart = csvreader.drawchart();
		
		//frame set
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//呼叫了 setDefaultCloseOperation 方法，這個方法是設定視窗標題列的關閉按鈕結束程式執行，提供 JFrame 類別的 staic 屬性 (field) EXIT_ON_CLOSE 當參數 (parameter)
		frame.getContentPane().add(BorderLayout.WEST,new ChartPanel(chart[0]));//add product pie in frame
		frame.getContentPane().add(BorderLayout.EAST,new ChartPanel(chart[1]));//add sex pie in frame
		frame.revalidate();//revalidate() : 改變大小通知，加入新的元件或改變元件大小	// repaint(): 重新繪製通知，例如: 顏色, 文字改變, 等
		frame.setSize(1400, 500);//設定視窗的大小
		frame.setVisible(true);//setVisible() : 用來設定元件的可見性
		
	}

}

