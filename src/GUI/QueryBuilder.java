package GUI;

import java.util.Scanner;

public class QueryBuilder {
	
	public static String buildQuery(String queryFilePath){
		Scanner scanner = new Scanner(queryFilePath);
		StringBuilder sb = new StringBuilder();
		String nextLine;
		while((nextLine = scanner.next()) != null){
			sb.append(nextLine);
		}
		return sb.toString();
	}
}
