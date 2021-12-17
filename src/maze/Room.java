/**
 * 
 */
package maze;

import java.io.Serializable;

/**
 * @author stephg02
 *
 */
public class Room implements Serializable {
  
	private static final long serialVersionUID = 469306839098404806L;
/*
   - has door object (up to 4)
   - 4 doors if in middle, 3 doors if edge-side , 2 doors if corner or BUFFER
   - makes up maze locations in 2D array
   - should look like: [ ]
   */
	
	//Position of Room within Maze array
	private int xPos;
	private int yPos;
	private int xEdge;
	private int yEdge;
	private boolean isTom;
	
	String ifPlayer = "[ ]";
	
	//Doors in the Room starting from North, East, South, and then West.
	Door[] cardinalDoors = new Door[4];
	
	public Room(int x, int y, int xEdge, int yEdge) {
		xPos = x;
		yPos = y;
		this.xEdge = xEdge;
		this.yEdge = yEdge;
		isTom = false;
	}
  
  public void setTom(boolean isTom) {
		this.isTom = isTom;
	}

public boolean isTom() {
		return isTom;
	}

public void displayPlayerInRoom() {
	  ifPlayer = "[o]";
  }
  
  public void displayEmptyRoom() {
	  ifPlayer = "[ ]";
  }
  
  public void displayClosedRoom() {
	  ifPlayer = "[x]";
  }
  
  public void wallCheck() {
	  	if (xPos == 1) wallDoor(3); 
		if (yPos == 1) wallDoor(0);
		if (yEdge == 1) wallDoor(1);
		if (xEdge == 1) wallDoor(2);
  }
  
  public void wallDoor(int door) {
	  cardinalDoors[door] = new Door(true);
  }
  
  public Door createDoor(Question theQuestion) {
	return new Door(theQuestion); 
  }  
  
  public boolean doorLocked(int direction) {
	  if (direction < 4) return cardinalDoors[direction].getDoorLock();
	  else return true;
  }
}
