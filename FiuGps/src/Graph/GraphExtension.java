package Graph;

import java.util.ArrayList;
import java.util.List;

public abstract class GraphExtension implements Graph {


	protected  List<Vertex> vertices;
    protected List<Edge> edges;

    
    GraphExtension(List vertices, List edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    
    public List vertices() {
        return vertices;
    }


    public Vertex getVertex(int index) {
        return this.vertices.get(index);
    }

    
    public List edges() {
        return edges;
    }
    

    public List<Edge> incidentEdges(Vertex v) {
    	
    	
    	List<Edge> incidentEdges = new ArrayList<>();

       
        for (Edge edge : edges) {           
            if (edge.vertex1.toString().equals(v.toString())) {
                incidentEdges.add(edge);
            }
        }
        return incidentEdges;
    }

}
