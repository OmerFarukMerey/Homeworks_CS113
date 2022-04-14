public class Trip
{
    	String companyName, source, destination, departureTime, arrivalTime, seatType;
    	int ticketPrice, numberOfSeats, numberOfTicketsSold;
    	Date date;
    	//source variable refers to the name of the departure city and destination refers to the arrival city.

    	public Trip(String companyName, String source, String destination, int ticketPrice, Date date, String departureTime, String arrivalTime, String seatType, int numberOfSeats)
    	{
        	numberOfTicketsSold = 0;
        	this.companyName = companyName;
        	this.source = source;
        	this.destination = destination;
        	this.ticketPrice = ticketPrice;
        	this.date = date;
        	this.departureTime = departureTime;
        	this.arrivalTime = arrivalTime;
        	this.seatType = seatType;
        	this.numberOfSeats = numberOfSeats;
    	}
	public Date getDate()
	{
		return this.date;
	}
	public String getDepartureTime()
	{
		return this.departureTime;
	}
	public String getSource()
	{
		return this.source;
	}
	public String getDestination()
	{
		return this.destination;
	}
	public String getCompanyName()
	{
		return this.companyName;
	}
	public String getArrivalTime()
	{
		return this.arrivalTime;
	}
	public String getSeatType()
	{
		return this.seatType;
	}
	public String toString()
		{
			return String.format("%s tarihinde %s saatinde %s şehrinden %s şehrine %s firmasının %s araci bulunmaktadır. Fiyat: %d TL, boş koltuk sayısı:%d", date.toString(), departureTime, source, destination, companyName, seatType, ticketPrice, (numberOfSeats - numberOfTicketsSold));
		}
}
