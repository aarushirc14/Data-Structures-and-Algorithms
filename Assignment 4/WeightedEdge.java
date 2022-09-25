/**
 * CPSC 319 Assignment 4
 * Created by: Aarushi Roy Choudhury
 * Date: 2022-04-01
 * Version: 6.3
 */

public class WeightedEdge extends Edge {

	int weight; // edge weight

	WeightedEdge(Vertex from, Vertex to, int weight) {
		super(from, to);
		this.weight = weight;
	}

}
