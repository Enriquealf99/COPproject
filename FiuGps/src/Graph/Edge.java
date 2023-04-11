package Graph;

public class Edge {

	    public Vertex vertex1, vertex2;
	    public Integer weight;

	    public Edge(Vertex v1, Vertex v2, Integer wt) {
	        vertex1 = v1;
	        vertex2 = v2;
	        weight = wt;
	    }


	    public String toString() {
	        return vertex1.toString() + " " + vertex2.toString() + " " + weight;
	    }
}
