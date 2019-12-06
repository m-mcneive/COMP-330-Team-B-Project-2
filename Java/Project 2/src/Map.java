
import java.util.*;
import java.io.*;

public class Map {
	static Floor[] building = new Floor[4]; //ie Doyle would have levels equal to 4;
	private String last_name;
	private int room;
	private String status;
	private int floor;

	public Map(int size) {
		Floor second = new Floor(size,2);
		Floor third = new Floor(size,3);
		building[0] = second;
		building[1] = third;
		
		last_name = "";
		room = 0;
		status = "";
		floor = 0;
	}
	
	public void setConnection(String last_name, int room, String status, int floor) {
		this.last_name = last_name;
		this.room = room;
		this.status = status;
		this.floor = floor;
		
		int intStatus = 0;
		
		if (status.equals("in")) {
			intStatus = 1;
		} else if (status.equals("busy")) {
			intStatus = 2;
		} else {
			intStatus = 3;
		}
		System.out.println(floor);
		System.out.println(building[floor - 2]);
		building[floor - 2].getRoom(room).setStatus(intStatus);
		building[floor - 2].getRoom(room).setCurrentProf(last_name);
	}

	public int getRoomStatus(int floor, int num) {
		return building[floor - 2].getRoom(room).getStatus();
	}

	public Floor getFloor(int n){
		return building[n - 2];
	}


}
