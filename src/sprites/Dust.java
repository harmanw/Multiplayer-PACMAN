package sprites;

import game.Constants;

/**
 * A representation of a Dust particle.
 * @author wadhwaha
 *
 */
public class Dust extends Dirt {
  
  /**
   * Creates a new Dust Particle at the given (row,column) position on the grid.
   * @param row row index of Dust object on the grid
   * @param column column index of Dust object on the grid
   * @param value Value of score to allocate the player who cleans a dust particle
   */
  public Dust(int row, int column, int value) {
    // call superclass
    super(Constants.DUST, row, column, Constants.DUST_SCORE);

  }

}
