/**
 * @author emilysager, itscharlieb
 */
package network;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCommunicator 
{
	private Connection aConnection;

	/**
	 * DatabaseCommunicator constructor 
	 * Creates a connection to a Trottier database account
	 */
	public DatabaseCommunicator() 
	{
		try
		{		
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to find postgres driver.");
		}
		aConnection = null;
		try 
		{
			aConnection = DriverManager.getConnection(
					"jdbc:postgresql://db2.cs.mcgill.ca:5432/CS421", //host
					"ecallo1", "rFIbIPY*"
					//	"cs421g34", //username
					//	"cisicvijo" //password
					);
		} 
		catch (SQLException e) 
		{
			System.out.println("Failed to connect to the database server.");
		}
	}
	
	public ResultSet getRacer(String pFirstName, String pLastName){
		try {
			Statement lQuery = aConnection.createStatement();
			ResultSet lResultSet = lQuery.executeQuery("SELECT racerID FROM Racer WHERE firstName = '" + pFirstName + "' AND lastName = '" + pLastName + "'");
			return lResultSet;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}


	public void getTable(String pTableName)
	{
		try
		{ 
			Statement lQuery = aConnection.createStatement();
			ResultSet lResultSet = lQuery.executeQuery("SELECT * FROM " + pTableName);
			FormatResults(lResultSet);
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
			FormatResults(lResultSet);
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
			FormatResults(lResultSet);

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void twoRaces()
	{
		try 
		{
			Statement lQuery = aConnection.createStatement(); 
			ResultSet lResultSet = lQuery.executeQuery(
					"SELECT C.racerID, C.raceID " +  
							"FROM ( " +
							"SELECT racerID " +
							"FROM CompetesIn " +
							"GROUP BY racerID " +
							"HAVING COUNT(*) > 1 " +
					") " +
					"AS CurrentRacer " +  
					"INNER JOIN CompetesIn C " +
					"ON C.racerID = CurrentRacer.racerID ");		
			FormatResults(lResultSet);
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
			FormatResults(lResultSet);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Parses a ResultSet into an SSV
	 * @param pResultSet
	 * @throws SQLException
	 */
	public static void FormatResults(ResultSet pResultSet) throws SQLException
	{
		ResultSetMetaData lData = pResultSet.getMetaData();
		int lNumColumns =  lData.getColumnCount();
		int i = 1;
		for (int j = 1; j<=lNumColumns; j++)
		{
			System.out.print(lData.getColumnLabel(j) + " ");
		}
		System.out.println("");
		while(pResultSet.next())
		{
			while (i <= lNumColumns)
			{

				System.out.print(pResultSet.getString(i) + " ");
				i++;
			}
			if (i == (lNumColumns +1) )
			{
				i =  1; 
				System.out.println("");
			}
		}
	}

	public void addRacer(String lRacerID, String lFirstName, String lLastName,
			int i, double d, String lCoach, String lClub) {
		int x = Integer.parseInt(lRacerID);
		try 
		{
			PreparedStatement lPreparedStatement  = aConnection.prepareStatement("INSERT INTO RACER (racerID, firstName, lastName,  coach, clubName, rank, points) "
					+ "VALUES (?, ?, ? , ? , ?,  ?, ? )" );
			lPreparedStatement.setInt(1, Integer.parseInt(lRacerID));
			lPreparedStatement.setString(2, lFirstName);
			lPreparedStatement.setString(3, lLastName);
			lPreparedStatement.setInt(4,Integer.parseInt( lCoach));
			lPreparedStatement.setString(5, lClub);
			lPreparedStatement.setInt(6, 1000);
			lPreparedStatement.setDouble(7, 999.99);
			System.out.println("[psql] Insert Successful.");
		}
		catch (SQLException e)
		{
			System.out.println("Unable to Insert:  " + e.getMessage());
		}
		
	}
}
