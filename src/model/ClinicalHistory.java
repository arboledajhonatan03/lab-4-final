package model;
import java.util.ArrayList;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class ClinicalHistory{
	
	//Atributes
	
	private static final String STATE_OPEN = "abierto";
	private static final String STATE_CLOSE = "cerrado";
	private String symptom;
	private String diagnostic;
	private boolean state;
	
	//Relations 
	
	private ArrayList<Medicament> medicaments;
	private HistorialDate date;
	private HistorialDate dateExit;
	private Pet data;
	
	
	public ClinicalHistory (String symptom, String diagnostic, boolean state, Date admissionDate,Date exitDate, Pet data){
		this.symptom = symptom;
		this.diagnostic = diagnostic;
		this.state = state;
		this.admissionDate=admissionDate;
    	this.exitDate=exitDate;
		medicaments = new ArrayList<Medicament>();
		this.data = data;
	}
	public String getSymptom(){
		return symptom;
	}
	public void setSymptom (String symptom){
		this.symptom = symptom;
	}
	public String getDiagnostic(){
		return diagnostic;
	}
	public void setDiagnostic (String diagnostic){
		this.diagnostic = diagnostic;
	}
	public boolean getState(){
		return state;
	}
	public void setState (boolean state){
		this.state = state;
	}
	public Date getAdmissionDate(){
    	return admissionDate;
    }
    public void setAdmissionDate(Date admissionDate){
    	this.admissionDate=admissionDate;
    }
    public Date getExitDate(){
    	return exitDate;
    }
    public void setExitDate(Date exitDate){
    	this.exitDate=exitDate;
    }
	}
	public void addMedicine(Medicament medicine){
        medicaments.add(medicine);
    }
	public Pet getData(){
		return data;
	}
	public void setData(Pet data){
		this.data =	data;
	}
	/**
	*Add new medication to the clinical history
	*@param medicine1 the medicine to add
	*/
    public void addMedicines(Medicament medicine1){
        medicaments.add(medicine1);
    }
	
	/**
	*to calculate the days hospitalized<br>
	*pre: the clinic history was created before and the join date must be not null<br>
	*post: the days hospitalized is calculated<br>
	*@return the days hospitalized
	*/
	
    public int daysHospitalized(){
        int days = 0;
        if(exitDate == null){
            GregorianCalendar date = new GregorianCalendar(admissionDate.getYear(), admissionDate.getMonth() - 1, admissionDate.getDay());
            GregorianCalendar actualDate = new GregorianCalendar();
            while (true) {
                if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
                    && (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
                    && (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
                    break;
                }
                date.add(Calendar.DAY_OF_MONTH, 1);
                days++;
            }
        }
        else{
            GregorianCalendar date = new GregorianCalendar(admissionDate.getYear(), admissionDate.getMonth() - 1, admissionDate.getDay());
            GregorianCalendar actualDate = new GregorianCalendar(exitDate.getYear(), exitDate.getMonth() - 1, exitDate.getDay());
            while (true) {
                if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
                    && (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
                    && (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
                    break;
                }
                date.add(Calendar.DAY_OF_MONTH, 1);
                days++;
            }
        }
        return days;
    }
	
	/**
	*to calculate the cost of the hospitalization service
	*@return the cost of the hospitalized service
	*/
	
	public double hospitalizationCost(){
        double cost = 0.0;
        if(datas.getType() == 'c'){
            if(datas.getWeight() >= 1.0 && datas.getWeight() <= 3.0){
                cost = 10000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 3.1 && datas.getWeight() <= 10.0){
                cost = 12000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 10.1 && datas.getWeight() <= 20.0){
                cost = 15000.0*daysHospitalized();
            }
            else if (datas.getWeight() > 20.0){
                cost = 20000.0*daysHospitalized();
            }
        }
        else if(datas.getType() == 'd'){
            if(datas.getWeight() >= 1.0 && datas.getWeight() <= 3.0){
                cost = 15000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 3.1 && datas.getWeight() <= 10.0){
                cost = 17000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 10.1 && datas.getWeight() <= 20.0){
                cost = 20000.0*daysHospitalized();
            }
            else if (datas.getWeight() > 20.0){
                cost = 25000.0*daysHospitalized();
            }
        }
        else if(datas.getType() == 'b'){
            if(datas.getWeight() >= 1.0 && datas.getWeight() <= 3.0){
                cost = 10000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 3.1 && datas.getWeight() <= 10.0){
                cost = 12000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 10.1 && datas.getWeight() <= 20.0){
                cost = 20000.0*daysHospitalized();
            }
            else if (datas.getWeight() > 20.0){
                cost = 25000.0*daysHospitalized();
            }
        }
        else if(datas.getType() == 'o'){
            if(datas.getWeight() >= 1.0 && datas.getWeight() <= 3.0){
                cost = 10000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 3.1 && datas.getWeight() <= 10.0){
                cost = 17000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 10.1 && datas.getWeight() <= 20.0){
                cost = 30000.0*daysHospitalized();
            }
            else if (datas.getWeight() > 20.0){
                cost = 33000.0*daysHospitalized();
            }
        
        }
        for(int i = 0; i < medicines.size(); i++){
            cost += medicines.get(i).calculatedDose();
        }
        return cost;
    }
	
	public String addMedicament(String name, double dose, double costDose, double frecuency){
		String msg ="";
		if (name!=null ){
			msg="Se pudo agregar";
			Medicament drug = new Medicament(name,dose,costDose,frecuency);
			medicaments.add(drug);
		}
		else{
			msg="No se puedo Agregar la medicina";
		}
		return msg;
    }
	
	/**
	*Description This method allows to add new notes to the possible diagnostic during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: New notes were added to the possible diagnostic in the patient clinic story.
	*@param notes  notes of possible diagnostic. This param must be not null.
	*/
	public void addNotesToHospitalizationFatality(String notes){
		this.diagnostic += "\n "+notes;
	}
	
	/**
	*Description This method allows to add a new symptom presented during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: A new symptom were added to the patient clinic story.
	*@param symptoms new symptom presented. This param must be not null.
	*/
	public void addSymptoms(String symptoms){
		this.symptom += "\n "+symptoms;
	}
}