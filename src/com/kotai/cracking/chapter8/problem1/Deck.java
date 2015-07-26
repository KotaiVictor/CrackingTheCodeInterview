package com.kotai.cracking.chapter8.problem1;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class Deck<T extends Card> {
  private List<T> deckOfCards;
  private List<T> workingDeck;

  public Deck(List<T> deck) {
    this.deckOfCards = Collections.unmodifiableList(deck);
    this.workingDeck = Lists.newArrayList(deck);
  }

  public void reset() {
    workingDeck = Lists.newArrayList(deckOfCards);
  }

  public void shuffle() {
    Collections.shuffle(workingDeck);
  }

  public int remainingCards() {
    return workingDeck.size();
  }

  public List<T> dealHand(int handSize) {
    return workingDeck.stream().limit(handSize).collect(Collectors.toList());
  }

  public T dealCard() {
    if (workingDeck.isEmpty())
      return null;
    return workingDeck.remove(0);
  }
}
