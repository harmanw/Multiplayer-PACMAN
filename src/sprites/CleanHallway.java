package sprites;

import game.Constants;

/**
 * Representation of a CleanHallway.
 * @author wadhwaha

 */
public class CleanHallway extends Sprite {

  /**
   * Creates a new CleanHallway Object at the given (row,Column) position on the grid.
   * @param row row index of CleanHallway object on the grid
   * @param column column index of CleanHallway object on the grid
   */
  public CleanHallway(int row, int column) {
    // call superclass
    super(Constants.CLEAN, row, column);
  }
}
