package model;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
/**
*This class contains the information of the services
*/
public class Service {
	
	//atributes 
	
	public static final String PET_BATHV="Pet bath in the veterinary";
	public final static String PET_BATHD="Pet bath at home";
	public static final String NAIL_CUTTING="Nail cutting";
	public final static String DENTA_PRO="Dental prophylaxis";
	public static final String VACCINATIONS="Vacine";
	private String type;
	private double cost;
	private String idPet;
	private String idOwner;

	//relations
	
	private Date realization;
	private Mascot theMascot;

	/**
	name:Costructor Service 
	 @param type the type of the service 
	 @param realization the realization  of the service
	 @param theMascot   theMascot  the Mascot to whom the service was performed
	*/
	
	public Service(String type,Date realization,Pet theMascot){
		this.type=type;
		this.realization=realization;
		this.theMascot=theMascot;
		idPet=theMascot.getNamePet();
		cost=costService();
		idOwner=theMascot.idOwerr();

	}
	public String  getType(){
		return type;
	}
	public void setType(String type){
		this.type=type;

	}
	public double getCost(){
		return cost;

	}
	public void setCost(double cost){
		this.cost=cost;
	}
	public String getIdPet(){
		return idPet;
	}
	public void setIdPet(String idPet){
		this.idPet=idPet;
	}
	public String getIdOwner(){
		return idOwner;
	}
	public void setIdOwner(String idOwner){
		this.idOwner=idOwner;
	}
	public Date getRealization(){
		return realization;
	}
	public void setRealization(Date realization){
		this.realization=realization;
	}
	public Pet getTheMascot(){
		return theMascot;
	}
	public void setTheMascot(Pet theMascot){
		this.theMascot=theMascot;
	}

	/**
	  Calculates the cost of the service<br>
	  pre: the service was created before and the type must be not null<br>
	  post: the cost is calculated<br> 
	  @return the cost of the type service 
	*/
	public double costService(){

		double theCost=0.0;


		if (type.equals(PET_BATHV)){
			theCost=20000.0;

		}
		else if (type.equals(PET_BATHD)){
			theCost=30000.0;
		}
		else if (type.equals(NAIL_CUTTING)){
			theCost=8000.0;
		}
		else if (type.equals(DENTA_PRO)){
			theCost=12000.0;

		}
		else if (type.equals(VACCINATIONS)){
			theCost=45000.0;
		}
	return theCost;


	}

	/**
	*to calculate the days realization service<br>
	*pre: the clinic history was created before and the join date must be not null<br>
	*post: the date of the service made since the beginning of the time is obtained <br>
	*@return the days realization of the service
	 */
	public int calculateDate(){

		int days =0;
		GregorianCalendar date = new GregorianCalendar(realization.getYear(), realization.getMonth() - 1, realization.getDay());
		GregorianCalendar actualDate = new GregorianCalendar(0,0,1);
		while (true) {
			if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH)) && (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))&& (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
				break;
			}
		actualDate.add(Calendar.DAY_OF_MONTH, 1);
		days++;
		}
		return days;
	}

	/**
	*This method is used to give the reports of the services given some dates
	*pre: the services can not be null
	*@return service reports message
	*/
	public String toString(){
		String msg="";

		msg="----------------------------------------------------"+"\n";
		msg+=  " Type of service: "+type+"\n";
		msg+= " Cost of service: "+cost+"\n";
		msg+= " The pet's name: "+idPet+"\n";
		msg+= " Identification of the owner: "+idOwner+"\n";
		msg+= " Date of realization: "+realization.getDay()+"/"+realization.getMonth()+"/"+realization.getYear()+"\n";
		msg+="----------------------------------------------------";

	return msg ;
	}
}