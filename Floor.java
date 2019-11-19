import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Floor {
    private Room[] rooms;
   // private ArrayList<Room> roomChange;
    private int numSpaces;
    private int level;
    private int size;

    public Floor(int size, int level) {
    	this.size = size;
    	rooms = new Room[size];
    	numSpaces = 0;
    	this.level = level;
    	createEmptyRooms();
    }
    
    public void createEmptyRooms() {

    	for (int i = 0; i < size; i++) {
    		rooms[i] = new Room(0, 0, 0, 0, " ");
    		numSpaces ++;
    	}
    }

	public static void readFloorPlan() throws IOException{

	}

	public void addRoom(Room r) {
		if(numSpaces < size) {
			rooms[numSpaces] = r;
			numSpaces++;
		}
	}
	
	public Room getRoom(int roomNum) {
		return rooms[roomNum - 1];
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


}
