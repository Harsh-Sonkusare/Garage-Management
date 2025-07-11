package GarageManagement;
import java.util.ArrayList;
import java.util.HashMap;
public class ServicedVehicle 
{
	static HashMap<String,AddVehicle>Serviced=new HashMap<String,AddVehicle>();
	static HashMap<String,AddVehicle>serviced_Vehicle=new HashMap<String,AddVehicle>();
	static public void numberMatch(String key,AddVehicle pending_Vehicle)
	{
		Serviced.put(key, pending_Vehicle);
	}
	static public String MarkServiced(String Vnumber,AddVehicle Vehicle)
	{
		if(Serviced.containsKey(Vnumber))
		{
			serviced_Vehicle.put(Vnumber,Serviced.get(Vnumber));
			PendingVehicles.pending_Vehicle.remove(Serviced.remove(Vnumber));
			
			return "Vehicle marked as serviced\n";
		}
		return "Vehicle not found\n";
	}
}
