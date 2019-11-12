import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FloorLayout {
	    String two = "C:\\Users\\Alexander\\git\\COMP-330Project-2\\src\\D2F.jpg";
	    String three ="C:\\Users\\Alexander\\git\\COMP-330Project-2\\src\\D3F.jpg";
	    BufferedImage image2 = null;
		BufferedImage image3 = null;
		File f = null;
		File g = null;
	    Graphics2D twoFloor;
	    Graphics2D threeFloor;
	    JLabel floor;
	    
	     public void readFloorPlan() throws IOException{
		
			try {
				f = new File(two); // image file path for floor two
				g = new File(three);
				image2 =ImageIO.read(f);
				image3 =ImageIO.read(g);
				twoFloor = image2.createGraphics();
			    threeFloor = image3.createGraphics();
				System.out.println("Reading complete");
			}
			catch(IOException e) {
				System.out.println("Error: unable to read " + e);
			}
			
		}
		
		public void editFloorPlan(Room r,Floor f) { //trigger after changing room status to update it on map
			int roomX = r.getXPos();
			int roomY = r.getYPos();
			int status = r.getStatus();
			
			if(f.getLevel() == 2) {
				twoFloor.clearRect(roomX,roomY,5,5);
				switch(status) {
				case 1:  //1 = Open = green
					twoFloor.drawRect(roomX, roomY, 5, 5);
					twoFloor.setColor(new Color(0,204,0));
					twoFloor.fillRect(roomX, roomY, 5, 5);
					break;
					
				case 2:  //2 = Occupied/With Student but in building = yellow
					twoFloor.drawRect(roomX, roomY, 5, 5);
					twoFloor.setColor(new Color(255,255,0));
					twoFloor.fillRect(roomX, roomY, 5, 5);
					break;
				
				case 3:  //3 = Closed/now in building = red
					twoFloor.drawRect(roomX, roomY, 5, 5);
					twoFloor.setColor(new Color(255, 0, 0));
					twoFloor.fillRect(roomX, roomY, 5, 5);
					break;
				}
				
			}
			if(f.getLevel() == 3) {
				threeFloor.clearRect(roomX,roomY,3,3);
				switch(status) {
				case 1:  //1 = Open = green
					threeFloor.drawRect(roomX, roomY, 5, 5);
					threeFloor.setColor(new Color(0,204,0));
					threeFloor.fillRect(roomX, roomY, 5, 5);
					break;
					
				case 2:  //2 = Occupied/With Student but in building = yellow
					threeFloor.drawRect(roomX, roomY, 5, 5);
					threeFloor.setColor(new Color(255,255,0));
					threeFloor.fillRect(roomX, roomY, 5, 5);
					break;
				
				case 3:  //3 = Closed/now in building = red
					threeFloor.drawRect(roomX, roomY, 5, 5);
					threeFloor.setColor(new Color(255, 0, 0));
					threeFloor.fillRect(roomX, roomY, 5, 5);
					break;
				}
			}
		}
		
		public void printFloorPlan(Floor f) {
			if(f.getLevel() == 2) {
			floor = new JLabel(new ImageIcon(image2));
			JPanel jpanel = new JPanel();
			jpanel.add(floor);
			JFrame canvas = new JFrame();
			canvas.setSize(new Dimension(image2.getWidth(),image2.getHeight()));
			canvas.add(jpanel);
			canvas.setVisible(true);
			}
			
			if(f.getLevel() == 3) {
				floor = new JLabel(new ImageIcon(image3));
				JPanel jpanel = new JPanel();
				jpanel.add(floor);
				JFrame canvas = new JFrame();
				canvas.setSize(new Dimension(image3.getWidth(),image3.getHeight()));
				canvas.add(jpanel);
				canvas.setVisible(true);
				}
			
		}
		
}
