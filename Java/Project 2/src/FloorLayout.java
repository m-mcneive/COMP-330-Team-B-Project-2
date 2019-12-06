import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class FloorLayout {
    String two = "/Users/gubdev/Documents/GitHub/COMP-330-Team-B-Project-2/Java/Project 2/imgs/DOYLE-2nd-Floor.png"; //* make sure to change this and the and three for the program to work
    String three ="/Users/gubdev/Documents/GitHub/COMP-330-Team-B-Project-2/Java//Project 2/imgs/DOYLE-3rd-Floor.png";
    BufferedImage twoFloor,threeFloor;
    Graphics2D twoMapFloor,threeMapFloor;

    int[][] floor3 = {{0, 0}, {190, 625}, {0, 0}, {180, 520}, {190, 465}, {215, 390}, {210, 330}, {175, 245}, {235, 235}, {345, 235}, {405, 245}, {380, 330}, {370, 430}, {0, 0}, {405, 525}, {400, 585}, {380, 650}};
    int[][] floor2 = {{0, 0}, {200,610}, {0, 0}, {0, 0}, {0, 0}, {230,395}, {220,330} /*206*/, {200,260} /*207*/,{248,246} /*208*/, {340,250} /*209*/, {410,250}, {377,341}, {380,400}, {383,454}, {400,550}, {0, 0}, {390, 628} /*216*/ };


    public void readFloorPlan(int floorLevel) throws IOException {
        try { // load image as bufferedImage and create 2D graphics to be able to draw on it
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
        int roomX = 100;
        int roomY = 100;
        int pixelSize = 10;
        if (f.getLevel() == 2) {
            System.out.println(r.getRoomNum() - 1);
            roomX = floor2[r.getRoomNum() - 1][0];
            roomY = floor2[r.getRoomNum() - 1][1];
        } else {
        	roomX = floor3[r.getRoomNum() - 1][0];
        	roomY = floor3[r.getRoomNum() - 1][1];
        }
        int status = r.getStatus();
        //draw rectangles on image to denote status
        if(f.getLevel() == 2) {
            twoMapFloor.setColor(Color.BLACK);
            switch(status) {
                case 1:  //1 = Open = green
                    twoMapFloor.drawRect(roomX, roomY, pixelSize, pixelSize);
                    twoMapFloor.setColor(Color.GREEN);
                    twoMapFloor.fillRect(roomX, roomY, pixelSize, pixelSize);
                    break;

                case 2:  //2 = Occupied/With Student but in building = yellow
                    twoMapFloor.drawRect(roomX, roomY, pixelSize, pixelSize);
                    twoMapFloor.setColor(Color.YELLOW);
                    twoMapFloor.fillRect(roomX, roomY, pixelSize, pixelSize);
                    break;

                case 3:  //3 = Closed/now in building = red
                    twoMapFloor.drawRect(roomX, roomY, pixelSize, pixelSize);
                    twoMapFloor.setColor(Color.RED);
                    twoMapFloor.fillRect(roomX, roomY, pixelSize, pixelSize);
                    break;
            }

        }
        if(f.getLevel() == 3) {
            threeMapFloor.setColor(Color.BLACK);
            switch(status) {
                case 1:  //1 = Open = green
                    threeMapFloor.drawRect(roomX, roomY, pixelSize, pixelSize);
                    threeMapFloor.setColor(Color.GREEN);
                    threeMapFloor.fillRect(roomX, roomY, pixelSize, pixelSize);
                    break;

                case 2:  //2 = Occupied/With Student but in building = yellow
                    threeMapFloor.drawRect(roomX, roomY, pixelSize, pixelSize);
                    threeMapFloor.setColor(Color.YELLOW);
                    threeMapFloor.fillRect(roomX, roomY, pixelSize, pixelSize);
                    break;

                case 3:  //3 = Closed/now in building = red
                	System.out.println(roomX + " " + roomY);
                    threeMapFloor.drawRect(roomX, roomY, pixelSize, pixelSize);
                    threeMapFloor.setColor(Color.RED);
                    threeMapFloor.fillRect(roomX, roomY, pixelSize, pixelSize);
                    break;
            }

        }

        System.out.println("Done drawing");
    }

    public void displayFinalMap(int floorLevel) {
        if(floorLevel == 2) {   //save bufferedImage to new file location
            try {
                saveImage(2);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if (floorLevel == 3) {
            try {
                saveImage(3);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        ImagePanel panel = new ImagePanel(floorLevel); /* Code borrowed from https://coderanch.com/t/338284/java/zoom-zoom-picture-swing  to display image correctly*/
        ImageZoom zoom = new ImageZoom(panel);    // display image on screen
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(zoom.getUIPanel(), "North");
        f.getContentPane().add(new JScrollPane(panel));
        f.setSize(1000,1000);
        f.setLocation(200,200);
        f.setVisible(true);


		/* beginning of original output
		 JFrame frame = buildFrame();
		 JPanel pane = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                if (floorLevel == 2) {
	                twoFloor = sizeChange(twoFloor,twoFloor.getWidth(),twoFloor.getHeight(), 0.40,BufferedImage.TYPE_3BYTE_BGR);
	                g.drawImage(twoFloor, 300, -100, null);
	                try {
						saveImage(2);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                }
	                else if (floorLevel == 3) {
	                	threeFloor = sizeChange(threeFloor,threeFloor.getWidth(),threeFloor.getHeight(), 0.40,BufferedImage.TYPE_3BYTE_BGR);
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
	        */
    }

	  /*
	private JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(2500,3300);
        return frame;
    } */

    public void saveImage(int floorLevel) throws IOException {
        if(floorLevel == 2) {
            try {
                ImageIO.write(twoFloor,"png", new File("Doyle2F.png"));
                twoMapFloor.dispose();
            }
            catch (IOException e){
                e.printStackTrace();
                System.out.println("Error in saving buffered image for " + floorLevel);
            }
        }
        else if (floorLevel == 3) {
            try {
                ImageIO.write(threeFloor,"png", new File("Doyle3F.png"));
                threeMapFloor.dispose();
            }
            catch (IOException e){
                e.printStackTrace();
                System.out.println("Error in saving buffered image for " + floorLevel);
            }
        }
    }
	/*
	public BufferedImage sizeChange (BufferedImage originalImage, int imageWidth, int imageHeight ,double zoomLevel, int imageType) {
		int newImageWidth = (int) (imageWidth * zoomLevel);
		int newImageHeight = (int) (imageHeight * zoomLevel);
		BufferedImage resizedImage = new BufferedImage(newImageWidth , newImageHeight, imageType);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newImageWidth , newImageHeight , null);
		g.dispose();
		return resizedImage;
	}
	end of original output  */

    class ImagePanel extends JPanel
    {
        BufferedImage image;
        double scale;

        public ImagePanel(int i)
        {
            loadImage(i);
            scale = 1;
            setBackground(Color.black);
        }

        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            int w = getWidth();
            int h = getHeight();
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();
            double x = (w - scale * imageWidth)/2;
            double y = (h - scale * imageHeight)/2;
            AffineTransform at = AffineTransform.getTranslateInstance(x,y);
            at.scale(scale, scale);
            g2.drawRenderedImage(image, at);
        }

        /**
         * For the scroll pane.
         */
        public Dimension getPreferredSize()
        {
            int w = (int)(scale * image.getWidth());
            int h = (int)(scale * image.getHeight());
            return new Dimension(w, h);
        }

        public void setScale(double s)
        {
            scale = s;
            revalidate();      // update the scroll pane
            repaint();
        }

        public void loadImage(int fl)
        {
            String fileName = null;
            if (fl == 2) {
                fileName = "/Users/gubdev/Desktop/Project2/Doyle2F.png" ;
            }
            else if(fl == 3) {
                fileName = "/Users/gubdev/Desktop/Project2/Doyle3F.png";
            }
            try
            {
                image = ImageIO.read(new File(fileName));
            }
            catch(MalformedURLException mue)
            {
                System.out.println("URL trouble: " + mue.getMessage());
            }
            catch(IOException ioe)
            {
                System.out.println("read trouble: " + ioe.getMessage());
            }
        }
    }

    class ImageZoom
    {
        ImagePanel imagePanel;

        public ImageZoom(ImagePanel ip)
        {
            imagePanel = ip;
        }

        public JPanel getUIPanel()
        {
            SpinnerNumberModel model = new SpinnerNumberModel(1.0, 0.1, 1.4, .01);
            final JSpinner spinner = new JSpinner(model);
            spinner.setPreferredSize(new Dimension(45, spinner.getPreferredSize().height));
            spinner.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e)
                {
                    float scale = ((Double)spinner.getValue()).floatValue();
                    imagePanel.setScale(scale);
                }
            });
            JPanel panel = new JPanel();
            panel.add(new JLabel("scale"));
            panel.add(spinner);
            return panel;
        }
    }
/*
    public static void main(String[] args) {
		/*
		Floor test = new Floor(3,2);
		Room greenberg = new Room(216,1650,2600,1,"Greenberg");
		test.addRoom(greenberg);
		Room ye = new Room(210,1580,1130,2,"Ye");
		test.addRoom(ye);
		Room yacobellis = new Room(210,1030,1100,3,"Yacobellis");
		test.addRoom(yacobellis);
		FloorLayout map = new FloorLayout();
		try {
			map.readFloorPlan(test.getLevel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.editFloorPlan(ye, test);
		map.editFloorPlan(greenberg, test);
		map.editFloorPlan(yacobellis, test);
		map.displayFinalMap(test.getLevel());
		*
        Floor test2 = new Floor(1,3);
        Room Honig = new Room(316,2000,2000,2,"Honig");
        test2.addRoom(Honig);

        FloorLayout map2 = new FloorLayout();
        try {
            map2.readFloorPlan(test2.getLevel());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        map2.editFloorPlan(Honig, test2);
        map2.displayFinalMap(test2.getLevel());
    }*/

}
