/**
 * @author emilysager, itscharlieb
 */
package GUI;

import java.util.Scanner;

import com.sun.tools.javac.comp.Enter;

import network.DatabaseCommunicator;

public class OptionMenu {

	private String aCoachesForAGivenClub; 
	private String aRacersOnMountain; 
	private String aAllRuntimes; 
	private boolean userWantsToQuit; 
	private DatabaseCommunicator aSkiDB; 

	public OptionMenu () 
	{ 
		aCoachesForAGivenClub = "Return all the coaches who coach for a given club"; 
		aRacersOnMountain = "Return all the Racers who have raced on a given mountain"; 
		aAllRuntimes = "Returns all the runtimes for a given race"; 
		userWantsToQuit = false;
		aSkiDB = new DatabaseCommunicator();
	}

	public boolean doesUserWantsToquit() 
	{
		return userWantsToQuit;
	}

	public void performOption(String lSelectedOption) 
	{
		if (lSelectedOption.equals("1"))
		{
			QueryCoachesForAGivenClub(); 
		}
		if (lSelectedOption.equals("2"))
		{
			QueryRacersOnMountain(); 
		}
		if (lSelectedOption.equals("3"))
		{
			QueryAllRunTimes();
		}
		if (lSelectedOption.equals("4"))
		{
			getTable(); 
		} 
		if (lSelectedOption.equals("5"))
		{
			QueryTwoRaces(); 
		}
		if (lSelectedOption.equals("6"))
		{
			addRacer();
		}
		if (lSelectedOption.equals("7"))
		{
			userWantsToQuit = true; 
		}
	}
	private void addRacer() 
	{
		System.out.println("Enter the RacerID");
		String lRacerID = receiveUserInput(); 
		System.out.println("Enter the first name");
		String lFirstName = receiveUserInput(); 
		System.out.println("Enter the last name of the racer" );
		String lLastName = receiveUserInput();
		System.out.println("Enter the coachID of the racer's coach");
		String lCoach = receiveUserInput();
		System.out.println("Enter the club name of the racer");
		String lClub = receiveUserInput();
		
		aSkiDB.addRacer(lRacerID, lFirstName, lLastName, 1000, 999.99, lCoach, lClub); 
	}

	private void QueryTwoRaces() 
	{
		aSkiDB.twoRaces();
	}

	private void getTable() 
	{
		System.out.println("Please enter the Table you'd like to view");
		String lTable = receiveUserInput();
		aSkiDB.getTable(lTable);	
	}

	private void QueryAllRunTimes() 
	{
		System.out.println("Please enter the RaceID:");
		String RaceID = receiveUserInput();
		aSkiDB.AllRuntimes(RaceID);
	}
	
	private void QueryRacersOnMountain() 
	{
		System.out.println("Please enter the Mountain Name:");
		String lMountainName = receiveUserInput();
		aSkiDB.RacerOnMountain(lMountainName);
	}
	
	private void QueryCoachesForAGivenClub() 
	{
		System.out.println("Please enter the ClubName:");
		String lClubName = receiveUserInput();
		aSkiDB.CoachesForClub(lClubName);
	}

	public  void displayOptions () 
	{ 
		System.out.println("Please enter the option number for one of the options displayed below: ");
		System.out.println(" 1. " + aCoachesForAGivenClub);
		System.out.println(" 2. " +  aRacersOnMountain);
		System.out.println(" 3." +  aAllRuntimes);
		System.out.println("4. " + "Returns all the entries in a table"  );
		System.out.println("5. Returns all racers who have competed in at least two races");
		System.out.println("6. Insert a Racer");
		System.out.println("7. Quit");

	}
	
	public String receiveUserInput()
	{
		Scanner lScanner  = new Scanner(System.in); 
		String lInput = lScanner.nextLine(); 
		return lInput; 
	}




}
