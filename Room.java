import java.util.*;

public class Room {
private int roomNum,xPos,yPos, status;
private String currentProf;

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