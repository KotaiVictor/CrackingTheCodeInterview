package com.kotai.cracking.chapter4.test;

import static com.kotai.cracking.chapter4.BinaryTreeCreator.height;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.kotai.cracking.chapter4.BinaryTreeCreator;

public class BinaryTreeCreatorTest {
  private BinaryTreeCreator treeCreator = new BinaryTreeCreator();

  @Test
  public void three_element_list_gets_transformed_into_a_2_height_tree() {
    List<Integer> list = Stream.of(10, 11, 12).collect(Collectors.toList());

    assertThat((height(treeCreator.createBinaryTreeFromList(list))), equalTo(2));
  }

  @Test
  public void five_element_list_gets_transformed_into_a_3_height_tree() {
    List<Integer> list = Stream.of(10, 11, 12, 13, 14).collect(Collectors.toList());
    assertThat(height(treeCreator.createBinaryTreeFromList(list)), equalTo(3));
  }

  @Test
  public void seven_element_list_gets_transformed_into_a_3_height_tree() {
    List<Integer> list = Stream.of(10, 11, 12, 13, 14, 15, 16).collect(Collectors.toList());
    assertThat(height(treeCreator.createBinaryTreeFromList(list)), equalTo(3));
  }

  @Test
  public void four_element_list_gets_transformed_into_a_3_height_tree() {
    List<Integer> list = Stream.of(10, 11, 12, 14).collect(Collectors.toList());
    assertThat(height(treeCreator.createBinaryTreeFromList(list)), equalTo(3));
  }
}
