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
			//���|�l�ܡ]Stack Trace�^
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
			//���|�l�ܡ]Stack Trace�^
			e.printStackTrace();
		}
		
	}

	//draw pie chart
	public JFreeChart[] drawchart() {
		
		for (Map.Entry<String,CustomerData> item : list.entrySet()) {//entrySet �Nmap���X�����M�g���Y�s�J��Fset���X���A�ӳo�����Y���ƾ������N�OMap.Entry
			
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
		product.setValue("Product_A", (double) this.PoductA);//PoductA(�ƶq),"ProductA"(�������D),"ProductA"(��b���D)
		product.setValue("Product_B", (double) this.PoductB);
		product.setValue("Product_C", (double) this.PoductC);

		// Dataset sex pie
		DefaultPieDataset sex = new DefaultPieDataset();
		sex.setValue("Female", (double) this.female);
		sex.setValue("Male", (double) this.man);

		JFreeChart[] chart = new JFreeChart[2];
		PiePlot plot;
		//title(Product) �����D, dataset(product) �����, true ���O�_�[�W�����C, true ���O�_�[�W Tool chip, false ���O�_�[�WURL��m
		chart[0] = ChartFactory.createPieChart3D("Product", product, true, true, false);
		chart[1] = ChartFactory.createPieChart3D("Sex",sex, true, true, false);

		//���o PiePlot, �������Ϥ�����ƧΦ�
		plot = (PiePlot) chart[0].getPlot();
		//�����O���Ҫ��榡�A�]�w��null�h��Ӽ��ҥ]�A�s���u�������
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} : {1} - {2}"));//�N�����    {0}���~�W��  : {1}�ƶq  - {2}�X�w

		//���o PiePlot, �������Ϥ�����ƧΦ�
		plot = (PiePlot) chart[1].getPlot();
		//�����O���Ҫ��榡�A�]�w��null�h��Ӽ��ҥ]�A�s���u�������
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} : {1} - {2}"));
		
		return chart;
	}
}
