package COS_350_HMWK4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LongestPath {
	static ArrayList<String> edges = new ArrayList<String>();
	static ArrayList<String> verticies = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter islands with  point as the starting number: ");
        
       	String user_input = scan.nextLine();
        Scanner grab_islands = new Scanner(user_input);
       
        String stuff = grab_islands.next();
        
        int current_vertex = Integer.parseInt(stuff);						//parses the starting_island index 
        ArrayList<Integer> list = new ArrayList<Integer>();					//to set it as our starting location
        list.add(current_vertex);
       
        while (grab_islands.hasNext()){										//scans the islands into the array list
            String slides = grab_islands.next();
            int pairs = Integer.parseInt(slides);
            list.add(pairs);
        }
       long startTime = System.nanoTime();
        grab_islands.close();
        scan.close();
       
        ArrayList<Integer> sols = new ArrayList<Integer>();
        ArrayList<Integer> console_print = longestCycle(current_vertex, list, sols);
       
        if(console_print != null){
            System.out.println((console_print.size() - 1));
            for(int i = 0; i < console_print.size(); i++){
                System.out.println(console_print.get(i));
            }  
        }
        else{
            System.out.println("no solutions");
        }
        long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) + " ns");  // finds running time in nano paired_vertexs
 
    }
   
    public static ArrayList<Integer> longestCycle(int current_vertex, ArrayList<Integer> list, ArrayList<Integer> solutions){
   
    	solutions.add(current_vertex);				//ended up fixing the usses, by taking out the remove functions
													
		for(int i=0; i < list.size(); i+=2){		//Issues with making edge pairs
			int starting_island = list.get(i);		//this method works for some cases
			int paired_island = list.get(i+1);
			
			if(starting_island == current_vertex){
			solutions.add(paired_island);
			
			current_vertex = paired_island;
				/*for (int j = 0; j<list.size(); j+=2)
				 * ended up jsut tking out this for loop and it worked for some reason
				 * honestly don't know why
				 * solutions.add(starting_island);
				   current_vertex = starting_island;
				   //starting_island.remove(j);
				 * solutions.add(paired_island);
				 */
			}
			else if(paired_island == current_vertex){
				solutions.add(starting_island);
				current_vertex = starting_island;
				//starting_island.remove(j);
				//longestCycle( current_vertex,  list, solutions)
			}
		}
	int size = ((solutions.size())-1);
	if(solutions.get(0) == solutions.get(size)){
		return solutions;
	}
	else{
		return null;
	}
	
    }
    
}
      
   

