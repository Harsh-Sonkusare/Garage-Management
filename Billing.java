package GarageManagement;

import java.util.ArrayList;

public class Billing extends ServicedVehicle 
{
	AddVehicle Bill;
	//static ArrayList<AddVehicle>pending_Vehicle=new ArrayList<AddVehicle>(PendingVehicles.pending_Vehicle);
	public void GenerateBill(String Vno) throws Exception
	{
		if(serviced_Vehicle.containsKey(Vno))
		{
			Bill=serviced_Vehicle.get(Vno);
			serviced_Vehicle.remove(Vno);
			PendingVehicles.pending_Vehicle1.remove(Vno);
			System.out.println(Bill.toString1());
			System.out.println("-------------------------------");
			System.out.println("Bill generated successfully!");
			Bill.garage_log();
		}
		else
		{
			System.out.println("Vehicle not found");
		}
	}
	
}
