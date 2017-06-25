package sprites;

import game.Constants;

/**
 * Representation of a Dumpster Object.
 * @author wadhwaha
 *
 */
public class Dumpster extends Sprite {
  
  /**
 * Creates a new Dumpster Object at the given (row, column) position on the grid.
 * @param row row index of Dumpster on grid
 * @param column Column index of Dumpster on grid
 */
  public Dumpster(int row, int column) {
    // Call superclass
    super(Constants.DUMPSTER, row, column);
  }
}

