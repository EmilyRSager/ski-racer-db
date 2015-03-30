package network;

public class IndexTimer 
{
	public static void main(String[] args) {
		DatabaseCommunicator dbc = new DatabaseCommunicator();
		long startTime = System.currentTimeMillis();
		dbc.getRacer("Charlie", "Bloomfield");
		long stopTime = System.currentTimeMillis();
		
		System.out.println("Execution time of getRacer call without Indexing took " + (stopTime - startTime) + " milliseconds.");
		
	}
}
