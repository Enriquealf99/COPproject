package Path;

import Graph.GraphExtension;
import Graph.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Graph.Edge;

// Class to compute shortest paths in a graph using Dijkstra's algorithm
public class Path {

    // Main method for Dijkstra's algorithm, given a graph and source vertex
    public List<PathVertex> dijkstra(GraphExtension g, Vertex v) {
        // Initialization step
        List<PathVertex> pathVertices = initializeSingleSource(g, v);
        List<PathVertex> unvisited = new ArrayList<>(pathVertices);

        // Main loop: while there are unvisited vertices
        while (!unvisited.isEmpty()) {
            // Find the unvisited vertex with the smallest distance
            PathVertex current = null;
            int min = Integer.MAX_VALUE;
            for (PathVertex pv : unvisited) {
                if (pv.getDistance() < min) {
                    current = pv;
                    min = pv.getDistance();
                }
            }

            // If all remaining vertices are unreachable, terminate
            if (min == Integer.MAX_VALUE) {
                break;
            }

            // Mark the current vertex as visited and retrieve its incident edges
            current.setVisited(true);
            List<Edge> ie = g.incidentEdges(current);

            // Remove the current vertex from the unvisited set
            unvisited.remove(current);

            // Iterate over incident edges and relax each edge if needed
            for (Edge edges : ie) {
                Vertex adjacentV = edges.vertex2;
                PathVertex adjacentPV = null;

                // Find the PathVertex object corresponding to the adjacent vertex
                for (PathVertex pv : pathVertices) {
                    if (pv.getLabel().equals(adjacentV.getLabel())) {
                        adjacentPV = pv;
                        break;
                    }
                }

                // If the adjacent vertex is unvisited, relax the edge
                if (adjacentPV != null && !adjacentPV.isVisited()) {
                    relaxEdge(current, adjacentPV, edges.weight);
                }
            }
        }

        // Return the list of PathVertex objects with their final distances
        return pathVertices;
    }

    // Helper method to relax an edge and update distances and parents
    private void relaxEdge(PathVertex current, PathVertex adjacentPV, int edgeWeight) {
        int newDistance = current.getDistance() + edgeWeight;
        if (newDistance < adjacentPV.getDistance()) {
            adjacentPV.setDistance(newDistance);
            adjacentPV.setParent(current);
        }
    }

    // Helper method to initialize distances and parents for all vertices
    private List<PathVertex> initializeSingleSource(GraphExtension g, Vertex source) {
        List<PathVertex> pathVertices = new ArrayList<>();

        for (Vertex v : g.getVertices()) {
            PathVertex pv = new PathVertex(v.getLabel());
            if (v.getLabel().equals(source.getLabel())) {
                pv.setDistance(0);
            }
            pathVertices.add(pv);
        }

        return pathVertices;
    }

    // Method to find the shortest path between two vertices in a graph
    public List<Vertex> shortestPath(GraphExtension g, Vertex source, Vertex target) {
        // Run Dijkstra's algorithm from the source vertex
        List<PathVertex> pathVertices = dijkstra(g, source);

        // Find the PathVertex object corresponding to the target vertex
        PathVertex targetPV = null;
        for (PathVertex pv : pathVertices) {
            if (pv.getLabel().equals(target.getLabel())) {
                targetPV = pv;
                break;
            }
        }

        // If the target vertex is not found in the graph, throw an exception
        if (targetPV == null) {
            throw new IllegalArgumentException("Target vertex not found in the graph");
        }

        // Create a linked list to store the shortest path
        LinkedList<Vertex> shortestPath = new LinkedList<>();

        // If the target vertex is unreachable, return an empty list
        if (targetPV.getDistance() == Integer.MAX_VALUE) {
            return shortestPath;
        }

        // Build the shortest path by following the parent pointers
        PathVertex current = targetPV;
        while (current != null) {
            shortestPath.addFirst(current);
            current = current.getParent();
        }

        // Return the shortest path as a list of vertices
        return shortestPath;
    }
}
