package Homework3_350;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Poles {

	static ArrayList<String> poles_combinations = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter distance of each poles can travel (ex: 3 5 1 10 2):");

		String user_input = input.nextLine(); 						// picks up the user input as string

		long startTime = System.nanoTime(); 						// used to find the running time
	
		ArrayList<Integer> poles = new ArrayList<Integer>();			// array list containing the users given integers		
		Scanner array_add_ints = new Scanner(user_input);

		while (array_add_ints.hasNext()) { 							// scans the user input into the array list

			String distances = array_add_ints.next();
			int integers = Integer.parseInt(distances);
			poles.add(integers);

		}
		input.close(); 			// close scanners
		array_add_ints.close(); //close scanners
		difference(poles); 		// output statement
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) + " ns"); // finds running time in nano seconds
		
	}

	public static void difference(ArrayList<Integer> poles) {
		ArrayList<String> combinations = new ArrayList<String>();
		Collections.sort(poles);
													 // counts how many times it finds a combination, used for question 6
		for (int i = 0; i < poles.size(); i++) {
			
			int ruby = poles.get(i);
			
			for (int j = 0; j < poles.size(); j++) {
				int garnet = poles.get(j);
				
				for (int k = 0; k < poles.size(); k++) {
					
					int beryl = poles.get(k);
					
					if (i != j && j != k && i != k) {
						if ((garnet - ruby) == (beryl - garnet) && (garnet - ruby >= 0) && (beryl-garnet >=0)) {
							//(&& garnet > 0) (&& ruby > 0) (&& beryl > 0)			if you don't want negative poles, include this
							combinations.add(ruby +" " + garnet +" " + beryl);
							//count++;
						
						}
					}
				}
			}
		}		
		System.out.println(combinations.size());;
		
		for (String l : combinations){
			System.out.println(l);
			//count++;
		}
		return;
	}
}