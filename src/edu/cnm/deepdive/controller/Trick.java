package edu.cnm.deepdive.controller;

import edu.cnm.deepdive.model.Card;
import edu.cnm.deepdive.model.Deck;
import edu.cnm.deepdive.model.Suit.Color;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Trick {

  private Deck deck;
  private List<Card> redPile;
  private List<Card> blackPile;
  private Random rng = new SecureRandom();

  /**
   * Manages trick by calling each method in the appropriate order.
   *
   * @param args not used.
   */
  public static void main(String[] args) {
    Trick trick = new Trick();
    trick.prepare();
    trick.split();
    trick.swap();
    trick.report();
  }

  /**
   * Creates a new {@link Deck} and shuffles the cards according to {@link Deck} instructions.
   */
  private void prepare() {
    deck = new Deck();
    deck.shuffle(rng);
  }

  /**
   * Defines the main action of the trick.  A card is discarded and its {@link Color} determines the
   * placement of the next card into one of two piles.
   */
  private void split() {
    redPile = new LinkedList<>();
    blackPile = new LinkedList<>();
    for (Card selector = deck.deal(); selector != null; selector = deck.deal()) {
      if (selector.getSuit().color() == Color.BLACK) {
        blackPile.add(deck.deal());
      } else {
        redPile.add(deck.deal());
      }
    }
  }

  /**
   * Defines the "twist."  A random, equal number of cards is passed from the top of each pile into
   * the other.
   */
  private void swap() {
    int swapSize = rng.nextInt(1 + Math.min(redPile.size(), blackPile.size()));
    for (int i = 0; i < swapSize; i++) {
      redPile.add(blackPile.remove(0));
      blackPile.add(redPile.remove(0));
    }

  }

  /**
   * Final step.  The contents of each pile is displayed, demonstrating that the count of each
   * {@link Color} in the opposite pile is equivalent.
   */
  private void report() {
    int redCount = 0;
    int blackCount = 0;
    for (Card c : redPile) {
      if (c.getSuit().color() == Color.RED) {
        redCount++;
      }
    }
    for (Card c : blackPile) {
      if (c.getSuit().color() == Color.BLACK) {
        blackCount++;
      }
    }
    System.out.printf("Red Pile: %s.  Red count: %d.%n", redPile, redCount);
    System.out.printf("Black Pile: %s.  Black count: %d.%n", blackPile, blackCount);
  }

}
