import java.util.ArrayList;
public class TripReservation {
    	ArrayList<BusCompany> registeredBusCompanies;
    	ArrayList<Ticket> soldTickets = new ArrayList<>();
    	ArrayList<Trip> designatedTrips;

    	public TripReservation(ArrayList<BusCompany> registeredBusCompanies) 
    	{
			this.registeredBusCompanies = registeredBusCompanies;
			designatedTrips = registeredBusCompanies.get(0).designatedTrips;
			for (int j = 1; j < this.registeredBusCompanies.size(); j++)
			{
				designatedTrips.addAll(this.registeredBusCompanies.get(j).designatedTrips);
			}
    	}

    	public void printAllRegisteredCompanies() //Printing all companies that have trips.
    	{
 			for (int i = 0; i < registeredBusCompanies.size(); i++)
				System.out.println(registeredBusCompanies.get(i).name);
    	}

    	public ArrayList<Trip> findAllTrips(String Source, String Destination, Date date1, Date date2, String seatType) //We searched for all trips in a for loop in wanted parameters.
    	{
			ArrayList<Trip> alltrips4 = new ArrayList<>();
			while (0 <= date2.compareTo(date1)) {
				for (int i = 0; i < designatedTrips.size(); i++) {
					if (designatedTrips.get(i).source.equals(Source) && designatedTrips.get(i).destination.equals(Destination) && (designatedTrips.get(i).date.compareTo(date1) == 0) && designatedTrips.get(i).seatType.equals(seatType))
						alltrips4.add(designatedTrips.get(i));
				}
				date1.day = date1.day +1;
			}
			return alltrips4;
    	}

    	public Trip findCheapestTrip(String source, String destination, Date date1, Date date2, String seatType) //We searched the cheapest trip in given parameters.
    	{
			int min = Integer.MAX_VALUE, index = -1;
			for (int i = 0; i < designatedTrips.size(); i++)
			{
				if ((designatedTrips.get(i).ticketPrice < min) && designatedTrips.get(i).source.equals(source) && designatedTrips.get(i).destination.equals(destination) && (designatedTrips.get(i).date.compareTo(date1) == 0))
				{
					min = designatedTrips.get(i).ticketPrice;
					index = i;
				}
			}
			return designatedTrips.get(index);
    	}

    	public Trip findCheapestTrip(String source, String destination, Date date1, Date date2) //We searched the cheapest trip in given parameters.
		{
			int min = Integer.MAX_VALUE, index = -1;
			while (0 <= date2.compareTo(date1))
			{
				for (int i = 0; i < designatedTrips.size(); i++) {
					if ((designatedTrips.get(i).ticketPrice < min) && designatedTrips.get(i).source.equals(source) && designatedTrips.get(i).destination.equals(destination) && (designatedTrips.get(i).date.compareTo(date1) == 0)) {
						min = designatedTrips.get(i).ticketPrice;
						index = i;
					}
				}
				date1.day = date1.day + 1;
			}
			return designatedTrips.get(index);
		}

		public Trip findCheapestTrip(String source, String destination, Date date) //Finding the 
		{
			int min = Integer.MAX_VALUE, index = -1;
			for (int i = 0; i < designatedTrips.size(); i++)
			{
				if ((designatedTrips.get(i).ticketPrice < min) && designatedTrips.get(i).source.equals(source) && designatedTrips.get(i).destination.equals(destination) && (designatedTrips.get(i).date.compareTo(date) == 0))
				{
					min = designatedTrips.get(i).ticketPrice;
					index = i;
				}
			}
			return designatedTrips.get(index);

		}

    	public Ticket sellTicket(Trip trip, String customerName, String customerSurname, String gender) //Selling a ticket for the customer. By taking information in the parameters.
    	{
    		Ticket aSoldTicket;
    		int pnrNo = Ticket.createPnrNo();
    		if (trip.numberOfSeats - trip.numberOfTicketsSold == 0)
    			return null;
    		else
			{
				aSoldTicket = new Ticket(customerName, customerSurname, gender, trip, pnrNo);
				trip.numberOfTicketsSold++;
			}
    		soldTickets.add(aSoldTicket);
    		return aSoldTicket;
    	}

    	public boolean cancelTicket(String customerSurname, int pnrNo) //Cancelled the ticket. First checked if it's bought. And if it is then checking the customer.
    	{
    		int test = 0;
			for (int i = 0; i < soldTickets.size(); i++)
			{
				if (soldTickets.get(i).customerSurname.equals(customerSurname) && soldTickets.get(i).pnrNo == pnrNo)
				{
					soldTickets.get(i).trip.numberOfTicketsSold--;
					soldTickets.remove(soldTickets.get(i));
					test++;
					break;
				}
				else return false;
			}
			if (test == 0)
				return false;
			else
				return true;

    	}
    	public ArrayList<Trip> findAllTrips(String Source, String Destination, Date date) //We searched for all trips in a for loop in wanted parameters.
    	{

			ArrayList<Trip> alltrips2 = new ArrayList<>();
			for (int i = 0; i < designatedTrips.size(); i++)
				if (designatedTrips.get(i).getSource().equals(Source) && designatedTrips.get(i).getDestination().equals(Destination) && (designatedTrips.get(i).date.compareTo(date) == 0))
					alltrips2.add(designatedTrips.get(i));

			return alltrips2;
		}

    	public ArrayList<Trip> findAllTrips(String Source, String Destination, Date date, String seatType) //We searched for all trips in a for loop in wanted parameters.
    	{
			ArrayList<Trip> alltrips3 = new ArrayList<>();
			for (int i = 0; i < designatedTrips.size(); i++) {
				if (designatedTrips.get(i).source.equals(Source) && designatedTrips.get(i).destination.equals(Destination) && (designatedTrips.get(i).date.compareTo(date) == 0) && designatedTrips.get(i).seatType.equals(seatType))
					alltrips3.add(designatedTrips.get(i));
			}

			return alltrips3;

    	}
    	public ArrayList<Trip> findAllTrips(String source, String destination, Date date1, Date date2) //We searched for all trips in a for loop in wanted parameters.
		{
			ArrayList<Trip> alltrips4 = new ArrayList<>();
			while (0 <= date2.compareTo(date1)) {
				for (int i = 0; i < designatedTrips.size(); i++) {
					if (designatedTrips.get(i).source.equals(source) && designatedTrips.get(i).destination.equals(destination) && (designatedTrips.get(i).date.compareTo(date1) == 0))
						alltrips4.add(designatedTrips.get(i));
				}
				date1.day = date1.day +1;
			}
			return alltrips4;
		}

}
