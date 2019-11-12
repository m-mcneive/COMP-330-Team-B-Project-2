import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Floor  {
    private Room[] rooms;
   // private ArrayList<Room> roomChange;
    private int numSpaces; //array Room[] size current count
    private int level;  // floor level
    private int size;   //number of rooms 
    FloorLayout number = new FloorLayout();
   
    
    public Floor(int size, int level) {
    	this.size = size;
    	rooms = new Room[size];
    	numSpaces = 0;
    	this.level = level;
    }
    
    public void addRoom(Room r) {
		if(numSpaces < size) {
			rooms[numSpaces] = r;
			numSpaces++;
		}
	}
	/*
	public void removeRoom(Room r, int index) {
		if(numSpaces > 1 && index < rooms.length - 1) {
		roomChange = new ArrayList<Room>(Arrays.asList(rooms));
		roomChange.remove(index);
		roomChange.toArray(rooms);
		
		}
	}
	*/
    
    public int getLevel() {
    	return level;
    }
    
    public void setUpFloorLayout() {
    		try {
    		number.readFloorPlan();
    		}
    		catch (IOException e) {
    			System.out.println("Error in read of Floor.readFloorPlan().");
    		}
    	for(int i = 0; i < size; i++) {
    		Room statusChanger = rooms[i];
    		number.editFloorPlan(statusChanger, this); // should update the map of the floor based on each room's status	
    	}
    	number.printFloorPlan(this);
    }
    
	
	
	
}
