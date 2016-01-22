import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * @author Joseph Burt
 * A moveable clock shape that implements the
 * MoveableShape interface.
 */
public class ClockShape implements MoveableShape 
{
	private int x;
	private int y;
	@SuppressWarnings("unused")
	private int width;
	
	
	/**
	 * Constructs a new clock shape with a specified 
	 * x and y coordinate and a width.
	 * @param x  the location of the clock's x-coordinate 
	 * @param y  the location of the clock's y-coordinate
	 * @param width  the width of the new clock shape
	 */
	public ClockShape(int x, int y, int width)
	{
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	
	/**
	 * Draws the clock using 2D shapes and colors it.
	 * @param g2  the graphics context
	 */
	public void draw(Graphics2D g2) 
	{
		Ellipse2D.Double frame = new Ellipse2D.Double(x, y, 25, 25);
		
		Ellipse2D.Double bell1 = new Ellipse2D.Double(x, y - 3, 7, 7);
		Ellipse2D.Double bell2 = new Ellipse2D.Double(x + 18, y - 3, 7, 7);
		Ellipse2D.Double center = new Ellipse2D.Double(x + 13, y + 12, 2, 2);
		
		Point2D.Double p1 = new Point2D.Double(x + 14, y + 5);
		Point2D.Double p2 = new Point2D.Double(x + 14, y + 13);
		Point2D.Double p3 = new Point2D.Double(x + 14, y + 13);
		Point2D.Double p4 = new Point2D.Double(x + 19, y + 19);
		
		Line2D.Double hand1 = new Line2D.Double(p1, p2);
		Line2D.Double hand2 = new Line2D.Double(p3, p4);
		
		g2.setPaint(Color.WHITE);
		g2.fill(frame);
		g2.setPaint(Color.RED);
		g2.draw(frame);
		g2.setPaint(Color.YELLOW);
		g2.fill(bell1);
		g2.fill(bell2);
		g2.setPaint(Color.RED);
		g2.draw(bell1);
		g2.draw(bell2);
		g2.setPaint(Color.BLUE);
		g2.draw(hand1);
		g2.draw(hand2);
		g2.draw(center);
	}
	
	
	/**
	 * Moves the clock by a given amount.
	 * If the clock exceeds the secondary
	 * frame's x boundary, it warps around.
	 * @param dx  the amount to translate in x-direction
	 * @param dy  the amount to translate in y-direction
	 */
	public void translate(int dx, int dy) 
	{
		if(x > 600)
			x = 0;
		
		if(y > 600)
			y = 0;
		
		x += dx;
		y += dy;
	}
}
