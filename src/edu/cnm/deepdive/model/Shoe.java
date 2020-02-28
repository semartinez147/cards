package edu.cnm.deepdive.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Shoe {

  private List<Card> cards;
  private Random rng;
  private List<Card> dealt;

  public Shoe(Iterable<Deck> decks, Random rng) {

    dealt = new LinkedList<>();
    cards = new ArrayList<>();

    for (Deck deck : decks) {
      while (deck.deal() != null) {
        cards.add(deck.deal());
      }
      break;
      }
    this.rng = rng;
    }

  public void shuffle() {
    cards.addAll(dealt);
    dealt.clear();
    Collections.shuffle(cards, rng);
  }
  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
      if (card != null) {
        dealt.add(card);
      }
      return card;
  }


}
