import java.awt.event.KeyEvent;

public class Player
{
	private double	x, y;
	private boolean	isAlive;
	private double	speed;
	private int		w, h;
	private int		minPos, maxPos;
	private boolean spaceRealeased;
	private Laser[]	lasers;

	// Constructor :
	public Player(double speed, int width, int height)
	{
		this.w = width;
		this.h = height;
		this.speed = speed;
		spaceRealeased = true;
		y = 60;
		maxPos = 400 - (int)(0.5 * width);
		minPos = -maxPos;
		lasers = Laser.initLasers(3, 1, 20.0);
	}

	// Getters & Setters :
	public int getX()
	{
		return (int)(x);
	}
	
	public int getY()
	{
		return (int)(y);
	}

	public int getXend()
	{
		return ((int)(x) + w);
	}

	public int getYend()
	{
		return ((int)(y) - h);
	}

	public Laser[] getLasers()
	{
		return lasers;
	}

	// Action
	private void moveLeft()
	{
		x -= speed;
		x = (x < minPos) ? minPos : x;
	}

	private void moveRight()
	{
		x += speed;
		x = (x > maxPos) ? maxPos : x;
	}

	private void fire()
	{
		boolean done = false;
		int i = 0;
		
		while (!done && i < lasers.length)
		{
			if(!lasers[i].isUsed())
			{
				lasers[i].shot(x, y + h / 2);
				done = true;
			}
			i++;
		}
	}

	// Die :
	public void die()
	{
		System.out.println("End");
		isAlive = false;
	}

	// Control :
	public void comportement(Alien[][] aliens)
	{
		spaceRealeased |= !StdDraw.isKeyPressed(KeyEvent.VK_SPACE);

		if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
			this.moveLeft();
		if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
			this.moveRight();
		if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE) && spaceRealeased)
		{
			this.fire();
			spaceRealeased = false;
		}

		for (int i = 0; i < lasers.length; i++)
		{
			lasers[i].comportement(this, aliens);
		}
	}
}
