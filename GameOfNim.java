import java.util.Scanner;

public class GameOfNim {
  // constants for the minimum and maximum number of game pieces
  public static final int MIN_PIECES = 1;
  public static final int MAX_PIECES = 100;

  // instance variables
  private int pieces; // the number of game pieces
  private boolean playerTurn; // true if it is the player's turn, false if it is the computer's turn

  // constructor
  public GameOfNim(int pieces) {
    if (pieces < MIN_PIECES || pieces > MAX_PIECES) {
      throw new IllegalArgumentException("Invalid number of pieces: " + pieces);
    }
    this.pieces = pieces;
    playerTurn = true; // player goes first
  }

  // accessor method for the number of pieces
  public int getPieces() {
    return pieces;
  }

  // mutator method for the number of pieces
  public void setPieces(int pieces) {
    if (pieces < MIN_PIECES || pieces > MAX_PIECES) {
      throw new IllegalArgumentException("Invalid number of pieces: " + pieces);
    }
    this.pieces = pieces;
  }

  // method to play a turn of the game
  public void playTurn() {
    if (playerTurn) {
      // player's turn
      Scanner sc = new Scanner(System.in);
      int numPieces;
      do {
        System.out.print("Enter the number of pieces to remove (1-" + (pieces / 2) + "): ");
        numPieces = sc.nextInt();
      } while (numPieces < 1 || numPieces > pieces / 2);
      pieces -= numPieces;
      playerTurn = false; // switch to computer's turn
    } else {
      // computer's turn
      int numPieces = (int)(Math.random() * (pieces / 2)) + 1;
      System.out.println("Computer removes " + numPieces + " pieces.");
      pieces -= numPieces;
      playerTurn = true; // switch to player's turn
    }
  }

  // method to check if the game is over
  public boolean isGameOver() {
    return pieces <= 0;
  }

  // method to determine the winner of the game
  public String getWinner() {
    if (playerTurn) {
      return "You won!";
    } else {
      return "Computer won.";
    }
  }
}

