package sprites;

import game.Constants;

/**
 * Representation of a WALL.
 * @author wadhwaha
 *
 */
public class Wall extends Sprite {

  
  /**
   * Creates a new Wall Object at the given (row,Column) position on the grid.
   * @param row row index of Wall on grid
   * @param column column index of Wall on grid
   */
  public Wall(int row, int column) {
    // Call superClass
    super(Constants.WALL, row, column);
  }
}
