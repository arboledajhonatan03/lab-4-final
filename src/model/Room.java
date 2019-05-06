package model;
public class Room{
	private boolean available;
	private int numRoom;
	private ClinicalHistory history;
	public Room(boolean available, int numRoom, ClinicalHistory history;){
		this.available=available;
		this.numRoom=numRoom;
		this.history=history;
	}
	public boolean getAvailable(){
		return available;
	}
	public void setAvailable(boolean available){
		this.available = available;
	}
	public int getNumRoom(){
	return numRoom;
	}
	public void setNumRoom(int numRoom){
		this.numRoom = numRoom;
	}
	public ClinicHilstory getHistory(){
	return history;
	}
	public void setHistory(ClinicalHistory history){
		this.history=history;
	}
	
	/**
	*to get the cost of the hospitalization<br>
	*pre: the availability is false and the history must be not null<br>
	*post: the cost of the hospitalization is calculated<br>
	*@return the cost of the hospitalization
	*/
	public double hospitalizeCost(){
		return history.hospitalizationCost();
	}
	
	public String showRoomInformation(){
	String msj ="";
	msj += "If he is busy\n 1. And if it is not busy 2. False: "+""+available+"\n";
    msj += "The mini room number is:"+numRoom+"\n";

	return msj;
	}
	
	/**
	*@param name 
	*@param dose 
	*@param costDose 
	*@param frecuency 
	*/

	public String medicamentHistory(String name, double dose, double costDose, double frecuency){
		String msg="";
		msg=history.addMedicament(name, dose, costDose, frecuency);
		return msg;
	}
	
	/**
	*This method is useful to be able to add a new notes 
	*@param notes new notes
	*/

	public void addNotesToPet(String notes){
	  history.addNotesToHospitalizationFatality(notes);
	}
	
	/**
	*This method is useful to be able to add a new symptom
	*@param symptoms new symptoms
	*/

	public void addSymptomsToPet(String symptoms){
	  history.addSymptoms(symptoms);
	}
}