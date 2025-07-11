package GarageManagement;

public enum Services 
{
	OIL_CHANGE_SERVICE("Oil Change",500),
	GENERAL_SERVICING("General Servicing",1500),
	ENGINE_REPARING("Engine Repair",5000),
	CAR_WASH("Car Wash",300);
	
	private final String Service;
	private final int Price;
	 Services(String Service,int Price)
	{
		 this.Service=Service;
		 this.Price=Price;
	}
	public String getService() 
	{
		return Service;
	}
	public int getPrice() 
	{
		return Price;
	}
	
	 
}
