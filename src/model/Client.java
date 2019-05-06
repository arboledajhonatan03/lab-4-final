package model;
import java.util.ArrayList;

//Client's information.

public class Client{
	
	//Atributes
	
	private String name;
	private String identify;
	private String address;
	private String numTel;
	
	//Relations
	
	private ArrayList<Pet> pets;
	
	/*
	*Client constructor
	*@param name the name
	*@param identify the identifier
	*@param address the address
	*@param numTel the phone number
	*/

	public Client(String name, String identify, String address, String numTel){
		this.name = name;
		this.identify = identify;
		this.address = address;
		this.numTel = numTel;
		pets = new ArrayList<Pet>();
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getIdentify(){
		return identify;
	}
	public void setIdentify(String identify){
		this.identify = identify;
	}
	public String getAddress(){
		return address;
	}
	public void setaddress(String address){
		this.address = address;
	}
	public String getNumTel(){
		return numTel;
	}
	public void setNumTel(String numTel){
		this.numTel = numTel;
	}
	public ArrayList<Pet> getPets(){
		return pets;
	}
	public void setPets(ArrayList<Pet> Pets){
		this.pets = pets;
	}
	
	/**
	*to add a pet<br>
	*pre:The client was created before and the pet is initialized<br>
	*post: The new pet were added to the client<br>
	*@param newPet the pet to add
	*/
	
	public void addPet(Pet newPet){
		pets.add(newPet);
	}
	
	/*
	*to return the contact details
	*@return the contact details of the client
	*/
	
	public String infoClient(){
		String msj = "";
		msj += "Name: " + name + "\n";
		msj += "ID: " + identify+ "\n";
		msj += "Address: " + address + "\n";
		msj += "Tel: " + numTel + "\n";
		msj += "\n";
		int j = 0;
		for(int i = 0; i<pets.size(); i++){
			++j;
			msj += "Pet"+ j + "";
			msj += "\n";
			msj += pets.get(i).showInfoPet();
			msj += "\n";
		}
		return msj;
	}
	
	/*
	*to return the needed pet<br>
	*pre: The name of the pet that it want be finded<br>
	*post: the pet searched<br>
	*@return the needed pet
	*/
	
	public Pet findPet(String nampe){

	Pet finded = null;
	boolean found = false;

		for(int i = 0; i<pets.size() && !found; i++){

			if(pets.get(i).getNamePet().equals(nampe)){
				finded = pets.get(i);
				found = true;
			}

		}
		return finded;
	}
	
	/*
	*to return the name of the pets that the client has<br>
	*pre: The client was created before and mascot is initialized<br>
	*post: the names of the pets is delivered<br>
	*@return the name of the pets 
	*/
	
	public String petNames(){
		String msg = "";
		int pos = 1;
		for(int j=0;j<pets.size();j++){
			msg += pos+". "+pets.get(j).getNamePet()+"\n";
		}
		return msg;
	}
	
	/*
	*Description This method allows to update the basic data of a veterinary client, these data include, address and phone number.
	*pre: The client was created before.
	*post: The address and /or phone number of the client is updated.
	*@param address The new address of the client. This param could be empty.
	*@param telePhone The new phone number of the client. This param could be empty.
	*/
	
	public void modificDatas(String address, String telePhone){
		this.address = address;
		numTel=telePhone;
	}

}
