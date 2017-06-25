package game;

import java.util.HashMap;
import java.util.Map;

/**
 * Representation of a MapGrid containing objects of type T.
 * @author wadhwaha
 *
 */
public class MapGrid<T> extends Grid<T> {
  
  private Map<Integer,Map<Integer, T>> gridmap = new HashMap<Integer, Map<Integer, T>>();
  private int numRows;    // number of rows in MapGrid
  private int numColumns;   // number of columns in MapGrid 
  
  /**
   * Creates a new empty MapGrid with the given number of rows and columns.
   * @param numRows the number of rows in the MapGrid
   * @param numColumns the number of columns in the MapGrid
   */

  public MapGrid(int numRows, int numColumns) {
    this.numColumns = numColumns;
    this.numRows = numRows;
    
    // Create an empty MapGrid (null at each position)
    for (int k = 0; k < numColumns; k++) {
      Map<Integer,T> newgrid = new HashMap<>();
      gridmap.put(k, newgrid);
      for (int j = 0; j < numRows; j++) {
        gridmap.get(k).put(j, null);
      }
    }   
  }

  /* (non-Javadoc)
   * @see game.Grid#getCell(int, int)
   */
  @Override
  public T getCell(int row, int column) {
    return gridmap.get(row).get(column);
  }


  /* (non-Javadoc)
   * @see game.Grid#setCell(int, int, java.lang.Object)
   */
  @Override
  public void setCell(int row, int column, T item) {
    gridmap.get(row).put(column, item);
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
