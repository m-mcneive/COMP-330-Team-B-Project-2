import java.util.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Map {
static Floor[] building = new Floor[4]; //ie Doyle would have levels equal to 4;

public static void main(String args[]){
	Floor second = new Floor(15,2);
	Floor third = new Floor(15,3);
	building[0] = second;
	building[1] = third;
	
}
}
