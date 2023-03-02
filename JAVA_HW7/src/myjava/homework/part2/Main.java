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
			
			JFrame frame = new JFrame("java_HW7_�������G��");
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
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�I�s�F setDefaultCloseOperation ��k�A�o�Ӥ�k�O�]�w�������D�C���������s�����{������A���� JFrame ���O�� staic �ݩ� (field) EXIT_ON_CLOSE ��Ѽ� (parameter)
			frame.getContentPane().add(BorderLayout.CENTER,new ChartPanel(chart));// frame add component(e.g. butten chart...)	//BorderLayout.CENTER ��bframe ������
			frame.revalidate();//revalidate() : ���ܤj�p�q���A�[�J�s������Χ��ܤ���j�p	// repaint(): ���sø�s�q���A�Ҧp: �C��, ��r����, ��
			frame.setSize(1400, 500);//�]�w�������j�p
			frame.setVisible(true);//setVisible() : �Ψӳ]�w���󪺥i����
		}
		
	}

}
