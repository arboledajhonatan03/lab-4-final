package model;
public class Medicament {
	
	//Atributes

	private String name;
	private double dose;
	private double costDose;
	private double frecuency;
	
	/**
	*Medicament constructor
	*@param name the name of the medicine. This param must be not null.
	*@param dose the dose of the medicine for the patient. This param must be not null.
	*@param costDose the cost of each dose
	*@param frequency the frequency of the medicine
	*/

	public Medicament (String name, double dose, double costDose, double frecuency){
		this.name = name;
		this.dose = dose;
		this.costDose = costDose;
		this.frecuency = frecuency;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public double getDose(){
		return dose;
	}
	public void setDose(double dose){
		this.dose = dose;
	}
	public double getCostDose(){
	return costDose;
	}
	public void setCostDose(double costDose){
		this.costDose = costDose;
	}
	public double getFrecuency(){
		return frecuency;
	}
	public void setFrecuency(double frecuency){
		this.frecuency = frecuency;
	}
	
	/**
	*This method calculates the cost of the medicament<br>
	*pre: The drug was created before and its attributes dose and costDose must be not null.<br>
	*post: The cost is calculated.<br>
	*@return the cost of the medicament
	*/
	
	public double calculatedDose(){
		double doseXcost = 0.0;
		doseXcost += dose*costDose;

		return doseXcost;
	}
}