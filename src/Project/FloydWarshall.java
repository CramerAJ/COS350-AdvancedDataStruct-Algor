package Project;

import java.util.ArrayList;

public class FloydWarshall {
	
	AdjacencyMatrix<String> predecessor;
	AdjacencyMatrix<Double> distances;
	ArrayList<String> vertices;
	
	public FloydWarshall(ArrayList<String> vertices, ArrayList<Edge> edges) {
		this.vertices = vertices;
		// set up the adjacency matrix
		predecessor = new AdjacencyMatrix<String>(vertices, edges);
		distances = new AdjacencyMatrix<Double>(vertices, edges);
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				predecessor.set(i,j,"");
				distances.set(i,j,Double.POSITIVE_INFINITY);
			}
			distances.set(i,i,0.0);
		}
		//create the initial matrices
		for (Edge e : edges) {
			distances.set(vertices.indexOf(e.getParentV()), vertices.indexOf(e.getChildV()), e.getDistance());
			predecessor.set(vertices.indexOf(e.getParentV()), vertices.indexOf(e.getChildV()), e.getParentV());
		}
		// iterate that jazz
		for (int i = 0; i < vertices.size(); i++) {
			for (int x = 0; x < vertices.size(); x++) {
				for (int y = 0; y < vertices.size(); y++) {
					if (distances.get(x, y) > distances.get(x,i) + distances.get(i, y)) {
						distances.set(x, y, distances.get(x,i) + distances.get(i, y));
						predecessor.set(x, y, (predecessor.get(x, i) + predecessor.get(i, y)));
					}
				}
			}
		}
		
	}
	
	public void printDistanceMatrix() {
		System.out.println("DISTANCE MATRIX: \n");
		
		double maxEntry = 0;
		double minEntry = 0;
		for (int x=0; x < vertices.size(); x++) {
			for (int y=0; y < vertices.size(); y++) {
				if (maxEntry < distances.get(x, y))
					maxEntry = distances.get(x, y);
				if (minEntry > distances.get(x, y))
					minEntry = distances.get(x, y);
			}
		}
		
		String entryPadding = "%-" + Math.max(Double.toString(maxEntry).length(), Double.toString(minEntry).length()) + ".1f";
		String headerPadding = "%-" + Math.max(Double.toString(maxEntry).length(), Double.toString(minEntry).length()) + "s";
		
		System.out.printf(headerPadding, "");
		for (int k=0;k<vertices.size();k++)  {
			System.out.print("| ");
			System.out.printf(headerPadding, vertices.get(k));
			System.out.print(" ");
		}
		System.out.print("|\n");
		for (int i=0; i < vertices.size(); i++) {
			System.out.printf(headerPadding, vertices.get(i));
			for (int j=0; j < vertices.size(); j++) {
				System.out.printf("| ");
				System.out.printf(entryPadding, this.getDistance(i, j));
				System.out.printf(" ");
				
			}
			System.out.print("|\n");
		}
	}
	
	public void printPredecessorMatrix() {
		System.out.println("PREDECESSOR MATRIX: \n");
		
		String maxEntry = "";
		for (int x=0; x < vertices.size(); x++) {
			for (int y=0; y < vertices.size(); y++) {
				if (maxEntry.length() < predecessor.get(x, y).length())
					maxEntry = predecessor.get(x, y);
			}
		}
		
		String padding = "%-" + maxEntry.length() + "s";
		
		System.out.printf(padding, "");
		for (int k=0;k<vertices.size();k++)  {
			System.out.print("| ");
			System.out.printf(padding, vertices.get(k));
			System.out.print(" ");
		}
		System.out.print("|\n");
		for (int i=0; i < vertices.size(); i++) {
			System.out.printf(padding, vertices.get(i));
			for (int j=0; j < vertices.size(); j++) {
				System.out.printf("| ");
				System.out.printf(padding, this.getPredecessor(i, j));
				System.out.printf(" ");
				
			}
			System.out.print("|\n");
		}
	}
	
	public double getDistance(int x, int y) {
		return distances.get(x, y);
	}
	
	public double getDistance(String x, String y) {
		return distances.get(vertices.indexOf(x), vertices.indexOf(y));
	}
	
	public String getPredecessor(int x, int y) {
		return predecessor.get(x, y);
	}
	
	public String getPredecessor(String x, String y) {
		return predecessor.get(vertices.indexOf(x), vertices.indexOf(y));

	}


}
