package database;

import java. util.Scanner;

public class Airline {
	//Created all attributes in private so that no one can access them, only inside the class we can have the access.
	private String airline_name, origin, destination,airlineUnique_id;
	private int seating_availability, fare;

	private static final Scanner constant = new Scanner(System.in);	


	/*Here we used setter method for the airline_id to set the value
	 *This keyword is refers to the current class object and also as the names are similar we used this keyword.
	 *Here we used getter method for the airline_id to return it's value in a string type.
	 */
	public void setairline_id(String airlineUnique_id)
	{
		this.airlineUnique_id = airlineUnique_id;
	}
	public String getairline_id()
	{
		return airlineUnique_id;
	}


	/*Here we used setter method for the airline_name to set the value
	 *This keyword is refers to the current class object and also as the names are similar we used this keyword.
	 *Here we used getter method for the airline_name to return it's value in a string type.
	 */
	public void setairline_name(String airline_name)
	{
		this.airline_name = airline_name;
	}
	public String getairline_name()
	{
		return airline_name;
	}


	/*Here we used setter method for the origin to set the value
	 *This keyword is refers to the current class object and also as the names are similar we used this keyword.
	 *Here we used getter method for the origin to return it's value in a string type.
	 */
	public void setorigin(String origin)
	{

		this.origin = origin;
	}
	public String getorigin()
	{
		return origin;
	}

	/*Here we used setter method for the destination to set the value
	 *This keyword is refers to the current class object and also as the names are similar we used this keyword.
	 *Here we used getter method for the destination to return it's value in a string type.
	 */
	public void setdestination(String destination)
	{
		this.destination = destination;
	}
	public String getdestination()
	{
		return destination;
	}


	/*Here we used setter method for the seating_availability to set the value
	 *This keyword is refers to the current class object and also as the names are similar we used this keyword.
	 *Here we used getter method for the seating_availability to return it's value in a string type.
	 */
	public void setseating_availability(int seating_availability)
	{
		this.seating_availability = seating_availability;
	}
	public int getseating_availability()
	{
		return seating_availability;
	}

	/*Here we used setter method for the fare to set the value
	 *This keyword is refers to the current class object and also as the names are similar we used this keyword.
	 *Here we used getter method for the fare to return it's value in a string type.
	 */
	public void setfare(int fare)
	{
		this.fare = fare;
	}
	public int getfare()
	{
		return fare;
	}

	/* Login is a static method and also a parameterized method 
	 * Inside this method we have a if condition which checks whether the entered ownername and password matches the given values
	 * If it is true it will execute the following print statements.
	 * if above condition fails it will come to else condition and execute the print statement
	 * Also in else condition if the credentials are wrong it will call the recheckingcredentials method
	 * Suddenly it will go to that method which is in ReservationClass class.
	 */
	public static void loginDetails(String admin_name,String admin_password) 
	{

		Airline airline_newobject=new Airline();

		if(admin_name.equals("ROYAL") && admin_password.equals("31@royal" ))  
		{
			System.out.println("\nYOU HAVE SUCCESSFULLY LOGGED IN..\n");

		}
		else
		{
			System.out.println("\nPLEASE CHECK YOUR CREDENTIALS");
			airline_newobject.checkingcredentials();
		}
	}

	// Created a non-static method to get the name and password from the user as input .
	public void checkingcredentials() {

		System.out.println("      WELCOME TO ROYAL AIRLINES        \n");
		System.out.println("TO LOG IN,GIVE THE NECESSARY DETAILS BELOW\n");

		System.out.print("\nENTER THE ADMIN NAME: ");
		String admin_name = constant.next();

		System.out.print("\nENTER THE ADMIN PASSWORD: ");
		String admin_password = constant.next();

		loginDetails(admin_name,admin_password);
	}
	public void toLogOut() {

		// Here it simply logged out if we enter the matching value

		System.out.println("Logged out successfully.");

	}

	public String toString() {
		return airline_name+" "+airlineUnique_id+" "+origin+" "+destination+" "+seating_availability+" "+fare;
	}
}
