import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.imageio.*;

public class GridTest {
	 String two = "C:\\Users\\Alexander\\git\\COMP-330Project-2\\src\\D2F.jpg";
	 String three ="C:\\Users\\Alexander\\git\\COMP-330Project-2\\src\\D3F.jpg";
	 BufferedImage twoFloor,threeFloor;
	 Graphics2D twoMapFloor,threeMapFloor;

	
	public void readFloorPlan(int floorLevel) throws IOException {
		try {
			if(floorLevel == 2) {
			twoFloor = ImageIO.read(new File(two));
			twoMapFloor = twoFloor.createGraphics();

			}
			else if (floorLevel == 3) {
			threeFloor = ImageIO.read(new File(three));
			threeMapFloor = threeFloor.createGraphics();
			}
		}
		catch (IOException e) {
		System.out.println("Error in creating buffered image for " + floorLevel);	
		}
		System.out.println("Finished reading file.");
	}
	
	public void editFloorPlan(Room r, Floor f) {
		int roomX = r.getXPos();
		int roomY = r.getYPos();
		int status = r.getStatus();
		
		if(f.getLevel() == 2) {
			twoMapFloor.setColor(Color.BLACK);
			switch(status) {
			case 1:  //1 = Open = green
				twoMapFloor.drawRect(roomX, roomY, 20, 20);
				twoMapFloor.setColor(Color.GREEN);
				twoMapFloor.fillRect(roomX, roomY, 20, 20);
				break;
				
			case 2:  //2 = Occupied/With Student but in building = yellow
				twoMapFloor.drawRect(roomX, roomY, 20, 20);
				twoMapFloor.setColor(Color.YELLOW);
				twoMapFloor.fillRect(roomX, roomY, 20, 20);
				break;
			
			case 3:  //3 = Closed/now in building = red
				twoMapFloor.drawRect(roomX, roomY, 20, 20);
				twoMapFloor.setColor(Color.RED);
				twoMapFloor.fillRect(roomX, roomY, 20, 20);
				break;
			}
			twoMapFloor.dispose();	
		}
		if(f.getLevel() == 3) {
			threeMapFloor.setColor(Color.BLACK);
			switch(status) {
			case 1:  //1 = Open = green
				threeMapFloor.drawRect(roomX, roomY, 20, 20);
				threeMapFloor.setColor(Color.GREEN);
				threeMapFloor.fillRect(roomX, roomY, 20, 20);
				break;
				
			case 2:  //2 = Occupied/With Student but in building = yellow
				threeMapFloor.drawRect(roomX, roomY, 20, 20);
				threeMapFloor.setColor(Color.YELLOW);
				threeMapFloor.fillRect(roomX, roomY, 20, 20);
				break;
			
			case 3:  //3 = Closed/now in building = red
				threeMapFloor.drawRect(roomX, roomY, 20, 20);
				threeMapFloor.setColor(Color.RED);
				threeMapFloor.fillRect(roomX, roomY, 20, 20);
				break;
			}
			threeMapFloor.dispose();
		}
		System.out.println("Done drawing");
	}
	
	public void displayFinalMap(int floorLevel) {
		JFrame frame = buildFrame();
		 JPanel pane = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                if (floorLevel == 2) {
	                twoFloor = sizeChange(twoFloor,twoFloor.getWidth(),twoFloor.getHeight(), 0.40,BufferedImage.TYPE_4BYTE_ABGR);
	                g.drawImage(twoFloor, 300, -100, null);
	                try {
						saveImage(2);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                }
	                else if (floorLevel == 3) {
	                	threeFloor = sizeChange(threeFloor,threeFloor.getWidth(),threeFloor.getHeight(), 0.40,BufferedImage.TYPE_4BYTE_ABGR);
		                g.drawImage(threeFloor, 300, -100, null);
	                try {
						saveImage(3);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                }
	            }

				
	        };
	        JScrollPane scrollBar=new JScrollPane(pane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	        
	        frame.add(scrollBar);
	       
	        frame.setVisible(true);
	}
	
	  
	private JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(2500,3300);
        return frame;
    }
	
	public void saveImage(int floorLevel) throws IOException {
		if(floorLevel == 2) {
		try {
		ImageIO.write(twoFloor,"jpg", new File("D2F.jpg"));
		 }
		catch (IOException e){
			System.out.println("Error in saving buffered image for " + floorLevel);	
		 }
		}
		else if (floorLevel == 3) {
			try {
			ImageIO.write(threeFloor,"jpg", new File("D3F.jpg"));	
			}
			catch (IOException e){
				System.out.println("Error in saving buffered image for " + floorLevel);	
			}
		}
	}
	
	public BufferedImage sizeChange (BufferedImage originalImage, int imageWidth, int imageHeight ,double zoomLevel, int imageType) {
		int newImageWidth = (int) (imageWidth * zoomLevel);
		int newImageHeight = (int) (imageHeight * zoomLevel);
		BufferedImage resizedImage = new BufferedImage(newImageWidth , newImageHeight, imageType);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newImageWidth , newImageHeight , null);
		g.dispose();
		return resizedImage;
	}
	
	
	public static void main(String[] args) {
		Floor test = new Floor(1,2);
		Room greenberg = new Room(216,1650,2600,1,"Greenberg");
		test.addRoom(greenberg);
		GridTest map = new GridTest();
		try {
			map.readFloorPlan(test.getLevel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.editFloorPlan(greenberg, test); 
		map.displayFinalMap(test.getLevel()); 
		
	}
	
}
