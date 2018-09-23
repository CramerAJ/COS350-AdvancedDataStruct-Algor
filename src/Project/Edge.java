package Project;
public class Edge {
	
	private String parentV, childV; 	// corresponding vertices
	private double distance;
	
	public Edge(String parentVertice, String childVertice, double distance) {
		parentV = parentVertice;
		childV = childVertice;
		this.distance = distance;
	}

	public String getParentV() {
		return parentV;
	}

	public void setParentV(String parentV) {
		this.parentV = parentV;
	}

	public String getChildV() {
		return childV;
	}

	public void setChildV(String childV) {
		this.childV = childV;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

//	public Time getTime() {
//		return time;
//	}
//
//	public void setTime(Time time) {
//		this.time = time;
//	}

}
