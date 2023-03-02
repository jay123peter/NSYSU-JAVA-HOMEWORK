package myjava.homework.part2;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.opencsv.CSVReader;

import myjava.homework.part1.CustomerData;

public class CSVReadBAR {

	CSVReader reader;//opencsv.CSVReader;
	HashMap<String,CustomerData> list;//store customer data by hash map
	
	private int PoductA;
	private int PoductB;
	private int PoductC;

	//read you csv and initializes
	public CSVReadBAR(String filepath) {
		
		try {
			reader = new CSVReader(new FileReader(filepath));
			list = new HashMap<String, CustomerData>();
			PoductA = 0;
			PoductB = 0;
			PoductC = 0;
		} catch (FileNotFoundException e) {
			//堆疊追蹤（Stack Trace）
			e.printStackTrace();
		}
		
	}

	//store you read data in hash map
	public void readdata() {
		String[] line;
		try {
			while ((line = reader.readNext()) != null) {// line by line read cvs  
				if (list.containsKey(line[0])) { //search have customer data by key
					//not first buy , have customer data
					CustomerData tmp =list.get(line[0]);//get this object
					
					if (line[1].equals("Product_A")) {
						tmp.setproductA();
					}
					
					if (line[1].equals("Product_B")) {
						tmp.setproductB();
					} 
					
					if (line[1].equals("Product_C")) {
						tmp.setproductC();
					}
					
					list.put(line[0], tmp);
					
				} else {
					// first buy , not have customer data,so store customer data
					list.put(line[0], new CustomerData(line[1],line[2]));
				}
			}
		}catch(IOException e) {
			//堆疊追蹤（Stack Trace）
			e.printStackTrace();
		}
	}

	//draw bar chart
	public JFreeChart drawchart(String id) {
		
		CustomerData tmp =list.get(id); // search value of id(customer data)
		
		if(tmp==null){
				return null;
		 }
		
		//get customer buy number of product 
		PoductA = tmp.getproductA();
		PoductB = tmp.getproductB();
		PoductC = tmp.getproductC();
		
		DefaultCategoryDataset  Product = new DefaultCategoryDataset();
	 	Product.setValue(PoductA,"ProductA","ProductA");//PoductA(數量),"ProductA"(說明標題),"ProductA"(橫軸標題)
	 	Product.setValue(PoductB,"ProductB","ProductB");
	 	Product.setValue(PoductC,"ProductC","ProductC");
	 	
	 	// name+"的購買統計" 圖表標題 //"個數"目錄軸的顯示標籤  (x軸) //"產品類別" 數值軸的顯示標籤(y軸) //dataset數據資料  // PlotOrientation.VERTICAL 圖標方向 :水平、垂直  //true 是否顯示圖例//false 是否生成工具 //false 是否生成URL連接  
	 	JFreeChart chart = ChartFactory.createBarChart3D(id+"的購買統計","個數","產品類別",Product, PlotOrientation.VERTICAL, true,true,false);
	 	
	 	CategoryPlot plot=chart.getCategoryPlot();//獲取圖表區域對象 
		CategoryAxis domainAxis=plot.getDomainAxis();//水平底部列表
		plot.setBackgroundPaint(Color.lightGray);//設置表格背景為亮灰
		plot.setDomainGridlinesVisible(true);//設置橫坐標網格線  可見見
		plot.setRangeGridlinesVisible(true);//設置縱坐標網格線  可看見
		plot.setDomainGridlinePaint(Color.white);//設置橫坐標網格線  線條為白色
		plot.setRangeGridlinePaint(Color.white);//設置縱坐標網格線   線條為白色
		domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));//水平底部標題
		domainAxis.setTickLabelFont(new Font("黑体",Font.BOLD,12));//垂直标题  
		ValueAxis rangeAxis=plot.getRangeAxis();//獲取柱狀
		rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));//粗體 Font.BOLD  
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15)); //設置項目字體  // 設定字體、類型、字號
		chart.getTitle().setFont(new Font("黑体",Font.BOLD,20));//設置標題字體   // 設定字體、類型、字號
		return chart;
		
	}

}
