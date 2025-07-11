package GarageManagement;

import java.util.ArrayList;
import java.util.HashMap;

public class VehicleSearch extends PendingVehicles
{
	static AddVehicle searchVehicle;
	static String status;
	static HashMap<String,AddVehicle>serviced_Vehicle=new HashMap<String,AddVehicle>(ServicedVehicle.serviced_Vehicle);
	static HashMap<String,AddVehicle>pending_Vehicle=new HashMap<String,AddVehicle>(PendingVehicles.pending_Vehicle1);
	static public void search(String VehicleNum)
	{
		if(serviced_Vehicle.containsKey(VehicleNum))
		{
			status="Serviced";
			searchVehicle=serviced_Vehicle.get(VehicleNum);
			System.out.println(searchVehicle.toString2());
		}
		else if(pending_Vehicle.containsKey(VehicleNum))
		{
			status="Pending";
			searchVehicle=pending_Vehicle.get(VehicleNum);
			System.out.println(searchVehicle.toString2());
		}
		else
		{
			System.out.println("Vehicle not found");
		}
	}
	
}
