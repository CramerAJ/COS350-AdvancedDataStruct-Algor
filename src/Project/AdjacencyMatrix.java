// A class modeling an adjacency matrix.
// For use with the Floyd-Warshall algorithm.
package Project;
import java.util.ArrayList;

public class AdjacencyMatrix<T> {
	
	ArrayList<ArrayList<T>> matrix;
	ArrayList<String> vertices;
	ArrayList<Edge> edges;
	
	public AdjacencyMatrix(ArrayList<String> vertices, ArrayList<Edge> edges) {
		this.vertices = vertices;
		this.edges = edges;
		matrix = new ArrayList<ArrayList<T>>(vertices.size());
		for (int i=0; i < vertices.size(); i++) {
			matrix.add(new ArrayList<T>(vertices.size()));
		}
		for (int i=0; i < vertices.size(); i++) {
			for (int j=0; j < vertices.size(); j++) {
				matrix.get(i).add(null);
			}
		}
	}
	
	public AdjacencyMatrix<T> subMatrix(int size) {
		if (size <= matrix.size()) {
			ArrayList<String> v = new ArrayList<String>(size);
			ArrayList<Edge> e = new ArrayList<Edge>(size);
			for (int i =0; i < size; i++) {
				v.set(i, vertices.get(i));
				e.set(i, edges.get(i));
			}
			return new AdjacencyMatrix<T>(v,e);
		}
		return null;
	}
	
	public void set(int x, int y, T element) {
		
		matrix.get(y).set(x, element);
	}
	
	public T get (int x, int y) {
		return matrix.get(y).get(x);
	}
	
	
}
