package com.kotai.cracking.chapter2.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kotai.cracking.chapter2.PalindromeCheck;
import com.kotai.cracking.samples.TestNode;

public class PalindromeCheckTest {

  private PalindromeCheck<String> pc = new PalindromeCheck<>();

  @Test
  public void check_valid_palindrome() {
    TestNode<String> node = new TestNode<String>("mimi").appendToTail("lala").appendToTail("mimi");

    assertThat(pc.testPalindrome(node), equalTo(true));
  }

  @Test
  public void check_invalid_palindrome() {
    TestNode<String> node = new TestNode<String>("mimi").appendToTail("lala");
    assertThat(pc.testPalindrome(node), equalTo(false));
  }

  @Test
  public void check_one_node_palindrome() {
    TestNode<String> node = new TestNode<String>("mimi");
    assertThat(pc.testPalindrome(node), equalTo(true));
  }
}
