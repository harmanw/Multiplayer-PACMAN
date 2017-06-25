package game;

/**
 * Representation of a Grid containing objects of type T.
 * @author wadhwaha
 *
 */
public abstract class Grid<T> {

  /**
   * Returns the Cell at the (row,column) position in the Grid.
   * @return the cell at the (row,column) position in the Grid
   */
  
  public abstract T getCell(int row, int column);
  /**
   * Sets the item T at the position (row, column) in the Grid.
   * @param row the row in the 2D grid
   * @param column the column in the 2D grid
   * @param item the item of type T to place at the (row,column) position
   */
  
  public abstract void setCell(int row, int column, T item);
  
  /**
 * Returns the number of rows in the Grid.
 * @return the number of rows in the Grid
 */
  
  public abstract int getNumRows();
  
  /**
   * Returns the number of columns in the Grid.
   * @return the number of columns in the Grid.
   */
  public abstract int getNumColumns();

  @Override
  public boolean equals(Object other) {
    boolean compareRow;
    boolean compareCol;
    boolean compareCells = true;
    Grid<T> obj = (Grid<T>) other;
    compareRow = this.getNumRows() == obj.getNumRows();
    compareCol = this.getNumColumns() == obj.getNumColumns();
   
    for (int row = 0; row < this.getNumRows() ; row++) {
      for (int col = 0; col < this.getNumColumns(); col++) {
        compareCells = compareCells && this.getCell(row, col) == obj.getCell(row, col);
      }
    }
    return compareRow && compareCol && compareCells;
  }
  
  @Override
  public abstract int hashCode();
  
  @Override
  public String toString() {
    
    String gridString = "";
    for (int row = 0; row < getNumRows(); row++) {
      gridString += "\n";
      for (int col = 0; col < getNumColumns() ; col++) {
        gridString += this.getCell(row, col);
      }
    }
    return gridString;
   
  }    
}




