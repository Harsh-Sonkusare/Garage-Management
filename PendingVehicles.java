package GarageManagement;
import java.util.ArrayList;
import java.util.HashMap;
public class PendingVehicles 
{
	static ArrayList<AddVehicle>pending_Vehicle=new ArrayList<AddVehicle>();
	static HashMap<String,AddVehicle>pending_Vehicle1=new HashMap<String,AddVehicle>();
	static void pendingVehicle(AddVehicle vehicle)
	 {
		 pending_Vehicle.add(vehicle);
	 }
	static void DisplayPendingVehicle()
	 {
		 for(AddVehicle vehicle:pending_Vehicle)
		 {
			 System.out.println(vehicle);
			 System.out.println();
		 }
	 }
}
