package com.kotai.cracking.chapter3.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter3.StackOfStacks;

public class StackOfStacksTest {

  private final int size_of_stack = 4;
  private StackOfStacks<Integer> stack;

  @Before
  public void setup() {
    stack = new StackOfStacks<Integer>(size_of_stack);
  }

  @Test
  public void adding_more_nodes_than_height_creates_internal_stacks() {
    for (int i = 0; i < 15; i++)
      stack.push(i);
    assertThat(stack.getStackCount(), equalTo(4));
  }

  @Test
  public void popping_nodes_deletes_internal_stacks() {
    for (int i = 0; i < 15; i++)
      stack.push(i);

    assertThat(stack.pop(), equalTo(14));
    assertThat(stack.pop(), equalTo(13));
    assertThat(stack.pop(), equalTo(12));
    assertThat(stack.pop(), equalTo(11));

    assertThat(stack.getStackCount(), equalTo(3));
  }

  @Test
  public void popping_nodes_at_a_specific_stack_deletes_internal_stacks() {
    for (int i = 0; i < 15; i++)
      stack.push(i);

    assertThat(stack.popAt(1), equalTo(7));
    assertThat(stack.popAt(1), equalTo(6));
    assertThat(stack.popAt(1), equalTo(5));
    assertThat(stack.getStackCount(), equalTo(4));
    assertThat(stack.popAt(1), equalTo(4));
    assertThat(stack.getStackCount(), equalTo(3));
    assertThat(stack.popAt(1), equalTo(11));
  }
}
