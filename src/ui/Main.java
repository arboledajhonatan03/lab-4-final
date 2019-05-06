package ui;
import model.*;
import java.util.Scanner;
public class Main{
	private Veterinary veti;
	private Scanner reader;
	//initializer
	public Main(){
		init ();
		reader = new Scanner (System.in);
	}
	public static void main (String[] args){
		Main m = new Main();
		m.showWelcome();
		m.showMenu();
		m.showOptions();
	}
	public void showWelcome(){
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("      -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-    ");
		System.out.println("           _-WELCOME TO MY LITTLE PET-_          ");
		System.out.println("      -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-    ");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
	}
	public void showOptions(){
		System.out.println("Please selec the option that you want ejecute: ");
		System.out.println("1. Add a client.");
		System.out.println("2. Hospitalize a pet.");
		System.out.println("3. Discharging a pet.");
		System.out.println("4. The total incomes");
		System.out.println("5. Show client's information");
		System.out.println("6. Exit");
		
	}
	public void showMenu(){
		int userInput = 0;
		while (userInput!=6){
			showOptions();
			userInput = reader.nextInt();
			reader.nextLine();
			System.out.println("\n");
			
			if(userInput==1){
				System.out.print("Type the client's name: ");
				String name1 = reader.nextLine();
				System.out.print("Type the client's ID: ");
				String id1 = reader.nextLine();
				System.out.print("Type the client's address: ");
				String address1 = reader.nextLine();
				System.out.print("Type the client's number phone: ");
				String tel1 = reader.nextLine();
				Client newClient = new Client(name1, id1, address1, tel1);
				System.out.println("How many pets the costumer will leave at the Veterinary? ");
				int numPets = reader.nextInt();
				reader.nextLine();
				int i = 1;
				for(int j=0;j<numPets;j++){
					System.out.println("\n");
					System.out.println("Pet number "+(i)+":");
					i++;
					System.out.println("Type the pet's name: ");
					String namePet = reader.nextLine();
					System.out.println("Type the pet's weight: ");
					double weightPet = reader.nextDouble();
					reader.nextLine();
					System.out.println("Type the kind of pet (DOG, CAT, BIRD or OTHER for another type): ");
					String typePet = reader.nextLine();
					System.out.println("Type the pet's age: ");
					int agePet = reader.nextInt();
					reader.nextLine();
					
					Pet newPet = new Pet(namePet, weightPet, typePet, agePet, name1, null);
					newClient.addPet(newPet);
				}
				veti.addClient(newClient, id1);
				System.out.println("The new client has been registered successfully.");
			}
			else if(userInput==2){
				int error = 0;
				while (error == 0){
					System.out.println("owner's identifier:");
					String id2 = reader.nextLine();
					if(veti.findCustomer(id2)){
						System.out.println("¿What pet do you want to hospitalize?");
						System.out.println(veti.petNames(id2));
						int option = reader.nextInt();
						System.out.println("¿What are the symptoms?");
						String symptoms = reader.nextLine();
						System.out.println("¿What is the diagnostic?");
						String diagnostic = reader.nextLine();
						Pet petHos = veti.hallarCliente(id2).getPets().get(option-1);
						System.out.println("Day to join:");
						int tDay = reader.nextInt();
						reader.nextLine();
						System.out.println("Month to join:");
						int tMonth = reader.nextInt();
						reader.nextLine();
						System.out.println("Year to join:");
						int tYear = reader.nextInt();
						reader.nextLine();
						HistorialDate today = new HistorialDate(tDay, tMonth, tYear);
						ClinicalHistory newClinic = new ClinicalHistory(symptoms, diagnostic, true, today,  null);
						System.out.println("¿How many medicines has the pet?");
						int quantityMedicines = reader.nextInt();
						reader.nextLine();
						for(int i = 0; i < quantityMedicines; i++){
							System.out.println("");
							System.out.println("What is the name of the medicine?");
							String nameMedicine = reader.nextLine();
							System.out.println("How many doses has the medicine?");
							double quantityDoses = reader.nextDouble();
							reader.nextLine();
							System.out.println("What is the price for dose?");
							double valorDose = reader.nextDouble();
							reader.nextLine();
							System.out.println("What is the frequency to take the medicine?");
							double frequency = reader.nextDouble();
							reader.nextLine();
							Medicament temporal = new Medicament(nameMedicine, quantityDoses, valorDose, frequency);
							newClinic.addMedicine(temporal);
						}
						veti.petHospitalize(newClinic);
						System.out.println("The pet was hospitalized successfully");
						error = 1;
					}
					else{
						System.out.println("The client wasn't finded, please enter the identifier again");
					}
				}
			}
				else if(userInput==3){
					System.out.println(veti.showClients());
					System.out.println("Type the client's ID for show him pets.");
					String idClient = reader.nextLine();
					System.out.println("Enter the pet's name to high.");
					String namePet1 = reader.nextLine();
					System.out.println(veti.findToHospitalize(idClient,namePet1));
				}
				else if(userInput==4){
					System.out.println("Type the current day");
					int actualDay = reader.nextInt();
					reader.nextLine();
					System.out.println("Type the current month.");
					int actualMonth = reader.nextInt();
					reader.nextLine();
					System.out.println("Type the current year");
					int actualYear = reader.nextInt();
					reader.nextLine();
					veti.totalIncomes(actualDay, actualMonth, actualYear);
					System.out.println("Los ingresos totales son: "+veti.totalIncomes(actualDay, actualMonth, actualYear));
				}
			else if(userInput==5){
				System.out.println(veti.showClients());
			}
			else{
				userInput=6;
			}
		}
	}
	public void init(){
		Client client1 = new Client("Jhon Jairo","114","Cra 76 #1a-35","3231159415");
		Client client2 = new Client("Anderson","121","Cra 76 #2b-47","3217222027");
		
		HistorialDate date1 = new HistorialDate (22,03,2018);
		HistorialDate dateExit1 = new HistorialDate(10,03,2019);
		HistorialDate date2 = new HistorialDate (20,02,2018);
		HistorialDate dateExit2 = new HistorialDate(20,02,2019);
		HistorialDate date3 = new HistorialDate (26,03,2019);
		
		ClinicalHistory history1 = new ClinicalHistory("Itchy", "Critical", true, date1, dateExit1);
		ClinicalHistory history2 = new ClinicalHistory("Fever ", "low risk", true, date2, dateExit2);
		ClinicalHistory history3 = new ClinicalHistory("Infecte bite", "high risk", true, date3,null);	
		
		Pet pet1 = new Pet("Sasha",20.0,"DOG",3,"Jhon Jairo",history1);
		Pet pet2 = new Pet("Chester",22.0,"CAT",5,"Anderson",history2);
		Pet pet3 = new Pet("Firulais",30.0,"DOG",6,"Anderson",history3);
		client1.getPets().add(pet1);
		client2.getPets().add(pet2);
		client2.getPets().add(pet3);
		
		Medicament medicine1 = new Medicament("Clomicalm",15.0,10.000,23.0);
		Medicament medicine2 = new Medicament("Amfipen",13.0,12.000,24.0);
		Medicament medicine3 = new Medicament("Syvaquinol",11.0,9.000,14.0);
		Medicament medicine4 = new Medicament("Albendex",10.0,8.000,9.0);
		
		history1.addMedicine(medicine1);
		history1.addMedicine(medicine2);
		history2.addMedicine(medicine3);
		history3.addMedicine(medicine4);
		
		Room room1 = new Room(false,1,null);
		Room room2 = new Room(false,2,null);
		Room room3 = new Room(false,3,null);
		Room room4 = new Room(false,4,null);
		Room room5 = new Room(true,5,pet2);
		Room room6 = new Room(false,6,null);
		Room room7 = new Room(true,7,pet1);
		Room room8 = new Room(true,8,pet3);
		Room[] rooms = {room1,room2,room3,room4,room5,room6,room7,room8};
		
		veti = new Veterinary();
     	veti.setRooms(rooms);
		veti.getHistorial().add(history1);
		veti.getHistorial().add(history2);
        veti.getHistorial().add(history3);
		veti.getClients().add(client1);
		veti.getClients().add(client2);


	}
}