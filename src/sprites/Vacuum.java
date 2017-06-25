package sprites;

import game.Constants;

/**
 * A representation of a Vacuum.
 * 
 * @author wadhwaha
 *
 */
public class Vacuum extends Sprite {


  private int score = Constants.INIT_SCORE;     // Player's initial score
  private int capacity = Constants.CAPACITY;   // Vacuum's capacity
  private int fullness = Constants.EMPTY;     // Vacuem's initial fullness
  private Sprite under = new CleanHallway(this.getRow(),this.getColumn());


  /**
   * Creates a new Vacuum with the given symbol symbol, at the given coordinates (row, column).
   * @param symbol the symbol of the new Vacuum
   * @param row the row number of the new Vacuum
   * @param column the new column of the new Vacuum
   * @param capacity the no of dust particles of the new vacuum can hold
   * 
   */

  public Vacuum(char symbol, int row, int column, int capacity) {
    // call superclass
    super(symbol, row, column);
    this.capacity = Constants.CAPACITY;
  }
  
  /**
   *  Moves the Vacuum to a new psoition by Updating the cooridnates.
   * @param row new row index of the Vacuum on the grid
   * @param column new column index of the vacuum on the grid
   */
  
  public void moveTo(int row, int column) {
    // call superclass
    super.updateCoordinates(row, column);
  }

  /**
   * Returns true if the vacuum cleans the object uder it.
   * Check if the vacuum can clean the object under it.
   * if it can, clean the sprite and add the score to the vacuum.
   * @param score the score the vacuum gets for cleaning the sprite under it
   * @return true iff the object under the vacuum can be cleabed
   */
  
  public boolean clean(int score) {
    boolean cleaned = false ;
    if (this.under.getSymbol() == Constants.CLEAN | this.under.getSymbol() == Constants.DUMPSTER) {
      if (this.getFullness() == this.getCapacity()) {
        cleaned = false;
      } 
    } else {
      this.score += score;
      cleaned = true;
    }
    return cleaned;
      
  }
  
  /**
   * Returns the fullness of the Vacuum.
   * @return the fullness of the Vacuum
   */
  
  public int getFullness() {
    return fullness;
  }

  /**
   * Sets the Fullness of the Vacuum.
   * @param fullness The fullness to set
   */
  public void setFullness(int fullness) {
    this.fullness = fullness;
  }

  /**
   * Returns the Capacity of the Vacuum.
   * @return the capacity of the Vacuum
   */
  
  public int getCapacity() {
    return capacity;
  }

  /**
   * Empties the Vacuum.
   * Makes the fullness the empty constant
   */
  public void empty() {
    this.fullness = Constants.EMPTY;
  }

  /**
   * Returns the object under the Vacuum.
   * @return the object under the Vacuum
   */
  public Sprite getUnder() {
    return under;
  }

  /**
   * Sets the sprite under under the vacuum.
   * @param under the sprite to set under the vacuum
   */
  public void setUnder(Sprite under) {
    this.under = under;
  }

  /**
   * Returns the score of the player.
   * @return the score of the player
   */
  public int getScore() {
    return score;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
