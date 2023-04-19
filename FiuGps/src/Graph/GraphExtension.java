package Graph;

import java.util.ArrayList;
import java.util.List;

public abstract class GraphExtension implements Graph {

    protected List<Vertex> vertices;
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
            if (edge.vertex1.toString().equals(v.toString()) || edge.vertex2.toString().equals(v.toString())) {
                incidentEdges.add(edge);
            }
        }
        return incidentEdges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public Vertex getVertexByLabel(String label) {
        for (Vertex vertex : vertices) {
            if (vertex.getLabel().equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    public int getEdgeWeight(Vertex v1, Vertex v2) {
        for (Edge edge : edges) {
            if ((edge.vertex1.equals(v1) && edge.vertex2.equals(v2))
                    || (edge.vertex1.equals(v2) && edge.vertex2.equals(v1))) {
                return edge.weight;
            }
        }
        return 0;
    }

}
