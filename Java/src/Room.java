import java.util.*;

public class Room {
public int roomNum,xPos,yPos, status;
public String currentProf;

public Room(){
	roomNum = 0;
	xPos = 0;
	yPos = 0;
	status = 0;
	currentProf = null;
}

public Room(int roomNum,int xPos, int yPos, int status, String currentProf){
	roomNum = 0;
	this.xPos = xPos;
	this.yPos = yPos;
	this.status = status;
	this.currentProf = currentProf;
}

public int getRoomNum() {
	return roomNum;
}

public void setRoomNum(int roomNum) {
	this.roomNum = roomNum;
}

public int getXPos() {
	return xPos;
}

public void setXPos(int xPos) {
	this.xPos = xPos;
}

public int getYPos() {
	return yPos;
}

public void setYPos(int yPos) {
	this.yPos = yPos;
}

public int getStatus() {
	if(status == 1) {
		System.out.println("Open");
	}
	else if (status == 2) {
		System.out.println("Occupied");
	}
	else if (status == 3) {
		System.out.println("Closed");
	}
	return status;
}

public void setStatus(int status) {
	this.status = status;
}
public String getCurrentProf() {
	return currentProf;
}

public void setCurrentProf(String currentProf) {
	this.currentProf = currentProf;
}

}
