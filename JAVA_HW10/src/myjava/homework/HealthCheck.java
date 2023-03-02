package myjava.homework;

import java.util.ArrayList;


public class HealthCheck <T>{

	public double AverageBloodPressure(ArrayList<T> list){
		double ABP = 0, TotalABP = 0;
		for(int i = 0; i<list.size(); i++){
			ABP = ABP +Double.parseDouble(list.get(i).toString());
		}
		TotalABP = ABP /list.size();
		return TotalABP;
	}
	
	public double AverageWeight(ArrayList<T> list){
			double AW=0, TotalAW = 0;
			for(int i = 0; i<list.size(); i++){
				AW = AW + Double.parseDouble(list.get(i).toString());
			}
			TotalAW = AW /list.size();
			return TotalAW;
	}
	
	public T MaxBloodPressure(ArrayList<T> list, int type1, int type2){
		T MAXBP = list.get(0);
		if(type1 == 4 && type2 == 8){//for cat (type1 == 4)=int && (type2 == 8)=double
			for(int i = 1; i<list.size(); i++){
				if(Double.parseDouble(MAXBP.toString()) < Double.parseDouble(list.get(i).toString())){
					MAXBP = list.get(i);
				}
			}
			return MAXBP;
		}else{//for dog 
			for(int i = 1; i<list.size(); i++){
				if(Integer.parseInt(MAXBP.toString()) < Integer.parseInt(list.get(i).toString())){
					MAXBP = list.get(i);
				}
			}
			return MAXBP;
		}
	}
	
	public T MaxWeight(ArrayList<T> list, int type1, int type2){
		if(type1 == 4 && type2 == 8){//for cat (type1 == 4)=int && (type2 == 8)=double
			T MAXW = list.get(0);
			for(int i = 1; i<list.size(); i++){
				if(Integer.parseInt(MAXW.toString()) < Integer.parseInt(list.get(i).toString())){
					MAXW = list.get(i);
				}
			}
			return MAXW;
		}else{//for dog 
			T MAXW = list.get(0);
			for(int i = 1; i<list.size(); i++){
				if(Double.parseDouble(MAXW.toString()) < Double.parseDouble(list.get(i).toString())){
					MAXW = list.get(i);
				}
			}
			return MAXW;
		}
	}
	
	public T MinBloodPressure(ArrayList<T> list, int type1, int type2){
		if(type1 == 4 && type2 == 8){//for cat (type1 == 4)=int && (type2 == 8)=double
			T MINBP = list.get(0);
			for(int i = 1; i<list.size(); i++){
				if(Double.parseDouble(MINBP.toString()) > Double.parseDouble(list.get(i).toString())){
					MINBP = list.get(i);
				}
			}
			return MINBP;
		}else{//for dog 
			T MINBP = list.get(0);
			for(int i = 1; i<list.size(); i++){
				if(Integer.parseInt(MINBP.toString()) > Integer.parseInt(list.get(i).toString())){
					MINBP = list.get(i);
				}
				if(Double.parseDouble(MINBP.toString()) > Double.parseDouble(list.get(i).toString())){
					MINBP = list.get(i);
				}
			}
			return MINBP;
		}
	}
	
	public T MinWeight(ArrayList<T> list, int type1, int type2){
		if(type1 == 4 && type2 == 8){//for cat (type1 == 4)=int && (type2 == 8)=double
			T MINW = list.get(0);
			for(int i = 1; i<list.size(); i++){
				if(Integer.parseInt(MINW.toString()) > Integer.parseInt(list.get(i).toString())){
					MINW = list.get(i);
				}
			}
			return MINW;
		}else{//for dog 
			T MINW = list.get(0);
			for(int i = 1; i<list.size(); i++){
				if(Double.parseDouble(MINW.toString()) > Double.parseDouble(list.get(i).toString())){
					MINW = list.get(i);
				}
			}
			return MINW;
		}
	}
	
}
