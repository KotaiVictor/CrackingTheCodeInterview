package com.kotai.cracking.samples.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Directed Graph
 */
public class Graph<T> {
  public Set<Node<T>> nodes;
  public List<Edge<T>> edges;

  public Graph() {
    nodes = new HashSet<Node<T>>();
    edges = new ArrayList<Edge<T>>();
  }

  public void addEdge(Node<T> vertex, Node<T> otherVertex) {
    Edge<T> newEdge = new Edge<>(vertex, otherVertex);
    edges.add(newEdge);

    vertex.addNeighbour(otherVertex);

    nodes.add(otherVertex);
    nodes.add(vertex);
  }
}
