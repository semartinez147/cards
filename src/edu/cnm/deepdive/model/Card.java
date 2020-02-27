package edu.cnm.deepdive.model;

import java.util.Comparator;
import java.util.Objects;

/**
 * Encapsulates a single playing card as a combination of {@link Suit} and {@link Rank}.  Instances
 * of this class are immutable.
 *
 * @author Samuel Martinez
 */
public class Card implements Comparable<Card> {

  private final Suit suit;
  private final Rank rank;
  private final int hash;

  /**
   * Initializes the card instance with the specified {@link Suit} and {@link Rank}.
   *
   * @param suit {@link Suit} value of card.
   * @param rank {@link Rank} value of card.
   */
  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
    hash = Objects.hash(suit, rank);
  }

  /**
   * Returns {@link Suit} of this card instance.
   */
  public Suit getSuit() {
    return suit;
  }

  /**
   * Returns {@link Rank} of this card instance.
   */
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
    if (obj
        == this) { // if the object we're testing points to the same heap object as this instance of Card
      comparison = true;
    } else if (obj instanceof Card // if the object is a (different) instance of Card
        && obj.hashCode() == hash) { // and if the hashcodes match
      Card other = (Card) obj; // "other" is an obj that we cast as type Card
      if (suit == other.suit && rank == other.rank) {
        ;
      }
      comparison = true;
    }

    return comparison;
  }

  @Override
  public int compareTo(Card other) {
    return Comparator.comparing(Card::getSuit).thenComparing(Card::getRank).compare(this, other);
  }
}
