public class Date 
{
    	int day, month, year;

    	public Date(String date)
    	{
		int index1 = date.indexOf("/");
		int index2 = date.lastIndexOf("/");
		this.day = Integer.parseInt(date.substring(0,index1));
		this.month = Integer.parseInt(date.substring(index1 + 1, index2));
		this.year = Integer.parseInt(date.substring(index2 + 1));
    	}
   		public Date(int day, int month, int year)
    	{
        	this.day = day;
        	this.month = month;
        	this.year = year;
    	}
    	public String toString()
    	{
        	return String.format("%d/%d/%d", day, month, year);
    	}
    	public int compareTo(Date date2)
    	{
    		if (this.day == date2.day)
    			return 0;
    		else
    			return (this.day - date2.day);
    	}
	public int getDay()
	{
		return this.day;
	}
	public int getMonth()
	{
		return this.month;
	}
	public int getYear()
	{
		return this.year;
	}

}
