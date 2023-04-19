package Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphImplementation extends GraphExtension {

    public GraphImplementation(List vertices, List edges) {
        super(vertices, edges);
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

}
