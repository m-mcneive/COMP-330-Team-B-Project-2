import java.util.*;
import java.io.*;

public class Map {
static Floor[] building = new Floor[4]; //ie Doyle would have levels equal to 4;

public static void main(String args[]){
	Floor second = new Floor(15,2);
	Floor third = new Floor(15,3);
	building[0] = second;
	building[1] = third;
	
}
}
