import java.io.*;
import java.util.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.imageio.*;

public class FloorLayout {
	   static String two = "C:\\Users\\Alexander\\git\\COMP-330Project-2\\src\\D2F.jpg";
	   static String three ="C:\\Users\\Alexander\\git\\COMP-330Project-2\\src\\D3F.jpg";
	   static BufferedImage image2 = null;
	   static BufferedImage image3 = null;
	   static File second = null;
	   static File third = null;
	   static Graphics2D twoFloor;
	   static Graphics2D threeFloor;
	   static JLabel floor;
	   static int height, width; // dimensions of jpg
	   static int screenWidth, screenHeight;
       static Dimension imgSize, boundary, output;
       static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
	     public static void readFloorPlan() throws IOException{
		
			try {
				second = new File(two); // image file path for floor two
				third = new File(three);
				image2 =ImageIO.read(second);
				image3 =ImageIO.read(third);
				height = image2.getHeight();
				width = image2.getWidth();
				Dimension imgSize = new Dimension(width, height);
				screenWidth = screenSize.width;
				screenHeight = screenSize.height;
				Dimension boundary = new Dimension(screenHeight / 2,screenWidth / 2);
				Dimension output = getScaledDimension(imgSize,boundary);
				twoFloor = image2.createGraphics();
			    threeFloor = image3.createGraphics();
				System.out.println("Reading complete");
			}
			catch(IOException e) {
				System.out.println("Error: unable to read " + e);
			}
			
		}
		
		public static void editFloorPlan(Room r,Floor f) { //trigger after changing room status to update it on map
			int roomX = r.getXPos();
			int roomY = r.getYPos();
			int status = r.getStatus();
			
			if(f.getLevel() == 2) {
				twoFloor.clearRect(roomX,roomY,5,5);
				twoFloor.setColor(new Color(0,0,0));
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
				twoFloor.dispose();
				try {
				ImageIO.write(image2,"jpg",second);
				}
				catch (IOException e) {
					System.out.println("Error in saving file image2 to file location.");
				}
				
				
			}
			if(f.getLevel() == 3) {
				threeFloor.clearRect(roomX,roomY,3,3);
				threeFloor.setColor(new Color(0,0,0));
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
			threeFloor.dispose();
			try {
				ImageIO.write(image3,"jpg",third);
				}
				catch (IOException e) {
					System.out.println("Error in saving file image2 to file location.");
				}
		}
		
		public static void printFloorPlan(Floor f) {
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
		
		public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

		    int original_width = imgSize.width;
		    int original_height = imgSize.height;
		    int bound_width = boundary.width;
		    int bound_height = boundary.height;
		    int new_width = original_width;
		    int new_height = original_height;

		    // first check if we need to scale width
		    if (original_width > bound_width) {
		        //scale width to fit
		        new_width = bound_width;
		        //scale height to maintain aspect ratio
		        new_height = (new_width * original_height) / original_width;
		    }

		    // then check if we need to scale even with the new height
		    if (new_height > bound_height) {
		        //scale height to fit instead
		        new_height = bound_height;
		        //scale width to maintain aspect ratio
		        new_width = (new_height * original_width) / original_height;
		    }

		    return new Dimension(new_width, new_height);
		}  
		
}
