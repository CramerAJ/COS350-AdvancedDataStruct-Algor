package Project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> vertices, stops;
		ArrayList<Edge> edges;
		
		System.out.println("Enter your directory of vertices and edges (i.e. name.txt)");
		Scanner scan = new Scanner(System.in);
		String textfile = scan.next();
		Scanner read = new Scanner(new FileReader(textfile));
		Scanner firstLine = new Scanner(read.nextLine());
		
		
		stops = new ArrayList<String>();
		vertices = new ArrayList<String>();
		edges = new ArrayList<Edge>();
			
		//adding vertices into the ArrayList from the first line of the text file
		while(firstLine.hasNext()){
			vertices.add(firstLine.next());
			stops.add(firstLine.next());
		}
		//reading File and scanning it, distinguishing what(V) is what(E).
		while(read.hasNextLine()){
			Scanner nextLine = new Scanner(read.nextLine());
			String vertexP;
			String vertexC;
			String time;
				
			vertexP = nextLine.next();				
			time = nextLine.next();
			vertexC = nextLine.next();
			double t = Double.parseDouble(time);
			
			edges.add(new Edge(vertices.get(stops.indexOf(vertexP)),vertices.get(stops.indexOf(vertexC)), t));	
			
		}
		System.out.println("STOPS: ");
		for (int i=0; i<stops.size(); i++) {
			System.out.print(vertices.get(i) + " : ");
			System.out.println(stops.get(i));
		}
		
		FloydWarshall master = new FloydWarshall(vertices, edges);
		master.printDistanceMatrix();
		System.out.println();
		master.printPredecessorMatrix();
		System.out.println();
		
		System.out.println("Type \"exit\" to quit.");
		System.out.println("Enter the keys for two stops(i.e \"X Y\"), get the time and path: ");
		String input1 = scan.next();
		String input2 = scan.next();
		while (!input1.equals("exit") && !input2.equals("exit")) {
			System.out.println("To get from " + stops.get(vertices.indexOf(input1)) + 
					" to " + stops.get(vertices.indexOf(input2)) + ":");
			System.out.println("It would take " + master.getDistance(vertices.indexOf(input1), vertices.indexOf(input2)) + " minutes.");
			System.out.println("You would hit these stops: ");
			String path = master.getPredecessor(vertices.indexOf(input1), vertices.indexOf(input2));
			System.out.println("Get on at " + stops.get(vertices.indexOf(path.substring(0,1))));
			for (int i=2; i<=path.length(); i++) {
				System.out.println(stops.get(vertices.indexOf(path.substring(i-1, i))));
			}
			System.out.println("Get off at " + stops.get(vertices.indexOf(input2)));
			input1 = scan.next();
			input2 = scan.next();
		}
	}

}