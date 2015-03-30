/**
 * @author emilysager, itscharlieb
 */
package network;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCommunicator {
	private Connection aConnection;


	public DatabaseCommunicator() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to find postgres driver.");
		}

		aConnection = null;
		try {
			aConnection = DriverManager.getConnection(
					"jdbc:postgresql://db2.cs.mcgill.ca:5432/CS421", //host
					"ecallo1", "rFIbIPY*"
					//	"cs421g34", //username
					//	"cisicvijo" //password
					);
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database server.");
		}
	}

	public void test()
	{ 
		//TODO 
	}

	public void getTable(String pTableName)
	{
		try
		{ 
			Statement lQuery = aConnection.createStatement();
			ResultSet lResultSet = lQuery.executeQuery("SELECT * FROM " + pTableName);
			ResultSetMetaData lData = lResultSet.getMetaData();
			int lNumColumns =  lData.getColumnCount();
			int i = 1;
			for (int j = 1; j<lNumColumns; j++)
			{
				System.out.print(lData.getColumnLabel(j) + " ");
			}
			System.out.println("");
			while(lResultSet.next())
			{
				while (i < lNumColumns)
				{

					System.out.print(lResultSet.getString(i) + " ");
					i++;
				}
				if (i == lNumColumns)
				{
					i =  1; 
					System.out.println("");
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void CoachesForClub (String pClubName)
	{

		try 
		{ 
			Statement lQuery = aConnection.createStatement(); 

			ResultSet lResultSet = lQuery.executeQuery(
					"SELECT firstName, lastName " +  
							"FROM Coach " + 
							"WHERE clubName = '" + pClubName + "'"
					);
			while (lResultSet.next())
			{
				System.out.println(lResultSet.getString("firstName") + " " + lResultSet.getString("lastName")); 
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void WinnerOfRace (String pRaceID)
	{
		int lRaceID = Integer.parseInt(pRaceID);
		try 
		{ 
			Statement lQuery = aConnection.createStatement(); 
			ResultSet lResultSet = lQuery.executeQuery(""); //TODO 

			while (lResultSet.next())
			{
				System.out.println(lResultSet.getString("firstName") + " " + lResultSet.getString("lastName")); 
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void RacerOnMountain(String pMountainName)
	{
		try 
		{
			Statement lQuery = aConnection.createStatement(); 
			ResultSet lResultSet = lQuery.executeQuery(
					"SELECT DISTINCT lastName, firstName " + 
							"FROM Racer, CompetesIn " +
							"WHERE CompetesIn.raceID = ANY ( " +
							"SELECT Race.raceID " +
							"FROM Race " +
							"WHERE Race.mountainName = '" + pMountainName + "'" + ")"
					); 
			System.out.println("The racers who raced on " + pMountainName + " are: ");
			while (lResultSet.next())
			{
				System.out.println(lResultSet.getString("firstName") + " " + lResultSet.getString("lastName")); 
			}

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void AllRuntimes(String  pRaceID)
	{
		try 
		{
			Statement lQuery = aConnection.createStatement(); 
			ResultSet lResultSet = lQuery.executeQuery(
					"SELECT RacerID, runNum.runNumber, time " +

					"FROM ( " +
								"(SELECT runNumber " +
								"FROM ConsistsOf " +
								"WHERE RaceID = " + pRaceID + ") AS runNum " +

								"INNER JOIN " +

								"(SELECT * FROM HasTime) AS t "+
								"ON runNum.runNumber = t.runNumber " +
						")"
					);

System.out.println("RacerID runNumber time ");
			while (lResultSet.next())
			{
				System.out.println(lResultSet.getString("RacerID") + " " + lResultSet.getString("runNumber") + " " + lResultSet.getString("time") ); 
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
