package edu.cnm.deepdive.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {

  private List<Card> cards;
  private List<Card> dealt;

  /**
   * Builds deck of {@link Card} values. Fills the list of cards by assigning each {@link Suit} to
   * the full range of {@link Rank} values.
   */
  public Deck() {
    cards = new ArrayList<>();
    dealt = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));

      }
    }
  }

  /**
   * Defines the process of dealing. One card at a time is moved from a the {@link Deck} card list
   * to a dealt pile until there are none left.
   *
   * @return {@link Card} value for each dealt card.
   */
  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

  /**
   * Gathers all cards and shuffles according to {@link Collections} method.
   *
   * @param rng generates random number for a fair shuffle.
   */
  public void shuffle(Random rng) {
    gather();
    Collections.shuffle(cards, rng);
  }

  private void gather() {
    cards.addAll(dealt);
    dealt.clear();
  }

  public int remaining() {
    return cards.size();
  }

  public int dealt() {
    return dealt.size();
  }

  @Override
  public String toString() {
    return cards.toString();
  }

  public void sort(boolean gather) {
    if (gather) {
      gather();
    }
    cards.sort((card1, card2) -> {
     int result = card1.getSuit().compareTo(card2.getSuit());
     if (result == 0) {
       result = card1.getRank().compareTo(card2.getRank());
     }
     return result;
    });
  }

}

