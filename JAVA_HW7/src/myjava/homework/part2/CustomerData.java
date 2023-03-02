package myjava.homework.part2;

public class CustomerData {

	private int productA = 0;
	private int productB = 0;
	private int productC = 0;
	private String idsex = new String();
	
	//constructor initializes
	public CustomerData(String producttype,String idsex) {
		//for first building customer data
		if(producttype.equals("Product_A")){
			this.productA = 1;
		}else if(producttype.equals("Product_B")){
			this.productB = 1;
		}else if(producttype.equals("Product_C")){
			this.productC = 1;
		}
		
		this.idsex = idsex;
	}
	
	// add once for you buy product
	public void setproductA(){
		this.productA += 1;// this.productA  = this.productA +1;
	}
	
	public void setproductB(){
		this.productB += 1;
	}
	
	public void setproductC(){
		this.productC += 1;
	}
	
	//set customer sex
	public void setidsex(String idsex){
		this.idsex = idsex;
	}
	
	//get customer buy how much product
	public int getproductA(){
		return productA;
	}
	
	public int getproductB(){
		return productB;
	}
	
	public int getproductC(){
		return productC;
	}
	
	//get customer sex
	public String getidsex(){
		return idsex;
	}

}
