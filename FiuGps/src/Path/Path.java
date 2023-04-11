package Path;

import java.util.ArrayList;
import java.util.List;

import Graph.Edge;
import Graph.Vertex;


public class Path {
	
	public static void main(String[] args) {
		
		List<Vertex> vertices = new ArrayList<>();
		vertices.add(new Vertex("PG6"));
		vertices.add(new Vertex("PG5")); 
		vertices.add(new Vertex("Graham Center"));
		vertices.add(new Vertex("PG1"));
		vertices.add(new Vertex("Blue Parking Grarage (PG2)"));
		vertices.add(new Vertex("Panther Hall"));
		vertices.add(new Vertex("Green Library"));
		vertices.add(new Vertex("University Towers"));
		vertices.add(new Vertex("Charles E. Perry"));
		vertices.add(new Vertex("College of Law"));
		vertices.add(new Vertex("Frost Art Museum"));
		vertices.add(new Vertex("Parking Garage 3"));
		vertices.add(new Vertex("Parking Garage 4 (Red Parking Garage)"));
		vertices.add(new Vertex("college of Business"));
		vertices.add(new Vertex("Wertheim School of music and preforming arts"));
		vertices.add(new Vertex("Knight Foundation School of Computing and Information Sciences"));
		vertices.add(new Vertex("Fiu the Honors College"));
		
		
		System.out.println(vertices); 
	}

}

// method to find the shortest path








