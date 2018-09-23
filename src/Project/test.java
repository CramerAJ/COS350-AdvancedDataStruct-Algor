// Test case using figure 25.1 on page 690 of the textbook
package Project;

import java.util.ArrayList;


public class test {

	public static void main(String[] args) {
		ArrayList<String> V = new ArrayList<String>();
		ArrayList<Edge> E = new ArrayList<Edge>();
		for (int i=1; i<=5; i++) {
			V.add(Integer.toString(i));
		}
		E.add(new Edge("1", "2", 3));
		E.add(new Edge("1", "3", 8));
		E.add(new Edge("1", "5", -4));
		E.add(new Edge("2", "4", 1));
		E.add(new Edge("2", "5", 7));
		E.add(new Edge("3", "2", 4));
		E.add(new Edge("4", "1", 2));
		E.add(new Edge("4", "3", -5));
		E.add(new Edge("5", "4", 6));
		
		FloydWarshall test = new FloydWarshall(V,E);
		test.printDistanceMatrix();
		System.out.println();
		test.printPredecessorMatrix();
		
	}

}
