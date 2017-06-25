package sprites;

import game.Constants;
/**
 * Representation of a DustBall object.
 * @author wadhwaha
 *
 */

public class DustBall extends Dirt {
  
  /**
   * Creates a new DustBall Object at the given (row,column) position on the grid.
   * @param row row index of DustBall object on the grid
   * @param column column index of DustBall object on the grid
   * @param value Value of score to allocate the player who cleans a DustBall
   */
  public DustBall(int row, int column, int value) {
      super(Constants.DUST_BALL, row, column, Constants.DUST_BALL_SCORE);
  }
    
  /**
   * Updates the cooridinates of the DuatBall when it is moved.
   * @param row new row of the DustBall
   * @param column new column of the DustBall
   */
    
  public void moveTo(int row, int column) {
    // call superclass
    super.updateCoordinates(row, column);
  }

}





