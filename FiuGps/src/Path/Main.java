package Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Graph.Edge;
import Graph.GraphExtension;
import Graph.GraphImplementation;
import Graph.Vertex;

public class Main {

	public static void main(String[] args) {

		List<Vertex> vertices = new ArrayList<>();

		Vertex v1 = new Vertex("PG6");
		vertices.add(v1);

		Vertex v2 = new Vertex("PG5");
		vertices.add(v2);

		Vertex v3 = new Vertex("Graham Center");
		vertices.add(v3);

		Vertex v4 = new Vertex("PG1");
		vertices.add(v4);

		Vertex v5 = new Vertex("Blue Parking Grarage (PG2)");
		vertices.add(v5);

		Vertex v6 = new Vertex("Panther Hall");
		vertices.add(v6);

		Vertex v7 = new Vertex("Green Library");
		vertices.add(v7);

		Vertex v8 = new Vertex("University Towers");
		vertices.add(v8);

		Vertex v9 = new Vertex("Charles E. Perry");
		vertices.add(v9);

		Vertex v10 = new Vertex("College of Law");
		vertices.add(v10);

		Vertex v11 = new Vertex("Frost Art Museum");
		vertices.add(v11);

		Vertex v12 = new Vertex("Parking Garage 3");
		vertices.add(v12);

		Vertex v13 = new Vertex("Parking Garage 4 (Red Parking Garage)");
		vertices.add(v13);

		Vertex v14 = new Vertex("college of Business"); // add edges
		vertices.add(v14);

		Vertex v15 = new Vertex("Wertheim School of music and preforming arts");
		vertices.add(v15);

		Vertex v16 = new Vertex("Knight Foundation School of Computing and Information Sciences");
		vertices.add(v16);

		Vertex v17 = new Vertex("Fiu the Honors College");
		vertices.add(v17);

		List<Edge> edges = new ArrayList<>();

		edges.add(new Edge(v1, v13, 1260));
		edges.add(new Edge(v1, v16, 860));
		edges.add(new Edge(v1, v12, 3705));
		edges.add(new Edge(v13, v2, 973));
		edges.add(new Edge(v13, v16, 961));
		edges.add(new Edge(v16, v7, 1350));
		edges.add(new Edge(v7, v3, 1015));
		edges.add(new Edge(v7, v9, 1160));
		edges.add(new Edge(v7, v17, 916));
		edges.add(new Edge(v3, v4, 1071));
		edges.add(new Edge(v3, v11, 1800));
		edges.add(new Edge(v4, v5, 750));
		edges.add(new Edge(v5, v15, 1050));
		edges.add(new Edge(v15, v11, 940));
		edges.add(new Edge(v11, v5, 650));
		edges.add(new Edge(v11, v9, 2470));
		edges.add(new Edge(v3, v9, 805));
		edges.add(new Edge(v9, v17, 720));
		edges.add(new Edge(v9, v8, 1190));
		edges.add(new Edge(v17, v8, 1058));
		edges.add(new Edge(v8, v6, 1173));
		edges.add(new Edge(v8, v10, 2136));
		edges.add(new Edge(v7, v10, 2666));
		edges.add(new Edge(v10, v12, 1813));
		edges.add(new Edge(v13, v1, 1260));
		edges.add(new Edge(v16, v1, 860));
		edges.add(new Edge(v12, v1, 3705));
		edges.add(new Edge(v2, v13, 973));
		edges.add(new Edge(v16, v13, 961));
		edges.add(new Edge(v7, v16, 1350));
		edges.add(new Edge(v3, v7, 1015));
		edges.add(new Edge(v9, v7, 1160));
		edges.add(new Edge(v17, v7, 916));
		edges.add(new Edge(v4, v3, 1071));
		edges.add(new Edge(v11, v3, 1800));
		edges.add(new Edge(v5, v4, 750));
		edges.add(new Edge(v15, v5, 1050));
		edges.add(new Edge(v11, v15, 940));
		edges.add(new Edge(v5, v11, 650));
		edges.add(new Edge(v9, v11, 2470));
		edges.add(new Edge(v9, v3, 805));
		edges.add(new Edge(v17, v9, 720));
		edges.add(new Edge(v8, v9, 1190));
		edges.add(new Edge(v8, v17, 1058));
		edges.add(new Edge(v6, v8, 1173));
		edges.add(new Edge(v10, v8, 2136));
		edges.add(new Edge(v10, v7, 2666));
		edges.add(new Edge(v12, v10, 1813));
		edges.add(new Edge(v14, v12, 944));
		edges.add(new Edge(v14, v1, 1090));
		edges.add(new Edge(v14, v16, 1087));
		edges.add(new Edge(v14, v10, 566));
		edges.add(new Edge(v14, v7, 1076));
		edges.add(new Edge(v12, v14, 944));
		edges.add(new Edge(v1, v14, 1090));
		edges.add(new Edge(v16, v14, 1087));
		edges.add(new Edge(v10, v14, 566));
		edges.add(new Edge(v7, v14, 1076));

		GraphImplementation graph = new GraphImplementation(vertices, edges);

		Path p = new Path();
		System.out.println(p.shortestPath(graph, v1, v6));

		Scanner scanner = new Scanner(System.in);
		Path path = new Path();

		System.out.println("Welcome");

		while (true) {

			System.out.println("Select your location and destination from the list below:");
			for (int i = 0; i < vertices.size(); i++) {
				System.out.println((i + 1) + ". " + vertices.get(i).getLabel());
			}

			System.out.print("Enter the number of your location or enter exit to leave the program: ");
			int locationIndex = Integer.parseInt(scanner.nextLine()) - 1;
			Vertex sourceVertex = vertices.get(locationIndex);

			System.out.print("Enter the number of your destination: ");
			int destinationIndex = Integer.parseInt(scanner.nextLine()) - 1;
			Vertex destinationVertex = vertices.get(destinationIndex);

			if (sourceVertex == null || destinationVertex == null) {
				System.out.println("Invalid vertex label(s). Please try again.");
			} else {
				List<Vertex> shortestPath = path.shortestPath(graph, sourceVertex, destinationVertex);

				if (shortestPath != null) {
					PathVertex destinationPathVertex = null;
					for (Vertex pv : shortestPath) {
						if (pv.getLabel().equals(destinationVertex.getLabel())) {
							destinationPathVertex = (PathVertex) pv;
							break;
						}
					}

					if (destinationPathVertex != null) {
						List<String> pathLabels = new ArrayList<>();
						int totalDistance = destinationPathVertex.getDistance();
						while (destinationPathVertex != null) {
							pathLabels.add(destinationPathVertex.getLabel());
							destinationPathVertex = destinationPathVertex.getParent();
						}

						Collections.reverse(pathLabels);

						System.out.println("Shortest path: ");
						for (String label : pathLabels) {
							System.out.print(label + " -> ");
						}
						System.out.println();
						System.out.println("Total distance: " + totalDistance + " ft.");
					} else {
						System.out.println("No path found between the source and destination vertices.");
					}
				} else {
					System.out.println("No path found between the source and destination vertices.");
				}

				System.out.println("Do you want to continue? if not enter exit.");
				String exit = scanner.nextLine();
				if (exit.equals("exit")) {
					break;
				}
			}
		}
		scanner.close();
	}
}