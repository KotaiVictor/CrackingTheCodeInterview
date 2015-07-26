package com.kotai.cracking.chapter8.problem1;

public abstract class Card {
  /**
   * Values: 2-10 for regular cards, Jack - 11, Queen - 12, King - 13, Ace - 1
   */
  protected int cardValue;
  protected CardColor color;

  public Card(int value, CardColor color) {
    this.cardValue = value;
    this.color = color;
  }

  public abstract int getValue();

  public CardColor getCardColor() {
    return this.color;
  }
}
