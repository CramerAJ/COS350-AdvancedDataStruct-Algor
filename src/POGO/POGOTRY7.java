package POGO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class POGOTRY7 {

	//Had to make all private variables static
	//in order for the Stacks and ArrayLists to function properly 
	
	private static Stack<Integer> distances = new Stack<Integer>();
	private static int POGO_stacks = 0;
	static ArrayList<String> pogokeptSTICKS = new ArrayList<String>();

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();		
		
		Scanner scan = new Scanner(System.in);
		int n = 0;

		System.out.println("Enter E to enumerate the target distance, with all the pogo sticks you have ");
		System.out.println("and the distance each can travel (ex: 5 5 10 1 3):");
		
		String user_input_pogos = scan.nextLine();
		String[] POGOS = user_input_pogos.split("\\s+");
		
		ArrayList<Integer> coins_used = new ArrayList<Integer>();
		ArrayList<Integer> pogo = new ArrayList<Integer>();
																	//used to parse the first int the user inserted
																	//to designate that the integer is the goal
																	//once the value is known it will be represented later
		for (int i = 1; i < POGOS.length; i++) {					//on for the algorithm to compare with other results
		
			int distance_costs = Integer.parseInt(POGOS[i]);
			
			if( (i % 2) == 0){												//This is used to separate the coins cost
				coins_used.add(distance_costs);						//from the pogos, D value.
			}														//VERY VERY IMPORTANT TO have, or it wont separate
			if ( i > 1 ){									//and will treat the coins cost as a pogo stick
				coins_used.add(distance_costs);
			}
			else{
			pogo.add(distance_costs);	
			}
			
		}
		n = pogo.get(0);
		ArrayList<Integer> usable_pogo_stick = new ArrayList<Integer>();
		
		for (int i = 1; i < pogo.size(); i++) {

			int pogo_stick_value_ = (n / pogo.get(i));
			
			if (pogo_stick_value_ > 1) {
				for (int h = 0; h < pogo_stick_value_; h++) {
					usable_pogo_stick.add(pogo.get(i));
				}
			}
		}

		for (int i = 0; i < usable_pogo_stick.size(); i++) {
			pogo.add(usable_pogo_stick.get(i));
		}

		CS_subset(pogo, 1, pogo.size(), n, coins_used );
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		
		scan.close();

	}
		//outputs all results that were stored in the popokeptSTICKS
		//these are the pogosticks that are used to reach the final goal
		//as well as the combinations to be output to the user
		
	private static void print(Stack<Integer> distances, int n, ArrayList<Integer> coins_cost ) {	
		
		StringBuilder combinations_added = new StringBuilder();
																	//Used this for loop type from either the textbook or online
		float totals_coins;											//sources couldn't remember which one
																	//Since I was having issues printing out the results back to the Main Class
		for (Integer i : distances) {
			//combinations_added.append(i).append(" ");
			combinations_added.append(i).append(" ");
		}
		if (!(pogokeptSTICKS.contains(combinations_added.toString()))) {
			pogokeptSTICKS.add(combinations_added.toString());

			String nul = combinations_added.toString();
			totals_coins = coins(nul, coins_cost);
			
			pogokeptSTICKS.add(combinations_added.toString());
			
			System.out.println(combinations_added.toString()+" "+ totals_coins );
		}
	}
	
	//This is the main part that checks the arraylist(stacks) for results == to n
	//as well as results < n to then add them over and over with each other to
	//have the end result be equal to n
	//The name of the method isn't really relative to what a LCS actually is
	//just named it like that for the heck of it.
	
	public static void CS_subset(ArrayList<Integer> POGOARRAY, int fromIndex, int POGO_last, int n, ArrayList<Integer> coins) {

		if (POGO_stacks == n) {
			print(distances, n, coins);
		}

		//THIS IS THE BREAD AND BUTTER
		//Read on how to iterate the index from current position to the end
		//once the iteration was done it would push all values needed onto the stack
		
		for (int POGO_i = fromIndex; POGO_i < POGO_last; POGO_i++) {

			if (POGO_stacks + POGOARRAY.get(POGO_i) <= n) {
				
				distances.push(POGOARRAY.get(POGO_i));
				POGO_stacks += POGOARRAY.get(POGO_i);
				CS_subset(POGOARRAY, POGO_i - 1, POGO_last, n, coins);
				POGO_stacks -= (Integer) distances.pop();
				
				
			}
		}
		//System.out.println(n);
	}
	
		//The coins method is used to keep track of all the costs of each pogo stick
		//wasn't working for an int variable,(NO CLUE WHY) so ended up just making it a float.
		//This looks correct from my standpoint, but there just isn't something crossing over 
		//or being called over correctly when looking as the coins
	
	public static float coins (String user_input, ArrayList<Integer> coins_cost ){
			
		float total_coins = 0;
		
		ArrayList<String> pogo_combinations = new ArrayList<String>();
		
		String[] stuff_collected = user_input.split("//+s");
		
		for (int i = 0; i<stuff_collected.length; i++){
			pogo_combinations.add(stuff_collected[i]);
		}
		
		for (int i = 0; i < pogo_combinations.size(); i++){
			
			int coins = coins_cost.indexOf(pogo_combinations.get(i));
			//coins += Math.max(coins, b );
			
			coins = Math.abs(coins);	
			//coins = Math.round(coins);
			
			total_coins += coins;
			
		}
		//return coins;
		return total_coins;
		
	}
	//this was an old thought I was looking at which I didnt know what to do with anymore
	//but looked back to it for help, which is a Hashing method
	   /*List<Integer> list = new ArrayList<Integer>(originalSet);
       Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
       for (Set<Integer> set : powerSet(rest)) {
           Set<Integer> newSet = new HashSet<Integer>();
           newSet.add(head);
           sets.add(set);
       }
*/
}