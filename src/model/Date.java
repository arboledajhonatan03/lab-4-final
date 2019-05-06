package model;

/**
*The Dates
*/

public class Date{

	//Atributes 

	private int day;
	private int month;
	private int year;
	
	/**
	*Date constructor
	*@param day the day
	*@param month the month
	*@param year the year
	*/

	public Date (int day, int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	/**
	*Gets the day
	*@return the day
	*/

	public int getDay(){
		return day;
	}
	
	/**
	*Sets the day
	*@param day the day
	*/
	
	public void setDay(int day){
		this.day=day;
	}

	/**
	*Gets the month
	*@return the month
	*/

    public int getMonth(){
		return month;
	}
	
	/**
	*Sets the month
	*@param month the month
	*/
	
	public void setMonth(int month){
		this.month=month;
	}

	/**
	*Gets the year
	*@return the year
	*/
	
	public int getYear(){
		return year;
	}
	
	/**
	*Sets the year
	*@param year the year
	*/

	public void setYear(int year){
		this.year=year;
	}


}