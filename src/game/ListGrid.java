package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a ListGrid containing objects of type T.
 * @author wadhwaha
 *
 */

public class ListGrid<T> extends Grid<T> {
  
  private List<List<T>> grid = new ArrayList<>(); // List of lists 
  private int numRows;    // number of rows in ListGrid
  private int numColumns;    // number of columns in ListGrid
  
  /** Creates a new Empty ListGrid with the given number of rows and columns.
   * @param numRows the number of rows in the ListGrid
   * @param numColumns the number of columns in the ListGrid
   */
  
  public ListGrid(int numRows, int numColumns) {
    this.numRows = numRows;
    this.numColumns = numColumns;
       
    // Create an empty ListGrid (with null at each position)
    for (int k = 0; k < numRows; k++) {
      grid.add(new ArrayList<T>());
      for (int j = 0; j < numColumns; j++) {
        grid.get(k).add(j, null);
      }
    } 
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
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

  /* (non-Javadoc)
   * @see game.Grid#getCell(int, int)
   */
  @Override
  public T getCell(int row, int column) {
    return grid.get(row).get(column);
  }

  /* (non-Javadoc)
   * @see game.Grid#setCell(int, int, java.lang.Object)
   */
  @Override
  public void setCell(int row, int column, T item) {
    grid.get(row).set(column, item);
  }

  /* (non-Javadoc)
   * @see game.Grid#getNumRows()
   */
  @Override
  public int getNumRows() {
    return numRows;
  }

  /* (non-Javadoc)
   * @see game.Grid#getNumColumns()
   */
  @Override
  public int getNumColumns() {
    return numColumns;
  }

  /* (non-Javadoc)
   * @see game.Grid#hashCode()
   */
  @Override
  public int hashCode() {
    return 0;
  }

  
  
  
}
