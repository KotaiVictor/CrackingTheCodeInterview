package com.kotai.cracking.samples.graph;

public class Edge<T> {

  private final Node<T> from, to;

  public Edge(Node<T> from, Node<T> to) {
    this.from = from;
    this.to = to;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(Object o) {
    if (o instanceof Edge) {
      Edge edge = (Edge) o;
      return this.to == edge.to && this.from == edge.from;
    }
    return false;
  }
}
