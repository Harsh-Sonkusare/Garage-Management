package GarageManagement;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Garage 
{
	
	static ArrayList<AddVehicle> Adding_Vehicle=new ArrayList<AddVehicle>();
	static ArrayList<String>Vehicle_Number=new ArrayList<String>();
	AddVehicle NewVehicle;
	Scanner sc=new Scanner(System.in);
	void showWelcomeScreen()
	{
		System.out.println("🔧 Welcome to Turbo Garage 🔧");
		System.out.println("=============================");
	}
	void DisplayMenuBar() throws Exception
	{
		while(true)
		{
		showWelcomeScreen();
		System.out.println();
		System.out.println("1. Add New Vechile for Service");
		System.out.println("2. View Pending Vehicles");
		System.out.println("3. Mark Vehicle as Serviced");
		System.out.println("4. Generate Bill");
		System.out.println("5. Search Vehicle");
		System.out.println("6. Exit");
		System.out.println();
		System.out.print("Enter your choice : ");
		int choose=sc.nextInt();
		System.out.println();
		switch(choose)
		{
		case 1 :
			System.out.println("--- Add New Vehicle ---");
			System.out.print("Enter Owner Name : ");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.print("Enter Contact : ");
			long contact=0;
			try
			{
				contact=sc.nextLong();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid entry");
				sc.nextLine();
				continue;
			}
			System.out.print("Enter Vehicle Number : ");
			String number=sc.next();
			Vehicle_Number.add(number);
			System.out.print("Enter Vehicle Model : ");
			sc.nextLine();
			String model=sc.nextLine();
			System.out.print("Enter Vehicle Type(car/bike) : ");
			String type=sc.next();
		    NewVehicle=new AddVehicle(name, contact, number, model, type);
		    NewVehicle.setDrop_time(LocalTime.now());
		    NewVehicle.setDrop_date(LocalDate.now());
			Adding_Vehicle.add(NewVehicle);
			PendingVehicles.pendingVehicle(NewVehicle);
			PendingVehicles.pending_Vehicle1.put(number, NewVehicle);
			System.out.println("\nSelect Service :  ");
			System.out.println("1. Oil Change (₹500) ");
			System.out.println("2. General Servicing (₹1500)");
			System.out.println("3. Engine Repair (₹5000)");
			System.out.println("4. Car Wash (₹300)");
			System.out.println("Enter service numbers separated by comma");
			System.out.print("(e.g. 1,4) : ");
			sc.nextLine();
			String choice=sc.nextLine();
			String option[]=choice.split(",");
			for(String o:option)
			{
				int Service=Integer.parseInt(o.trim());
				switch(Service)
				{
				case 1 :
					Services oil=Services.OIL_CHANGE_SERVICE;
					NewVehicle.Services(oil.getService(),oil.getPrice());
					break;
				case 2 :
					Services general=Services.GENERAL_SERVICING;
					NewVehicle.Services(general.getService(),general.getPrice());
					break;
				case 3 :
					Services engine=Services.ENGINE_REPARING;
					NewVehicle.Services(engine.getService(),engine.getPrice());
					break;
				case 4 :
					Services wash=Services.CAR_WASH;
					NewVehicle.Services(wash.getService(),wash.getPrice());
					break;
				default :
					System.out.println("\t Invalid Selection");
					break;
				}
			}
			ServicedVehicle.numberMatch(number,  NewVehicle);
			System.out.println("Vehicle added successfully for service!\n");
			System.out.println("Press Enter to return to main menu...");
			sc.nextLine();
			break;
		case 2 :
			System.out.println("--- Pending Vehicle ---");
			PendingVehicles.DisplayPendingVehicle();
			System.out.println("Press Enter to return to main menu...");
			sc.nextLine();
			sc.nextLine();
			break;
		case 3 :
			System.out.print("Enter Vehicle Number to mark as\nserviced : ");
			System.out.println(ServicedVehicle.MarkServiced(sc.next(),NewVehicle));
			System.out.println("Press Enter to return to main menu...");
			sc.nextLine();
			sc.nextLine();
			break;
		case 4 :
			System.out.println("--- Bill ---");
			System.out.print("Enter vehicle number : ");
			Billing bills=new Billing();
			bills.GenerateBill(sc.next());
			System.out.println("\nPress Enter to return to main menu...");
			sc.nextLine();
			sc.nextLine();
			break;
		case 5 :
			System.out.print("Enter vehicle number : ");
			String number0=sc.next();
			System.out.println("--- Search Vehicle ---");
			VehicleSearch.search(number0);
			System.out.println("\nPress Enter to return to main menu...");
			sc.nextLine();
			sc.nextLine();
			break;
		case 6 :
			System.out.println("Thank you for using Turbo Garage\nHave a great day!");
			return;
			
		}
	   }
	}
	public static void main(String[] args) throws Exception
	{
		Garage customer=new Garage();
		customer.DisplayMenuBar();
	}
	
}
