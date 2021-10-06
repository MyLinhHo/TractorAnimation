import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a scarecrow look to the left side watching a tractor riding on the road
 *
 * @author BSU CS 121 Instructors
 * @author MY-Linh Ho
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;

	private final Color BACKGROUND_COLOR = Color.white;
	private final Color TRACTOR_COLOR = new Color(227, 32, 18);

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		
		// the tractor body at their new positions on the screen	
		int squareSideW = (2 * width) / 15;
		int squareSideH = height / 5;
		int squareY = height / 2 - squareSideH / 2;

		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);
				
		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;
		
		//obsert head subject coordinate 
		int xObserHead = squareSideW / 5;
		int yObserHead = height / 2 - squareSideH * 2;
		
		//draw blue sky
		g.setColor( new Color(52, 151, 237));
		g.fillRect(0, 0, width, squareY + squareSideH / 2);
		
		// draw the text
		g.setColor(Color.white);
		g.drawString("Good day!!!", width / 2  , height / 10);
		
		//draw bush1
		int xBush0 = 2 * (xObserHead + squareSideW /4);
		int yBush0 = yObserHead +  squareY / 2 ;
		g.setColor(new Color(34, 168, 17));
		g.fillOval(xBush0, yBush0, squareSideW, 2 * squareSideH);
		
		//draw bush2
		int xBush1 = 2 * (xObserHead + squareSideW /4) + squareSideW;
		int yBush1 = yObserHead +  squareY / 2 - squareSideH ;
		g.setColor(new Color(22, 107, 11));
		g.fillOval(xBush1, yBush1, squareSideW + squareSideW / 2, 3 * squareSideH);
		
		//draw bush3
		int xBush2 = 2 * (xObserHead + squareSideW /4) + 2 * squareSideW;
		int yBush2 = yObserHead +  squareY / 2 ;
		g.setColor(new Color(34, 168, 17));
		g.fillOval(xBush2, yBush2, squareSideW, 2 * squareSideH);
		
		//draw the road lane
		g.setColor(Color.BLACK);
		g.fillRect(0, squareY + squareSideH / 2, width, height / 4);
		
		//draw white line
		g.setColor(Color.white);
		g.fillRect(0 , squareY + squareSideH / 2 + height / 8, width, height / 30 );
		
		//draw green grass
		g.setColor(Color.GREEN);
		g.fillRect(0,squareY + squareSideH / 2 + height / 4, width, height / 3);
		
		//draw stick line body
		g.setColor(Color.BLACK);
		g.drawLine(xObserHead + squareSideW /4, yObserHead, xObserHead + squareSideW / 4, squareY + squareSideH / 2 );	        
		//draw stick hand
		g.drawLine(0, yObserHead + 3 * squareY / 8, 2 * (xObserHead + squareSideW /4) , yObserHead +  3 * squareY / 8);
		
		//draw stick clothe
		g.setColor( new Color(115, 80, 9));
		g.fillRect(xObserHead, yObserHead + 3 * squareY / 8, squareSideW / 2, squareSideH );
		
		//draw  scarecrow head
		g.setColor(new Color (207, 142, 12));
		g.fillOval(xObserHead, yObserHead, squareSideW /2 , squareSideH / 2 +  squareSideH / 8);
		
		// draw left eye
        g.setColor(Color.BLACK);
        g.fillOval(2 * xObserHead, yObserHead + squareSideH / 4, xObserHead / 2, squareSideH / 6  );
        
        //fill right eye
        g.fillOval(2 * xObserHead +  squareSideW / 6, yObserHead + squareSideH / 4, xObserHead / 2, squareSideH / 6 );
		
        //draw nose
        g.fillOval(xObserHead + squareSideW / 3 ,  yObserHead + 3 * squareSideH / 8, xObserHead / 6, squareSideH / 15 );
        
        //draw mouth
        g.setColor(Color.RED);
        g.drawArc(xObserHead + squareSideW / 4 + squareSideW / 20 ,  yObserHead + 3 * squareSideH / 8 + squareSideH / 25 , xObserHead / 2, yObserHead / 4, 0, -180);
        
        //draw a scarecrow hat
		int [] xHat = {xObserHead / 2 ,xObserHead / 2 + squareSideW / 4,2 * xObserHead +  squareSideW / 2  };
        int [] yHat = {yObserHead + squareSideH / 4 , yObserHead - squareSideH / 4 ,yObserHead + squareSideH / 4  };
        g.setColor( new Color(115, 80, 9));
        g.fillPolygon(xHat, yHat, 3);
		
		// This draws a red tractor body.
		g.setColor(TRACTOR_COLOR);
		g.fillRect(xOffset, squareY, squareSideW * 2 + squareSideW / 2, squareSideH);
		
		//head of a tractor coordinate
		int xHead =  (xOffset + squareSideW / 4)  ;
		int yHead =  squareY - squareSideH / 2 ;
		
		//draw head 		
		g.fillRect(xHead, yHead, squareSideW , squareSideH / 2 );
		
		//draw a window
		g.setColor(Color.GRAY);
		g.fillRect(xHead + squareSideW / 4, yHead + squareSideH / 4, squareSideW / 2, squareSideH / 2 );
		
		// air stack coordinate and drawing
		int xAirStack = xOffset + 2 *squareSideW ;
		int yAirStack = yHead + squareSideW / 4;
		
		g.fillRect(xAirStack, yAirStack, squareSideW / 4 ,  squareSideH /2);	 	
		
		// back wheel coordinate and draw oval
		int xBackWheel = xOffset;
		int yBackWheel = squareY + squareSideH / 2;
		
		g.fillOval(xBackWheel, yBackWheel, squareSideW, squareSideH );
		
		// back wheel coordinate and draw oval
		int xFrontWheel = xOffset + squareSideW + squareSideW / 2;
		int yFrontWheel = squareY + squareSideH / 2;
	
		g.fillOval(xFrontWheel, yFrontWheel + squareSideH / 4, squareSideW , squareSideH / 2 +  squareSideH / 4);
		   
       
        //draw yellow sun
        g.setColor(Color.yellow);
        g.fillOval(width - squareSideW /2 , 0 , squareSideW, squareSideH );

		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
