package sprites;

/**
 * Representation of a Sprite Object.
 * @author wadhwaha
 *
 */
public abstract class Sprite {

  private char symbol;          // Sprite's Symbol
  private int row;             // row index in grid
  private int column;         // column index in grid

  /**
   * Creates a new Sprite Object with given symbol and placed at.
   * given row and column index on the grid.
   * @param symbol symbol of the Sprite Object
   * @param row row index on the grid
   * @param column column index on the grid
   */
  public Sprite(char symbol, int row, int column) {
    this.symbol = symbol;         
    this.row = row;               
    this.column = column;         
  }
  /**
   * Returns the Sprites symbol.
   * @return the symbol
   */
  
  public char getSymbol() {
    return symbol;
  }

  /**
   * Returns the Sprites row index in the grid.
   * @return the row
   */
  public int getRow() {
    return row;
  }

  /**
   * Returns the Sprites column index in the grid.
   * @return the column
   */
  public int getColumn() {
    return column;
  }
  /**
    * Updates the cooridinates of the sprite when it is moved.
    * @param row new row of the sprite
    * @param column new column of the sprite
    */
  
  protected void updateCoordinates(int row, int column) {
    this.row = row;
    this.column = column; 
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "" + this.getSymbol();
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + column;
    result = prime * result + row;
    result = prime * result + symbol;
    return result;
  }

  /* (non-Javadoc)
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
    Sprite other = (Sprite) obj;
    if (column != other.column) {
      return false;
    }
    if (row != other.row) {
      return false;
    }
    if (symbol != other.symbol) {
      return false;
    }
    return true;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

}
