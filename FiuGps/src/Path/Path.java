package Path;

import java.util.ArrayList;
import java.util.List;

import Graph.Edge;
import Graph.Vertex;

public class Path {

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

		Vertex v14 = new Vertex("college of Business");
		vertices.add(v14);

		Vertex v15 = new Vertex("Wertheim School of music and preforming arts");
		vertices.add(v15);

		Vertex v16 = new Vertex("Knight Foundation School of Computing and Information Sciences");
		vertices.add(v16);

		Vertex v17 = new Vertex("Fiu the Honors College");
		vertices.add(v17);

		List<Edge> edges = new ArrayList<>();

		edges.add(new Edge(v1, v13, 200));
		edges.add(new Edge(v1, v16, 400));
		edges.add(new Edge(v1, v12, 600));
		edges.add(new Edge(v16, v7, 300));

	}
}

// method to find the shortest path
