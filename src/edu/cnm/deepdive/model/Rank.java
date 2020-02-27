package edu.cnm.deepdive.model;

/**
 * Encapsulates all rank values for a standard deck of playing cards and associates each with a 1-2
 * character {@link #symbol()} for condensed reference to individual cards.
 */
public enum Rank {
  ACE,
  TWO,
  THREE,
  FOUR,
  FIVE,
  SIX,
  SEVEN,
  EIGHT,
  NINE,
  TEN,
  JACK,
  QUEEN,
  KING;

  private static final String[] symbols = {
      "A",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9",
      "10",
      "J",
      "Q",
      "K"
  };

  public String symbol() {
    return symbols[ordinal()];
  }
}
