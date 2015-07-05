package com.kotai.cracking.chapter2.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter2.LinkedListAdder;
import com.kotai.cracking.samples.TestNode;

public class LinkedListAdderTest {

  private LinkedListAdder adder = new LinkedListAdder();

  @Test
  public void adding_2_null_nodes_should_return_zero() {
    assertThat(adder.addReverse(null, null).data, equalTo(0));
    assertThat(adder.addReverse(null, null).next, equalTo(null));
  }

  @Test
  public void adding_a_reverse_number_to_null_should_return_the_number() {
    TestNode<Integer> number = new TestNode<Integer>(7).appendToTail(3).appendToTail(1);
    assertThat(adder.addReverse(number, null), equalTo(number));
    assertThat(adder.addReverse(null, number), equalTo(number));
  }

  @Test
  public void adding_2_reverse_numbers_of_the_same_length_no_carry_over() {
    TestNode<Integer> firstNumber = new TestNode<Integer>(7).appendToTail(3).appendToTail(1); // 137
    TestNode<Integer> secondNumber = new TestNode<Integer>(2).appendToTail(4).appendToTail(5); // 542

    TestNode<Integer> resultNumber = new TestNode<Integer>(9).appendToTail(7).appendToTail(6); // 679

    assertThat(adder.addReverse(firstNumber, secondNumber).toList(),
        equalTo(resultNumber.toList()));
  }

  @Test
  public void adding_2_reverse_numbers_of_same_length_with_carry_overs() {
    TestNode<Integer> firstNumber = new TestNode<Integer>(7).appendToTail(3).appendToTail(1); // 137
    TestNode<Integer> secondNumber = new TestNode<Integer>(4).appendToTail(8).appendToTail(9); // 984

    TestNode<Integer> resultNumber =
        new TestNode<Integer>(1).appendToTail(2).appendToTail(1).appendToTail(1); // 1121

    assertThat(adder.addReverse(firstNumber, secondNumber).toList(),
        equalTo(resultNumber.toList()));
  }

  @Test
  public void adding_2_reverse_numbers_of_different_length_with_carry_overs() {
    TestNode<Integer> firstNumber = new TestNode<Integer>(9).appendToTail(9).appendToTail(8);
    TestNode<Integer> secondNumber = new TestNode<Integer>(1);

    TestNode<Integer> resultNumber = new TestNode<Integer>(0).appendToTail(0).appendToTail(9);

    assertThat(adder.addReverse(firstNumber, secondNumber).toList(),
        equalTo(resultNumber.toList()));
  }


  @Test
  public void adding_2_reverse_numbers_of_different_length_with_carry_overs_recursive() {
    TestNode<Integer> firstNumber = new TestNode<Integer>(9).appendToTail(9).appendToTail(8);
    TestNode<Integer> secondNumber = new TestNode<Integer>(1);

    TestNode<Integer> resultNumber = new TestNode<Integer>(0).appendToTail(0).appendToTail(9);

    assertThat(adder.recursiveAdd(firstNumber, secondNumber, 0).toList(),
        equalTo(resultNumber.toList()));
  }

  @Test
  public void adding_2_reverse_numbers_of_same_length_with_carry_overs_recursive() {
    TestNode<Integer> firstNumber = new TestNode<Integer>(7).appendToTail(3).appendToTail(1); // 137
    TestNode<Integer> secondNumber = new TestNode<Integer>(4).appendToTail(8).appendToTail(9); // 984

    TestNode<Integer> resultNumber =
        new TestNode<Integer>(1).appendToTail(2).appendToTail(1).appendToTail(1); // 1121

    assertThat(adder.recursiveAdd(firstNumber, secondNumber, 0).toList(),
        equalTo(resultNumber.toList()));
  }

}
