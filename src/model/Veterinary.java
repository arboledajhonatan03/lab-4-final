/*Name: Jhonatan Steven Arboleda Velez
  code: A00358993
  Algoritmos y programacion I
  Laboratorio IV
*/
package model;
import java.util.*;
import java.time.*;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
public class Veterinary{
	private Room[] rooms;
	private ArrayList<Client> clients;
	private ArrayList<ClinicalHistory> historial;
	public Veterinary(){
		rooms = new Room[8];
		clients = new ArrayList<Client>();
		historial = new ArrayList<ClinicalHistory>();
	}
	public Room[] getRooms(){
		return rooms;
	}
	public void setRooms(Room[] rooms){
		this.rooms = rooms;
	}
	public ArrayList<Client> getClients(){
		return clients;
	}
	public void setClients(ArrayList<Client> clients){
		this.clients = clients;
	}
	public ArrayList<ClinicalHistory> getHistorial(){
		return historial;
	}
	public void setHistorial(ArrayList<ClinicalHistory> historial){
		this.historial = historial;
	}
	public void addHistory(ClinicalHistory newHistory){
		historial.add(newHistory);
	}
	public String addClient(Client client, String id1){
		String msg = "";
		boolean search = searchClient(id1);
		if(search!=false){
			msg = "No se puede agregar este cliente porque el cliente ya existe.";
		}
		else{
			msg = "Se pudo agregar el cliente exitosamente.";
			clients.add(client);
		}
		return msg;
	}
	public String petNames(String id2){
		String msg = "";
		boolean foundClient = false;
		if(findCustomer(id2)){
			for(int j=0;j<clients.size() && !foundClient;j++){
				if(id2.equals(clients.get(j).getIdentify())){
					msg = clients.get(j).petNames();
					foundClient = true;
				}
			}
		}
		return msg;
	}
	public boolean searchClient(String id1){
		boolean listo = false;
		for(int j=0;j<clients.size() && !listo;j++){
			if(clients.get(j).getIdentify().equals(id1)){
				listo=true;
			}
		}
		return listo;
	}
	public String showClients(){
	String msj = "";
	msj += clients.size();
	for(int j = 0 ; j<clients.size(); j++){
		msj +=  (j+1) + ". \n";
		msj += clients.get(j).infoClient();
	}
	msj += "\n";
	return msj;
	}
	public double totalIncomes(int actualDay, int actualMonth, int actualYear){
		double total = 0.0;
		for(int j=0;j<clients.size();j++){
			total+=clients.get(j).incomesForPets(actualDay, actualMonth, actualYear);
		}
		return total;
	}
	public String findToHospitalize(String idClient, String namePet1){
		String msj = "";
		Pet pety = null;
		for(int i =0; i<clients.size() && pety==null; i++){
			if(idClient.equals(clients.get(i).getIdentify())){
				pety = clients.get(i).findPet(namePet1);
				if(pety==null){
					msj = "Este cliente no tiene ninguna mascota con ese nombre.";
				}
				else{
					boolean way = false;
					for(int j = 0; j < rooms.length && !way; j++){
						if(rooms[i].getAvailable()){
							if(rooms[i].getPet().getNamePet().equals(namePet1)){
								rooms[i].setPet(null);
								way= true;
								rooms[i].setAvailable(true);
								msj = "Ya no está hospitalizado el animal.";
							}
							else{
								msj = "No se encuentra el animal.";
							}
						}
						else{
							msj = "Todas las habitaciones estan desocupadas";
						}
					}
				}
			}
		}
		return msj;
	}
	public Client hallarCliente(String id2){
		Client client1 = null;
		boolean stop = false;
		if(findCustomer(id2)){
			for(int j=0;j<clients.size() && !stop;j++){
				if(id2.equals(clients.get(j).getIdentify())){
					client1 = clients.get(j);
					stop = true;
				}
			}
		}
		return client1;
	}
	public void petHospitalize (ClinicalHistory newClinic){
		boolean available = false;
		for(int j=0;j<rooms.length && !available;j++){
			if(rooms[j].getAvailable()){
				rooms[j].setAvailable(false);
				available = true;
			}
		}
	}
	public boolean findCustomer(String id2){
		boolean foundClient = false;
		for(int j=0;j<clients.size() && foundClient;j++){
			if(id2.equals(clients.get(j).getIdentify())){
				foundClient = true;
			}
		}
		return foundClient;
	}
}