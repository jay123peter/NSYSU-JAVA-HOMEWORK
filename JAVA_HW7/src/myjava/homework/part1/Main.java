package myjava.homework.part1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class Main {

	public static void main(String[] args) {
		
		JFreeChart[] chart;
		JFrame frame = new JFrame("java_HW7_����");
		CSVReadPIE csvreader = new CSVReadPIE("D:\\query_result.csv");
		
		//read csv data
		csvreader.readdata();
		
		//draw pie chart
		chart = csvreader.drawchart();
		
		//frame set
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�I�s�F setDefaultCloseOperation ��k�A�o�Ӥ�k�O�]�w�������D�C���������s�����{������A���� JFrame ���O�� staic �ݩ� (field) EXIT_ON_CLOSE ��Ѽ� (parameter)
		frame.getContentPane().add(BorderLayout.WEST,new ChartPanel(chart[0]));//add product pie in frame
		frame.getContentPane().add(BorderLayout.EAST,new ChartPanel(chart[1]));//add sex pie in frame
		frame.revalidate();//revalidate() : ���ܤj�p�q���A�[�J�s������Χ��ܤ���j�p	// repaint(): ���sø�s�q���A�Ҧp: �C��, ��r����, ��
		frame.setSize(1400, 500);//�]�w�������j�p
		frame.setVisible(true);//setVisible() : �Ψӳ]�w���󪺥i����
		
	}

}

