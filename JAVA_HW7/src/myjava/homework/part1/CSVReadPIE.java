package myjava.homework.part1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.opencsv.CSVReader;

public class CSVReadPIE {
	
	CSVReader reader;//opencsv.CSVReader;
	HashMap<String,CustomerData> list;//store customer data by hash map
	
	private int PoductA;
	private int PoductB;
	private int PoductC;
	private int female;
	private int man;

	//read you csv and initializes
	public CSVReadPIE(String filepath) {
		
		try {
			reader = new CSVReader(new FileReader(filepath));
			list = new HashMap<String, CustomerData>();
			PoductA = 0;
			PoductB = 0;
			PoductC = 0;
			female = 0;
			man = 0;
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
				if (list.containsKey(line[0])) {//search have customer data by key
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

	//draw pie chart
	public JFreeChart[] drawchart() {
		
		for (Map.Entry<String,CustomerData> item : list.entrySet()) {//entrySet 將map集合中的映射關係存入到了set集合中，而這個關係的數據類型就是Map.Entry
			
			//man or female count
			if (item.getValue().getidsex().equals("F")) {
				female++;
			} else if (item.getValue().getidsex().equals("M")) {
				man++;
			}
			
			//poduct ABC total
			PoductA += item.getValue().getproductA();
			PoductB += item.getValue().getproductB();
			PoductC += item.getValue().getproductC();
		}
		
		// Dataset product pie
		DefaultPieDataset product = new DefaultPieDataset();
		product.setValue("Product_A", (double) this.PoductA);//PoductA(數量),"ProductA"(說明標題),"ProductA"(橫軸標題)
		product.setValue("Product_B", (double) this.PoductB);
		product.setValue("Product_C", (double) this.PoductC);

		// Dataset sex pie
		DefaultPieDataset sex = new DefaultPieDataset();
		sex.setValue("Female", (double) this.female);
		sex.setValue("Male", (double) this.man);

		JFreeChart[] chart = new JFreeChart[2];
		PiePlot plot;
		//title(Product) 為標題, dataset(product) 為資料, true 為是否加上說明列, true 為是否加上 Tool chip, false 為是否加上URL位置
		chart[0] = ChartFactory.createPieChart3D("Product", product, true, true, false);
		chart[1] = ChartFactory.createPieChart3D("Sex",sex, true, true, false);

		//取得 PiePlot, 此為圓餅圖中的資料形式
		plot = (PiePlot) chart[0].getPlot();
		//分類別標籤的格式，設定成null則整個標籤包括連接線都不顯示
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} : {1} - {2}"));//代表標籤    {0}產品名稱  : {1}數量  - {2}幾趴

		//取得 PiePlot, 此為圓餅圖中的資料形式
		plot = (PiePlot) chart[1].getPlot();
		//分類別標籤的格式，設定成null則整個標籤包括連接線都不顯示
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} : {1} - {2}"));
		
		return chart;
	}
}
