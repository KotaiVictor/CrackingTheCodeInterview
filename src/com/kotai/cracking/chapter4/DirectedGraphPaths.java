package com.kotai.cracking.chapter4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.kotai.cracking.samples.graph.Graph;
import com.kotai.cracking.samples.graph.Node;

/*
 * Given a directed graph, design an algorithm to find out whether there is a route between two
 * nodes.
 */
public class DirectedGraphPaths {

  public <T> boolean pathExists(Graph<T> graph, Node<T> startNode, Node<T> endNode) {
    LinkedList<Node<T>> queue = new LinkedList<>();
    Set<Node<T>> visitedNodes = new HashSet<>();
    queue.add(startNode);

    Node<T> currentNode;
    while (!queue.isEmpty()) {
      currentNode = queue.removeFirst();
      if (currentNode != null) {
        for (Node<T> neighbour : currentNode.getAdjacentNodes()) {
          if (!visitedNodes.contains(neighbour)) {
            if (neighbour == endNode)
              return true;
            else {
              queue.add(neighbour);
            }
          }
        }
        visitedNodes.add(currentNode);
      }
    }

    return false;
  }
}
