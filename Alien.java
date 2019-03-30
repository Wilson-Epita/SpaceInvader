public class Alien
{
	private double	x, y;
	private double	speed;
	private int		w, h;
	private double	minPos, maxPos;
	private boolean	isAlive;
	private boolean	touchWall;

	// Constructor :
	public Alien(double x, double y, int w, int h, double speed)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.speed = speed;
		isAlive = true;
		touchWall = false;
		maxPos = 400 - (int) (w * 0.5);
		minPos = -maxPos;
	}

	// Getter & Setter :
	
	public int getX()
	{
		return (int)(x);
	}

	public int getY()
	{
		return (int)(y);
	}

	public int getWidth()
	{
		return (w);
	}

	public int getHeight()
	{
		return (h);
	}

	public boolean isAlive()
	{
		return isAlive;
	}

	public boolean hasTouchWall()
	{
		boolean res = touchWall;

		touchWall = false; // reset
		return (res);
	}

	// Mooving :
	private void moveRight()
	{
		x += speed;
		touchWall = (x > maxPos);
	}

	private void moveLeft()
	{
		x -= speed;
		touchWall = (x < minPos);
	}

	private void moveDown()
	{
		y -= 20;
	}
	
	// Die : 
	public void die()
	{
		isAlive = false;
	}
	
	// Static functions :
	public static Alien[][] initAliens(int nbLines, int nbCols, int w, int h, double speed)
	{
		int		x;
		int		y = 630;
		Alien[][] res = new Alien[nbLines][nbCols];
		
		for (int i = 0; i < nbLines; i++)
		{
			x = -365;
			for (int j = 0; j < nbCols; j++)
			{
				res[i][j] = new Alien(x, y, w, h, speed);
				x += (w + 20);
			}
			y -= (h + 10);
		}

		return (res);
	}

	public static boolean changeDirection(Alien[][] aliens)
	{
		boolean res = false;

		// We have to call the function on all aliens to reset the flag
		for (int i = 0; i < aliens.length; i++)
		{
			for (int j = 0; j < aliens[0].length; j++)
			{
				if (aliens[i][j].isAlive())
					res = aliens[i][j].hasTouchWall() || res;
				
			}
		}

		return (res);
	}

	public static void aliensDown(Alien[][] aliens)
	{
		for (int i = 0; i < aliens.length; i++)
		{
			for (int j = 0; j < aliens[0].length; j++)
				aliens[i][j].moveDown();
		}
	}

	public static void comportement(Alien[][] aliens, int direction)
	{
		for (int i = 0; i < aliens.length; i++)
		{
			for (int j = 0; j < aliens[0].length; j++)
			{
				if (aliens[i][j].isAlive())
				{
					if (direction == 1)
						aliens[i][j].moveRight();
					else
						aliens[i][j].moveLeft();
				}
			}
		}
	}
}
