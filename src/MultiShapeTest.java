import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * @author Joseph Burt
 * Creates all of the components necessary for displaying and interacting
 * with moving shapes into a GUI. The main JFrame is extended and always visible
 * while the secondary frame is created and visible at the user's command. Also 
 * implements ActionListener to receive input from JButtons.
 */
@SuppressWarnings("serial")
public class MultiShapeTest extends JFrame implements ActionListener
{
	public static final int fWidth = 400;
	public static final int fHeight = 400;
	public static final int sfWidth = 600;
	public static final int sfHeight = 600;
	
	public static final int ICON_WIDTH = 600;
	public static final int ICON_HEIGHT = 600;
	public static final int SHAPE_WIDTH = 50;
	
	private MoveableShape shapes[] = new MoveableShape[99];
	
	private JFrame subFrame;
	private boolean sfDisplayed;
	
	private ShapeIcon shapesIcon;
	private int shapesCount;
	
	private JPanel mainPanel, checkBoxPanel;
	
	private JButton showButton, addButton, removeButton, exitButton;
	private JCheckBox airplaneCB, boatCB, clockCB;
	
	private JLabel display;
	
	private JButton hideButton, sfExitButton;
	
	
	/**
	 * Constructs the components for the GUI and the Timer for
	 * how often the shapes in the shapes array move.
	 */
	public MultiShapeTest()
	{		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		
		sfDisplayed = false;
		subFrame = new JFrame();
		
		shapesIcon = new ShapeIcon(ICON_WIDTH, ICON_HEIGHT);
		shapesCount = 0;
		
		setShow();
		setAdd();
		setRemove();
		setExit();
		setCheckBox();
		
		this.setLayout(new GridLayout(1,2));
		this.add(mainPanel);
		this.add(checkBoxPanel);
		this.setSize(fWidth, fHeight);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setHide();
		setSfExit();
		setTimer();
	}
	
	
	/**
	 * Private helper method to set up the "Show" button
	 * on the main frame and add an ActionListener to it.
	 */
	private void setShow()
	{
		showButton = new JButton("Show");
		mainPanel.add(showButton);
		showButton.setBounds(20, 35, 90, 30);
		
		showButton.addActionListener(this);
	}
	
	
	/**
	 * Private helper method to set up the "Add" button
	 * on the main frame and add an ActionListener to it.
	 */
	private void setAdd()
	{
		addButton = new JButton("Add");
		mainPanel.add(addButton);
		addButton.setBounds(20, 110, 90, 30);
		
		addButton.addActionListener(this);
	}
	
	
	/**
	 * Private helper method to set up the "Remove" button
	 * on the main frame and add an ActionListener to it.
	 */
	private void setRemove()
	{
		removeButton = new JButton("Remove");
		mainPanel.add(removeButton);
		removeButton.setBounds(20, 185, 90, 30);
		
		removeButton.addActionListener(this);
	}
	
	
	/**
	 * Private helper method to set up the "Exit" button
	 * on the main frame and add an ActionListener to it.
	 */
	private void setExit()
	{
		exitButton = new JButton("Exit");
		mainPanel.add(exitButton);
		exitButton.setBounds(20, 260, 90, 30);
		
		exitButton.addActionListener(this);
	}
	
	
	/**
	 * Private helper method to set up the Airplane,
	 * Boat and Clock checkboxes that are used to 
	 * determine which shape is added to the secondary frame.
	 */
	private void setCheckBox()
	{
		airplaneCB = new JCheckBox("Airplane", true);
		boatCB = new JCheckBox("Boat");
		clockCB = new JCheckBox("Clock");
		
		checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new GridLayout(3,0));
		
		checkBoxPanel.add(airplaneCB);
		checkBoxPanel.add(boatCB);
		checkBoxPanel.add(clockCB);
	}
	
	
	/**
	 * Private helper method to set up the "Hide" button
	 * on the secondary frame and add an ActionListener to it.
	 */
	private void setHide()
	{
		hideButton = new JButton("Hide");
		subFrame.add(hideButton);
		hideButton.setBounds(15, 30, 90, 30);
		
		hideButton.addActionListener(this);
	}
	
	
	/**
	 * Private helper method to set up the "Exit" button
	 * on the secondary frame and add an ActionListener to it.
	 */
	private void setSfExit()
	{
		sfExitButton = new JButton("Exit");
		subFrame.add(sfExitButton);
		sfExitButton.setBounds(150, 30, 90, 30);
		
		sfExitButton.addActionListener(this);
	}
	
	
	/**
	 * Private helper method to set a timer that controls
	 * how often the shapes are moved across the secondary
	 * frame.
	 */
	private void setTimer()
	{
		final int DELAY = 20;
		Timer t = new Timer(DELAY, new 
			ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					if(subFrame.isVisible())
					{
						for(int j = 0; j < shapesCount; j++)
						{
							shapes[j].translate(2, 0);
							display.repaint();
						}
					}
				}
			});
		
		t.start();
	}
	
	
	/**
	 * Private helper method to set up the secondary frame
	 * that holds two buttons and one label to display
	 * moving shapes.
	 */
	private void setSubFrame()
	{
		subFrame.setLayout(new FlowLayout());
		subFrame.setSize(sfWidth, sfHeight);
		subFrame.setVisible(true);
		
		subFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		subFrame.setLocation(410, 30);
		
		setDisplay();
		sfDisplayed = true;
	}
	
	
	/**
	 * Private helper method to set up the label that
	 * displays the shape icon that holds all of the 
	 * moving shapes.
	 */
	private void setDisplay()
	{	
		display = new JLabel();
		subFrame.add(display);
	}
	
	
	/**
	 * Implemented method from the ActionListener 
	 * interface that handles the input from buttons.
	 * @param e  the action the user invokes
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == showButton)
			showSubFrame();
		
		if(e.getSource() == addButton)
		{	
			if(shapesCount < 99)
				addShape();
		}
		
		if(e.getSource() == removeButton)
		{	
			removeShape();
		}
		
		if(e.getSource() == exitButton)
		{
			exitProgram();
		}
		
		if(e.getSource() == hideButton)
		{
			hideSubFrame();
		}
		
		if(e.getSource() == sfExitButton)
		{
			exitSubFrame();
		}
	}
	
	
	/**
	 * Private helper method to determine whether
	 * to set up the secondary frame when the 
	 * "Show" button is clicked.
	 */
	private void showSubFrame()
	{
		if(!sfDisplayed)
			setSubFrame();
		
		if(sfDisplayed)
			subFrame.setVisible(true);
	}
	

	/**
	 * Private helper method to determine which shapes
	 * to add to the secondary frame once the "Add" button
	 * is clicked.
	 */
	private void addShape()
	{
		if(airplaneCB.isSelected())
		{
			testVisibility();
			addPlane();
		}
		
		if(boatCB.isSelected())
		{	
			testVisibility();
			addBoat();
		}
		
		if(clockCB.isSelected())
		{
			testVisibility();
			addClock();
		}
		
		if(shapesCount > 0)
			display.setVisible(true);
	}
	
	
	/**
	 * Private helper method to determine whether 
	 * to show the secondary frame when adding a
	 * new shape.
	 */
	private void testVisibility()
	{
		if(!sfDisplayed)
			setSubFrame();
		
		if(sfDisplayed)
			subFrame.setVisible(true);
	}
	
	
	/**
	 * Adds a plane to the shapes array at random x
	 * and y coordinates, then adds it to a shape icon
	 * that is added onto the display label. The count 
	 * for shapes in the array is incremented by 1.
	 */
	public void addPlane()
	{
		shapes[shapesCount] = new AirplaneShape((1 + (int)(Math.random() * ((400 - 1) + 1))), 
					((1 + (int)(Math.random() * ((400 - 1) + 1)))),  SHAPE_WIDTH);
		
		shapesIcon.addShape(shapes[shapesCount]);
		display.setIcon(shapesIcon);
		shapesCount++;
	}
	
	
	/**
	 * Adds a boat to the shapes array at random x
	 * and y coordinates, then adds it to a shape icon
	 * that is added onto the display label. The count 
	 * for shapes in the array is incremented by 1.
	 */
	public void addBoat()
	{
		shapes[shapesCount] = new BoatShape((1 + (int)(Math.random() * ((380 - 1) + 1))), 
				((1 + (int)(Math.random() * ((380 - 1) + 1)))),  SHAPE_WIDTH);
		
		shapesIcon.addShape(shapes[shapesCount]);
		display.setIcon(shapesIcon);
		shapesCount++;
	}
	
	
	/**
	 * Adds a clock to the shapes array at random x
	 * and y coordinates, then adds it to a shape icon
	 * that is added onto the display label. The count 
	 * for shapes in the array is incremented by 1.
	 */
	public void addClock()
	{
		shapes[shapesCount] = new ClockShape((1 + (int)(Math.random() * ((380 - 1) + 1))), 
				((1 + (int)(Math.random() * ((380 - 1) + 1)))),  SHAPE_WIDTH);
		
		shapesIcon.addShape(shapes[shapesCount]);
		display.setIcon(shapesIcon);
		shapesCount++;
	}
	

	/**
	 * Removes the most recently added shape from
	 * the secondary frame once the "Remove" button
	 * is clicked.
	 */
	public void removeShape()
	{
		if(subFrame.isVisible())
		{
			if(shapesCount > 0)
			{
				shapesIcon.removeShape();
				shapesCount--;
			}
			
			if(shapesCount == 0)
				display.setVisible(false);
		}
	}

	
	/**
	 * Private helper method that terminates the
	 * program.
	 */
	private void exitProgram()
	{
		System.exit(0);
	}
	
	
	/**
	 * Private helper method that hides the secondary
	 * frame.
	 */
	private void hideSubFrame()
	{
		subFrame.setVisible(false);
	}
	
	
	/**
	 * Private helper method that removes every shape
	 * added onto the label, hides the secondary frame,
	 * and resets the count for shapes to 0.
	 */
	private void exitSubFrame()
	{
		for(int j = 0; j < shapesCount; j++)
		{
			shapesIcon.removeShape();
		}
		
		subFrame.setVisible(false);
		shapesCount = 0;
	}
}
