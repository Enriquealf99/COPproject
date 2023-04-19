package Path;

import Graph.Vertex;

public class PathVertex extends Vertex {
    private Integer distance;
    private PathVertex parent;
    private boolean visited;

    public PathVertex(String label) {
        super(label);
        this.distance = Integer.MAX_VALUE;
        this.parent = null;
        this.visited = false;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public PathVertex getParent() {
        return parent;
    }

    public void setParent(PathVertex parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String info() {
        String parentString = (parent == null) ? "null" : parent.toString();
        String visitedString = visited ? "visited" : "not visited";
        return "(parent: " + parentString + ", distance: " + this.distance + ", destination: " + this.getLabel()
                + ", status: " + visitedString + ")";
    }
}