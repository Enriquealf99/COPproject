# COPproject
Members:
Enrique Alfonso
Sebastian Helver

Contribution:
It is impossible to determine each person's contribution to the project because we both collaborated on it simultaneously.

Program Explanation: 
This program represents the Fiu campus map as a graph and finds the shortest path between two locations on the map. It prompts the user to choose their current location and destination from a list of campus locations, then calculates the shortest path between the chosen locations and prints the path and its total distance.

The program starts by creating a list of Vertex objects, which represent campus locations. It then creates a list of Edge objects, which represent the distances between pairs of locations. The edges are added in both directions to create an undirected graph.

A GraphImplementation object is created using the vertices and edges, which is then used to find the shortest path between two locations using Dijkstra's algorithm. The Path class handles the shortest path calculation.

Vertex class: This class represents a node or a location in the graph. It has one field, label, which is a string that identifies the location. The class has a constructor that takes a label as a parameter, a getter method getLabel() to retrieve the label, and a toString() method that returns a string representation of the Vertex.

Edge class: This class represents an edge or a connection between two vertices in the graph. It has three fields: source, destination, and weight. The source and destination fields are Vertex objects, while the weight field is an integer representing the distance between the source and destination vertices. The class has a constructor that takes the source, destination, and weight as parameters, and getter methods for each field (getSource(), getDestination(), and getWeight()).

GraphImplementation class: This class represents an undirected graph using adjacency lists. It has two fields: vertices, a list of Vertex objects, and adjacencies, a map that associates each vertex with a list of its adjacent vertices along with the corresponding edge weights. The class has a constructor that takes a list of vertices and a list of edges as parameters, and initializes the adjacency lists. It also has a method getNeighbors(Vertex vertex) that returns a list of adjacent vertices and their edge weights for a given vertex.

PathVertex class: This class extends the Vertex class and is used in Dijkstra's algorithm to store additional information about each vertex during the shortest path calculation. It has two extra fields: distance, an integer representing the shortest distance from the source vertex to this vertex, and parent, a PathVertex object representing the previous vertex in the shortest path. The class has a constructor that takes a label as a parameter, getter and setter methods for the distance and parent fields (getDistance(), setDistance(int distance), getParent(), and setParent(PathVertex parent)), and a compareTo() method that compares two PathVertex objects based on their distance fields.

Path class: This class implements Dijkstra's algorithm for finding the shortest path between two vertices in a graph. It has a single method, shortestPath(GraphImplementation graph, Vertex source, Vertex destination), which takes a graph, a source vertex, and a destination vertex as parameters and returns a list of Vertex objects representing the shortest path between the source and destination. If no path is found, it returns null.

Main class: This class contains the main method and is the entry point for the program. It initializes the vertices, edges, and graph, and interacts with the user to get their current location and destination, calculates the shortest path between the chosen locations, and prints the path and its total distance. 