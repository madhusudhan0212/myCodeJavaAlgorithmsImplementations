package temp;

import java.util.*;
import java.util.Iterator;

public class Graph {
	
	private final int V;
	private Bag<Integer>[] adj;
    Graph(int v){
    	this.V = v;
    	adj = (Bag<Integer>[]) new Bag[V];
    	for (int i =0; i < v; i++){
    		adj[i] = new Bag<Integer>();
    	}
    }
    
    public int V(){
    	return V;
    }
    
    public void addEdge(int a, int b){
    	adj[a].add(b);
    	adj[b].add(a);
    }

    public Iterable<Integer> adj(int v){
    	return adj[v];
    }
    
    public int degree(int v){
    	int degree = 0;
    	for (Integer i : adj[v]) {
    		degree++;
    	}
    	return degree;
    }
    
    public int maxDegree(){
    	int max = 0;
    	for (int i = 0; i < V ; i++){
    		int degree = degree(i);
    		if (degree > max) { max = degree; }
    	}
    	return max;
    }
    
    public void displayGraph(){
       for(int i = 0; i < V; i++){
    	   System.out.print(i + "-- { ");
    	   for(Integer x : adj[i]){
    		   System.out.print(x+ " ");
    	   }
    	   System.out.println("}");
       }
    }
    
    public void buildTree(){
    	addEdge(0, 4);
    	addEdge(0, 3);
    	addEdge(2, 4);
    	addEdge(6, 4);
    	addEdge(3, 6);
    	addEdge(3, 5);
    	addEdge(1, 3);
    }
    
    public static void main(String[] args){
    	Graph G = new Graph(7);
        G.buildTree();
    	System.out.println("Graph display");
    	G.displayGraph();
    	System.out.println("Max Degree");
    	System.out.println(G.maxDegree());
    		
    	}
    }

