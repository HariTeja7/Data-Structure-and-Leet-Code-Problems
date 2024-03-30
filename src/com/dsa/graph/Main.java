package com.dsa.graph;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.printGraph();
		g.addEdge("A", "B");
		g.addVertex("C");
		g.addEdge("C", "B");
		g.printGraph();
	}

}
