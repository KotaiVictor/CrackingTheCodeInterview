package com.kotai.cracking.chapter8.problem1;

import java.util.List;

import com.google.common.collect.Lists;

public class Hand<T extends Card> {

  protected List<T> cards;

  public Hand(List<T> cards) {
    this.cards = Lists.newArrayList(cards);
  }

  public int score() {
    return cards.stream().reduce(0, (sum, card) -> sum += card.cardValue,
        (sum1, sum2) -> sum1 + sum2);
  }

  public void addCard(T newCard) {
    cards.add(newCard);
  }
}
