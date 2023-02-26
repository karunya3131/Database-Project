package database;

/*Author: S.Karunya Ganashree 
 * Project: Airline Reservation System
 * The Project performs functions such as adding, displaying,
 * searching, updating and deleting airline details with SQL database,
 * which is connected using JDBC*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/*	There are some  rules to connect a java program to the database,they are
 * 1.Load the driver
 * 2.Register the driver
 * 3.Create the connection
 * 4.Create the statements
 * 5.Execute the queries
 * 6.Get the resultSet
 * 7.Close the connection*/

public class DriverClass {

	/*"createConnection" method performs operations such as 
	 * register the driver and create the connection. The first step is
	 * "load the driver" is performed by loading JDBC into the Classpath.
	 * These  operations are surrounded by "try-catch" as there is a
	 * chance of exception, if the connection did not open*/
	public static Connection createConnection() {
		Connection connection=null;
		try {

			//username and password are given SQL
			String userName = "root";
			String passWord = "Karunya@31//";

			//register the SQL driver
			Class.forName("com.mysql.jdbc.Driver");

			//create the connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedatabase",userName,passWord);
		}
		catch(Exception obj) {
			System.out.println(obj);
		}
		return connection;
	}
	public static void main(String[] args)throws SQLException {

		//object for the "AirlineDatabase" class is created to access the methods in it.
		AirlineDatabase object = new AirlineDatabase();

		//connection created is returned, which is captured here
		Connection connectionData = createConnection() ;
		Scanner scan=new Scanner(System.in);

		//object for the "Airline" class is created to access the methods in it
		Airline airline_newobject=new Airline();

		/* "checkingcredentials" method is called using object created for
		 * "Airline" class to perform login process  */
		airline_newobject.checkingcredentials();

		System.out.println("\n..........| WELCOME TO ROYAL AIRLINES |..........\n");

		System.out.println(" * TO ADD AN AIRLINE      --> PRESS 1");
		System.out.println(" * TO DISPLAY THE AIRLINE --> PRESS 2");
		System.out.println(" * TO SEARCH AN AIRLINE   --> PRESS 3");
		System.out.println(" * TO DELETE AN AIRLINE   --> PRESS 4");
		System.out.println(" * TO UPDATE AN AIRLINE   --> PRESS 5");
		System.out.println(" * TO LOGOUT              --> PRESS 6");

		/*"adminChoice" is a variable that is declared to hold
		 * the inputed value to be passed to switch. */
		byte adminChoice;
		do {
			adminChoice = scan.nextByte();

			/*calls the non static method using the object of the class 
			 * "Airline" based on the value on "adminChoice" that is 
			 * given by the user and performs the corresponding process.*/
			switch(adminChoice) {
			case 1:
				object.toaddAirline(connectionData);
				break;
			case 2:
				object.todisplayAirline(connectionData);
				break;
			case 3:
				object.tosearchAirline(connectionData);
				break;
			case 4:
				object.todeleteAirline(connectionData);
				break;
			case 5:
				object.toupdateAirline(connectionData);
				break;
			case 6:
				airline_newobject.toLogOut();
			}
		}
		while(adminChoice!=6);

		scan.close();
		connectionData.close();
	}
}
