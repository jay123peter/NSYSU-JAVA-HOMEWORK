package myjava.homework;

import java.util.Objects;

public class Animal <T,K>{

	private String id;
	private String sex;
	private T weight;
	private K bloodpressure;
	
	//Construction initialization
	public Animal(String id, String sex, T weight, K bloodpressure) {
		this.id = id;
		this.sex = sex;
		this.weight = weight;
		this.bloodpressure = bloodpressure;
	}
	
	//get id
	public String id(){
		return this.id;
	}
	
	//get sex
	public String sex(){
		return this.sex;
	}
	
	//get weight 
	public T weight(){
		return this.weight;
	}
	
	//get bloodpressure()
	public K bloodpressure(){
		return this.bloodpressure;
	}
	
	@Override
	public boolean equals(Object animal){//Determine whether they are equal

		if (animal == null) {
            return false;
        }
		
        if (getClass() != animal.getClass()) {
            return false;
        }
        
        final Animal other = (Animal) animal;
        
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        
        if (!Objects.equals(this.bloodpressure, other.bloodpressure)) {
            return false;
        }
        
        return true;

	}
	
	@Override
	public int hashCode(){
        return Objects.hash(id,sex,weight,bloodpressure);
        /*int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.sex);
        hash = 47 * hash + Objects.hashCode(this.weight);
        hash = 47 * hash + Objects.hashCode(this.bloodpressure);
        return hash;*/
	}
	
	@Override
	public String toString(){
		return id.toString()+", "+sex.toString()+", "+bloodpressure.toString()+", "+weight.toString();
		//return String.format("(%s, %s, %s, %s)", id, sex, bloodpressure, weight);
	}

}
