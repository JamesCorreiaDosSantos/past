package application;

import java.text.ParseException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
	String[] vect = sc.nextLine().split(" ");
		
	int n = sc.nextInt();
	
	System.out.println(vect[n]);
	
	}

}
