package GUI;

public class MainApplication {

	public static void main(String [] args)
	{ 
		OptionMenu Menu = new OptionMenu(); 

		while(!Menu.doesUserWantsToquit())
		{
			Menu.displayOptions();
			String lSelectedOption = Menu.receiveUserInput(); 
			if (!(lSelectedOption.equals("1")||lSelectedOption.equals("2") || lSelectedOption.equals("3") || lSelectedOption.equals("4") || 
					lSelectedOption.equals("5")||lSelectedOption.equals("6")))
			{
				System.out.println("Please enter a valid option number 1-5."); 
			}
			else
			{
				Menu.performOption(lSelectedOption);
			}

		}
	}

}
