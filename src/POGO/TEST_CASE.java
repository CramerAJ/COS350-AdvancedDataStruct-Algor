package POGO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class TEST_CASE {
	
	public static void main (String[] args) throws IOException{
		
		Scanner scan = new Scanner(System.in);
		String testresults = "";				//Test case that generates
		Random DOIT = new Random();				//Random array lists for me to test
												//Which I inserted in manually
		long startTime = System.nanoTime();										
		for (int i = 0; i<200; i++){			//and recorded the time it took for each to run
												//Used this only once really and it outputs it to the
			int pogo_1 = DOIT.nextInt(20-5+5) + 1; //console to give the feel of randomuser input
			
			int pogo_2 = DOIT.nextInt(20-5+5) + 1;
			
			int pogo_3 = DOIT.nextInt(20-5+5) + 1;
			
			int pogo_4 = DOIT.nextInt(20-5+5) + 1;
			
			int pogo_5 = DOIT.nextInt(20-5+5) + 1;
			
			int pogo_6 = DOIT.nextInt(20-5+5) + 1;
			
			int pogo_7 = DOIT.nextInt(20-5+5) + 1;
			
			int pogo_8 = DOIT.nextInt(20-5+5) + 1;
			
			testresults = (pogo_1 + " " + pogo_2 + " " + pogo_3 + " " + pogo_4 + " " + pogo_5 + " " +
					pogo_6 + " " + pogo_7 + " " + pogo_8 + " ");
			
			System.out.println(testresults);
			
			//code
			
		
		}
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		
	}
	/*
	private static Stack<Integer> distances = new Stack<Integer>();
	private static int ArrayofPOGOS = 0;
	static ArrayList<String> stored = new ArrayList<String>();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = 0;

		System.out.println("Enter target distance, with all the pogo sticks you have ");
		System.out.println("and the distance each can travel (ex: 5 1 3 5 10):");

		String user_input_pogos = scan.nextLine();

		String[] POGOS = user_input_pogos.split("\\s+");

		ArrayList<Integer> pogo = new ArrayList<Integer>();

		for (int i = 0; i < POGOS.length; i++) {
			
			int wall_distance = Integer.parseInt(POGOS[i]);
			
			pogo.add(wall_distance);
		
		}

		n = pogo.get(0);
		ArrayList<Integer> usable_pogo_stick = new ArrayList<Integer>();

		for (int i = 1; i < pogo.size(); i++) {

			int pogo_stick_value_ = (n / pogo.get(i));

			if (pogo_stick_value_ > 1) {

				for (int j = 0; j < pogo_stick_value_; j++) {
					usable_pogo_stick.add(pogo.get(i));
				}
			}
		}

		for (int i = 0; i < usable_pogo_stick.size(); i++) {
			pogo.add(usable_pogo_stick.get(i));
		}

		populateSubset(pogo, 1, pogo.size(), n);

	}

	public static void populateSubset(ArrayList<Integer> POGOARRAY,

			int fromIndex, int POGO_last, int n) {

		if (ArrayofPOGOS == n) {
			print(distances, n);
		}

		for (int POGO_i = fromIndex; POGO_i < POGO_last; POGO_i++) {

			if (ArrayofPOGOS + POGOARRAY.get(POGO_i) <= n) {

				distances.push(POGOARRAY.get(POGO_i));
				ArrayofPOGOS += POGOARRAY.get(POGO_i);
				populateSubset(POGOARRAY, POGO_i - 1, POGO_last, n);
				ArrayofPOGOS -= (Integer) distances.pop();
			}
		}
	}

	private static void print(Stack<Integer> distances, int n) {

		StringBuilder sb = new StringBuilder();

		for (Integer i : distances) {

			sb.append(i).append(" ");

		}

		if (!(stored.contains(sb.toString()))) {

			stored.add(sb.toString());
			stored.add(sb.toString());

			System.out.println(sb.toString());
		}
	}
	*/
}
