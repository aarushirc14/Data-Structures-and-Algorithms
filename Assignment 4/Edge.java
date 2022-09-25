/**
 * CPSC 319 Assignment 4
 * Created by: Aarushi Roy Choudhury
 * Date: 2022-04-01
 * Version: 6.3
 */

public class Edge {
	Vertex prev; // source
	Vertex next; // destination

	Edge(Vertex from, Vertex to) {
		prev = from;
		next = to;
	}

	public Vertex getNeighbour(int index) {
		if (prev.key == index)
			return next;
		return prev;
	}
}
