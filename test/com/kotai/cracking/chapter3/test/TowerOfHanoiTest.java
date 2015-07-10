package com.kotai.cracking.chapter3.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.kotai.cracking.chapter3.TowerOfHanoi;
import com.kotai.cracking.chapter3.TowerOfHanoi.Move;

public class TowerOfHanoiTest {

  private TowerOfHanoi tower;

  @Test
  public void solve_1_height_tower() {
    tower = new TowerOfHanoi(1);
    List<Move> moves = tower.solve();

    assertThat(tower.displayStack(2), equalTo("1"));
    assertThat(moves.size(), equalTo(1));
    assertThat(moves.get(0), equalTo(new TowerOfHanoi.Move(1, 0, 2)));
  }

  @Test
  public void solve_2_height_tower() {
    tower = new TowerOfHanoi(2);
    List<Move> moves = tower.solve();

    assertThat(tower.displayStack(2), equalTo("12"));
    assertThat(moves.size(), equalTo(3));
    assertThat(moves, equalTo(Stream.of(new Move(1, 0, 1), new Move(2, 0, 2), new Move(1, 1, 2))
        .collect(Collectors.toList())));
  }

  @Test
  public void solve_3_height_tower() {
    tower = new TowerOfHanoi(3);
    List<Move> moves = tower.solve();

    assertThat(tower.displayStack(2), equalTo("123"));
    assertThat(moves.size(), equalTo(7));
    assertThat(moves,
        equalTo(Stream
            .of(new Move(1, 0, 2), new Move(2, 0, 1), new Move(1, 2, 1), new Move(3, 0, 2),
                new Move(1, 1, 0), new Move(2, 1, 2), new Move(1, 0, 2))
            .collect(Collectors.toList())));
  }
}
