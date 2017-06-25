package ui;

import game.Constants;
import game.VacuumGame;
import sprites.Vacuum;

import java.util.Scanner;

/**
 * A simple TextUI for the Game.
 * @author wadhwaha
 */

public class TextUi implements Ui {
  
  private VacuumGame game;
  
  /**
   * Initializes a TextUi for the given VacuumGame.
   * 
   * @param game The VacuumGame of this TextUi
   */
  
  public TextUi(VacuumGame game) {
    this.game = game;
    
  }
  /* (non-Javadoc)
   * @see ui.Ui#launchGame()
   */
  
  @Override
  public void launchGame() {
    
    int numRows = game.getNumRows();
    int numCols = game.getNumColumns();
    // display the inital grid map
    
    System.out.println(game.getGrid().toString());
    
    // accept user input in the console (System.in)
    
    Scanner sc = new Scanner(System.in);
    
    while (!game.gameOver()) {
      String strInput = sc.nextLine();
      char charInput = strInput.charAt(0);
      game.move(charInput);
      
      // Display Game Statistics after each Move in the form
      // Vacuum score score | Fullness fullness/capacity
     
      System.out.print("Vacuum1 score " + game.getVacuumOne().getScore());
      System.out.print(" | Fullness " + game.getVacuumOne().getFullness());
      System.out.println("/" + game.getVacuumOne().getCapacity());
      
      System.out.print("Vacuum2 score " + game.getVacuumTwo().getScore());
      System.out.print(" | Fullness " + game.getVacuumTwo().getFullness());
      System.out.println("/" + game.getVacuumTwo().getCapacity());
   
      // Display grid after movement
      System.out.println(game.getGrid());
    }
  }
    


      
  
  /* (non-Javadoc)
   * @see ui.Ui#displayWinner()
   */
  @Override
  public void displayWinner() {
    // TODO Auto-generated method stub
    if (!game.gameOver()) {
      return;
    }
    char won = game.getWinner();
    String message;
    if (won == Constants.TIE) {
      message = "It's a tie!";
    } else {
      Vacuum winner = (won == Constants.P1) ? game.getVacuumOne() : game.getVacuumTwo();
      int score = winner.getScore();
      message = String.format("Congratulations Player %s! You won the game with a score of %d.",
          winner.toString(), score);
    }
    System.out.println(message);
  }
    
}



