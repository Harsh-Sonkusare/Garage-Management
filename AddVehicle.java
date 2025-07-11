package GarageManagement;
import java.time.LocalTime;
import java.time.LocalDate;
//import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
public class AddVehicle extends Billing
{
	private int total_price=0;
	int i=0;
	private Services services;
	private String name;
	private long contact;
	public void setDrop_date(LocalDate drop_date) {
		this.drop_date = drop_date;
	}
	private String veh_number;
	private String veh_model;
	//private String service[]=new String[4];
	//private int price[]=new int[4];
	private String veh_type;
	private LocalDate drop_date;
	private String drop_time;
	ArrayList<String>Services=new ArrayList<String>();
	ArrayList<String>service=new ArrayList<String>();
	ArrayList<Integer>Price=new ArrayList<Integer>();
	public AddVehicle(String name, long contact, String veh_number, String veh_model, String veh_type) 
	{
		
		this.name = name;
		this.contact = contact;
		this.veh_number = veh_number;
		this.veh_model = veh_model;
		this.veh_type = veh_type;
	}

	public String getName() {
		return name;
	}

	public void setDrop_time(LocalTime drop_time) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("hh:mma");
		String ampm=drop_time.format(dtf);
		this.drop_time = ampm;
	}

	public long getContact() {
		return contact;
	}

	public String getVeh_number() {
		return veh_number;
	}
	
	public String getDrop_time() {
	
		return drop_time;
	}

	public String getVeh_model() {
		return veh_model;
	}

	public String getVeh_type() {
		return veh_type;
	}
	public void Services(String Service,int price) 
	{
		Services.add(Service);
		service.add(Service);
		Price.add(price);
	}
	public int ServicePriceList()
	{
		System.out.println("\nVehicle : "+veh_number+" ("+veh_model+")"+ "\nOwner   : "+name );
		System.out.println("Services Availed :");
		for(String s:service)
		{
			System.out.printf("- %-18s ₹%d\n",s,Price.get(i));
			total_price=total_price+Price.get(i);
			i++;
		}
		return total_price;
	}
	 public void garage_log() throws Exception
	{
		BufferedWriter garage_log=new BufferedWriter(new FileWriter("C:\\Users\\sonku\\Documents\\garage_log.txt",true));
		garage_log.write(filedata());
		garage_log.close();
	}
	public String filedata()
	{
		return "Date 	   : "+drop_date+"\nTime  	   : "+drop_time+"\nOwner      : "+name+"\nContact    : "+
				contact+"\nVehicle    : "+veh_number+"\nServices   : "+Services+"\nPrice      : "+Price +"\nTotal Bill : "+total_price+"\n------------------------------------------------------------\n";
	}
	public String toString()
	{
		return  "Drop-Time : "+drop_time+ "\nVehicle No : " + veh_number + "\nModel : " + veh_model + "\nOwner : " + name + "\nServices : "
				+ Services;
	}
	public String toString1()
	{
		return "-------------------------------\nTotal Bill Amount :  ₹"+ServicePriceList();
	}
	public String toString2()
	{
		return "Status        : "+VehicleSearch.status+"\nOwner         : "+name+"\nContact       : "+contact+"\nVehicle Model : "+veh_model+"\nType          : "+veh_type+"\nDrop Time     : "+drop_time;
	}
}