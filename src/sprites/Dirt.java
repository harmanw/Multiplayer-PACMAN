package sprites;

import game.Constants;

/**
 * Representation of a dirt particle.
 * @author wadhwaha
 *
 */
public abstract class Dirt extends Sprite {

  private int value; //value to allocate to the player who cleans a dirt particle
  /**
 * Creates a new Dirt Object with given symbol symbol, coordinates row,column and a value.
 * @param symbol symbol of the dirt object
 * @param row row number of its position on the grid
 * @param column column number of it's position on the grid
 * @param value no of dirt objects at the position
 */
  
  public Dirt(char symbol, int row, int column, int value) {
    super(symbol, row, column);
    this.value = value;
  }
  
  /**
   * Returns the value of the dirt object.
   * @return the value of the dirt object
   */
  
  public int getValue() {
    return value;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + value;
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Dirt other = (Dirt) obj;
    if (value != other.value) {
      return false;
    }
    return true;
  }


}
