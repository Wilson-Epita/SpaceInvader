public class Laser
{
	private int direction;
	private double speed;
	private double x, y;
	private boolean collision;
	private boolean isUsed;

	public Laser(int direction, double x, double y, double speed)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.direction = direction;
		collision = false;
		isUsed = false;
	}

	public int getX()
	{
		return (int)(x);
	}

	public int getY()
	{
		return (int)(y);
	}

	public boolean isUsed()
	{
		return (isUsed);
	}

	private void move()
	{
		y += (speed * direction);
	}

	private void outOfScreen()
	{
		isUsed &= !(y <= 0 || y >= 800);
	}

    private void playerCollision(Player player)
	{
		if (
			(x > player.getX() && x < player.getXend()) &&
			(y > player.getY() && y < player.getYend())
		)
		{
			isUsed = false;
			player.die();
		}
	}

	private void aliensCollision(Alien[][] aliens)
	{
		int aX, aY, w, h;
		
		w = aliens[0][0].getWidth();
		h = aliens[0][0].getHeight();
		for (int i = 0; i < aliens.length; i++)
		{
			for (int j = 0; j < aliens[0].length; j++)
			{
				aY = aliens[i][j].getY();
				aX = aliens[i][j].getX();
				if (
						aliens[i][j].isAlive() &&
						(x > (int)(aX - 0.5 * w)) && (x < (int)(aX + 0.5 * w)) &&
						(y > (int)(aY - 0.5 * w)) && (y < (int)(aY + 0.5*w))
				)
				{
					isUsed = false;
					aliens[i][j].die();
				}
			}
		}
	}

	public void shot(double x, double y)
	{
		this.x = x;
		this.y = y;
		isUsed = true;
	}

	public void comportement(Player player, Alien[][] aliens)
	{
		if (isUsed)
		{
			move();
			outOfScreen();
			playerCollision(player);
			aliensCollision(aliens);
		}
	}

	// Static function
	public static Laser[] initLasers(int length, int direction, double speed)
	{
		Laser[] res = new Laser[length];
		
		for (int i = 0; i < length; i++)
			res[i] = new Laser(direction, 0, 0, speed);

		return (res);
	}

	public static boolean allUnused(Laser[] lasers)
	{
		boolean res = true;
		int i = 0;

		while(res && i < lasers.length)
		{
			res = !lasers[i].isUsed;
			i++;
		}
		return (res);
	}
}
