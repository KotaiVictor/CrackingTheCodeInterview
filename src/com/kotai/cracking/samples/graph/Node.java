package com.kotai.cracking.samples.graph;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

  private T data;
  private List<Node<T>> adjacencyList;

  public Node(T data) {
    this.adjacencyList = new ArrayList<>();
    this.data = data;
  }

  public void addNeighbour(Node<T> node) {
    adjacencyList.add(node);
  }

  public void removeNeighbour(Node<T> node) {
    adjacencyList.remove(node);
  }

  public List<Node<T>> getAdjacentNodes() {
    return adjacencyList;
  }

  public T getNodeData() {
    return data;
  }
}
