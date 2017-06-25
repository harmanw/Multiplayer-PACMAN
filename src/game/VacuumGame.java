package game;

import sprites.CleanHallway;
import sprites.Dumpster;
import sprites.Dust;
import sprites.DustBall;
import sprites.Sprite;
import sprites.Vacuum;
import sprites.Wall;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that represents the basic functionality of the vacuum game. This class is responsible for
 * performing the following operations: 1. At creation, it initializes the instance variables used
 * to store the current state of the game. 2. When a move is specified, it checks if it is a legal
 * move and makes the move if it is legal. 3. It reports information about the current state of the
 * game when asked.
 */
public class VacuumGame {

  private Random random; // a random number generator to move the DustBalls
  private Grid<Sprite> grid; // the grid
  private Vacuum vacuum1; // the first player
  private Vacuum vacuum2; // the second player
  private List<Dust> dusts; // the dusts
  private List<DustBall> dustBalls; // the dust balls

  /**
   * Creates a new <code>VacuumGame</code> that corresponds to the given input text file. Assumes
   * that the input file has one or more lines of equal lengths, and that each character in it
   * (other than newline) is a character that represents one of the <code>Sprite</code>s in this
   * game. Uses gridType to implement the grid.
   * 
   * @param layoutFileName path to the input grid file
   * @param gridType the type of grid implementation to use
   */
  public VacuumGame(String layoutFileName, Constants.GridType gridType) throws IOException {
    dusts = new ArrayList<>();
    dustBalls = new ArrayList<>();
    random = new Random();

    // open the file, read the contents, and determine dimensions of the grid
    int[] dimensions = getDimensions(layoutFileName);
    int numRows = dimensions[0];
    int numColumns = dimensions[1];

    if (gridType.equals(Constants.GridType.LIST_GRID)) {
      grid = new ListGrid<>(numRows, numColumns);
    } else {
      grid = new MapGrid<>(numRows, numColumns);
    }
    // open the file again, read the contents, and store them in grid
    Scanner sc = new Scanner(new File(layoutFileName));
    
    for (int row = 0; row < numRows; row++) {
      String nextLine = sc.nextLine();

      /********
       * Initialize the grid
       ********/
      // Populate the Grid
      for (int col = 0; col < numColumns ; col++) {
        Sprite spr = this.charToSprite(nextLine.charAt(col), row, col);
        grid.setCell(row, col, spr);
        if (spr.getSymbol() == Constants.DUST) {
          dusts.add((Dust)spr);
        } else if (spr.getSymbol() == Constants.DUST_BALL) {
          dustBalls.add((DustBall)spr);
        }
      }
    }
    sc.close();
  }


  /*********
   * Lots of methods.
   ************/

  /**
   * Returns the dimensions of the grid in the file named layoutFileName.
   * 
   * @param layoutFileName path of the input grid file
   * @return an array [numRows, numCols], where numRows is the number of rows and numCols is the
   *         number of columns in the grid that corresponds to the given input grid file
   * @throws IOException if cannot open file layoutFileName
   */
  private int[] getDimensions(String layoutFileName) throws IOException {

    Scanner sc = new Scanner(new File(layoutFileName));

    // find the number of columns
    String nextLine = sc.nextLine();
    int numCols = nextLine.length();

    // find the number of rows
    int numRows = 1;
    while (sc.hasNext()) {
      numRows++;
      nextLine = sc.nextLine();
    }

    sc.close();
    return new int[] {numRows, numCols};
  }

  /**
   * Returns the Vacuum vacuum1.
   * @return the Vacuum vacuum1
   */
  public Vacuum getVacuumOne() {
    return vacuum1;
  }

  /**
   * Returns the Vacuum vacuum2.
   * @return the Vacuum vacuum2
   */
  public Vacuum getVacuumTwo() {
    return vacuum2;
  }

  /**
   * Returns the sprite at the (row,column) position on the Grid.
   * @param row row index of sprite position
   * @param column column index of sprite position
   * @return Sprite object at the (row,column) position on the Grid
   */
  
  public Sprite getSprite(int row, int column) {
    return grid.getCell(row, column);
  }
  /**
   * Returns True iff the move the Vacuum is attempting to make is legal.
   * @param row row to which the Vacuum is attempting to move to
   * @param column column to which the Vacuum is attempting to move to
   * @return True iff the move the Vacuum is attempting to make is legal
   */
  
  private boolean authenticateVacuumMove(int row, int column) {
    boolean movePossible = false;
    // get sprite at the position the Vacuum is attempting to move to
    Sprite obj = this.getSprite(row, column);
    // Vacuum cannot move into wall or other player
    if (Wall.class.isInstance(obj) | Vacuum.class.isInstance(obj)) {
      movePossible = false;
    } else {
      movePossible = true;
    }
    return movePossible;
  }
  
  /**
   * Moves the Vacuum on the basis of the given char NextMove.
   * if the move is Valid, the Vacuum will move to it
   * if not, the Vacuum will remain at Original Position
   * @param nextMove intended movement for the Vacuum
   */
  
  private void moveVacuum(char nextMove) {
    // check if move if intended for Vacuum1 or Vacuum2
    
    boolean isVac1A = (nextMove == Constants.P1_UP) | (nextMove == Constants.P1_DOWN);
    boolean isVac1 = isVac1A | (nextMove == Constants.P1_RIGHT) | (nextMove == Constants.P1_LEFT);

    boolean isVac2A = (nextMove == Constants.P2_UP) | (nextMove == Constants.P2_DOWN);
    boolean isVac2 = isVac2A | (nextMove == Constants.P2_RIGHT) | (nextMove == Constants.P2_LEFT);
    // Get the Vacuum for whcih the movement has been input
    if (isVac1 | isVac2) {
      boolean validInput = false;
      Vacuum vac = vacuum1;
      if (isVac1) {
        vac = vacuum1; 
      } else if (isVac2) {
        vac = vacuum2;
      }
      
      int newrow = vac.getRow();
      int newcolumn = vac.getColumn();
      
      // Get the new coordinates for the Vacuum to move to    
      
      if (nextMove == Constants.P1_UP | nextMove == Constants.P2_UP) {
        newrow += Constants.UP;
        validInput = true;
      } else if (nextMove == Constants.P1_DOWN | nextMove == Constants.P2_DOWN) {
        newrow += Constants.DOWN;
        validInput = true;
      } else if (nextMove == Constants.P1_LEFT | nextMove == Constants.P2_LEFT) {
        newcolumn += Constants.LEFT;
        validInput = true;
      } else if (nextMove == Constants.P1_RIGHT | nextMove == Constants.P2_RIGHT) {
        newcolumn += Constants.RIGHT;
        validInput = true;
      } 
      
      // Check if the Vacuum can move to the intended position 
      if (validInput && this.authenticateVacuumMove(newrow, newcolumn)) {
        // Keep the Vacuum's old position as it was bfore the Vacuum had arrived on it
        grid.setCell(vac.getRow(), vac.getColumn(), vac.getUnder());
        
        // Move Vacuum to new position on grid
        vac.moveTo(newrow,newcolumn); 
        vac.setUnder(this.getSprite(newrow, newcolumn));
        grid.setCell(newrow, newcolumn, vac);
       
        // Check action to perform now that the Vacuum has moved to new position
        boolean full = vac.getFullness() == vac.getCapacity();
        int score = 0;
        // if the Vacuum has arrived onto a Dust particle
        
        if (vac.getUnder().getSymbol() == Constants.DUST && !full) {
          // add score and remove the dust particle from the grid
          score += Constants.DUST_SCORE;
          vac.clean(score);
          dusts.remove(vac.getUnder());
          // add fullness
          vac.setFullness(vac.getFullness() + 1);
          // Put a clean hallway sprite where the dust particle was
          vac.setUnder(new CleanHallway(vac.getRow(), vac.getColumn()));  
          
          // if the Vacuum has arrived onto a DustBall
          
        } else if (vac.getUnder().getSymbol() == Constants.DUST_BALL && !full) {
          // add score and remove the dust particle from the grid
          score += Constants.DUST_BALL_SCORE;
          vac.clean(score);
          dustBalls.remove(vac.getUnder()); 
          // add fullness
          vac.setFullness(vac.getFullness() + 1);
          // Put a clean hallway sprite where the dust particle was
          vac.setUnder(new CleanHallway(vac.getRow(), vac.getColumn()));  
          
          // if the Vacuum has arrived onto a Dumpster
          
        } else if (Dumpster.class.isInstance(vac.getUnder())) {
          // Empty the Vacuum
          vac.setFullness(Constants.EMPTY);
        }
      } 
    }
  }
  
  /**
   * Handles the random movement of the dustballs(if it is not under a vacuum).
   * Leaves dust particles where the dustballs have been.
   * @param dustball the dustball to move
   */
  
  private void moveDustBall(DustBall dustball) {
    // check that the dustball is NOT under a vacuum
    
    if (!this.vacuum1.getUnder().equals(dustball) && !this.vacuum2.getUnder().equals(dustball)) {
      // Create a list of valid movements
      // "u" = UP, "d" = DOWN, "r" = RIGHT, "l" = LEFT
      String[] dustballMovement = {"u","d","l","r","-"};
      
      // generate a random index
      int index = random.nextInt(5);
    
      // get coordinates to move dustball to
      int row = dustball.getRow();
      int column = dustball.getColumn();
    
      if (dustballMovement[index] == "u") {
        row += Constants.UP;
      } else if (dustballMovement[index] == "d") {
        row += Constants.DOWN;
      } else if (dustballMovement[index] == "r") {
        column += Constants.RIGHT;
      } else if (dustballMovement[index] == "l") {
        column += Constants.LEFT;
      }
      
      Sprite obj = this.getSprite(row, column);
      
      // if the dustball moves onto a clean hallway
      // leave dust  particle at old position

      if (obj.getSymbol() == Constants.CLEAN) {
        grid.setCell(row, column, dustball);
        Dust mydust = new Dust(dustball.getRow(), dustball.getColumn(), Constants.DUST);
        grid.setCell(dustball.getRow(), dustball.getColumn(), mydust);
        dustball.moveTo(row, column);
        dusts.add(mydust);
        
        // if the dustball moves onto a dust particle 
        // leave dust particle at old position
      } else if (Dust.class.isInstance(obj)) {
        grid.setCell(row, column, dustball);
        Dust mydust = new Dust(dustball.getRow(), dustball.getColumn(), Constants.DUST);
        grid.setCell(dustball.getRow(), dustball.getColumn(), mydust);
        dustball.moveTo(row, column);
      }
    }
  }    

  /**
   * Handles the Movement of the Vacuum and the Dustballs.
   * Vacuum movement depends on the char NextMove 
   * @param nextMove char that represents the next desired move
   */
  
  public void move(char nextMove) {
    // move Vacuum
    this.moveVacuum(nextMove);
   
    // Move DustBalls
    for (int i = 0; i < dustBalls.size() ; i++) {
      this.moveDustBall(dustBalls.get(i));
    }
  }
  /**
   * Returns the number of Rows in the grid.
   * @return number of Rows in the grid
   */
  
  public int getNumRows() {
    return grid.getNumRows();
  }
  /**
   * Returns the number of Columns in the grid.
   * @return number of Columns in the grid
   */
  
  public int getNumColumns() {
    return grid.getNumColumns();
  }
  /**
   * Returns the Grid Object.
   * @return the grid object
   */
  
  public Grid<Sprite> getGrid() {
    return grid;
  }
  /**
   * Returns true iff the Game is Over.
   * Game ends when there are no more dustballs and dust particles
   * @return true iff the Game is Over
   */
  
  public boolean gameOver() {
    boolean endgame = false;
    if (dustBalls.isEmpty() && dusts.isEmpty()) {
      endgame = true;
    }
    return endgame;
  }
  
  /**
   * Returns the Winner(char) of the Game.
   * Player(Vacuum) with the higher score wins
   * Returns TIE if both Vacuum's have same score
   * @return the winning char(Vacuum) of the game
   */
  
  public char getWinner() {
    char win;
    if (vacuum1.getScore() > vacuum2.getScore()) {
      win = Constants.P1;
    } else if (vacuum1.getScore() < vacuum2.getScore()) {
      win = Constants.P2;
    } else {
      win = Constants.TIE; 
    }
    return win;
  }
  /**
   * Returns the Sprite version of the input character read from the file.
   * @param symbol the sybol read from the file to be converted into a Sprite Object
   * @param row the row index at the which the sprite is to be placed
   * @param col the column index at which the sprite is to be placed
   * @return Sprite object depending in the input character
   */
  
  private Sprite charToSprite(char symbol, int row, int col) {
    Sprite spr;
    // Case of Wall
    if (symbol == Constants.WALL) {
      spr = new Wall(row,col);  
      // Case of Vacuum1
    } else if (symbol == Constants.P1) {
      spr = new Vacuum(symbol,row,col, Constants.CAPACITY);
      vacuum1 = (Vacuum)spr;
      // Case of Vacuum2
    } else if (symbol == Constants.P2) {
      spr = new Vacuum(symbol,row,col, Constants.CAPACITY);
      vacuum2 = (Vacuum)spr;
      // Case of Dust particle
    } else if (symbol == Constants.DUST) {
      spr = new Dust(row,col, Constants.DUST_SCORE);
      // Case of DustBall
    } else if (symbol == Constants.DUST_BALL) {
      spr = new DustBall(row, col, Constants.DUST_BALL_SCORE);
      // Case of Dumpster
    } else if (symbol == Constants.DUMPSTER) {
      spr = new Dumpster(row, col);
      // Case of CleanHallway
    } else {
      spr = new CleanHallway(row, col);
    }
    // return the sprite object
    return spr;
  } 
}

  
  

