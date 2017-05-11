package com.kotai.cracking.chapter4;

import com.kotai.cracking.samples.graph.Graph;
import com.kotai.cracking.samples.graph.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
                List<Node<T>> adjacentNodes = currentNode.getAdjacentNodes();
                if (adjacentNodes != null) {
                    if (adjacentNodes.contains(endNode)) {
                        return true;
                    }
                    queue.addAll(adjacentNodes.stream().filter(node -> !visitedNodes.contains(node))
                            .collect(Collectors.toList()));
                    visitedNodes.add(currentNode);
                }
            }
        }

        return false;
    }
}
