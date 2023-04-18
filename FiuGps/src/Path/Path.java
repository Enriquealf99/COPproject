package Path;

import Graph.GraphExtension;
import Graph.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Graph.Edge;

public class Path {

    public List<PathVertex> dijkstra(GraphExtension g, Vertex v) {

        List<PathVertex> pathvertices = initializeSingleSource(g, v);
        List<PathVertex> unvisited = new ArrayList<>(pathvertices);

        while (!unvisited.isEmpty()) {

            PathVertex current = null;
            int min = Integer.MAX_VALUE;
            for (PathVertex pv : unvisited) {
                if (pv.getDistance() < min) {
                    current = pv;
                    min = pv.getDistance();
                }
            }

            if (current == null) {
                break;
            }

            current.setVisited(true);
            List<Edge> ie = g.incidentEdges(current);

            unvisited.remove(current);

            for (Edge edges : ie) {
                Vertex adjacentV = edges.vertex2;
                PathVertex adjacentPV = null;

                for (PathVertex pv : pathvertices) {
                    if (pv.getLabel().equals(adjacentV.getLabel())) {
                        adjacentPV = pv;
                        break;
                    }
                }

                if (adjacentPV != null && !adjacentPV.isVisited()) {
                    relaxEdge(current, adjacentPV, edges.weight);
                }
            }
        }

        return pathvertices;

    }

    private void relaxEdge(PathVertex current, PathVertex adjacentPV, int edgeWeight) {
        int newDistance = current.getDistance() + edgeWeight;
        if (newDistance < adjacentPV.getDistance()) {
            adjacentPV.setDistance(newDistance);
            adjacentPV.setParent(current);
        }
    }

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

    public List<Vertex> shortestPath(GraphExtension g, Vertex source, Vertex target) {
        List<PathVertex> pathVertices = dijkstra(g, source);

        PathVertex targetPV = null;
        for (PathVertex pv : pathVertices) {
            if (pv.getLabel().equals(target.getLabel())) {
                targetPV = pv;
                break;
            }
        }

        if (targetPV == null) {
            throw new IllegalArgumentException("Target vertex not found in the graph");
        }

        LinkedList<Vertex> shortestPath = new LinkedList<>();
        if (targetPV.getDistance() == Integer.MAX_VALUE) {
            return shortestPath; // Empty path, since no path exists between the source and target vertices
        }

        PathVertex current = targetPV;
        while (current != null) {
            shortestPath.addFirst(current);
            current = current.getParent();
        }

        return shortestPath;
    }

}