package GUI;

import java.util.Scanner;

public class OptionMenu {

	private String aCoachesForAGivenClub; 
	private String aRacersOnMountain; 
	private String aWinnerOfRace; 
	private String aAllRuntimes; 
	private boolean userWantsToQuit; 

	public OptionMenu () 
	{ 
		aCoachesForAGivenClub = "Return all the coaches who coach for a given club"; 
		aRacersOnMountain = "Return all the Racers who have raced on a given mountain"; 
		aWinnerOfRace = "Returns the winner of a given race"; 
		aAllRuntimes = "Returns all the runtimes for a given race"; 
		userWantsToQuit = false;
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
			QueryWinnerOfRace(); 
		}
		if (lSelectedOption.equals("4"))
		{
			QueryAllRunTimes();
		}
		if (lSelectedOption.equals("5"))
		{
			userWantsToQuit = true; 
		}
	}
	private void QueryAllRunTimes() 
	{
		System.out.println("Please enter the RaceID:");
		String RaceID = receiveUserInput();
		//Call Charlie's Code
	}
	
	private void QueryWinnerOfRace() 
	{
		System.out.println("Please enter the RaceID:");
		String RaceID = receiveUserInput();
		//Call Charlie's Code
	}
	
	private void QueryRacersOnMountain() {
		System.out.println("Please enter the Mountain Name:");
		String MountainName = receiveUserInput();
		// Call Charlie's Code

	}
	
	private void QueryCoachesForAGivenClub() 
	{
		System.out.println("Please enter the ClubID:");
		String ClubID = receiveUserInput();
		//Call Charlies code
	}
	

	public  void displayOptions () 
	{ 
		System.out.println("Please enter the option number for one of the options displayed below: ");
		System.out.println(" 1. " + aCoachesForAGivenClub);
		System.out.println(" 2. " +  aRacersOnMountain);
		System.out.println(" 3. " + aWinnerOfRace);
		System.out.println(" 4." +  aAllRuntimes);
		System.out.println("5. Quit");

	}
	public String receiveUserInput()
	{
		Scanner lScanner  = new Scanner(System.in); 
		String lInput = lScanner.nextLine(); 
		return lInput; 
	}




}
