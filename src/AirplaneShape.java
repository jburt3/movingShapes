import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;


/**
 * @author Joseph Burt
 * A moveable airplane shape that implements the 
 * MoveableShape interface.
 */
public class AirplaneShape implements MoveableShape 
{
	private int x;
	private int y;
	@SuppressWarnings("unused")
	private int width;
	
	
	/**
	 * Constructs a new AirplaneShape with a specified
	 * x and y coordinate and a width.
	 * @param x  the location of the plane's x-coordinate 
	 * @param y  the location of the plane's y-coordinate
	 * @param width  the width of the new plane shape
	 */
	public AirplaneShape(int x, int y, int width)
	{
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	
	/**
	 * Draws the airplane using 2D shapes
	 * and colors it.
	 * @param g2  the graphics context
	 */
	public void draw(Graphics2D g2) 
	{
		GeneralPath p = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 20);
	
		Rectangle2D.Double window1 = 
				new Rectangle2D.Double(x + 15, y + 4, 3, 2);
		
		Rectangle2D.Double window2 = 
				new Rectangle2D.Double(x + 20, y + 4, 3, 2);
		
		Rectangle2D.Double window3 = 
				new Rectangle2D.Double(x + 25, y + 4, 3, 2);
		
		p.moveTo(x, y);
		p.lineTo(x + 10, y);
		p.lineTo(x, y - 15);
		p.lineTo(x + 5, y - 15);
		p.lineTo(x + 20, y);
		p.lineTo(x + 32 , y);
		p.lineTo(x + 40, y + 6);
		p.lineTo(x + 32, y + 12);
		p.lineTo(x + 20, y + 12);
		p.lineTo(x + 5, y + 27);
		p.lineTo(x, y + 27);
		p.lineTo(x + 10, y + 12);
		p.lineTo(x, y + 12);
		p.lineTo(x + 6, y + 6);
		p.lineTo(x, y);
		
		g2.setPaint(Color.RED);
		g2.fill(p);
		
		g2.setPaint(Color.BLUE);
		g2.draw(p);
		
		g2.setPaint(Color.YELLOW);
		g2.fill(window1);
		g2.fill(window2);
		g2.fill(window3);
		
		g2.setPaint(Color.BLACK);
		g2.draw(window1);
		g2.draw(window2);
		g2.draw(window3);
	}

	
	/**
	 * Moves the airplane by a given amount.
	 * If the airplane exceeds the secondary
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
