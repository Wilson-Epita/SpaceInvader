public class Visualize
{
	private int w, h;
	private Player player;
	private Alien[][] aliens;

	public Visualize(int width, int height, Player player, Alien[][] aliens)
	{
		w = width;
		h = height;
		this.player = player;
		this.aliens = aliens;
		initWindow();
	}
 
	public void initWindow()
	{
		StdDraw.setCanvasSize(w, h);
		StdDraw.setXscale(-w/2, w/2);
		StdDraw.setYscale(0, h);
	}
	 
	public void drawGame()
	{
		StdDraw.clear();
		drawGameBackground();
		drawPlayer();
		drawAliens();
		drawPlayerLasers();
	}

	public void drawMenu()
	{
	
	}

	private void drawGameBackground()
	{
		StdDraw.picture(0, 400, "img/black_background.jpg");
	}

	private void drawPlayer()
	{
		StdDraw.picture(player.getX(), player.getY(), "img/player_s.png");
	}

	private void drawPlayerLasers()
	{
		Laser[] lasers = player.getLasers();
		int l = lasers.length;

		for (int i = 0; i < l; i++)
		{
			if (lasers[i].isUsed())
				StdDraw.picture(lasers[i].getX() - 4, lasers[i].getY(), "img/laser.png");
		}
	}

	private void drawAliens()
	{
		for (int i = 0; i < aliens.length; i++)
		{
			for (int j = 0; j < aliens[0].length; j++)
			{
				if (aliens[i][j].isAlive())
					StdDraw.picture(aliens[i][j].getX(), aliens[i][j].getY(), "img/alien.png");
			}
		}
	}
}
