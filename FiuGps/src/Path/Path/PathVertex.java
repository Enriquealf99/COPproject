package Path;

import Graph.Vertex;

public class PathVertex extends Vertex {
    private Integer distance;
    private PathVertex parent;
    private boolean visited;

    // Constructor that initializes a PathVertex with a label
    public PathVertex(String label) {
        super(label);
        this.distance = Integer.MAX_VALUE;
        this.parent = null;
        this.visited = false;
    }

    // Getter for distance
    public Integer getDistance() {
        return distance;
    }

    // Setter for distance
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    // Getter for parent vertex
    public PathVertex getParent() {
        return parent;
    }

    // Setter for parent vertex
    public void setParent(PathVertex parent) {
        this.parent = parent;
    }

    // Check if the vertex is visited
    public boolean isVisited() {
        return visited;
    }

    // Set the visited status of the vertex
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    // Return information about the vertex, including parent, distance, label, and
    // visited status
    public String info() {
        String parentString = (parent == null) ? "null" : parent.toString();
        String visitedString = visited ? "visited" : "not visited";
        return "(parent: " + parentString + ", distance: " + this.distance + ", destination: " + this.getLabel()
                + ", status: " + visitedString + ")";
    }
} // End of PathVertex class
