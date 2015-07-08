package com.kotai.cracking.chapter3.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter3.StackThatKnowsMin;

public class StackThatKnowsMinTest {

  private StackThatKnowsMin<Integer> stack;

  @Before
  public void setup() {
    stack = new StackThatKnowsMin<>();
  }

  @Test
  public void pushing_several_items_keeps_min_accurate() {
    stack.push(10);
    assertThat(stack.min(), equalTo(10));

    stack.push(7);
    assertThat(stack.min(), equalTo(7));

    stack.push(9);
    assertThat(stack.min(), equalTo(7));
  }

  @Test
  public void popping_several_items_keeps_min_accurate() {
    stack.push(10);
    stack.push(7);
    stack.push(11);
    stack.push(5);

    assertThat(stack.min(), equalTo(5));
    stack.pop();
    assertThat(stack.min(), equalTo(7));
    stack.pop();
    assertThat(stack.min(), equalTo(7));
    stack.pop();
    assertThat(stack.min(), equalTo(10));
  }
}
