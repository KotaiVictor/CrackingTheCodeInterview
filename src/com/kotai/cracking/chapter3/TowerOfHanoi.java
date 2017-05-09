package com.kotai.cracking.chapter3;

import java.util.ArrayList;
import java.util.List;

import com.kotai.cracking.samples.TestNode;
import com.kotai.cracking.samples.TestStack;

import lombok.Data;

public class TowerOfHanoi {
  private final int height;
  private HanoiStack[] stacks;

  public TowerOfHanoi(int height) {
    this.height = height;
    initializeTower();
  }

  private void initializeTower() {
    stacks = new HanoiStack[3];
    for (int i = 0; i < 3; i++) {
      stacks[i] = new HanoiStack();
    }

    for (int plates = height - 1; plates >= 0; plates--)
      stacks[0].push(plates);
  }

  public List<Move> solve() {
    return move(height, 0, 1, 2);
  }

  private List<Move> move(int value, int from, int inter, int to) {
    List<Move> moves = new ArrayList<>();
    if (value == 1) {
      moves.add(move(1, from, to));
    } else {
      moves.addAll(move(value - 1, from, to, inter));
      moves.add(move(value, from, to));
      moves.addAll(move(value - 1, inter, from, to));
    }
    return moves;
  }

  private Move move(int value, int from, int to) {
    HanoiStack fromStack = stacks[from];
    HanoiStack toStack = stacks[to];

    int poppedValue = fromStack.pop();
    assert(value == poppedValue);
    toStack.push(value);
    return new Move(value, from, to);
  }

  public String displayStack(int stackNumber) {
    assert(stackNumber >= 0 && stackNumber <= 3);
    return stacks[stackNumber].toString();
  }

  private class HanoiStack extends TestStack<Integer> {
    @Override
    public void push(Integer element) {
      assert(element.compareTo(peek()) >= 0);
      super.push(element);
    }

    @Override
    public String toString() {
      StringBuffer accumulator = new StringBuffer();
      TestNode<Integer> runner = top;
      while (runner != null) {
        accumulator.append(runner.data);
        runner = runner.next;
      }
      return accumulator.toString();
    }
  }

  @Data
  public static class Move {
    private final int diskWeight;
    private final int initialPosition;
    private final int endPosition;

    public Move(int diskWeight, int initialPosition, int endPosition) {
      this.diskWeight = diskWeight;
      this.initialPosition = initialPosition;
      this.endPosition = endPosition;
    }

    @Override
    public boolean equals(Object moveObj) {
      if (moveObj instanceof Move) {
        Move move = (Move) moveObj;
        if (move.diskWeight == this.diskWeight && move.initialPosition == this.initialPosition
            && move.endPosition == this.endPosition)
          return true;
      }
      return false;
    }

    @Override
    public String toString() {
      return "Move " + diskWeight + " from " + initialPosition + " to " + endPosition;
    }
  }
}
