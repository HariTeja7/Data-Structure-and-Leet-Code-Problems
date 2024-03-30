package com.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<String, List<String>> adjList;

	public Graph() {
		this.adjList = new HashMap<>();
	}

	public void printGraph() {
		System.out.println(adjList);
	}

	public boolean addVertex(String vertex) {
		if (!adjList.containsKey(vertex)) {
			adjList.put(vertex, new ArrayList<>());
			return true;
		}
		return false;
	}

	public boolean addEdge(String vertex1, String vertex2) {
		if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
			adjList.get(vertex1).add(vertex2);
			adjList.get(vertex2).add(vertex1);
			return true;
		}
		return false;
	}

	public boolean removeVertex(String vertex) {
		if (adjList.containsKey(vertex)) {
			for (String connectedVertex : adjList.get(vertex)) {
				adjList.get(connectedVertex).remove(vertex);
			}
			adjList.remove(vertex);
			return true;
		}
		return false;
	}

	public boolean removeEdge(String vertex1, String vertex2) {
		if (adjList.get(vertex1).contains(vertex2)) {
			adjList.get(vertex2).remove(vertex1);
			adjList.get(vertex1).remove(vertex2);
			return true;
		}
		return false;
	}

}
