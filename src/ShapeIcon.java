import java.awt.*;

import javax.swing.*;


/**
 * @author Joseph Burt
 * An icon that contains a moveable shape.
 */
public class ShapeIcon implements Icon
{
	private int width;
	private int height;
	private int i = 0;
	private MoveableShape[] shape = new MoveableShape[99];
	
	
	/**
	 * Constructs a ShapeIcon with a passed value for width and height
	 * @param width  the width of the icon
	 * @param height  the height of the icon
	 */
	public ShapeIcon(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	
	/**
	 * Adds a new shape to the array of shapes.
	 * @param shape  the new shape to be added to the array
	 */
	public void addShape(MoveableShape shape)
	{
		this.shape[i] = shape;
		i++;
	}
	
	
	/**
	 * Removes only the most recently added shape from the array.
	 */
	public void removeShape()
	{
		shape[i - 1] = null;
		i--;
	}
	
	
	/**
	 * Retrieves the value for the icon's width.
	 * @return width  the width of the icon
	 */
	public int getIconWidth() 
	{
		return width;
	}
	
	
	/**
	 * Retrieves the value for the icon's height.
	 * @return height  the height of the icon
	 */
	public int getIconHeight() 
	{
		return height;
	}

	
	/**
	 * Draws each shape stored in the array onto a component.
	 * @param c  the GUI component that shapes are drawn onto
	 * @param g  the object that draws onto a component
	 * @param x  the x coordinate to draw on
	 * @param y  the y coordinate to draw on
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
		Graphics2D g2 = (Graphics2D) g;
		
		for(int j = 0; j < i; j++)
			shape[j].draw(g2);
	}
}
