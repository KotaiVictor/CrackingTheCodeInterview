package com.kotai.cracking.chapter3.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter3.SortedStack;

public class SortedStackTest {

  private SortedStack<Integer> sortedStack;

  @Before
  public void setup() {
    sortedStack = new SortedStack<>();
  }

  @Test
  public void new_sorted_stack_is_emtpy() {
    assertThat(sortedStack.isEmpty(), equalTo(true));
  }

  @Test
  public void pushing_element_to_the_stack_makes_it_not_be_empty() {
    for (int i = 0; i < 5; i++)
      sortedStack.push(i);

    assertThat(sortedStack.isEmpty(), equalTo(false));
  }

  @Test
  public void pushing_and_then_popping_elements_leaves_stack_empty() {
    for (int i = 0; i < 5; i++)
      sortedStack.push(i);

    for (int i = 0; i < 5; i++)
      sortedStack.pop();

    assertThat(sortedStack.isEmpty(), equalTo(true));
  }

  @Test
  public void peeking_returns_the_sorted_value() {
    sortedStack.push(10);
    sortedStack.push(20);

    assertThat(sortedStack.peek(), equalTo(10));
  }

  @Test
  public void pushing_and_then_popping_several_values_returns_them_in_ascending_order() {
    sortedStack.push(5);
    sortedStack.push(10);
    sortedStack.push(1);
    sortedStack.push(4);

    assertThat(sortedStack.pop(), equalTo(1));
    assertThat(sortedStack.pop(), equalTo(4));
    assertThat(sortedStack.pop(), equalTo(5));
    assertThat(sortedStack.pop(), equalTo(10));
    assertThat(sortedStack.pop(), equalTo(null));
  }
}
