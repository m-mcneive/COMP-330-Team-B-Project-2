import java.util.*;
import java.io.*;

public class Map {
	static Floor[] building = new Floor[4]; //ie Doyle would have levels equal to 4;
	private String last_name;
	private int roomm;
	private String status;

	public Map(int size) {
		Floor second = new Floor(size,2);
		Floor third = new Floor(size,3);
		building[0] = second;
		building[1] = third;
		
		last_name = "";
		roomm = 321;
		status = "";
	}
	
	public void setConnection(String last_name, int room, String status) {
		this.last_name = last_name;
		this.roomm = 321;
		this.status = status;
	}


}
