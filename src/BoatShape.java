import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;


/**
 * @author Joseph Burt
 * A moveable boat shape that implements the
 * MoveableShape interface.
 */
public class BoatShape implements MoveableShape 
{
	private int x;
	private int y;
	@SuppressWarnings("unused")
	private int width;
	
	
	/**
	 * Constructs a new boat shape with a specified 
	 * x and y coordinate and a width.
	 * @param x  the location of the boat's x-coordinate 
	 * @param y  the location of the boat's y-coordinate
	 * @param width  the width of the new boat shape
	 */
	public BoatShape(int x, int y, int width)
	{
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	
	/**
	 * Draws the boat using 2D shapes and colors it.
	 * @param g2  the graphics context
	 */
	public void draw(Graphics2D g2) 
	{
		GeneralPath p = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 20);
		
		p.moveTo(x, y);
		p.lineTo(x + 18, y + 16);
		p.lineTo(x, y + 16);
		p.lineTo(x, y);
		p.lineTo(x, y + 16);
		p.lineTo(x + 9, y + 16);
		p.lineTo(x + 9, y + 20);
		p.lineTo(x + 21, y + 20);
		p.lineTo(x + 15, y + 27);
		p.lineTo(x + 2, y + 27);
		p.lineTo(x - 1, y + 20);
		p.lineTo(x + 9, y + 20);
		
		Ellipse2D.Double detail = new Ellipse2D.Double(x + 3, y + 11, 6, 4);
		
		g2.setPaint(Color.WHITE);
		g2.fill(p);
		
		g2.setPaint(Color.BLUE);
		g2.draw(p);
		
		g2.setPaint(Color.CYAN);
		g2.fill(detail);
		g2.draw(detail);
	}

	
	/**
	 * Moves the boat by a given amount.
	 * If the boat exceeds the secondary
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
