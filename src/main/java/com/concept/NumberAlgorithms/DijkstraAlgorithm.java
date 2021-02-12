package com.concept.NumberAlgorithms;

/*
 *  
    Given: Start City A, Destination City Z
	
	List of Distances between Cities:
	A - B : 10
	F - K : 23
	R - M : 8
	K - O : 40
	Z - P : 18
	J - K : 25
	D - B : 11
	M - A : 8
	P - R : 15
	M - P : 17
	A - P : 21
 *
 */

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex> {

	public final String name;
    public Edge[] adjacents;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    
    public Vertex(String name) {
    	this.name = name; 
    }
    
    public String toString() {
    	return name; 
    }
    
    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}


class Edge {
	
    public final Vertex targetVertex;
    public final double vertexDistance;
    
    public Edge(Vertex target, double distance) {
    	this.targetVertex = target; 
    	this.vertexDistance = distance; 
    }
}

public class DijkstraAlgorithm {
	
    public static void computePaths(Vertex source) {
    	
        source.minDistance = 0d;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex sourceVertex = vertexQueue.poll();

            // Visit each edge of source vertex
            for (Edge edge : sourceVertex.adjacents) {
                Vertex targetVertex = edge.targetVertex;
                double adjVerDistance = edge.vertexDistance;
                double distance = sourceVertex.minDistance + adjVerDistance;
                if (distance < targetVertex.minDistance) {
                    vertexQueue.remove(targetVertex);
                    targetVertex.minDistance = distance ;
                    targetVertex.previous = sourceVertex;
                    vertexQueue.add(targetVertex);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
    	
        // mark all the vertices 
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex D = new Vertex("D");
        Vertex F = new Vertex("F");
        Vertex K = new Vertex("K");
        Vertex J = new Vertex("J");
        Vertex M = new Vertex("M");
        Vertex O = new Vertex("O");
        Vertex P = new Vertex("P");
        Vertex R = new Vertex("R");
        Vertex Z = new Vertex("Z");
    	
        // set all the edges and vertexDistance
        A.adjacents = new Edge[]{ new Edge(M,  8), new Edge(B, 10), new Edge(P, 21) };
        B.adjacents = new Edge[]{ new Edge(D, 11), new Edge(A, 10) };
        D.adjacents = new Edge[]{ new Edge(B, 11) };
        F.adjacents = new Edge[]{ new Edge(K, 23) };
        K.adjacents = new Edge[]{ new Edge(O, 40), new Edge(F, 23), new Edge(J, 25) };
        J.adjacents = new Edge[]{ new Edge(K, 25) };
        M.adjacents = new Edge[]{ new Edge(R,  8), new Edge(A,  8), new Edge(P, 17) };
        O.adjacents = new Edge[]{ new Edge(K, 40) };
        P.adjacents = new Edge[]{ new Edge(Z, 18), new Edge(R, 15), new Edge(M, 17), new Edge(A, 21) };
        R.adjacents = new Edge[]{ new Edge(P, 15), new Edge(M, 8) };
        Z.adjacents = new Edge[]{ new Edge(P, 18) };

        // compute all paths
        computePaths(A);
        System.out.println("Distance A to " + Z + ": " + Z.minDistance);

        // find path
        List<Vertex> path = getShortestPathTo(Z);
        System.out.println("Path: " + path);
    }
}