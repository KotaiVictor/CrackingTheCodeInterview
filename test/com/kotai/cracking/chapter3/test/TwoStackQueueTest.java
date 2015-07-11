package com.kotai.cracking.chapter3.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter3.TwoStackQueue;

public class TwoStackQueueTest {

  private TwoStackQueue<Integer> queue;

  @Before
  public void setup() {
    queue = new TwoStackQueue<>();
  }

  @Test
  public void peek_works_on_the_queue() {
    queue.enqueue(10);
    queue.enqueue(11);

    assertThat(queue.peek(), equalTo(10));
  }

  @Test
  public void enqueued_items_get_dequeued_in_proper_order() {
    queue.enqueue(10);
    queue.enqueue(11);
    queue.enqueue(12);

    assertThat(queue.dequeue(), equalTo(10));
    assertThat(queue.dequeue(), equalTo(11));
    assertThat(queue.dequeue(), equalTo(12));
    assertThat(queue.dequeue(), equalTo(null));
  }
}
