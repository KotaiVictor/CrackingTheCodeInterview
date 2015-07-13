package com.kotai.cracking.chapter4.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter4.DirectedGraphPaths;
import com.kotai.cracking.samples.graph.Graph;
import com.kotai.cracking.samples.graph.Node;

public class DirectedGraphPathsTest {

  private DirectedGraphPaths pathFinder = new DirectedGraphPaths();
  private Graph<String> testGraph;

  @Before
  public void setup() {
    testGraph = new Graph<>();
  }

  @Test
  public void path_exists_between_directed_vertices_on_edge() {
    Node<String> one = new Node<>("one");
    Node<String> ten = new Node<>("ten");

    testGraph.addEdge(one, ten);

    assertThat(pathFinder.pathExists(testGraph, one, ten), equalTo(true));
  }

  @Test
  public void paht_doesnt_exist_between_reverse_vertices_on_edge() {
    Node<String> one = new Node<>("one");
    Node<String> ten = new Node<>("ten");

    testGraph.addEdge(one, ten);

    assertThat(pathFinder.pathExists(testGraph, ten, one), equalTo(false));
  }

  @Test
  public void path_doesnt_exist_between_two_edges_on_parallel_lines() {
    Node<String> one = new Node<>("one");
    Node<String> two = new Node<>("two");

    Node<String> ten = new Node<>("ten");
    Node<String> eleven = new Node<>("eleven");

    testGraph.addEdge(one, two);
    testGraph.addEdge(ten, eleven);

    assertThat(pathFinder.pathExists(testGraph, one, ten), equalTo(false));
  }

  @Test
  public void path_exists_in_cycle_graph() {
    Node<String> one = new Node<>("one");
    Node<String> two = new Node<>("two");
    Node<String> three = new Node<>("three");

    testGraph.addEdge(one, two);
    testGraph.addEdge(two, three);
    testGraph.addEdge(three, one);

    assertThat(pathFinder.pathExists(testGraph, one, three), equalTo(true));
    assertThat(pathFinder.pathExists(testGraph, two, one), equalTo(true));
    assertThat(pathFinder.pathExists(testGraph, three, two), equalTo(true));

  }
}
