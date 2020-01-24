package edu.cnm.deepdive.model;

import java.util.Objects;

public class Card {

  private final Suit suit;
  private final Rank rank;
  private final int hash;

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
    hash = Objects.hash(suit, rank);
  }

  public Suit getSuit() {
    return suit;
  }

  public Rank getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return rank.symbol() + suit.symbol();
  }

  @Override
  public int hashCode() {
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    boolean comparison = false;
    if (obj == this) { // if the object we're testing points to the same heap object as this instance of Card
      comparison = true;
    } else if (obj instanceof Card // if the object is a (different) instance of Card
        && obj.hashCode() == hash) { // and if the hashcodes match
      Card other = (Card) obj; // "other" is an obj that we cast as type Card
      if (suit == other.suit && rank == other.rank);
      comparison = true;
    }

    return comparison;
  }
}
