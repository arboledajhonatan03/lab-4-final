package model;
import java.util.ArrayList;

//Pets information

public class Pet{

	//Atributes 
	private static final String DOG = "dog";
	private static final String CAT = "cat";
	private static final String BIRD = "bird";
	private static final String OTHER = "other";
	private String namePet;
	private double weightPet;
	private double heightPet;
	private char typeOfPet;
	private int ageOfPet;
	private double imc;
	//Relations
    private Client owner;
	
	/*
	*P constructor
	*@param namePet the Pet name
	*@param weight the Pet weight
	*@param age the Pet age
	*@param type the Pet type
	*@param owner the  owner of the animal
	*/
	
	private ClinicalHistory history;
	public Pet (String namePet, double weightPet, double heightPet, String typeOfPet, int ageOfPet, String owner, double imc, Client owner){
		this.namePet = namePet;
		this.weightPet = weightPet;
		this.heightPet = heightPet;
		this.typeOfPet = typeOfPet;
		this.ageOfPet = ageOfPet;
		imc = calculateIMC();
		this.owner=owner;
	}
	
	
	
	public String getNamePet(){
		return namePet;
	}
	public void setNamePet (String namePet){
		this.namePet = namePet;
	}
	public double getWeightPet(){
		return weightPet;
	}
	public void setWeightPet (double weightPet){
		this.weightPet = weightPet;
	}
	public double getHeightPet(){
		return heightPet;
	}
	public void setHeightPet (double heightPet){
		this.heightPet = heightPet;
	}
	public String getTypeOfPet(){
		return typeOfPet;
	}
	public void setTypeOfPet (String typeOfPet){
		this.typeOfPet = typeOfPet;
	}
	public int getAgeOfPet(){
		return ageOfPet;
	}
	public void setAgeOfPet (int ageOfPet){
		this.ageOfPet = ageOfPet;
	}
	public Client getOwner(){
		return owner;
	}
	public void setOwner(Client owner){
		this.owner = owner;
	}
	
	/*metod :idOwnerr
	*to return the identifier of the owner<br>
	*pre: The mascot  was created before and the owner must be not null<br>
	*post: the owner's identifier is delivered<br>
	*@return the ID of the owner
	*/
	
	public String idOwner(){
		return owner.getID();
	}
	
	/*
	*to return the pet's details
	*@return the details of the pet
	*/
	
	public String showInfoPet(){
	String msj = "";
	msj += "Name: " + namePet + "\n";
	msj += "Age: " + ageOfPet + "\n";
	msj += "Weight: " + weightPet + "\n";
	msj += "Height: " + heightPet + "\n";
	msj += "Type of animal: " + typeOfPet + "\n";
	return msj;
	}
	
	/**
	*Description This method allows to calculate the imc for a pet.
	*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.
	*post: The IMC is calculated.
	*@return The pet body mass index. Returns -1 if the height is zero  due to the division on zero does not exist.
	*/
	public double calculateIMC(){
		return weight/(height * height);
	}
}