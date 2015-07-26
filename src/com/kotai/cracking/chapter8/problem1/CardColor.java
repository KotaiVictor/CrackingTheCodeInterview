package com.kotai.cracking.chapter8.problem1;

/*
 * Design the data structures for a generic deck of cards. Explain how you would subclass the data
 * structures to implement blackjack
 */
public enum CardColor {
  Club(0), Diamond(1), Heart(2), Spade(3);

  private int value;

  private CardColor(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public static CardColor getCardColorFromValue(int value) {
    switch (value) {
      case 0:
        return CardColor.Club;
      case 1:
        return CardColor.Diamond;
      case 2:
        return CardColor.Heart;
      case 3:
      default:
        return CardColor.Spade;
    }
  }
}
