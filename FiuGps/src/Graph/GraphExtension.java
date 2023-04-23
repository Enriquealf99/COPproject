package Graph;

import java.util.ArrayList;
import java.util.List;

public abstract class GraphExtension implements Graph {

    protected List<Vertex> vertices;
    protected List<Edge> edges;

    // Constructor that initializes the GraphExtension with vertices and edges
    GraphExtension(List vertices, List edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    // Returns the list of vertices
    public List vertices() {
        return vertices;
    }

    // Returns the vertex at the given index
    public Vertex getVertex(int index) {
        return this.vertices.get(index);
    }

    // Returns the list of edges
    public List edges() {
        return edges;
    }

    // Returns the list of incident edges for the given vertex
    public List<Edge> incidentEdges(Vertex v) {
        List<Edge> incidentEdges = new ArrayList<>();

        for (Edge edge : edges) {
            if (edge.vertex1.toString().equals(v.toString()) || edge.vertex2.toString().equals(v.toString())) {
                incidentEdges.add(edge);
            }
        }
        return incidentEdges;
    }

    // Returns the list of vertices
    public List<Vertex> getVertices() {
        return vertices;
    }

    // Returns the vertex with the given label
    public Vertex getVertexByLabel(String label) {
        for (Vertex vertex : vertices) {
            if (vertex.getLabel().equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    // Returns the weight of the edge between the given vertices
    public int getEdgeWeight(Vertex v1, Vertex v2) {
        for (Edge edge : edges) {
            if ((edge.vertex1.equals(v1) && edge.vertex2.equals(v2))
                    || (edge.vertex1.equals(v2) && edge.vertex2.equals(v1))) {
                return edge.weight;
            }
        }
        return 0;
    }

} // End of GraphExtension class
