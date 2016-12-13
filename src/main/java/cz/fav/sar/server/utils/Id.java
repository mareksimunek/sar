package cz.fav.sar.server.utils;

public class Id {
	public long number;
	public int year;
	
	public Id(int year, long number)
	{
		this.year = year;
		this.number = number;
	}
	
	public long getId()
	{
		return Long.valueOf(year+""+number);
	}
}
