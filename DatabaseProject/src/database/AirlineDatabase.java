package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AirlineDatabase {

	public static final Scanner scanner_object=new Scanner(System.in);

	/* "toaddAirline" method performs insertion of airline details 
	 * to SQL through java with the help of "PreparedStatement".
	 * Whenever the values are dynamic and the user is going to give input,
	 * "PreparedStatement" is used.Any type of query can be given here. 
	 * "executeUpdate" method is used whenever a change is going to
	 *occur inside the table in the database,it returns the integer value
	 *"set" method sets the values with respect to the number of columns given. 
	 */

	public void toaddAirline(Connection connectionData) throws NullPointerException,SQLException{

		PreparedStatement add_state = connectionData.prepareStatement("INSERT INTO AIRLINE_DETAILS VALUES(?,?,?,?,?,?)");
		System.out.println("ENTER THE AIRLINE_ID: ");
		add_state.setString(1,scanner_object.next());
		scanner_object.nextLine();
		System.out.println("ENTER THE AIRLINE_NAME: ");
		add_state.setString(2,scanner_object.nextLine());
		System.out.println("ENTER THE AIRLINE_ORIGIN: ");
		add_state.setString(3,scanner_object.nextLine());
		System.out.println("ENTER THE AIRLINE_DESTINATION: ");
		add_state.setString(4,scanner_object.nextLine());
		System.out.println("ENTER THE AIRLINE_SEATING_CAPACITY: ");
		add_state.setInt(5,scanner_object.nextInt());
		System.out.println("ENTER THE AIRLINE_FARE: ");
		add_state.setInt(6,scanner_object.nextInt());
		int airline_add = add_state.executeUpdate();
		System.out.println(airline_add +" ADDED SUCCESSFULLY");

	}

	/* "todisplayAirline" method displays all the records in the table
	 * from the database. "Statement" is used, whenever to write the 
	 * queries in java and read the values from the database.The result 
	 * got is stored using the "ResultSet", using which the result is displayed
	 */

	public void todisplayAirline(Connection connectionData) throws NullPointerException,SQLException {
		Statement newState=connectionData.createStatement();
		ResultSet save_result=newState.executeQuery("SELECT * FROM  AIRLINE_DETAILS");
		System.out.println("THE ARILINE WE HAVE CURRENTLY ARE LISTED BELOW:\n");
		/*"next" method checks whether there is next record and 
		 * produces the record, if it is available. "getString" method
		 * prints the records by using  the column number
		 */
		while(save_result.next()) {
			System.out.println(save_result.getString(1)+"  "+save_result.getString(2)+"  "+save_result.getString(3)+"  "+save_result.getString(4)+"  "+save_result.getInt(5)+"  "+save_result.getInt(6));
		}
	}

	/* "tosearchAirline" method searches whether the user given id 
	 * is available in the database or not. "executeQuery" method is
	 * used, whenever the queries in database is to be executed here,
	 * to display the result. The result got is stored using the "ResultSet",
	 * using which the result is displayed. 
	 */
	public void tosearchAirline(Connection connectionData) throws NullPointerException,SQLException {
		PreparedStatement search_state = connectionData.prepareStatement("SELECT * FROM AIRLINE_DETAILS WHERE Airline_id=?");
		System.out.println("ENTER THE AIRLINE_ID TO SEARCH: ");
		String display_id =scanner_object.next();
		search_state.setString(1,display_id);
		ResultSet record_result=search_state.executeQuery();
		while(record_result.next()) {
			System.out.println(record_result.getString(1)+" "+record_result.getString(2)+" "+record_result.getString(3)+" "+record_result.getString(4)+" "+record_result.getInt(5)+" "+record_result.getInt(6));
		}
	}

	/* "todeleteAirline" method deletes the record related to the
	 * id given by the user."executeUpdate" method is used whenever
	 * a change is going to occur inside the table in the database,
	 * it returns the integer value
	 */
	public void todeleteAirline(Connection connectionData) throws NullPointerException,SQLException {
		PreparedStatement delete_state = connectionData.prepareStatement("DELETE FROM AIRLINE_DETAILS WHERE Airline_id=? ");
		System.out.println("ENTER THE AIRLINE_ID TO DELETE: ");
		String delete_airline =scanner_object.next();
		delete_state.setString(1,delete_airline);
		int airline_delete= delete_state.executeUpdate();
		System.out.println(airline_delete+" DELETED SUCCESSFULLY");

	}

	/*"toupdateAirline" method updates the changes made, into the
	 * table in the database."executeUpdate" method is used whenever
	 * a change is going to occur inside the table in the database,
	 * it returns the integer value
	 */
	public void toupdateAirline(Connection connectionData) throws NullPointerException,SQLException {
		PreparedStatement update_value = connectionData.prepareStatement("UPDATE AIRLINE_DETAILS SET seating_capacity = ? WHERE airline_id = ?");
		System.out.println("ENTER THE AIRLINE ID TO UPDATE : ");
		String airline_id = scanner_object.next();
		System.out.println("ENTER THE SEATING CAPACTIY :");
		int seating_capacity = scanner_object.nextInt();
		update_value.setInt(1,seating_capacity);
		update_value.setString(2,airline_id);
		int airline_update = update_value.executeUpdate();
		System.out.println(airline_update +" UPDATED SUCCESSFULLY");

	}
}

