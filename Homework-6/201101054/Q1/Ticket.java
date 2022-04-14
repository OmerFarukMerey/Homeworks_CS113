public class Ticket {
    	
    	String customerName, customerSurname, gender;
    	int pnrNo;
    	Trip trip;
    	static int unique = 0;
	// By using a static variable named unique we made a unique pnrNo for all the passengers.

    	public Ticket(String customerName, String customerSurname, String gender, Trip trip, int pnrNo)
    	{
    		unique++;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.gender = gender;
		this.pnrNo = unique;
		this.trip = trip;

    	}

    	public String toString()
    	{
        	return String.format("Ad soyad:%s %s Yolculuk tarihi:%S Saat:%s Kalkis:%s Varis:%s Firma:%s Koltuk Tipi:%s PNR:%s", customerName, customerSurname, trip.getDate().toString(), trip.getDepartureTime(), trip.getSource(), trip.getDestination(), trip.getCompanyName(), trip.getSeatType(), pnrNo);

    	}
	public int getPnrNo()
	{
		return this.pnrNo;
	}
	public static int createPnrNo()
	{
		return unique;
	}
   


}
