package com.ahad.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class FindIfPathExistInGraph {

	private List<List<Integer>> buildGraph(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();

		for(int i=0;i<n;i++) {
			graph.add(new ArrayList<>());
		}

		for(int[] edge: edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		return graph;
	}
	
	public boolean validPathBfs(int n, int[][] edges, int source, int destination) {
		List<List<Integer>> graph = buildGraph(n, edges);        
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(source);

		while(!queue.isEmpty()) {
			int current = queue.poll();

			if (current == destination) return true;

			visited[current] = true;

			for(int neighbor: graph.get(current)) {
				if (!visited[neighbor]) queue.offer(neighbor);
			}
		}

		return false;
	}
	
	public boolean validPathDfsIteration(int n, int[][] edges, int source, int destination) {      
		List<List<Integer>> graph = buildGraph(n, edges);        
		boolean[] visited = new boolean[n];
		Stack<Integer> stack = new Stack<>();

		stack.push(source);

		while(!stack.isEmpty()) {
			int current = stack.pop();

			if (current == destination) return true;

			visited[current] = true;

			for(int neighbor: graph.get(current)) {
				if (!visited[neighbor]) stack.push(neighbor);
			}
		}

		return false;
	}
	
	public boolean validPathDfsRecursive(int n, int[][] edges, int source, int destination) {
		List<List<Integer>> graph = buildGraph(n, edges);

		boolean[] visited = new boolean[n];

		return hasPath(graph, visited, source, destination);
	}


	private boolean hasPath(List<List<Integer>> graph, boolean[] visited, int src, int dst) {        
		if (src == dst) return true;    
		visited[src] = true;

		for(int neighbor: graph.get(src)) {
			if (visited[neighbor]) continue;
			if (hasPath(graph, visited, neighbor, dst)) return true;
		}

		return false;
	}
	
}
