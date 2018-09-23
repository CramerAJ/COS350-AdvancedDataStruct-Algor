package COS_350_HMWK4;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HASHMAPtry3 {
	
	public static void main(String[] args){
		
		HashMap<Integer, List<Integer>> edges_mapped = new HashMap<Integer, List<Integer>> ();
		List<Integer> pairs_stored = new ArrayList<Integer>();
																			//Logic on how a hashmap works, may be a bit hazy
		//long startTime = System.nanoTime(); 								//nano counter			
	
		System.out.println("Enter islands: ");
		Scanner input = new Scanner(System.in);
		Scanner edges = new Scanner(input.nextLine());
		
		while (edges.hasNext()){											//Had someone explain to me how to first scan the input
			int starting = edges.nextInt();									//making a key, by grabbing 2 indexes at a time
			int pairing_vertex = edges.nextInt();							//and storing them together as a key
			//now has to check each index/vertex value
			if (edges_mapped.containsKey(starting)){
				List<Integer> slides = edges_mapped.get(starting);			//with the .put command into the hashmap itself
				slides.add(pairing_vertex);									
				edges_mapped.put(starting, slides);
			}
			else if (edges_mapped.containsKey(pairing_vertex)){
				List<Integer> slides = edges_mapped.get(pairing_vertex);
				slides.add(starting);
				edges_mapped.put(pairing_vertex, slides);
			}
			else{															//there are duplicates though in the hashmap to consider
				return;														//about having to get rid of later on
			}
			
			for (int i = 0; i < pairs_stored.size(); i++ ){					//Was unsure how to output the function below
				//System.out.println(value.get(i));							Not that confident in how a hash map works, but was 
				System.out.println(pairs_stored.get(i));					//having more success following this then my earlier code
			}
		
		}
	//	long endTime = System.nanoTime();
		//System.out.println("Took " + (endTime - startTime) + " ns");  		//finds running time in nano seconds
	}
	
	public static void longestpath(List<Integer> pairs_stored,int location, HashMap<Integer,
		
		List<Integer>> edges_mapped, int counter){
		counter++;												
		pairs_stored.add(location);								//thought I could just do a .size() - 1 of the pairs found 
																//Also unsure on how to restart a new trial of tracing
																//the hashmap, which is where the counter would come into play 
																//but unsure if its simply just seeing if the counter has been set to 0
		if ( counter > 1){										//this would also check to see if the graph is complete
			//counter -1???
		}
		/*if(counter!=0){		THIS would NOT WORK
		 * (counter -1)
		 */
		List<Integer> list = edges_mapped.get(location);		//creates a new list, where possible edges will be stored
		
		for (int i = 0; i<list.size(); i++){					//finds a pair, and trys to map it
			int value = list.get(i);
																//Was reading later also, that we need to remove duplicates
			if(/*edges_mapped.contains(i)*/ edges_mapped.containsKey(value)){
				List<Integer> solutions = edges_mapped.get(value);//would then grab that edge value
				if ( solutions.contains(location)){				  //check to see if it's contained
					
					for (int j = 0; j < solutions.size(); j++){	  //and then also match it with it's current location in the map
						if (solutions.get(j).equals(location)){	  //to check whether it is an edge or not.
							solutions.remove(j);
							edges_mapped.put(value, solutions);
						}
					}
					/*for (int j = 0; j < solutions.size(); j+=2){ brought this over from other class, just to compare
						if (solutions.get(j).equals(location)){	  
							solutions.remove(j);
							edges_mapped.put(value, solutions);
						}
					}*/
					
				}
				else{
					return;
				}
		
			}
			else{
				return;
			}
		}
		
		edges_mapped.put(location, list);
		//longestpath( edges_mapped,counter,pairs_stored, value); has to also recall the function
		
	}
}
